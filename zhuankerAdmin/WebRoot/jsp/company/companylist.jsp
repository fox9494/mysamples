<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%@taglib prefix="my" uri="/WEB-INF/tlds/frame.tld"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

	<title>My JSP 'clientuserlist.jsp' starting page</title>
	
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
    <link rel="stylesheet" href="<%=path%>/css/alert.css" type="text/css"/>
	<link rel="stylesheet" href="<%=path%>/css/task.css" type="text/css"/>
	<link rel="stylesheet" href="<%=path%>/css/jquery-ui-1.9.2.custom.css" type="text/css"/>
	<script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery-ui-1.9.2.custom.js"></script>
	<script type="text/javascript" src="<%=path%>/js/table.js"></script>
    <script type="text/javascript">
       //添加客户
       function addUser(){
          window.location.href="<%=path%>/company/companyAdd!initAddUserClient.shtml";
       }
       
       //修改客户
       function updateUser(){
          var array=getId();
          if(array.length!=0&&array.length>1){
             alert("只能一个一个修改");
             return;
          }
          if(array.length==0){
             return;
          }
          window.location.href="<%=path%>/company/companyEdit!initUserClient.shtml?info="+array;
          
       }
       
       //删除客户
       function deleteUser(){        
         array=getId();        
         if(array.length==0){
             return;
         }       
         window.location.href="<%=path%>/company/companyDelete!removeUserClient.shtml?info="+array;
       }
       
       //订单管理
       function manageOrder(){
          
          window.location="<%=path%>/companyorder/companyorderList!searchList.shtml";
       }
       
       function getId(){
		var array = new Array(); 
		//用于保存 选中的那一条数据的ID   
        var flag;
        var param=""; //判断是否一个未选   
        $("input[name='selectFlag']:checkbox").each(function() { //遍历所有的name为selectFlag的 checkbox  
                    if ($(this).attr("checked")) { //判断是否选中    
                        flag = true; //只要有一个被选择 设置为 true  
                    }  
        });  
        if (flag) {  
        $("input[name='selectFlag']:checkbox").each(function() { //遍历所有的name为selectFlag的 checkbox  
                      if ($(this).attr("checked")) { //判断是否选中                
                           array.push($(this).val()); //将选中的值 添加到 array中   
                      }  
        });                   
            //将要集体删除的数据 传递给action处理   
					
        } else {  
            alert("请至少选择一个客户"); 
        }  
		
		return array;
       }
       
        //全选
       function checkAll(){
         if($("input[name='all']:checkbox").attr("checked")){
             $("input[name='selectFlag']:checkbox").each(function(){
               $(this).attr("checked",true);          
             });            
         }else{
             $("input[name='selectFlag']:checkbox").each(function(){
               $(this).attr("checked",false);
             });          
         }        
       }
    </script>
</head>

<body>
		<div class="main">
		<div class="btarea line">
	       <a href="javascript:;" class="graybtn" id="add" onclick="addUser()">新增</a>
	       <a href="javascript:;" class="graybtn" onclick="updateUser()">修改</a>
	       <a href="javascript:;" class="graybtn" onclick="deleteUser()">删除</a>
	       <!-- <a href="javascript:;" class="graybtn" onclick="manageOrder()">订单管理</a> -->
		</div>
		
		<form action="company/companyList!findByConditions.shtml" method="post">
			<div class="search">
			   <ul> 
					<li>
					   <p>客户名称：</p><input type="text" name="company.name" value="<s:property value="company.name"/>" />
					</li>
					<li>
					   <p>所属行业:</p>
					                <select name="channelindustry.name">
						                   <option value=""><--请选择行业 --></option>
										   <s:iterator value="channelIndustrys" id="channelIndustry">
												<option value="<s:property value="#channelIndustry.name"/>" <s:if test="#channelIndustry.name==channelindustry.name">selected="selected"</s:if>><s:property value="#channelIndustry.name" /></option>
										   </s:iterator>
					                 </select>
					    	                  
					 </li>
					 <li>
				        <input type="submit" class="button" value="查询"/> 
				     </li>
				</ul>
			  </div>
				<div class="list">
					<table cellspacing="0" border="0">
					   <tr class="head"><th><input type="checkbox" name="all" onclick="checkAll()" />全选</th>
							<td>客户名称</td>
							<td>所属行业</td>
							<td>所在城市</td>
							<td>联系人</td>
							<td>联系电话</td>
							<td>邮箱</td>
							<td>创建时间</td>
					    </tr>
							<s:iterator value="pageBean.list" id="tCompany">
								<tr>
									<th><input type="checkbox" name="selectFlag"
										value="<s:property value="#tCompany.id"/>" />
									</th>
									<td><s:property value="#tCompany.name" />
									</td>
									<td><s:property value="#tCompany.channelIndustry.name" />
									</td>
									<td><s:property value="#tCompany.area.statename" />
									</td>
									<td><s:property value="#tCompany.contactName" />
									</td>
									<td><s:property value="#tCompany.phone" />
									</td>
									<td><s:property value="#tCompany.email" />
									</td>
									<td><s:date name="#tCompany.createDate"
											format="yyyy-MM-dd" />
									</td>
								</tr>
							</s:iterator>
					</table>
					<div class="">
						<my:page total="${pageBean.allRow}" pageSize="${pageBean.pageSize}" showNum="2" currentPage="${pageBean.currentPage}"></my:page>
					</div>
				</div>
		</form>
	</div>
</body>
</html>
