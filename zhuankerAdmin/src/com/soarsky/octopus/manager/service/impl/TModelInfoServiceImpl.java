package com.soarsky.octopus.manager.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.soarsky.octopus.clientuser.vo.Attr;
import com.soarsky.octopus.clientuser.vo.TreeData;
import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.manager.dao.TModelInfoDAO;
import com.soarsky.octopus.manager.service.TModelInfoService;
import com.soarsky.octopus.manager.vo.TransModelBean;
import com.soarsky.octopus.mapping.TModelInfo;


public class TModelInfoServiceImpl implements TModelInfoService {
	
	private TModelInfoDAO tModelInfoDAO;
	
	
	/**
	 * 只查询第三级菜单
	 * @return
	 */
	public List<TransModelBean>  queryThirdLevelMenu(){
		List<TransModelBean> list = tModelInfoDAO.selectMenu();
		List<TransModelBean> rtnList = new ArrayList<TransModelBean>(); 
		if (list!=null && !list.isEmpty()){
			for (TransModelBean transModelBean : list) {
				if (transModelBean.getLEVEL()==3){//只获取第三级菜单
					rtnList.add(transModelBean);
				}
			}
		}
		
		return rtnList;
	}
	
	
	/**
	 * 查询所有模块
	 * @return  Map
	 */
	public Map<Long,TModelInfo> queryAllForMap(){
		List<TModelInfo> list = tModelInfoDAO.queryAll(TModelInfo.class);
		Map<Long,TModelInfo> map = new HashMap<Long, TModelInfo>();
		if (list!=null && !list.isEmpty()){
			for (TModelInfo modelInfo : list) {
				map.put(modelInfo.getId(), modelInfo);
			}
		}
		return map;
	}


	//添加tmodelinfo
	public void addModel(Long parentId, TModelInfo tmodel) {
		TModelInfo tmodelparent=this.tModelInfoDAO.getById(TModelInfo.class, parentId);
	    tmodel.setParent(tmodelparent);
        tModelInfoDAO.save(tmodel);
	}
	
	/**
	 * 查询出所有模块封装成jstree的树结构数据类型
	 * @return
	 */
	public List<TreeData> findAllModelForTree(){
		List<TreeData> resultList = new ArrayList<TreeData>();
		List<TModelInfo> list = tModelInfoDAO.queryAll(TModelInfo.class);
		
		Map<Long,TreeData> modelMap = new HashMap<Long,TreeData>();
		if (list!=null){
			for (TModelInfo tModelInfo : list) {
				TreeData tree=new TreeData();
				tree.setChildren(new ArrayList<TreeData>());
				tree.setData(tModelInfo.getName());
				
//				if (tModelInfo.getParent().getId()==JEEContant.ROOTMODEL){
//					tree.setState("open");
//				}else{
//					tree.setState("close");
//				}
				tree.setState("close");
				tree.setStatename(tModelInfo.getName());
				Attr attr=new Attr();
				attr.setId(tModelInfo.getId());
				attr.setParentId(tModelInfo.getParent().getId());
				tree.setAttr(attr);
				modelMap.put(tModelInfo.getId(), tree);
			}
		}
		
		//得到根节点并设置每个节点的子节点
		Set<Entry<Long, TreeData>> set = modelMap.entrySet();
		for (Entry<Long, TreeData> entry : set) {
			TreeData tree = entry.getValue();
			TreeData parentTree = modelMap.get(tree.getAttr().getParentId());
			if (parentTree==null){//表示root节点
				resultList.add(tree);
			}else{
				parentTree.getChildren().add(tree);
			}
		}
		return resultList;
	}
	

	//删除model
	public void deleteModel(Long id) {
		tModelInfoDAO.deleteModel(id);
		
		
	}
	
	//根据Id获取modelinfo
	public TModelInfo findModelInfo(Long id){
		TModelInfo model=this.tModelInfoDAO.getById(TModelInfo.class, id);
		return model;
	}
	
	
	
	public TModelInfoDAO gettModelInfoDAO() {
		return tModelInfoDAO;
	}

	public void settModelInfoDAO(TModelInfoDAO tModelInfoDAO) {
		this.tModelInfoDAO = tModelInfoDAO;
	}


	
	}
