<%@ page language="java" import="com.soarsky.octopus.utils.*" pageEncoding="utf-8"%>
<%@taglib prefix="my" uri="/WEB-INF/tlds/frame.tld" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'arealist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">	
    <link rel="stylesheet" href="<%=path%>/css/alert.css" type="text/css"/>
	<link rel="stylesheet" href="<%=path%>/css/task.css" type="text/css"/>
	<link rel="stylesheet" href="<%=path%>/css/jquery-ui-1.9.2.custom.css" type="text/css"/>
	<script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery-ui-1.9.2.custom.js"></script>
	<script type="text/javascript" src="<%=path%>/js/table.js"></script>
	<link href="<%=path %>/css/form.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="<%=path%>/js/jquery.validate.js"></script>
    <script type="text/javascript" src="<%=path%>/js/messages_zh.js"></script>
    
    <!-- 前台验证 -->
    <script type="text/javascript">
        $(document).ready(function(){
           /* 设置默认属性 */     
		   $.validator.setDefaults({     
			    submitHandler: function(form) { 
			         form.submit(); 
			    } 
		   }); 
		   $("#addForm").validate({
			/* 设置验证规则 */     
		    rules: {     
			   "channelInvite.name": {     
			    required: true,     
			    minlength: 1,
			    maxlength: 20    
			   },
			   "channelInvite.mobile": {     
			    required: true,     
			    minlength: 7,
			    maxlength: 12    
			   },  
			   "channelInvite.email": {     
			    required: true		       
			   }        			   
			 },
			 message:{
			    "hobbies.tagname": {     
		        required: "请填写爱好名称", 
		        "hobbies.tagname":"名称在1到20个字符之间" 
		        }    		        
			 }
		    }); 
		    if($("#modelError").val()!=""){
		       alert("请上传标准的推送模版");
		    }
       });
       //搜索查詢
	   function searchInfo(cur){
			document.getElementById("currentPage").value = cur;
			var search = document.getElementById("search_form");
			search.action="channelinvite/channelInviteList!searchList.shtml";
			search.submit();
	   }
       //导入EXCEL推送
       function addInvite(){
          var path=$("#excel").val();
          if(path==""){
	          alert("请选择文件");
	          return;
	      }else if(!/\.(xls)|(xlsx)$/.test(path)){
			  alert("请上传excel文件");
			  return;
	      }
          document.addform.action="<%=request.getContextPath()%>/channelinvite/channelInviteAdd!save.shtml";
          document.addform.submit();
       }
       //下载模版
       function downLoadExcel(){
          window.location.href="<%=PathUtil.getHttpPath()%>/upload/excel/template.xls";
       }
    </script>
    
  </head>
  <body>
     <div class="main" style="padding-top:20px;">
     <form action="channelinvite/channelInviteAdd!save.shtml" method="post" enctype="multipart/form-data" id="addForm" name="addform">
       <input type="hidden" name="channelId" value="<s:property value="channelId"/>">
       <input type="hidden" name="modelError" value="<s:property value="modelError"/>" id="modelError">
       <div class="form">
       <table cellspacing="0" border="0">
         <tr>
           <td class="title">姓名：</td>
           <td><input type="text" name="channelInvite.name"/></td>
         </tr>
         <tr>
           <td>手机号码：</td>
           <td><input type="text" name="channelInvite.mobile" class="phone"/></td>
         </tr>
         <tr>
           <td>邮箱：</td>
           <td><input type="text" name="channelInvite.email" class="email"/></td>
         </tr>  
         <tr>
           <td colspan="2"><center><input type="submit" value="保存并推送"/></center></td>
         </tr>     
       </table>
       </div>
       <div style="float: left"><input type="button" value="下载模版" onclick="downLoadExcel()"/>&nbsp;&nbsp;<input type="file" name="excel" id="excel"/>&nbsp;&nbsp;<input type="button" value="推送" onclick="addInvite()"/></div>
       </form>      
       <form action="" enctype="multipart/form-data" method="post">
       <input type="hidden" name="channelId" value="<s:property value="channelId"/>">      
       <div class="list">
       <table cellspacing="0" border="0">
          <tr class="head">
            <td>编号</td>
            <td>姓名</td>
            <td>手机号码</td>
            <td>邮箱</td>
            <td>推送时间</td>
          </tr>
          <s:iterator value="pageBean.list" id="invite">
            <tr>
              <td><s:property value="#invite.id"/></td>
              <td><s:property value="#invite.name"/></td>
              <td><s:property value="#invite.mobile"/></td>
              <td><s:property value="#invite.email"/></td>
              <td><s:date name="#invite.inviteDate" format="yyyy-MM-dd hh:dd:ss"/></td>
            </tr>
          </s:iterator>
        </table>
        <div class="">
		       <s:if test="pageBean.allRow!=0">
		         	<div class="css" style="style">
						<a href="javascript:void(0)" onclick="searchInfo(1)">首页</a>&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" onclick="searchInfo(${pageBean.currentPage-1})">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="javascript:void(0)" onclick="searchInfo(${pageBean.currentPage+1})">下一页</a>&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" onclick="searchInfo(${pageBean.totalPage})">尾页</a>
						一共有${pageBean.allRow}条记录 &nbsp;共${pageBean.totalPage}页&nbsp;当前是第${pageBean.currentPage}页
						转到<input type="text" name="pageBean.currentPage"  style="width:35px; text-align: center;" onblur="this.value=this.value.replace(/[^\d\.]+/g,'')"
								onafterpaste="this.value=this.value.replace(/[^\d\.]+/g,'')" id="pagenum"/>&nbsp;页<input type="button" value="go" onclick="searchInfo(document.getElementById('pagenum').value)"/>
			    	</div>
	         	</s:if>
	         	<s:else>	         	    
	         		<div style="text-align:center;padding-top:5px;padding-right:5px;">
						未找到数据
			    	</div>
	         	</s:else>
		</div>
       </div>
     </form>
     <s:form  method="post" id="search_form">
  		    <input name="currentPage" type="hidden" id="currentPage"/>
  		    <input type="hidden" name="channelId" value="<s:property value="channelId"/>">  
  	 </s:form>
     </div>
  </body>
</html>
