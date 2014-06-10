<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix ="s" uri ="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adduserclient.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery.validate.js"></script>
    <script type="text/javascript" src="<%=path%>/js/messages_zh.js"></script>
    <link href="<%=path %>/css/form.css" rel="stylesheet" type="text/css"/>
    <script language="javascript" type="text/javascript"
			src="<%=path%>/js/My97DatePicker/WdatePicker.js" ></script>
			
	<!-- 前台验证 -->
    <script type="text/javascript">
       $(document).ready(function(){
           /* 设置默认属性 */     
		   $.validator.setDefaults({     
			    submitHandler: function(form) { 
			       if($("#d12").val()>$("#d13").val()){
			         alert("截止时间不能小于开始时间");
			         return ;
			       }
			         form.submit(); 
			    } 
		   }); 
		   $("#addForm").validate({
			 /* 设置验证规则 */     
		    rules: {     
			   "company.name": {     
			    required: true,     
			    minlength: 1,
			    maxlength: 20    
			   },   
			   "order.name": {     
			    required: true,     
			    minlength: 1,
			    maxlength: 20    
			   }, 
			   "order.startDate": {     
			    required: true     		     
			   },
			   "order.endDate": {     
			    required: true,     
			    minlength: 1,
			    maxlength: 20    
			   },
			   "order.totalmoney": {     
			    required: true,     
			    minlength: 1,
			    maxlength: 10    
			   },
			   "order.unitprice": {     
			    required: true,     
			    minlength: 1,
			    maxlength: 10    
			   }				            			   
			 },
			 message:{
			   "company.name": {     
		           required: "请填写行业名称"
		        },
		        "order.unitprice": {     
		           required: "请填写电话号码"		        
		        }     		        
			 }
		    });        
       }); 
    </script>
    
    <script type="text/javascript">
       //得到所有客户
       function searchCompany(){
          
          window.location="<%=path%>/companyorder/companyorderAdd!getAllCompany.shtml";
       }
       
       //返回
       function goBack(){
          window.location="<%=path%>/companyorder/companyorderList!searchList.shtml";
       }
	</script>
  </head>
  
  <body>
       <div class="main" style="padding-top:20px;">
       <form action="companyorder/companyorderAdd!save.shtml" method="post" id="addForm">
         <input type="hidden" name="company.id" value="<s:property value="company.id"/>"/>
         <div class="form">
          <table cellspacing="0" border="0">
             <tr>
                 <td class="title">
                                                                      客户名称:
                 </td>
                 <td >
                       <input type="text" name="company.name" value="<s:property value="company.name"/>" readonly="readonly"/>
                       <input type="button" value="搜索" onclick="searchCompany()"/>                           
                       <font color="red"><s:fielderror fieldName="companyOrder.companyName"/></font>
                 </td>
              </tr>
              <tr>
                 <td>
                                                                      任务类型:
                 </td>
                 <td >                                                     
                        <select name="order.type">
                              <option value="0" <s:if test="">selected="selected"</s:if>>下载</option>
                              <option value="1" <s:elseif test="">selected="selected"</s:elseif>>安装</option>
                              <option value="2" <s:elseif test="">selected="selected"</s:elseif>>激活</option>
                        </select>
                 </td>
              </tr>
              <tr>
                 <td>
                                                                          应用名称:
                 </td>
                 <td >
                         <input type="text" name="order.name" value="<s:property value="order.name"/>" class="required"/>    
                         <font color="red"><s:fielderror fieldName="companyOrder.nameExist"/></font> 
                         <font color="red"><s:fielderror fieldName="companyOrder.companyOrderName"/></font>                                 
                 </td>
              </tr>
              <tr>
                 <td>
                                                                  订单开始时间:
                 </td>
                 <td>
                           <input id="d12" type="text" name="order.startDate" value="<s:date name="order.startDate" format="yyyy-MM-dd"/>" class="dateISO"/>
                           <img onclick="WdatePicker({el:$dp.$('d12')})" src="<%=path%>/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="middle"/>
                           <font color="red"><s:fielderror fieldName="companyOrder.startDate"/></font>                          
                 </td>
              </tr>
              <tr>
                 <td>
                                                                  订单结束时间:
                 </td>
                 <td>                                                 
                           <input id="d13" type="text" name="order.endDate" value="<s:date name="order.endDate" format="yyyy-MM-dd"/>" class="dateISO"/>
                           <img onclick="WdatePicker({el:$dp.$('d13')})" src="<%=path%>/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="middle"/>
                           <font color="red"><s:fielderror fieldName="companyOrder.endDate"/></font>                          
                 </td>
              </tr>
               <tr>
                 <td>
                                                                   订单总金额:
                 </td>
                 <td >
                           <input type="text" name="order.totalmoney" value="<s:property value="order.totalmoney"/>" class="number"/>
                           <font color="red"><s:fielderror fieldName="companyOrder.totalMoney"/></font>                          
                           <font color="red"><s:fielderror fieldName="companyOrder.totalMoney_unitPrice"/></font>                          
                 </td>
              </tr>
               <tr>
                 <td>
                                                                       任务单价:
                 </td>
                 <td >                                                       
                           <input type="text" name="order.unitprice" value="<s:property value="order.unitprice"/>" class="number"/>
                           <font color="red"><s:fielderror fieldName="companyOrder.unitPrice"/></font>                                                   
                 </td>
              </tr>
            </table>
             <div class="buttongroup">
                   <input type="submit" value="提交" class="graybtn"/>
                   <input type="button" value="返回" onclick="goBack()" class="graybtn"/>
             </div>
             <div>
             </div>
         </div>
       </form>
       </div>
  </body>
</html>
