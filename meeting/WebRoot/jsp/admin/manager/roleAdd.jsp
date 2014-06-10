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
   
		/* 设置默认属性 */     
		   $.validator.setDefaults({     
		    submitHandler: function(form) { form.submit(); }     
		   });     
		   // 中文字两个字节     
		   jQuery.validator.addMethod("byteRangeLength", function(value, element, param) {     
		     var length = value.length;     
		     for(var i = 0; i < value.length; i++){     
		      if(value.charCodeAt(i) > 127){     
		     length++;     
		    }     
		  }     
		  return this.optional(element) || ( length >= param[0] && length <= param[1] );     
		}, "请确保输入的值在4-16个字符之间(一个中文字算2个字符)");     
		   
		/* 追加自定义验证方法 */     
		// 身份证号码验证     
		jQuery.validator.addMethod("tappRoles.roleName", function(value, element) {     
		  return this.optional(element) || /^[\u0391-\uFFE5\w]+$/.test(value); 
		}, "请正确输入角色名");
		//备注验证
		jQuery.validator.addMethod("tappRoles.roleDescribe", function(value, element) {     
		  return this.optional(element) || /^[\u0391-\uFFE5\w]+$/.test(value); 
		}, "请正确输入描述");
		
		jQuery.validator.addMethod("regex", //addMethod第1个参数:方法名称 
				function(value, element, params) { //addMethod第2个参数:验证方法，参数（被验证元素的值，被验证元素，参数） 
				var exp = new RegExp(params); //实例化正则对象，参数为传入的正则表达式 
				return exp.test(value); //测试是否匹配 
		},"格式错误");
		
		 
		$("#form").validate({
			rules:{
				roleName:{
					required: true,
					maxlength:10
				}
		   }
		});
		
		$("#regFrom").validate({     
		/* 设置验证规则 */     
		  rules: {     
		   "tappRoles.roleName": {     
		    required: true,     
		    "tappRoles.roleName": true,     
		   minlength: 4,
		    maxlength: 16      
		   },     
		   "tappRoles.roleDescribe": {     
		    required: true, 
		    "tappRoles.roleDescribe":true,    
		    minlength: 6,
		    maxlength: 60    
		   }
		   },
		    /* 设置错误信息 */ 
		    messages: {     
			"tappRoles.roleName": {     
		    required: "请填写角色名",
		     minlength: jQuery.format("输入至少{0}个字符"),
		    maxlength: jQuery.format("输入最多{0}个字符"), 
		    "tappRoles.roleName":"请输入中文,英文", 
		    byteRangeLength: "角色名必须在4-16个字符之间(一个中文字算2个字符)"     
		   },     
		   "tappRoles.roleDescribe": {     
		    required: "请填写描述",   
		     minlength: jQuery.format("输入至少{0}个字符"),
		    maxlength: jQuery.format("输入最多{0}个字符"),  
		    "tappRoles.roleDescribe": "描述在6到60个字符之间"      
		   } 
		   }    
		   });
		   }) 
		   
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
			   		    nodeString  += nodes[i].key+",";
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
			<form action="roleAdd!addRole.action" method="post" id="regFrom">
				<table class="inputtable" style="width: 100%;">
					<tr>
						<td class="c01">
							角色名称:<font color="red">&nbsp;<b>*</b>&nbsp;</font>
						</td>
						<td>
							<input name="tappRoles.roleName" type="text" value="<s:property value="tappRoles.roleName"/>"/>
                            
                            <font color="red"><s:fielderror fieldName="tappRoles.roleName" /></font>
                            <font color="red"><s:fielderror fieldName="tappRoles.roleNamet" /></font>
						</td>
					</tr>
					
					<tr>
						<td class="c01">
							权限选择:<font color="red">&nbsp;<b>*</b>&nbsp;</font>
						</td>
						<td>
							 <ul id="tree" class="ztree"></ul>			
						</td>
					</tr>
					
					<tr>
						<td class="c01">
							角色描述:
						</td>
						<td>
							<textarea cols="40" rows="7" name="tappRoles.roleDescribe" type="text" ><s:property value="tappRoles.roleDescribe"/></textarea>	
                              <font color="red"><s:fielderror
									fieldName="tappRoles.roleDescribe" />
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
