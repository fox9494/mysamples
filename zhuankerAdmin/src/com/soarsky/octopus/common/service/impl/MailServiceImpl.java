package com.soarsky.octopus.common.service.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.log4j.Logger;

import com.soarsky.octopus.common.service.MailService;
import com.soarsky.octopus.utils.EmailUtil;
import com.soarsky.octopus.utils.ErrMsgUtil;

/**
 * 邮件服务类，对外提供邮件服务，使用线程异步发送
 * @author chenll
 *
 */
public class MailServiceImpl implements MailService {
	
	//线程池大小，spring配置文件中配置  
    private int poolSize;
    
    private ExecutorService pool;  
    
    private static Logger logger = Logger.getLogger(MailServiceImpl.class);  
    
    public void init(){
    	//初始化线程池
    	pool = Executors.newFixedThreadPool(poolSize);
    }
    
    public void sendMail(String targerEmail,String content){
    	pool.execute(new MainRunner(targerEmail,content));
    }
    
    /**
     * 线程执行类
     * @author chenll
     */
    private class MainRunner implements Runnable{
    	
    	private String targetEmail; //目标邮件地址
    	
    	private String content; //邮件内容
    	
    	

		public MainRunner(String targetEmail, String content) {
			this.targetEmail = targetEmail;
			this.content = content;
		}



		@Override
		public void run() {
			try {
				EmailUtil.sendEmail(targetEmail, content);
			} catch (AddressException e) {
				logger.error(ErrMsgUtil.getErrMsg(e));
			} catch (MessagingException e) {
				logger.error(ErrMsgUtil.getErrMsg(e));
			}
			
		}
    	
    	
    }

	public int getPoolSize() {
		return poolSize;
	}

	public void setPoolSize(int poolSize) {
		this.poolSize = poolSize;
	}

	public ExecutorService getPool() {
		return pool;
	}

	public void setPool(ExecutorService pool) {
		this.pool = pool;
	}

}
