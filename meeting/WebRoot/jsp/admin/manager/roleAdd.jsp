<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link href="css/pf_style.css" rel="stylesheet" type="text/css" />
        <link href="css/cmxform.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="js/jquery1.7.1.min.js"></script>		
		<script type="text/javascript" src="js/jquery.validate.js"></script>
		<script type="text/javascript" src="js/messages_zh.js"></script>
		<link rel="stylesheet" href="css/zTreeStyle/zTreeStyle.css" type="text/css">
		<script type="text/javascript" src="js/jquery.ztree.core-3.5.js"></script>
		<script type="text/javascript" src="js/jquery.ztree.excheck-3.5.js"></script>

      
		<script type="text/javascript">
		 
		 var zTreeObj;//定义ztree对象
		 
		 //ztree的参数设置
		 var setting = {
					check: {
						enable: true
					},
					data: {
						simpleData: {
							enable: true
						}
					},
					callback: {
						onCheck: zTreeOnCheck
					}
		  };
		 
		 function zTreeOnCheck(event, treeId, treeNode){
	    	   if(treeNode.getParentNode()){
	    		   treeObj.expandNode(treeNode.getParentNode(), true, false, true);
	    	   }
	      }
		 
		 var zNodes = ${treeJson};
        
         $(document).ready(function(){ 
        	 
        	 zTreeObj = $.fn.zTree.init($("#tree"), setting, zNodes);
        	 $("#addRoleForm").validate({
 				/* 设置验证规则 */     
 			    rules: {     
 				   "role.roleName": {     
 				      required: true,     
 				      maxlength: 20    
 				   },
 				    moduleIds: {     
 				     required: true     
 				   },
 				   "role.remark":{
 				     required: true,
 				     maxlength: 50
 				   }    			   
 				 },
 				 message:{
 				    "role.roleName": {     
 			          required: "请输入角色名称", 
 			          maxlength: jQuery.format("输入不能超过{0}个字符")
 			        },
 			        moduleIds: {     
 			        required: "无金币总数", 
 			        maxlength: jQuery.format("输入不能超过{0}个字符")
 			        },  
 			        "role.remark": {     
 			           required: "无结算金额",
 			           maxlength: jQuery.format("输入不能超过{0}个字符")
 			        }		        
 			 	}
 		    });
   
			
		});
		
		
		   
		   function goBackRoleList(){
		    window.location="<%=request.getContextPath()%>/roleList!searchListPage.action";
	       }
         
           //提交表单
           function submitForm(){
			   if ($("#roleName").val()==""){
			   	  Boteng.DialogBox.message("请输入角色名称");
			   	   $("#roleName").focus();
			   	   return;
			   }
			   var treeObj = $.fn.zTree.getZTreeObj("tree");
			   var nodes = treeObj.getCheckedNodes(true);
			   if (nodes.length>0){
			        var nodeString = "";
			   		for(var i=0;i<nodes.length;++i){

			   			//if(!nodes[i]['isParent'])
			   			//{
			   			//	nodeString += (nodes[i]['key'] + ",");
			   			//}
			   		    nodeString  += nodes[i].id+",";
			   		};
			   		//截取最后一个逗号
			   		$("#moduleIds").val(nodeString.substr(0,nodeString.length-1));
			   }else{
			   	   alert("请选择角色操作模块");
			   	   return;
			   };
			   
			   $("#form").submit();
			}
        </script>
    
	</head>

	<body>
		<div class="rightContent">
			<div class="toolpad clearfix">
				<label style="font-size: 14px"><strong>添加角色</strong></label>
			</div>
			<form action="roleAdd!addRole.action" method="post" id="addRoleForm">
				<table class="inputtable" style="width: 100%;">
					<tr>
						<td class="c01">
							角色名称:<font color="red">&nbsp;<b>*</b>&nbsp;</font>
						</td>
						<td>
							<input name="role.roleName" type="text" value="<s:property value="tappRoles.roleName"/>"/>
                            
                            <font color="red"><s:fielderror fieldName="role.roleName" /></font>
						</td>
					</tr>
					
					<tr>
						<td class="c01">
							权限选择:<font color="red">&nbsp;<b>*</b>&nbsp;</font>
						</td>
						<td>
							 <ul id="tree" class="ztree"></ul>	
							 <input type="hidden" name="moduleIds"/>		
						</td>
					</tr>
					
					<tr>
						<td class="c01">
							角色描述:
						</td>
						<td>
							<textarea cols="40" rows="7" name="role.remark"  ></textarea>	
                              <font color="red"><s:fielderror
									fieldName="role.remark" />
							</font>				
						</td>
					</tr>
					
					
					
					
				</table>
				<br>

				<div class="toolpad tcenter">
					<input type="submit" style="width: 100px;" value="提  交"  onclick="javascrpit:submitForm();"/>
                    <input type="reset" style="width: 100px;" value="返回"  onclick="goBackRoleList()"/>
				</div>

			</form>
		</div>
	</body>
</html>
