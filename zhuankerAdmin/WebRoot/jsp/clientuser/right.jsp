<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="my" uri="/WEB-INF/tlds/frame.tld" %>
<%@taglib prefix ="s" uri ="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>My JSP 'left.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="<%=path%>/css/alert.css" type="text/css"/>
	<link rel="stylesheet" href="<%=path%>/css/task.css" type="text/css"/>
	<link rel="stylesheet" href="<%=path%>/css/list2.css" type="text/css"/>
	<link rel="stylesheet" href="<%=path%>/css/jquery-ui-1.9.2.custom.css" type="text/css"/>
	<script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery-ui-1.9.2.custom.js"></script>
	<script type="text/javascript" src="<%=path%>/js/table.js"></script>
     <script src="<%=path %>/js/jquery.XYTipsWindow.2.8.js" type="text/javascript"></script>
    <script type="text/javascript">
    $(function(){    			
            //得到省级节点
     		$.ajax({
		   			url:"<%=path%>/area/areaList!initUserArea.shtml",
		   			type:'post',
		   			dataType:'json',
	       			cache:false, 
           			success:function(data){         			        			             															
					   for(var i=0;i<data.length;i++){
					    if(data[i].attr.id==$("#provinceL").val()){
					       $("#province").append("<option value='"+data[i].attr.id+"' selected='selected'>"+data[i].statename+"</option>");
					    }else{
					       $("#province").append("<option value='"+data[i].attr.id+"'>"+data[i].statename+"</option>");
					    }
					   }
					   $("#province").trigger("change");
					}																							          						    
	 		});
	 		//得到所有爱好信息
     		$.ajax({
		   			url:"hobbies/hobbiesList!findAllHobbies.shtml",
		   			type:'post',
		   			dataType:'json',
	       			cache:false, 
           			success:function(data){    
           			    var charSize=$("#hobbiesids").val().length;
	 		            var hobbieids=new Array();
                            hobbieids=$("#hobbiesids").val().substring(1,charSize-1).split(",");	 		                															
					   for(var i=0;i<data.length;i++){
					       var logic=false;
					       $.each(hobbieids,function(index,hobbie){					          					            				           
					            if(hobbie==data[i].hobbiesid){					                   
						               logic=true;
						        }
					        });					
                            if(logic){
					                  
					                   $("#checks").append("<div style='width:80px;display:block;float:left;'><input type='checkbox' value='"+data[i].hobbiesid+"' name='hobbies.hobbiesid' checked='checked'/>"+data[i].tagname+"</div>");
						    }else{					              
						               $("#checks").append("<div style='width:80px;display:block;float:left;'><input type='checkbox' value='"+data[i].hobbiesid+"' name='hobbies.hobbiesid' />"+data[i].tagname+"</div>");
						    }    
					   }	
					    $("#checks").append('<div style="clear:both;width:100%;text-align:center;margin-left:200px;margin-top:20px;"><a href="javascript:;" class="btn" id="checkboxsurebtn" onclick="reflashcheckbox(this)" style="clear:both;">确定</a></div>	');					   
					
					}																							          						    
	 		});
	 		
	 		
	     //得到市级节点
    	 $("#province").change(function(){
    	 if($("#province").val()==-1){
    	 		$("#city").html("");
    			$("#city").append("<option value=''>"+"<--请选择市-->"+"</option>");
    	 	}else{
    	 	$.ajax({
		   			url:"<%=path%>/area/areaList!getAreaById.shtml?parentId="+$("#province").val(),
		   			type:'post',
		   			dataType:'json',
	       			cache:false, 
           			success:function(data){           															
					   for(var i=0;i<data.length;i++){
					      if(data[i].attr.id==$("#cityL").val()){					   		
					   			$("#city").append("<option value='"+data[i].attr.id+"' selected='selected'>"+data[i].statename+"</option>");		 										 					   				     
	                      }else{
	                            $("#city").append("<option value='"+data[i].attr.id+"'>"+data[i].statename+"</option>");		 										 				
	                      }				   
					   }
					}																							          						    
	 		   });
	 		   $("#city").html("");
    	 	}	           
	         });   					       
	 });
	 //初始化详情信息
	 function initDetails(userid){
	   window.location="<%=path%>/userclient/userclientDetails!initUserDetails.shtml?userclient.id="+userid;
	 }
    </script>  
  </head>
  
  <body>
  	<div class="main">
	  <form action="<%=path %>/userclient/userclientList!findUserByConditions.shtml" method="post">
	    <input type="hidden" value="<s:property value="area.id"/>" id="cityL">
        <input type="hidden" value="<s:property value="province"/>" id="provinceL">
        <input type="hidden" value="<s:property value="hobbiesids"/>" id="hobbiesids">
		<div class="list">
		<table cellspacing="0" border="0">
		   <tr ><td>登录账号:<input type="text" name="userclient.userName" value="<s:property value="userclient.userName"/>"/></td>
			<td>区域:<select id="province" name="province"><option value="-1"><--请选择省--></option></select>&nbsp;<select id="city" name="area.id"><option value="-1"><--请选择市--></option></select></td>
		   <td>性别:<select name="userclient.sex"><option value="-1" <s:if test="userclient.sex==-1">selected='selected'</s:if>><--选择--></option><option value="1" <s:if test="userclient.sex==1">selected='selected'</s:if>>男</option><option value="0" <s:if test="userclient.sex==0">selected='selected'</s:if>>女</option></select></td>
			<td>年龄:    <input type="text" style="width: 50px;" name="startage" onkeyup="if(isNaN(value))execCommand('undo')"  value="<s:property value="startage"/>"/>至
               <input type="text" style="width: 50px;" name="endage"   onkeyup="if(isNaN(value))execCommand('undo')" value="<s:property value="endage"/>"/></td></td>
			<td id="hibbies">爱好：</td><td><input type=text name="inputname" class="input" id="checkboxinput"><div class="checks"  id="checks"><div class="checkboxsure"></div></div></td>
			
                <td><center><input type="submit" value="查询"  align="middle"/></center></td>
            </tr>
		</table>
		</div>
		<div class="list">
			<table cellspacing="0" border="0">
				<tr class="head">
				   <td>登录账号</td>
		           <td>昵称</td>
		           <td>客户级别</td>
		           <td>手机</td>
		           <td>邮箱</td>
		           <td>当前金币</td>
				</tr>
				 <s:iterator value="pageBean.list" id="userClient">
		           <tr>
		             <td>		             
		             	<a href="javascript:void(0)" onclick="initDetails(<s:property value='#userClient.id'/>)"><s:property value="#userClient.userName"/></a>   		                       	
		             </td>
		             <td><s:property value="#userClient.nickName"/></td>
		             <td><s:property value="#userClient.leveCode"/></td>                          
		             <td><s:property value="#userClient.phone"/></td>
		             <td><s:property value="#userClient.email"/></td>            
		             <td><s:property value="#userClient.current_gold"/></td>                  
		           </tr>
		         </s:iterator>
				
			</table>
			<div class="">
			   <my:page total="${pageBean.allRow}" pageSize="${pageBean.pageSize}" showNum="2" currentPage="${pageBean.currentPage}"></my:page>
			</div>
		 </div>
		 <script type="text/javascript">
		 		$(".input").click(function(){
						$.XYTipsWindow({
							___title:"爱好选择框",
							___content:'text:'+$('#checks').html(),
							___width:"586",
							___height:"138",
							___drag:"___boxTitle",
							___showbg:true
						});
						 $("#checks :checkbox").each(function(){
								var value = $(this).val();
								 if($(this).attr("checked")){
									 $(".___boxContent :checkbox").each(function(d){
									 		if($(this).val() == value) $(this).attr("checked","true");
									 });
								 }else{
									 $("#checks :checkbox").each(function(d){
									 	 if($(this).val() == value)  $(this).removeAttr("checked");
									 });	
								 }
							});
					});
						function reflashcheckbox(obj){
							var inputshowstr ="";
							 $(".___boxContent :checkbox").each(function(){
								var value = $(this).val();
								 if($(this).attr("checked")){
									  $("#checks :checkbox").each(function(d){
									  		if($(this).val() == value) {
									 			$(this).attr("checked","true");
									 			inputshowstr += $($(this)[0].parentNode)[0].innerText+"   ";
									 		}
									 });
								 }else{
									 $("#checks :checkbox").each(function(d){
									 	 if($(this).val() == value)  $(this).removeAttr("checked");
									 });	
								 }
							});
							$("#checkboxinput").val(inputshowstr);
							$.XYTipsWindow.removeBox();
							
						}
		 </script>
		</form>
	</div>
  </body>
</html>
