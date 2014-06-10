package com.soarsky.octopus.task.action;

import java.util.Date;
import java.util.List;

import com.soarsky.octopus.common.action.BaseAction;
import com.soarsky.octopus.common.contant.JEEContant;
import com.soarsky.octopus.mapping.TApplication;
import com.soarsky.octopus.mapping.TCompany;
import com.soarsky.octopus.mapping.TCompanyOrder;
import com.soarsky.octopus.mapping.TTask;
import com.soarsky.octopus.task.constant.TaskContent;
import com.soarsky.octopus.task.constant.TaskErrorMsg;
import com.soarsky.octopus.task.service.TApplicationService;
import com.soarsky.octopus.task.service.TCompanyOrderService;
import com.soarsky.octopus.task.service.TCompanyService;
import com.soarsky.octopus.task.service.TTaskService;

public class TaskEditAction extends BaseAction {

	private static final long serialVersionUID = -5403897607019356306L;
    
	private TTaskService tTaskService;
	
	private TCompanyService tCompanyService;
	
	private TApplicationService tApplicationService;
	
    private List<TCompanyOrder>orders;
	
	private TCompanyOrderService  tCompanyOrderService;
	
	private List<TCompany>companies;
	
	private TTask task;
	
	private TCompany company;
	
	private String info;
	
    private int isneedtop=0;
	
	private TApplication app;
	
	private TCompanyOrder order;
	
	private String msg;
	
	/**
	 * 获得任务最大任务数
	 * @author lw
	 * @return
	*/
	public String initTotalNumber(){
		
        companies=tCompanyService.findAllCompany();
		
        if(company.getId()!=null){
            orders=tCompanyOrderService.getOrderByCompany(company);
 		}
		if(order!=null){
			   if(order.getId()!=null){
			      order=tCompanyOrderService.initOrder(order);
			   }	
		}
		return "initSuccess";
	}
	
	/**
	 * 判断任务是否过期
	 * @author lw
	 * @return
	*/
	public String findExpireState(){
		
        TTask inittask=new TTask();
		inittask.setTaskid(Long.valueOf(info));
		
		task=tTaskService.ininTask(inittask);
		if(task.getExpireState()==JEEContant.OVERDUE){
			msg="该任务已过期不能修改";
		}
		
		return "findexpirestate";
	}
	
	/**
	 * 初始化修改任务
	 * @author lw
	 * @return
	*/
	public String input(){
		
		companies=tCompanyService.findAllCompany();
		
		TTask inittask=new TTask();
		
		inittask.setTaskid(Long.valueOf(info));
		
		task=tTaskService.ininTask(inittask);
		
		orders=tCompanyOrderService.getOrderByCompany(task.getCompanyId());

		if(task.getOrderId()!=null){
			if(task.getOrderId()!=null){
				TCompanyOrder initOrder=new TCompanyOrder();
				initOrder.setId(task.getOrderId());
				order=tCompanyOrderService.initOrder(initOrder);
			}else{
				TCompanyOrder initOrder=new TCompanyOrder();
				initOrder.setTotalNumber(task.getTotalNumber());
				order=initOrder;
			}
		}
		
		app=task.getApp();
		
		company=task.getCompanyId();
		
		if(task.getNeedTop()==true){
			
			isneedtop=TaskContent.NEETOP;
		}else{
			
			isneedtop=TaskContent.NOTNEETOP;
		}
		
		return SUCCESS;
	}
	
	/**
	 * 修改任务
	 * @author lw
	 * @return
	*/
    public String save(){
    	
    	companies=tCompanyService.findAllCompany();
    	
    	task.setCompanyId(tCompanyService.findUserById(company));
    	
    	if(app.getAppid()!=null){    
        TApplication tapp=new TApplication();
        tapp=tApplicationService.initApplication(app); 
        tapp.setAppName(task.getName());
    	task.setApp(tapp);
    	tApplicationService.editApplication(tapp);
    	}
    	task.setUpdateDate(new Date());
    	
    	if(isneedtop==TaskContent.NEETOP){
    		
			task.setNeedTop(true);
		}else{
			
			task.setNeedTop(false);
		}
    	//修改订单最大任务数
    	if(order.getTotalNumber()!=task.getTotalNumber()){
    		TCompanyOrder initOrder=new TCompanyOrder();
    		initOrder.setId(task.getOrderId());
    		initOrder=tCompanyOrderService.initOrder(initOrder);
    		initOrder.setTotalNumber(task.getTotalNumber());
    		tCompanyOrderService.editOrder(initOrder);
    		order=initOrder;
    	}
    	tTaskService.editTask(task);
    	
    	orders=tCompanyOrderService.getOrderByCompany(company);
    	
    	return "editsuccess";
    }
    
    /**
     * 验证修改任务
     * @author lw
    */
    public void validateSave(){
    	
    	TTask oldTask=tTaskService.ininTask(task);
        //验证任务名是否存在    	
    	if(!task.getName().equals(oldTask.getName())){
    		Boolean isExist=tTaskService.findTaskByName(task);
    		if(isExist){
    			this.addFieldError(TaskErrorMsg.NAMEEXIST, TaskErrorMsg.NAMEEXIST_MSG);
    		}
    	}
    	if(task.getName().length()<1){
    		this.addFieldError(TaskErrorMsg.NAME, TaskErrorMsg.NAME_MSG);
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
        //如果验证不通过就重新初始化添加客户和订单
        if(this.hasFieldErrors()){
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

	public TTask getTask() {
		return task;
	}

	public void setTask(TTask task) {
		this.task = task;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
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

	public TCompany getCompany() {
		return company;
	}

	public void setCompany(TCompany company) {
		this.company = company;
	}

	public TApplication getApp() {
		return app;
	}

	public void setApp(TApplication app) {
		this.app = app;
	}

	public TApplicationService gettApplicationService() {
		return tApplicationService;
	}

	public void settApplicationService(TApplicationService tApplicationService) {
		this.tApplicationService = tApplicationService;
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

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
