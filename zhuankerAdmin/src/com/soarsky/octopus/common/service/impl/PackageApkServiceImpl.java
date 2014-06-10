package com.soarsky.octopus.common.service.impl;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

import com.soarsky.octopus.channel.service.TChannelService;
import com.soarsky.octopus.common.service.PackageAdpter;
import com.soarsky.octopus.common.service.PackageApkService;
import com.soarsky.octopus.mapping.TChannel;
import com.soarsky.octopus.utils.BeanHolder;
import com.soarsky.octopus.utils.PackageApkLinuxUtil;
import com.soarsky.octopus.utils.PackageApkWinUtil;
import com.soarsky.octopus.utils.PageBean;

/**
 * 打包apk服务
 * 提供线程池异步进行打包
 * @author chenll
 *
 */
public class PackageApkServiceImpl implements PackageApkService {
	
	//线程池大小，spring配置文件中配置  
    private int poolSize;
    
    private ExecutorService pool;  
    
    private static Logger logger = Logger.getLogger(PackageApkServiceImpl.class);
    
    
    public void init(){
    	pool = Executors.newFixedThreadPool(poolSize);
    }
    
    /**
     * 打包服务方法
     * @param id  渠道id
     * @param fileName  打包后生产的文件名
     * @param souceApk  全路径源文件
     */
    public void packageApk(Long id,String fileName,String souceApk){
    	pool.execute(new PackageApkRunner(id,fileName,souceApk));
    }
    
    /**
     * 批量打包
     * @param  上传原始apk的url地址
     */
    public void batchPackageApk(String sourceApkUrl){
    	pool.execute(new PackageBatchRunner(sourceApkUrl));
    }
    
    
    /**
     * 线程执行类
     * @author chenll
     */
    private class PackageApkRunner implements Runnable{
    	
    	/**
    	 * 待打包的ID(如渠道，个人客户)
    	 */
    	private Long   mid;   
    	
    	/**
    	 * 打包后生产的文件名(不带路径)
    	 */
    	private String fileName;
    	
    	/**
    	 * 全路径源文件（用户上传的原始赚客apk）
    	 */
    	private String sourceApkPath;
    	
    	

		public PackageApkRunner(Long id,String fileName,String souceApk) {
			this.mid=id;
			this.fileName = fileName;
			this.sourceApkPath = souceApk;
		}



		@Override
		public void run() {
			Properties properties =  System.getProperties();
			String osName =  properties.getProperty("os.name");
			PackageAdpter packUtil=null;
			logger.info("the system is :"+osName);
			if (osName.contains("Windows")){
				 packUtil = new PackageApkWinUtil(mid,fileName,sourceApkPath);
			}
			if (osName.contains("Linux")){
				 packUtil = new PackageApkLinuxUtil(mid,fileName,sourceApkPath);
			}
			packUtil.packageApk();
		}
    	
    	
    }


	public int getPoolSize() {
		return poolSize;
	}

	public void setPoolSize(int poolSize) {
		this.poolSize = poolSize;
	}
	

	/**
	 * 批量打包内部实现类
	 * @author chenll
	 *
	 */
	private class PackageBatchRunner implements Runnable{
		
		private static final int PAGESIZE=1;
		
		private int curPage = 1;
		
		private String sourceUrl ="";
		

		public PackageBatchRunner(String sourceUrl) {
			this.sourceUrl = sourceUrl;
		}


		@Override
		public void run() {
			TChannelService tChannelService = (TChannelService) BeanHolder.getBean("tChannelService");
			this.batchPackageApk(tChannelService);
		}
		
		
		private void batchPackageApk(TChannelService tChannelService){
			PageBean pageBean= tChannelService.queryPageForPackage(PAGESIZE, curPage);
			
			logger.info("the curPage:"+curPage+",totalPage:"+pageBean.getTotalPage());
			
			if (curPage>pageBean.getTotalPage()){
				return;
			}else{
				List<TChannel> list = pageBean.getList();
				if (list!=null && !list.isEmpty()){
					for (TChannel channel : list) {
						packageApk(channel.getId(),"Octopus.apk",sourceUrl);
					}
					curPage = pageBean.getCurrentPage()+1;
					batchPackageApk(tChannelService);
				}
				
			}
		}
		
	}

}
