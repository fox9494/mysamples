<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
    <script src="<%=request.getContextPath() %>/js/jquery.jstree.js" type="text/javascript"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.hotkeys.js"></script>
    <link rel="stylesheet" href="<%=path%>/css/alert.css" type="text/css"/>
	<link rel="stylesheet" href="<%=path%>/css/task.css" type="text/css"/>
	<link rel="stylesheet" href="<%=path%>/css/jquery-ui-1.9.2.custom.css" type="text/css"/>
	<script type="text/javascript" src="<%=path%>/js/jquery-ui-1.9.2.custom.js"></script>
	<script type="text/javascript" src="<%=path%>/js/table.js"></script>
    
   <script type="text/javascript" >
    $(function () { 
 
       $("#async_json_1").jstree({   
       "themes": {
                theme: 'classic'
            },
         "json_data" : {   
             "ajax" : {  
                 "url" : "manager/modelList!tModelList.shtml",
                 "cache":false,  
                 "data" : function (NODE) {   
                     return { name : NODE.attr ? NODE.attr("id") : 0 };   
                 } 
             } 
         },
        "ui":{
             "initially_select" : [ "node_4" ]
        },
        "core":{
           "initially_open" : [ "node_2" , "node_3" ]
           
        },        
         "plugins" : ["themes","json_data","ui","crrm","hotkeys" ] 
        
     }).bind("loaded.jstree",function(e,data){
        
	      // $("#async_json_1").jstree("deselect_all",$("#async_json_1"));
	      data.inst.open_all(-1);//展开所有
     
     }) 	
     .bind("select_node.jstree",function(e,data){
				  var this_id=data.rslt.obj[0].id;
				  $("#parentid").val(this_id);
				  
				  //查询详情
			      $.ajax({
					  url: "<%=request.getContextPath()%>/manager/modelAdd!findModelInfo.shtml?tmodelx.id="+this_id,
					  cache: false,
					  dataType: "json",
					  success: function(data){
					    $("#namex").val(data.name);
					    $("#code").val(data.code);
					    if (data.type==0){
		 	     		    $("#type").val("菜单项");
					    }else{
					    	$("#type").val("非菜单项");
					    }
					    $("#order").val(data.modelOrder);
					    $("#icon").val(data.icon);
					    $("#url").val(data.url);
					  }
				});
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


</script>

 
  </head>
  
 <body>
 <div class="demo jstree jstree-5 jstree-default jstree-focused main" id="async_json_1" style="width: auto;float: left;">
 </div>
 <div class="main">
 <table>
  <tr>
     <td style="width: 200px"> </td>
     <td>
     <h3>增加</h3>
	      <form action="manager/modelAdd!addModel.shtml" method="post">
	      
	      <input type="hidden" name="parentId" id="parentid"/>
	      <table>
	         <tr>
	            <td>模块名:</td>   
	            <td><input type="text" name="tmodel.name" /></td>     
	         </tr>
	         <tr>
	            <td>模块code:</td>  
	            <td><input type="text" name="tmodel.code" /></td>      
	         </tr>
	         <tr>
	            <td>模块类型:</td>     
				<td>
				   <select style="width:100px" name="tmodel.type">						    	
						<option value="0">菜单模块</option>
						<option value="1" >非菜单模块</option>
				      </select>
				</td>   
	         </tr>
	         <tr>
	            <td>序号:</td>  
	            <td><input type="text" name="tmodel.modelOrder" /></td>      
	         </tr>
	         <tr>
	            <td>图标地址:</td>   
	            <td><input type="text" name="tmodel.icon" /></td>     
	         </tr>
	         <tr>
	            <td>模块URL:</td> 
	            <td><input type="text" name="tmodel.url" /></td>       
	         </tr>
	         <tr>
	         
	         <td><input type="submit" value="提交"/></td>
	         </tr>
	      </table>
	      </form> 
     </td>
     <td>
      <h4>详情</h4>
      <form method="post" name="tmodelx">
      <input type="hidden" name="parentId" id="parentid-detail" />
      <table>
         <tr>
            <td>模块名:</td>        
            <td><input type="text" value='<s:property value="tmodelx.name"/>' readonly="readonly" id="namex"/></td>
         </tr>
         <tr>
            <td>模块code:</td>        
            <td><input type="text" value='<s:property value="tmodelx.code"/>' readonly="readonly" id="code"/></td>
         </tr>
         <tr>
            <td>模块类型:</td>
			<td><input type="text" id="type"  readonly="readonly"/></td>
			 
         </tr>
         <tr>
            <td>序号:</td>        
            <td><input type="text" id="order" value='<s:property value="tmodelx.modelOrder"/>' readonly="readonly" /></td>
         </tr>
         <tr>
            <td>图标地址:</td>        
            <td><input type="text" id="icon" value='<s:property value="tmodelx.icon"/>' readonly="readonly" /></td>
         </tr>
         <tr>
            <td>模块URL:</td>        
            <td><input type="text" id="url" value='<s:property value="tmodelx.url"/>'  readonly="readonly"/></td>
         </tr>
      
      </table>
      </form>
     
     
     </td>
  </tr>
  </table>
</div>
 
</body>
</html>
