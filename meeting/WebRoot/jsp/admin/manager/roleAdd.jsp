<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ include file="../../common/libs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" / >
		<meta http-equiv="description" content="This is my page" / >

		<%@ include file="../../common/scripts.jsp"%>
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
	    		   //treeObj.expandNode(treeNode.getParentNode(), true, false, true);
	    	   }
	      }
		 
		 var zNodes = ${treeJson};
		 var modueIdValues ="${moduleIds}";//选中的值
		 
		 //根据后台返回的值选中树节点
		 function setNodeCheck(){
			 var modelArray = new Array(); 
			 modelArray= modueIdValues.split(",");
			 $.each(modelArray,function(index,value){
				 var node = zTreeObj.getNodeByParam("id", value, null);
				 zTreeObj.selectNode(node);
			 });
	     }
        
         $(document).ready(function(){ 
        	 zTreeObj = $.fn.zTree.init($("#tree"), setting, zNodes);//初始化树
        	 
        	 setNodeCheck();
        	 
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
 				     maxlength: 50
 				   }    			   
 				 },
 				 message:{
 				    "role.roleName": {     
 			          required: "请输入角色名称", 
 			          maxlength: jQuery.format("输入不能超过{0}个字符")
 			        },
 			        moduleIds: {     
 			        required: "请选择权限", 
 			        maxlength: jQuery.format("输入不能超过{0}个字符")
 			        },  
 			        "role.remark": {     
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
			   $("#addRoleForm").submit();
			}
        </script>
    
	</head>

	<body>
		<div class="rightContent">
			<div class="toolpad clearfix">
				<label style="font-size: 14px"><strong>添加角色</strong></label>
			</div>
			<form action="adminRoleAdd!addRole.action" method="post" id="addRoleForm">
				<table class="inputtable" style="width: 100%;">
					<tr>
						<td class="c01">
							角色名称:<font color="red">&nbsp;<b>*</b>&nbsp;</font>
						</td>
						<td>
							<input name="role.roleName" type="text" value="<s:property value="role.roleName"/>"/>
                            
                            <font color="red"><s:fielderror fieldName="role.hasExist" /></font>
						</td>
					</tr>
					
					<tr>
						<td class="c01">
							权限选择:<font color="red">&nbsp;<b>*</b>&nbsp;</font>
						</td>
						<td>
							 <ul id="tree" class="ztree"></ul>	
							 <input type="hidden" name="moduleIds" id="moduleIds"/>		
							 <font color="red"><s:fielderror fieldName="role.tree" /></font>
						</td>
					</tr>
					
					<tr>
						<td class="c01">
							角色描述:
						</td>
						<td>
							<textarea cols="40" rows="7" name="role.remark"  value ="<s:property value="role.remark"/>"></textarea>	
                              <font color="red"><s:fielderror fieldName="role.remark" />
							</font>				
						</td>
					</tr>
					
					
					
					
				</table>
				<br>

				<div class="toolpad tcenter">
					<input type="button" style="width: 100px;" value="提  交"  onclick="javascrpit:submitForm();"/>
                    <input type="reset" style="width: 100px;" value="返回"  onclick="goBackRoleList()"/>
				</div>

			</form>
		</div>
	</body>
</html>
