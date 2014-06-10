<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String imagePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/gxupload";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		     
		<script language="javascript" type="text/javascript"
			src="<%=path %>/js/My97DatePicker/WdatePicker.js" ></script>
		<link rel="stylesheet" type="text/css" href="<%=path%>/css/list2.css" />	
	    <link href="<%=path %>/css/form.css" rel="stylesheet" type="text/css"/>
	    <script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.js"></script>
	    <script type="text/javascript" src="<%=path%>/js/jquery.validate.js"></script>
        <script type="text/javascript" src="<%=path%>/js/messages_zh.js"></script>
        <style >
        	.editapp tr td{white-space:nowrap; }
        	.radioinput{line-height:32px;padding-top:0;}
        	.radioinput input{height:12px!important;margin-right:5px;background-color:#ffffff!important;border:none!important;background-image:url()!important;width:22px!important;}
        </style>
        <!-- 前台验证 -->
        <script type="text/javascript">
          $(document).ready(function(){
	           /* 设置默认属性 */     
			   $.validator.setDefaults({     
				    submitHandler: function(form) { 
				       if($("#rating").val()>5){
		                 alert("评分不能大于5分");
		                 return ;
		               }
				         form.submit(); 
				    } 
			   }); 
			   $("#editForm").validate({
				/* 设置验证规则 */     
			    rules: {     
				   "app.platform": {     
				    required: true,     
				    minlength: 1,
				    maxlength: 20    
				   },   
				   "app.versionrequire": {     
				    required: true,     
				    minlength: 1,
				    maxlength: 10    
				   },
				   "app.initDownLoad": {     
				    required: true,     
				    minlength: 1,
				    maxlength: 100    
				   },
				   "app.rating": {     
				    required: true,				       
				   },				   
				   "app.description": {     
				    required: true,	
				    minlength: 1,
				    maxlength: 1000	       
				   }		            			   
				 },
				 message:{
				   "company.name": {     
			        required: "请填写行业名称" ,
			        "company.name":"名称在1到20个字符之间" 
			        },
			        "company.phone": {     
			        required: "请填写电话号码" ,
			        "company.phone":"电话号码在6到12个字符之间" 
			        }     		        
				 }
			    });        
           }); 
        </script>
        
        <script type="text/javascript">
        
          var sumAddButton=0;
          
		  function uploadAPK(){
		   var path=$("#apk").val();
		   if(path==""){
		     alert("上传前请选择APK文件");
		     return;
		   }else if(!/\.(apk)$/.test(path)){
			           alert("请上传APK文件!");
			           return;
		   } 
		   document.getElementById("editForm").action="<%=request.getContextPath()%>/application/applicationEdit!uploadApk.shtml";
		   document.form.submit();
		  }
		  
		  function addVersion(){
		   var b=null;
		   var y=0;
		   var versionNo=$("#versionNo").val();
		   if(versionNo==""){
		        alert("请先上传APK");
		        b=false;
		        return false;
		   }
		   /* $("input[name='img']").each(function(i){
		       var v=$(this).val().lastIndexOf(".");
		       var v1=$(this).val().substr(v,4);
		       if($(this).val()!=""){
		   		if (v1!=".png"&&v1!=".PNG"){
		   			$(this).focus();
		   			alert("请上传png格式图片"+i);
		   			b=false;
		   		    return false;
		   		}else{
		   		    b=true;
		   		}
		   	   }else{
		   	        return false;
		   	   }
		   }); */
		   var icon1=$("#icon").val();
		   
		   if(icon1==""||icon2==""){
		      b=false;
		      alert("请上传图标");
		   }
		   return b;
		  }
		  
		  /*function goBackAddVersion(){
		     window.location="<%=request.getContextPath()%>/versionList!searchListPage.action?app.appId="+$("#appId").val()+"&typeId="+$("#typeId").val();
		  }*/
		  
		 //增加截图行
		  function addButton(){
		  
		     sumAddButton++;
		     
		     $("#eximg").append("<tr id='"+sumAddButton+"'><td>应用截图</td><td><input type='file' name='img'/><input type='hidden' name='imgid' value='0'/><font color='red'>图片大小240*320</font></td><td><input type='button' value='删除' onclick='removeButton("+sumAddButton+")'><td/></tr>");
		  
		  }
		  //删除截图行
		  function removeButton(sum){
		     
		     $("#"+sum).hide();
		  }
		  
		  //查看所有特定分辨率APK
		  function editSpecialApk(){
		     
		     window.location="<%=request.getContextPath()%>/application/specialApkEdit!searchList.shtml?app.appid="+$("#appid").val()+"&task.taskid="+$("#taskid").val()+"&company.id="+$("#companyid").val();
		  }
		  
		  //获取修改的图片ID
		  function getImgIDs(){		         
			     var array=new Array();
			     $("input[name='img']:file").each(function(index1){			       
			         if($(this).val()!=""){
				        $("input[name='imgid']:hidden").each(function(index2){			            		            
				            if(index1==index2){		       
				              array.push($(this).val());
				            } 
				        });
				      }  		         		          
			     });
			     $("#imgids").attr("value",array);			     
			     //document.form.action="<%=request.getContextPath()%>/application/applicationEdit!save.shtml";
			     //document.form.submit();
		  }
		  
		  //返回任务界面
		  function goback(){
		    window.location="<%=request.getContextPath()%>/task/taskEdit!input.shtml?info="+$("#taskid").val();
		  }
        </script>
	</head>

	<body  style="overflow-y:auto;"> 	       
		   <div class="main" style="padding-top:20px;">
		     <div align="center">		  
			   <form action="" style="border-bottom:1px solid #dedede;margin-bottom:5px;padding-bottom:0;">
			     <table id="toplist" style="width:100%">
			       <tr class="btarea">
				     <td width="150">
				       <s:if test="app.appid!=null">
				         <a href="javascript:;" class="graybtn"  onclick="editSpecialApk()">修改特定apk</a>
				       </s:if>
				      </td>
			        </tr>
			      </table>
			    </form>
		      </div>	  
			<form  method="post"  enctype="multipart/form-data" name="form" action="application/applicationEdit!save.shtml" id="editForm">
            <input type="hidden" name="entityapk.apkSize" value="<s:property value="entityapk.apkSize"/>"/>
            <input type="hidden" name="entityapk.downloadUrl" value="<s:property value="entityapk.downloadUrl"/>"/>
            <input type="hidden" name="entityapk.uploadDate" value="<s:property value="entityapk.uploadDate"/>"/> 
            <input type="hidden" name="entityapk.isDefault" value="<s:property value="entityapk.isDefault"/>"/>
            <input type="hidden" name="task.taskid" value="<s:property value="task.taskid"/>" id="taskid"/>
            <input type="hidden" name="task.name" value="<s:property value="task.name"/>" id="taskname"/>
            <input type="hidden" name="company.id" value="<s:property value="company.id"/>" id="companyid"/>
            <input type="hidden" name="app.appid" value="<s:property value="app.appid"/>" id="appid"/>
            <input type="hidden" name="app.iconUrl" value="<s:property value="app.iconUrl"/>"/>
            <input type="hidden" name="imgids" id="imgids"/>
            <div class="form">
             <table cellspacing="0" border="0" class="editapp">
                   <tr>
                      <td width=180>
                                                                       上传APK： 
                       </td>
                       <td>
                           <input type="file" name="apk" id="apk"/><input type="button" value="上传" style="width: 80px;margin-left:12px;" onclick="uploadAPK()"/>
                           <font color="red"><s:fielderror fieldName="app.apk"/></font>     
                       </td> 
                   </tr>
                   <tr>
						<td>
							版本包名:
						</td>
						<td> 
							<input name="app.package_name" value="<s:property value='app.package_name'/>" readonly="readonly" class="required"></input>
                            <font color="red">上传apk文件后自动获取</font>
						</td>
				   </tr>
				   <tr>                
						<td>
							版本号：
						</td>
						<td> 
							<input name="app.version" value="<s:property value='app.version'/>" readonly="readonly" id="versionNo" class="required"></input>
                             <font color="red">上传apk文件后自动获取</font>
						</td>
				   </tr>
				   <tr>
						<td>
							运行平台：
						</td>
						<td>
							<input name="app.platform" value="<s:property value='app.platform'/>"></input>
						    <font color="red">&nbsp;<b>*</b>&nbsp;</font>
							<font color="red"><s:fielderror fieldName="app.platform"/></font>
						</td>
				   </tr>
                   <tr>
						<td>
							版本要求：
						</td>
						<td>
							<input name="app.versionrequire" value="<s:property value='app.versionrequire'/>"></input>
						    <font color="red">&nbsp;<b>*</b>&nbsp;</font>
							<font color="red"><s:fielderror fieldName="app.versionrequire"/></font>
						</td>
				   </tr>
                   <tr>
						<td>
							图示(ICON)：
						</td>
						<td>
							<s:if test="app.appid!=null">
								 <input type="file" name="icon" id="icon"/>				    
							     <font color="red"><s:fielderror fieldName="app.icon"/></font>
							</s:if>
							<s:else>
							     <input type="file" name="icon" id="icon" class="required"/>						     
							     <font color="red"><s:fielderror fieldName="app.icon"/></font>
							</s:else>						
						</td>
						<td>
					       
				        </td>
				  </tr> 
				  <tr>
						<td>
							初始下载量：
						</td>
						<td>
							<input name="app.initDownLoad" value="<s:property value='app.initDownLoad'/>" class="number"></input>
						    <font color="red"><s:fielderror fieldName="app.initDownLoad"/></font>
						    <font color="red">&nbsp;<b>*</b>&nbsp;</font>
						</td>
				   </tr>
				   <tr>
						<td>
							评分：
						</td>
						<td>
							<input name="app.rating" value="<s:property value='app.rating'/>" id="rating" class="number"></input>
						    <font color="red">&nbsp;<b>*</b>&nbsp;</font>
                            <font color="red"><s:fielderror fieldName="app.rating"/></font>
						</td>
				   </tr>
				   <tr>
                      <td>
                                                                             费用类型： 
                       </td>
                       <td>
                         <s:if test="app.costType==0">
                             <input type="radio" name="app.costType" value="0" checked="checked"/>免费
                             <input type="radio" name="app.costType" value="1"/>限时免费
                         </s:if>
                         <s:elseif test="app.costType==1">
                              <input type="radio" name="app.costType" value="0"/>免费
                             <input type="radio" name="app.costType" value="1" checked="checked"/>限时免费                       
                         </s:elseif>
                         <s:elseif test="app.costType==null">
                             <input type="radio" name="app.costType" value="0" checked="checked"/>免费
                             <input type="radio" name="app.costType" value="1"/>限时免费                            
                         </s:elseif>                           
                       </td>                      
                       <td><font color="red"><s:fielderror fieldName="app.costType"/></font></td> 
                   </tr>                  
                   <s:if test="app.appid!=null">
                       <s:iterator id="img" value="imgs" status="st">
                   <tr>			           
								<td>
									应用截图：
								</td>
								<td>
									 <input type="file" name="img"/>
									 <font color="red">图片大小240*320</font>
									 <input type="hidden" name="imgid" value="<s:property value='#img.id'/>"/>									 
								</td>
								<s:if test="#st.index==0">
								<td>
					                  <input type="button" value="增加截图" id="addbutton" onclick="addButton()"/>
				                </td>
								</s:if>
					</tr> 									    
					    </s:iterator>					   
				    </s:if>    										   
				    <s:if test="app.appid==null">
				    <tr>				   
							<td>
								应用截图：
							</td>
							<td>
								 <input type="file" name="img" class="required"/>
								 <font color="red">图片大小240*320</font>
								 <input type="hidden" name="imgid" value="0"/><br/>
								 <font color="red"><s:fielderror fieldName="app.img"/></font>
							</td>	
							<td>
					             <input type="button" value="增加截图" id="addbutton" onclick="addButton()"/>
				            </td>
				   </tr>			   
				   </s:if>				   	       					             			          
				   <tbody id="eximg">
				    
				    
				   </tbody>
                   <tr>
						<td>
						             应用描述：
						</td>
						<td>
							<textarea name="app.description" rows="14" cols="60"><s:property value='app.description'/></textarea>                     
						    <font color="red"><s:fielderror fieldName="app.description"/></font>
						</td>						
					</tr> 
				</table>
				<div class="buttongroup">
					 <input type="button" value="返回任务界面" onclick="goback()" class="graybtn" />
                   <input type="submit" value="提交" class="graybtn" onclick="getImgIDs()"/>&nbsp;                  
                </div>
			   </div>
			</form>
			</div>	    
	</body>
</html>
