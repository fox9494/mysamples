<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'tmodelinfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/jstree/themes/classic/style.css" />
	<script src="<%=request.getContextPath() %>/js/jquery-1.8.3.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath() %>/js/jquery-1.8.3.js" type="text/javascript"></script>
	
	
	
   <script type="text/javascript" class="source">
 $(function () { 
     $("#async_json_1").jstree({   
       "themes": {
                theme: 'classic'
            },
         "json_data" : {   
             "ajax" : {  
                 "url" : "manager/modelList!tModelList.shtml",  
                 "data" : function (NODE) {   
                     return { name : NODE.attr ? NODE.attr("id") : 0 };   
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
     
     .bind("click.jstree",function(e,data){
    	          
    	         var this_id= $(event.target).parents('li').attr('id');
    	         alert(this_id);
				 // var this_id=data.rslt.obj[0].id;
				  //var parentId=$("#"+this_id).parent("ul").parent("li").attr("id");
				  //document.getElementById("parentid").value = this_id;
				  //var parentid= document.getElementById("parentid").value;
				 // alert(this_id);
				  var parentid=this_id;
				 // alert(parentid);
				  window.location="<%=request.getContextPath()%>/manager/modelAdd!findModelInfo.shtml?parentId="+parentid;
				 
				  })   	
     .bind("select_node.jstree",function(e,data){
				  var this_id=data.rslt.obj[0].id;
				  //var parentId=$("#"+this_id).parent("ul").parent("li").attr("id");
				  document.getElementById("parentid").value = this_id;
				  //var parentid= document.getElementById("parentid").value;
				 
				  
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

                url: "manager/modeldelete!deleteModel.shtml",

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

            "company/areaedit!editarea.shtml",

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
    function onDisplay(){
    	 var parentid= document.getElementById("parentid").value;
    	 window.location="<%=request.getContextPath()%>/manager/modelAdd!findModelInfo.shtml?parentid="+parentid;
    }


</script>

 
  </head>
  
  <body>
  <div class="model" id="async_json_1" style="float:left">
  
  </div>
  <div style="float:left">
      <form action="manager/modelAdd!addModel.shtml" method="post">
      <input type="hidden" name="parentId" id="parentid"/>
      <table>
         <tr>
            <td>NAME:<input type="text" name="tmodel.name" /></td>        
         </tr>
         <tr>
            <td>CODE:<input type="text" name="tmodel.code" /></td>        
         </tr>
         <tr>
            <td>TYPE: <select style="width:100px" name="tmodel.type">						    	
					<option value="0">是</option>
					<option value="1" >否</option>
					  </select>
			</td>        
         </tr>
         <tr>
            <td>MODELORDER<input type="text" name="tmodel.modelOrder" /></td>        
         </tr>
         <tr>
            <td>ICON:<input type="text" name="tmodel.icon" /></td>        
         </tr>
         <tr>
            <td>URL:<input type="text" name="tmodel.url" /></td>        
         </tr>
         <tr>
         <td><input type="submit" value="提交"/></td>
         </tr>
         
      
      </table>
      
      </form> 
  </div>
  <div>
      <form method="post" name="tmodelx">
      <input type="hidden" name="parentId" id="parentid"/>
      <table>
         <tr>
            <td>NAME:<input type="text" value='<s:property value="tmodelx.name"/>' readonly="readonly" /></td>        
         </tr>
         <tr>
            <td>CODE:<input type="text" value='<s:property value="tmodelx.code"/>' readonly="readonly" /></td>        
         </tr>
         <tr>
            <td>TYPE:<input type="text" value='<s:property value="tmodelx.type"/>' readonly="readonly"/>
			</td>        
         </tr>
         <tr>
            <td>MODELORDER<input type="text" value='<s:property value="tmodelx.modelOrder"/>' readonly="readonly" /></td>        
         </tr>
         <tr>
            <td>ICON:<input type="text" value='<s:property value="tmodelx.icon"/>' readonly="readonly" /></td>        
         </tr>
         <tr>
            <td>URL:<input type="text" value='<s:property value="tmodelx.url"/>'  readonly="readonly"/></td>        
         </tr>
         
         
      
      </table>
      </form>
  
  </div>
  </body>
</html>
