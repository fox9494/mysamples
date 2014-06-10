<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>筛选渠道</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/list2.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/jstree/themes/classic/style.css" />
	<script src="<%=request.getContextPath() %>/js/jquery-1.8.3.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath() %>/js/jquery.jstree.js" type="text/javascript"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.hotkeys.js"></script>
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
					      $("#province").append("<option value='"+data[i].attr.id+"'>"+data[i].statename+"</option>");
					   }
					   //$("#province").trigger("change");
					}																							          						    
	 	  });
	 	  //得到所有爱好信息
     	  $.ajax({
		   			url:"<%=path%>/hobbies/hobbiesList!findAllHobbies.shtml",
		   			type:'post',
		   			dataType:'json',
	       			cache:false, 
           			success:function(data){          			            			      															
					   $.each(data,function(index,HobbiesVo){					     
                          $("#hibbie").append("<input type='checkbox' value='"+HobbiesVo.hobbiesid+"' name='hobbies.hobbiesid'/>"+HobbiesVo.tagname+"");
					   });				   
					}																							          						    
	 	   });
	 	   //得到市级节点
	       $("#province").change(function(){
	           $.ajax({
		   			url:"<%=path%>/area/areaList!getAreaById.shtml?parentId="+$("#province").val(),
		   			type:'post',
		   			dataType:'json',
	       			cache:false, 
           			success:function(data){           															
					   for(var i=0;i<data.length;i++){
					      $("#city").append("<option value='"+data[i].attr.id+"'>"+data[i].statename+"</option>");
					   }
					   if($("#province").val()==""){
					      $("#city").append("<option value='' selected='selected'><--请选择市--></option>");
					   }
					}																							          						    
	 		   });
	 		   $("#city").html("");
	       });
          //以树的形式得到所有渠道
          $("#channel_json").jstree({
            "themes": {
                theme: 'classic'
            },
            "json_data" : {
            
                "ajax" : {

                "url" : "<%=path%>/task/screeningChannel!getAllChannels.shtml",

                "data" : function (NODE) {

                    return {
                    
                         name : NODE.attr ? NODE.attr("id") : 0

                      };

                }
            }
                
            },
            "type":{
                "max_depth" : -2,
                "max_children" : -2,
                "valid_children" : [ "drive" ],
                "types":{
                      "default" : {
                           "valid_children" : "none",
                            "default":{
                                "icon":{
                                    "image" : "<%=request.getContextPath() %>/js/jstree/themes/classic/d.png"
                                }
                            }     
                      }                  
                 },
                 "folder" : {
                      "valid_children" : [ "default", "folder" ],
                      "icon" : {
                        "image" : "/static/v.1.0pre/_demo/folder.png"
                       }
                 },
                 "drive" : {
                       "valid_children" : [ "default", "folder" ],
                       "icon" : {
                         "image" : "/static/v.1.0pre/_demo/root.png"
                       },
                       "start_drag" : false,
                       "move_node" : false,
                       "delete_node" : false,
                       "remove" : false
                 }
            },
            "ui" : {
            // this makes the node with ID node_4 selected onload
            "initially_select" : [ "node_4" ]
            },
            "core" : {
            // just open those two nodes up
            // as this is an AJAX enabled tree, both will be downloaded from the server
            "initially_open" : [ "node_2" , "node_3" ]
            },
            "plugins" : [ "themes", "json_data","checkbox", "ui" ]
          
          }).bind("check_node.jstree", function (e, data) { 
                
                   
          });
          
          $("#sub").click(function(){
          
              var array=new Array();
              
              $("#channel_json .jstree-checked").each(function(){
                      
                var node = $(this);
                
                array.push(node.attr("id"));
              
              });            
              if(array.length!=0){
                $("#channelids").attr("value",array);
                document.addForm.action="<%=path%>/task/screeningChannel!addScreeningChannel.shtml";
                document.addForm.submit();
              }else{
                document.addForm.action="<%=path%>/task/screeningChannel!addScreeningChannel.shtml";
                document.addForm.submit();
              }
              /* else{
                $("#msg").html("<font color='red'>请选择渠道</font>");
              } */
          });
      });
      
      //返回添加应用
      function goback(){
      
          window.location="<%=path%>/task/screeningChannel!goback.shtml?app.appid="+$("#appid").val()+"&task.taskid="+$("#taskid").val()+"&confiresubmit="+$("#confiresubmit").val()+"&submitApk="+$("#submitApk").val();
      }
    </script>
  </head>
    
  <body style="overflow-y:auto;border:none;">
    <form method="post" action="task/screeningChannel!addScreeningChannel.shtml" name="addForm">
      <input type="hidden" name="info" id="channelids"/>
      <input type="hidden" name="confiresubmit" id="confiresubmit" value="<s:property value="confiresubmit"/>"/>
      <input type="hidden" name="task.taskid" value="<s:property value="task.taskid"/>" id="taskid"/>
      <input type="hidden" name="app.appid" value="<s:property value="app.appid"/>" id="appid"/>
      <input type="hidden" name="submitApk" value="<s:property value="submitApk"/>" id="submitApk"/>
      <div>根据渠道属性进行筛选</div>
      <div class="demo" id="channel_json" align="left">
      
      
      </div>
      

      <div class="list" style="margin-top:22px;">
      <p>根据用户属性进行筛选</p>
      <table align="left" border="1" width="500px" cellpadding="0" cellspacing="0" class="table">
          <tr>
            <td>区域：</td>
            <td><select id="province"><option value=""><--请选择省份 --></option></select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select id="city" name="taskAttribute.areaId"><option value=""><--请选择市--></option></select></td>
          </tr>
          <tr>
            <td>性别：</td>
            <td><select name="taskAttribute.sex"><option value=""><--请选择性别--></option><option value="1">男</option><option value="0">女</option></select></td>
          </tr>
          <tr>
            <td>年龄段：</td>
            <td><input type="text" style="width: 50px;" name="taskAttribute.startAge"/>至<input type="text" style="width: 50px;" name="taskAttribute.endAge"/></td>
          </tr>
          <tr>
            <td>爱好：</td>
            <td id="hibbie"></td>
          </tr>
      </table>
      </div>
      <div>
        <input type="button" value="保存" id="sub" class="graybtn"/><input type="button" value="返回" onclick="goback()" class="graybtn"/>
      </div>
    </form>
  </body>
</html>
