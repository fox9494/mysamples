<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/jstree/themes/classic/style.css" />
	<script src="<%=request.getContextPath() %>/js/jquery-1.8.3.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath() %>/js/jquery.jstree.js" type="text/javascript"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.hotkeys.js"></script>
   <script type="text/javascript" >
			 $(function () { 
			     $("#async_json_1").jstree({   
			       "themes": {
			                theme: 'classic'
			            },
			         "json_data" : {   
			             "ajax" : {  
			                 "url" : "channel/channelTree.shtml",  
			                 "data" : function (node) {   
			                     return { name : node.attr ? node.attr("id") : 0 };   
			                 }
			             }
			         },
			         "types":{
			             "max_depth" : -2,
			             "max_children" : -2,
			             "valid_children" : [ "drive" ],
			             "types":{
			                 "default" : {
			                       "valid_children" : "none",
			                       "icon" : {
			                       "image" : "<%=request.getContextPath() %>/js/jstree/themes/classic/d.png"
			                    }                               
			               },
			              "folder" : {
			
			                    // can have files and other folders inside of it, but NOT `drive` nodes
			
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
			
			            }
			
			        },
			        "ui":{
			             "initially_select" : [ "node_4" ]
			        },
			        "core":{
			           "initially_open" : [ "node_2" , "node_3" ]
			           
			        },        
			         "plugins" : [ "themes","json_data","ui","crrm","cookies","dnd","search","hotkeys","contextmenu","default-rtl" ] 
			        
			     })
			     
			     .bind("create.jstree", function (e, data) {
			                 $.ajax({
			
			                async : false,
			
			                type: 'POST',
			
			                url: "area/areaadd!addArea.shtml",
			
			                data : {
			
			                     "statename" : data.rslt.name,
			                     "parentid" :  data.rslt.parent.attr("id")
			                },
			
			                success : function (r) {
			
			                    if(!r.status) {
			
			                        data.inst.refresh();
			                                }
			                          }
			                     });
			            })
			           
			            .bind("select_node.jstree",function(e,data){
							  var this_id=data.rslt.obj[0].id;
							  //var parentId=$("#"+this_id).parent("ul").parent("li").attr("id");
							  
							  document.getElementById("parentid").value = this_id;
							  
							  })
							 
			            .bind("remove.jstree", function (e, data) {
			               if(data.rslt.obj.attr("id")==1){
			               alert("节点不能被删除");
			              data.inst.refresh();
			               return;
			            }
			
			        data.rslt.obj.each(function () {
			          
			            $.ajax({
			
			                async : false,
			
			                type: 'POST',
			
			                url: "area/areadelete!deleteArea.shtml",
			
			                data : {
			                    "id" : data.rslt.obj.attr("id")
			                },
			                 
			                success : function (r) {
			
			                    if(!r.status) {
			
			                        data.inst.refresh();
			                                }
			                          }
			                     });
			
			               });
			           })
			           .bind("rename.jstree", function (e, data) {
			           
			             console.dir(data);
			             
			
			        $.post(
			
			            "area/areaedit!editArea.shtml",
			
			            {
			
			
			                "id" : data.rslt.obj.attr("id"),
			
			                "statename" : data.rslt.new_name
			
			            },
			
			            function (r) {
			
			                if(!r.status) {
			
			                    $.jstree.rollback(data.rlbk);
			                           }
			                     }
			                 );
			            });
			           
			            
			 });


          function addArea(){
          
               var parentid= document.getElementById("parentid").value;
               var statename=document.getElementById("statename").value;
		       window.location="<%=request.getContextPath()%>/area/areaadd!addArea.shtml?parentid="+parentid+"&statename="+encodeURI(encodeURI(statename))+"";
	        }
	        
	       function deleteArea(){
	       
	           var id= document.getElementById("parentid").value;          
		       window.location="<%=request.getContextPath()%>/area/areadelete!deleteArea.shtml?id="+id;
	     
	        }
	        
	       function editArea(){
	           
	           var id= document.getElementById("parentid").value;
	           var statename=document.getElementById("statename").value;
		       window.location="<%=request.getContextPath()%>/area/areaedit!editArea.shtml?id="+id+"&statename="+encodeURI(encodeURI(statename))+"";
	        }
		
</script>

 
  </head>
  
  <body>
  <div class="demo" id="async_json_1" style="float:left">
  
  </div>
  <div style="float:left">&nbsp; 
  
  
  <button onclick="addArea()">增加</button>
  <button onclick="editArea()">修改</button>
  <button onclick="deleteArea()">删除</button>
 
  
  </div>
  <div style="float:left">
  <form method="post">
  <input type="hidden" id="parentid">
  <input type="text" name="statename" id="statename" />
  </form>
  
  </div>
  </body>
</html>
