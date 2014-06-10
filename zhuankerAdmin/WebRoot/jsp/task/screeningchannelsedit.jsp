<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    
    
    <title>筛选渠道</title>
    
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
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
           //得到所有爱好信息
     		$.ajax({
		   			url:"<%=path%>/hobbies/hobbiesList!findAllHobbies.shtml",
		   			type:'post',
		   			dataType:'json',
	       			cache:false, 
           			success:function(data){       			   
           			   var charSize=$("#taskHobbiesids").val().length;
                       var hobbieids=new Array();
                           hobbieids=$("#taskHobbiesids").val().substring(1,charSize-1).split(",");                          															
					   for(var i=0;i<data.length;i++){
					        var logic=false;
					        $.each(hobbieids,function(index,hobbie){					          					            				           
					            if(hobbie==data[i].hobbiesid){					                   
						               logic=true;
						        }
					        });						      
					        if(logic){
					                  
					                   $("#hibbies").append("<input type='checkbox' value='"+data[i].hobbiesid+"' name='hobbies.hobbiesid' checked='checked'/>"+data[i].tagname+"");
						    }else{					              
						               $("#hibbies").append("<input type='checkbox' value='"+data[i].hobbiesid+"' name='hobbies.hobbiesid' />"+data[i].tagname+"");
						    }         					   	     
					    }
					 }																							          						    
	 		  });
	 		
           //得到省级节点
           $.ajax({
		   			url:"<%=path%>/area/areaList!initUserArea.shtml",
		   			type:'post',
		   			dataType:'json',
	       			cache:false, 
           			success:function(data){           															
					   for(var i=0;i<data.length;i++){
						    if(data[i].attr.id==$("#provinceid").val()){
						        $("#province").append("<option value='"+data[i].attr.id+"' selected='selected'>"+data[i].statename+"</option>");
						    }else{
						        $("#province").append("<option value='"+data[i].attr.id+"'>"+data[i].statename+"</option>");
						    }
					   }
					   if($("#provinceid").val()==""){
           			        $("#province").append("<option value='' selected='selected'><--请选择省--></option>");
           			   }else{
           			        $("#province").append("<option value='' ><--请选择省--></option>");
           			   }
					   $("#province").trigger("change");
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
           			   if($("#province").val()==""){
           			         $("#city").append("<option value='' selected='selected'><--请选择市--></option>");  
           			   }       															
					   for(var i=0;i<data.length;i++){
						     if(data[i].attr.id==$("#cityid").val()){
						        $("#city").append("<option value='"+data[i].attr.id+"' selected='selected'>"+data[i].statename+"</option>");
						     }else{
						        $("#city").append("<option value='"+data[i].attr.id+"'>"+data[i].statename+"</option>");
						     }
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
          
          }).bind("loaded.jstree", function (event, data) { 
                 var charSize=$("#taskChannelids").val().length;                
                 var channids=new Array();
                     channids=$("#taskChannelids").val().substring(1,charSize-1).split(",");                                        
               $("#channel_json").find("li").each(function(){
                     var treeid=$(this).attr("id");
                     var logic=false;
                     $.each(channids,function(index,channelid){                                                              
                               if(index>0){                            					          					            				           
					             if(channelid.substring(1,channelid.length)==treeid){					                   
						               logic=true;
						         }
						        }else{
						         if(channelid==treeid){					                   
						               logic=true;
						         }
						        }
					 });                    
                     if(logic){
                         $("#channel_json").jstree("check_node",$(this));
                     }
               });
           });   
          
          $("#sub").click(function(){
          
              var array=new Array();
              
              $("#channel_json .jstree-checked").each(function(){
                      
                var node = $(this);
                
                array.push(node.attr("id"));
              
              });
              $("#channelids").attr("value",array);
          });
      });
      //返回
      function goBack(){
         window.location="<%=path%>/task/taskEdit!input.shtml?info="+$("#taskid").val();
      }
    </script>
  </head>
    
  <body style="overflow-y:auto;border:none;">
    <form method="post" action="task/screeningChannelEdit!editChannel.shtml" >
      <input type="hidden" name="info" id="channelids"/>
      <input type="hidden" name="task.taskid" value="<s:property value="task.taskid"/>" id="taskid"/>
      <input type="hidden" name="" id="taskChannelids" value="<s:property value="taskChannelids"/>"/>
      <input type="hidden" name="" id="taskHobbiesids" value="<s:property value="taskHobbiesids"/>"/>
      <input type="hidden" name="" value="<s:property value="taskAttribute.areaId"/>" id="cityid"/>
      <input type="hidden" name="" value="<s:property value="province.parentId"/>" id="provinceid"/>
      <div>根据渠道属性进行筛选</div>
      <div class="demo" id="channel_json" align="left">
      
      </div>
      
      <div class="list" style="margin-top:22px;">
      <p>根据用户属性进行筛选</p>
      <table align="left" border="1" width="500px" cellpadding="0" cellspacing="0" class="table">
          <tr>
            <td>区域：</td>
            <td><select id="province"></select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select id="city" name="taskAttribute.areaId"></select></td>
          </tr>
          <tr>
            <td>性别：</td>
            <td><select name="taskAttribute.sex"><option value="" <s:if test="taskAttribute.sex==null">selected='selected'</s:if>><--请选择性别--></option><option value="1" <s:if test="taskAttribute.sex==1">selected='selected'</s:if>>男</option><option value="0" <s:if test="taskAttribute.sex==0">selected='selected'</s:if>>女</option></select></td>
          </tr>
          <tr>
            <td>年龄段：</td>
            <td><input type="text"  style="width: 50px;" name="taskAttribute.startAge" value="<s:property value="taskAttribute.startAge"/>"/>至<input type="text" style="width: 50px;" name="taskAttribute.endAge" value="<s:property value="taskAttribute.endAge"/>"/></td>
          </tr>
          <tr>
            <td>爱好：</td>
            <td id="hibbies"></td>
          </tr>
      </table>
      </div>
      <div><input type="submit" value="保存" id="sub" class="graybtn"/><input type="button" value="返回" onclick="goBack()" class="graybtn"/></div>
    </form>
  </body>
</html>
