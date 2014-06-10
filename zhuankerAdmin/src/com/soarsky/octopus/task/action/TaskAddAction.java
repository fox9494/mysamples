package com.soarsky.octopus.task.action;

import java.util.Date;
import java.util.List;

import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.enums.EnumConstant;
import com.soarsky.octopus.mapping.TApplication;
import com.soarsky.octopus.mapping.TCompany;
import com.soarsky.octopus.mapping.TCompanyOrder;
import com.soarsky.octopus.mapping.TTask;
import com.soarsky.octopus.task.constant.TaskContent;
import com.soarsky.octopus.task.constant.TaskErrorMsg;
import com.soarsky.octopus.task.service.TCompanyOrderService;
import com.soarsky.octopus.task.service.TCompanyService;
import com.soarsky.octopus.task.service.TTaskService;

public class TaskAddAction extends BaseAction {

	private static final long serialVersionUID = 6039901583318637767L;
    
	private TTaskService tTaskService;
	
	private TCompanyService tCompanyService;
	
	private TApplication  application;
	
	private TTask task;
	
	private TCompany company;
	
	private List<TCompany>companies;
	
	private int isneedtop=0;
	
	private int confiresubmit=0;
	
	private List<TCompanyOrder>orders;
	
	private TCompanyOrderService  tCompanyOrderService;
	
	private TCompanyOrder order;
	
	
	/**
	 * 初始订单
	 * @author lw
	 * @return
	*/
	public String initCompanyOrder(){
		
		companies=tCompanyService.findAllCompany();
		
		if(company.getId()!=null){
           orders=tCompanyOrderService.getOrderByCompany(company);
		}else{
		   order=null;  
		}
        return "initcompanyorder";
	}
	
	/**
	 * 初始化添加任务
	 * @author lw
	 * @return
	*/
	public String initAddTask(){
		
		companies=tCompanyService.findAllCompany();
		
		if(company!=null){
			if(company.getId()!=null){
		           orders=tCompanyOrderService.getOrderByCompany(company);
			}
		}
		if(order!=null){
			   if(order.getId()!=null){
			      order=tCompanyOrderService.initOrder(order);
			   }else{
				  order=null;  
			   }	
		}	
		if(task!=null&&task.getTaskid()!=null){
			
			task=tTaskService.ininTask(task);
			
			if(task.getNeedTop()==true){
				
				isneedtop=TaskContent.NEETOP;
			}else{
				
				isneedtop=TaskContent.NOTNEETOP;
			}
			
			company=task.getCompanyId();
		}
		
		return "initaddsuccess";
	}
	
	/**
	 * 添加任务
	 * @author lw
	 * @return
	*/
	public String save(){
		confiresubmit=TaskContent.SUMBIT;
		companies=tCompanyService.findAllCompany();
		task.setCompanyId(tCompanyService.findUserById(company));
		task.setCurNumber(Long.valueOf(0));
	    task.setCreateDate(new Date());
		if(isneedtop==TaskContent.NEETOP){
			task.setNeedTop(true);
		}else{
			task.setNeedTop(false);
		}
		
		//修改订单最大任务数
		if(task.getOrderId()!=0){
	    	if(order.getTotalNumber()!=task.getTotalNumber()){
	    		TCompanyOrder initOrder=new TCompanyOrder();
	    		initOrder.setId(task.getOrderId());
	    		initOrder=tCompanyOrderService.initOrder(initOrder);
	    		initOrder.setTotalNumber(task.getTotalNumber());
	    		tCompanyOrderService.editOrder(initOrder);
	    		order=initOrder;
	    	}
    	}else{
    		order.setTotalNumber(task.getTotalNumber());
    	}
		task.setIsRemove(TaskContent.NOTROMOVE);
		task.setState(JEEContant.WAITING);
		task.setExpireState(Integer.valueOf(EnumConstant.NORMAL.getCode()));
		task=tTaskService.addTask(task);
		
		orders=tCompanyOrderService.getOrderByCompany(company);
		
		return SUCCESS;
	}
	
	/**
	 * 验证添加任务
	 * @author lw
	*/
    public void validateSave(){
        
    	Boolean isExist=tTaskService.findTaskByName(task);
        //验证任务名是否存在
        if(isExist){
        	this.addFieldError(TaskErrorMsg.NAMEEXIST, TaskErrorMsg.NAMEEXIST_MSG);
        }
        if(task.getName().length()<1){
        	this.addFieldError(TaskErrorMsg.NAME, TaskErrorMsg.NAME_MSG);
        }
        if(task.getTotalNumber()==null){
        	this.addFieldError(TaskErrorMsg.TOTALNUMBER, TaskErrorMsg.TOTALNUMBER_MSG);
        }
        if(task.getGoldNum()==null){
        	this.addFieldError(TaskErrorMsg.GOLDNUM, TaskErrorMsg.GOLDNUM_MSG);
        }
        if(task.getCompleteDescription().length()<1){
        	this.addFieldError(TaskErrorMsg.COMPLETEDESCRIPTION, TaskErrorMsg.COMPLETEDESCRIPTION_MSG);
        }
        if(task.getEndDate()==null){
        	this.addFieldError(TaskErrorMsg.ENDDATE, TaskErrorMsg.ENDDATE_MSG);
        }
        if(task.getDescription().length()<1){
        	this.addFieldError(TaskErrorMsg.DESCRIPTION, TaskErrorMsg.DESCRIPTION_MSG);
        }
        if(this.hasFieldErrors()){
        	//初始化添加客户和订单
        	companies=tCompanyService.findAllCompany();   		
        	
        	orders=tCompanyOrderService.getOrderByCompany(company);
        }
    }
    
	public TTaskService gettTaskService() {
		return tTaskService;
	}

	public void settTaskService(TTaskService tTaskService) {
		this.tTaskService = tTaskService;
	}

	public TApplication getApplication() {
		return application;
	}

	public void setApplication(TApplication application) {
		this.application = application;
	}

	public TTask getTask() {
		return task;
	}

	public void setTask(TTask task) {
		this.task = task;
	}

	public TCompany getCompany() {
		return company;
	}
	public void setCompany(TCompany company) {
		this.company = company;
	}
	public List<TCompany> getCompanies() {
		return companies;
	}
	public void setCompanies(List<TCompany> companies) {
		this.companies = companies;
	}
	public TCompanyService gettCompanyService() {
		return tCompanyService;
	}
	public void settCompanyService(TCompanyService tCompanyService) {
		this.tCompanyService = tCompanyService;
	}

	public int getIsneedtop() {
		return isneedtop;
	}

	public void setIsneedtop(int isneedtop) {
		this.isneedtop = isneedtop;
	}

	public int getConfiresubmit() {
		return confiresubmit;
	}

	public void setConfiresubmit(int confiresubmit) {
		this.confiresubmit = confiresubmit;
	}

	public List<TCompanyOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<TCompanyOrder> orders) {
		this.orders = orders;
	}

	public TCompanyOrderService gettCompanyOrderService() {
		return tCompanyOrderService;
	}

	public void settCompanyOrderService(TCompanyOrderService tCompanyOrderService) {
		this.tCompanyOrderService = tCompanyOrderService;
	}

	public TCompanyOrder getOrder() {
		return order;
	}

	public void setOrder(TCompanyOrder order) {
		this.order = order;
	}
}
