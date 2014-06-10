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
      <title>渠道详情</title>
	</head>

	<body style="overflow-y:auto;border:none;">
		    <form action="">
		        <p>渠道</p>
                <table border="1" class="table">
		            <s:iterator value="channels" id="channel">
		              <tr>
		                <td>
		                    <select><option><s:property value="#channel.channelName"/></option></select>
		                </td>
		              </tr>
		            </s:iterator>
		        </table>
		        <div class="list" style="margin-top:22px;">
		        <p>属性选择</p>		
                <table align="left" border="1" width="500px" cellpadding="0" cellspacing="0" class="table">
		              <tr>
		                <td>区域：</td>
		                <td><select><option><s:property value="province.statename"/></option></select>&nbsp;&nbsp;<select><option><s:property value="city.statename"/></option></select></td>
		              </tr>
		              <tr>
		                <td>性别：</td>
		                <td><select>
		                    <s:if test="attr.sex==1">
		                       <option selected="selected">男</option>
		                    </s:if>
		                    <s:if test="attr.sex==0">
		                       <option selected="selected">女</option>
		                    </s:if>
		                </select></td>
		              </tr>
		              <tr>
		                <td>年龄段：</td>
		                <td><input value="<s:property value="attr.startAge"/>" readonly="readonly"/>至<input value="<s:property value="attr.endAge"/>" readonly="readonly"/></td>
		              </tr>
		              <tr>
		                <td>爱好：</td>
		                <td>
		                   <s:iterator value="hobbies" id="hobbie">
		                     <input type="checkbox" checked="checked"/><s:property value="#hobbie.tagname"/>
		                   </s:iterator>
		                </td>
		              </tr>
		        </table>
		        </div>
            </form>
	</body>
</html>
