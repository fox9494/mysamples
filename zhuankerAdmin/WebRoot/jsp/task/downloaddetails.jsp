<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="my" uri="/WEB-INF/tlds/frame.tld" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
      <title>渠道详情</title>
        		
	</head>

	<body>
	      <div class="main">
		   <div class="btarea line"></div>
		    <form action="" method="post">
		        <input type="hidden" name="app.appid" value="<s:property value="app.appid"/>" id="appid"/>     			    	        
		        <input type="hidden" id="currentPage"  value="<s:property value="pageBean.currentPage"/>" name="pageBean.currentPage"/>		        			    	        
		        <input type="hidden" id="totalPage"  value="<s:property value="pageBean.totalPage"/>" name="pageBean.totalPage"/>		        			
		        <div class="search">
		           <ul>
		             <li style="width: 200px">
		               <p>总下载量：</p><input type="text" value="<s:property value="pageBean.allRow"/>"/>
		             </li>
		           </ul>
		        </div>
		        <div class="list">
				<table cellspacing="0" border="0">
		              <tr class="head">
		                <td>用户昵称</td>
		                <td>用户登录账号</td>
		                <td>下载时间</td>
		              </tr>
		              <tbody id="listDown">
		              <s:iterator value="pageBean.list" id="downloadLog">
		                <tr>
		                 <td><s:property value="#downloadLog.TUserClient.nickName"/></td>
		                 <td><s:property value="#downloadLog.TUserClient.userName"/></td>
		                 <td><s:date name="#downloadLog.operateDate" format="yyyy-MM-dd"/></td>
		                </tr>
		              </s:iterator>
		              </tbody>
		        </table>
		        <div class="">
		           <center>
		           <s:if test="pageBean.allRow!=0">
		         	<div class="css" style="style">
						<a href="javascript:void(0)" onclick="searchInfo(1)">首页</a>&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" onclick="searchInfo(document.getElementById('currentPage').value-1)">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="javascript:void(0)" onclick="searchInfo(document.getElementById('currentPage').value*1+1)">下一页</a>&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" onclick="searchInfo(document.getElementById('totalPage').value)">尾页</a>
						一共有${pageBean.allRow}条记录 &nbsp;共${pageBean.totalPage}页&nbsp;当前是第<font id="showCurrentPage">${pageBean.currentPage}</font>页
						转到<input type="text" name="pageBean.currentPage"  style="width:35px; text-align: center;" onblur="this.value=this.value.replace(/[^\d\.]+/g,'')"
								onafterpaste="this.value=this.value.replace(/[^\d\.]+/g,'')" id="pagenum"/>&nbsp;页<input type="button" value="go" onclick="searchInfo(document.getElementById('pagenum').value)"/>
			    	 </div>
		         	</s:if>
		         	<s:else>	         	    
		         		<div style="text-align:center;padding-top:5px;padding-right:5px;">
							未找到数据
				    	</div>
		         	</s:else>
		         	</center>
		          </div>
                  </div>
             </form>                  
           </div> 
	</body>
</html>
