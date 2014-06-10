<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/upload";
String imagePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/gxupload";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		
        <script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.js"></script>
        
		<script language="javascript" type="text/javascript"
			src="js/My97DatePicker/WdatePicker.js" ></script>
			
        
          
        
	</head>

	<body>
		    <form action="">
                <table>
		            <tr>
		              <td>APK文件：</td>
		              <td><input type="text" value="<s:property value="apk.downloadUrl"/>" id="url" readonly="readonly"/><a <s:if test="apk.downloadUrl!=''">href="<%=basePath %><s:property value='apk.downloadUrl'/>"</s:if>>下载</a></td>
		            </tr>
		            <tr>
		              <td>包名：</td>
		              <td><input type="text" value="<s:property value="app.package_name"/>" readonly="readonly"/></td>
		            </tr>
		            <tr>
		              <td>版本号：</td>
		              <td><input type="text" value="<s:property value="app.version"/>" readonly="readonly"/></td>
		            </tr>
		            <tr>
		              <td>运行平台：</td>
		              <td><input type="text" value="<s:property value="app.platform"/>" readonly="readonly"/></td>
		            </tr>
		            <tr>
		              <td>版本要求：</td>
		              <td><input type="text" value="<s:property value="app.versionrequire"/>" readonly="readonly"/></td>
		            </tr>
		            <tr>
		              <td>图标ICON：</td>
		              <td><input type="text" value="<s:property value="app.iconUrl"/>" readonly="readonly"/></td>
		            </tr>
		            <tr>
		              <td>初始下载量：</td>
		              <td><input type="text" value="<s:property value="app.initDownLoad"/>" readonly="readonly"/></td>
		            </tr>
		            <s:iterator value="imgs" id="img">
		            <tr>
			              <td>应用截图：</td>
			              <td><input type="text" value="<s:property value="#img.imageUrl"/>" readonly="readonly"/></td>
		            </tr>
		            </s:iterator>
		            <tr>
		              <td>应用描述：</td>
		              <td><textarea rows="14" cols="60" readonly="readonly"><s:property value="app.description"/></textarea></td>
		            </tr>
		        </table>
            </form>
	</body>
</html>
