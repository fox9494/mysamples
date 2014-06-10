package com.soarsky.octopus.clientuser.service.impl;


import java.util.ArrayList;
import java.util.List;

import com.soarsky.octopus.clientuser.dao.TAreaDAO;
import com.soarsky.octopus.clientuser.service.TAreaService;
import com.soarsky.octopus.clientuser.vo.Attr;
import com.soarsky.octopus.clientuser.vo.TreeData;
import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.mapping.TArea;


public class TAreaServiceImpl implements TAreaService {
	    
		private TAreaDAO tAreaDAO;


		/**
		 * 查询所以区域
		 * 
		 */
		public List<TreeData> findArea() {
			
			List<TreeData> resultarea = new ArrayList<TreeData>();
			
			TArea rootarea=this.tAreaDAO.findByroot();
			
			List<TArea> tarealist = this.tAreaDAO.findArea(rootarea.getId());
			
			TreeData treedataroot=new TreeData();
			
			treedataroot.setData(rootarea.getStatename());
			
			Attr attrroot=new Attr();
			
			attrroot.setId(rootarea.getId());
			
			treedataroot.setAttr(attrroot);
			
			treedataroot.setStatename(rootarea.getStatename());	
			
			List<TreeData> rootchildren=new ArrayList<TreeData>();
			
			treedataroot.setChildren(rootchildren);
			
			  for (int i = 0; i < tarealist.size(); i++) { 
				  
				  TreeData tareabean=new TreeData();			  
				  tareabean.setData(tarealist.get(i).getStatename());			  
				  Attr attr=new Attr();				  
				  attr.setId(tarealist.get(i).getId());				  
				  tareabean.setAttr(attr);				  
				  tareabean.setStatename(tarealist.get(i).getStatename());				  
				  rootchildren.add(tareabean);				  
				  List<TreeData> resultareachild=new ArrayList<TreeData>();
			      
			 
			  // 有子节点 
			  if(tarealist.get(i).getId()!=rootarea.getId()&&tarealist.get(i).getIsremove()==JEEContant.NOTROMOVE)  {
				
				  List<TArea> tareachildlist=this.tAreaDAO.findArea(tarealist.get(i).getId());
				  
				  if(tareachildlist.size()!=0){
			       
			        for(int j=0;j<tareachildlist.size();j++){
			        	
			              TArea tarea2=tareachildlist.get(j);			            
 		        	      TreeData tareabean2=new TreeData();			        	
  		        	      tareabean2.setData(tarea2.getStatename());	        	 
						  Attr attr2=new Attr();						  
						  attr2.setId(tarea2.getId());						  
						  tareabean2.setAttr(attr2);						  
						  tareabean2.setStatename(tarea2.getStatename());						  
						  resultareachild.add(tareabean2);
						  
			        }
			         
				  }
				  else{
					  continue;
					  
				  }
			  
			  
			 
			   }
			  
			  tareabean.setChildren(resultareachild);
			   
			  }
			  
			  resultarea.add(treedataroot);
			      return resultarea;
		}
		
		
		/**
		 * 根据parentId查找本级的所有区域
		 * @param parentId
		 * @return
		 */
		public List<TArea>  findLevelArea(Long parentId){
			
			return tAreaDAO.findArea(parentId);
		}
		
		
        /**
         * 初始化用户注册管理区域
         * @author lw
         * @return
	    */
		public List<TreeData> initArea() {
			
			List<TreeData> resultarea = new ArrayList<TreeData>();
			
			TArea rootarea=this.tAreaDAO.findByroot();
			
			List<TArea> tarealist = this.tAreaDAO.findArea(rootarea.getId());
			
			for(TArea area:tarealist){
			
				TreeData data=new TreeData();				
				Attr  attr=new Attr();				
				attr.setId(area.getId());				
				data.setAttr(attr);			
				data.setStatename(area.getStatename());			
				resultarea.add(data);
			}
			
			return resultarea;
		}
        
		/**
		 * 根据parentId查找区域
		 * @author lw
		 * @param  parentId   父类ID
		 * @return
	    */
		public List<TreeData> findAreaById(Long parentId) {
			
			List<TreeData> resultarea = new ArrayList<TreeData>();
			
            List<TArea> tarealist = this.tAreaDAO.findAreaById(parentId);
			
			for(TArea area:tarealist){
			
				TreeData data=new TreeData();				
				Attr  attr=new Attr();				
				attr.setId(area.getId());				
				data.setAttr(attr);				
				data.setStatename(area.getStatename());				
				resultarea.add(data);
			}
			return resultarea;
		}
        
		/**
		 * 根据区域ID查询该客户所在区域
		 * @author lw
		 * @param  id 区域ID
		 * @return
		*/
		public TArea findAreaByClientId(Long id) {
			
			return tAreaDAO.getById(TArea.class, id);
		}


       //添加区域
		public void addArea(Long parentid, String statename) {
			
			TArea tarea=new TArea();		
			tarea.setIsremove(JEEContant.NOTROMOVE);		
			tarea.setParentId(parentid);		
			tarea.setStatename(statename);		
			this.tAreaDAO.save(tarea);
			
		}

		//删除区域
		public void deleteArea(Long id) {
			
			this.tAreaDAO.deleteArea(id);
		}

		//编辑区域
		public void editArea(Long id, String statename) {
			
			 this.tAreaDAO.editArea(id, statename);
		}
		//根据id得到area
		public TArea findAreaByAreaId(long id) {
			TArea area = tAreaDAO.getById(TArea.class, id);
			return area;
		}

		public TAreaDAO gettAreaDAO() {
			
			return tAreaDAO;
		}

		public void settAreaDAO(TAreaDAO tAreaDAO) {
			
			this.tAreaDAO = tAreaDAO;
		}




		

		
		
		

	}
	

