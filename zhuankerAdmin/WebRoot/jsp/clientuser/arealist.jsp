<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="my" uri="/WEB-INF/tlds/frame.tld" %>
<%@taglib prefix ="s" uri ="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html
PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'arealist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache,must-revalidate">
	<meta http-equiv="expires" content="Wed, 26 Feb 1997 08:21:57 GMT">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	  
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/jstree/themes/classic/style.css" />
	<link rel="stylesheet" href="<%=path%>/css/list2.css" type="text/css"/>
	<link rel="stylesheet" href="<%=path%>/css/jquery-ui-1.9.2.custom.css" type="text/css"/>
	<script src="<%=request.getContextPath() %>/js/jquery-1.8.3.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath() %>/js/jquery.jstree.js" type="text/javascript"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.hotkeys.js"></script>
    <script type="text/javascript" src="js/jquery.validate.js"></script>
	<script type="text/javascript" src="js/messages_zh.js"></script>
    <link href="<%=path %>/css/form.css" rel="stylesheet" type="text/css"/>
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
                 "url" : "area/areaList!areaList.shtml?"+(new Date()).valueOf(), 
                 "cache":false, 
                 "data" : function (node) {
                    
                     return { name : node.attr ? node.attr("id") : 0 };   
                 }  
                 
             } 
         },
         "types" : {
           "draggable" : false

        },
         
        "ui":{
             "initially_select" : [ "node_4" ]
           
        
        },
        "core":{
           "initially_open" : [ "node_2" , "node_3" ]
           
        },        
        "plugins" : [ "themes","json_data","ui","crrm","search","hotkeys","default-rtl","types" ] 
        
     })
     .bind("loaded.jstree",function(e,data){
        
	      data.inst.open_all(-1);//展开所有
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
				  var parentId=$("#"+this_id).parent("ul").parent("li").attr("id");	
				  document.getElementById("id").value = this_id;
				  document.getElementById("parentId").value = parentId;
				  var length=$("#"+this_id).parent("ul").parent("li").attr("id");
				  document.getElementById("length").value = length;

				  
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

         //增加区域
          function addArea(){
               var id= document.getElementById("id").value;
               var statename=document.getElementById("statename").value;
               var length=document.getElementById("length").value;
            if(length>1){
                    alert("不能增加区域了");
              }
            else{
               if(id==""){
                 alert("请选择一个节点");
               }               
               else{
               if(!/^[\u0391-\uFFE5\w]+$/.test(statename)){
                  $("#msg").html("<font color='red'>区域名为空或者不正确，请重新输入</font>");
                  return ;
               }
               else {
              
				$.ajax({
		   			url:"<%=path%>/area/areaadd!judgeName.shtml?parentid="+id+"&statename="+encodeURI(encodeURI(statename))+"",
		   			type:'post',
		   			dataType:'json',
	       			cache:false, 
           			success:function(data){      															
					    $("#judgeName").val(data.judgeName);
					     var judgeName=document.getElementById("judgeName").value;
			          if(judgeName==0){
			        
			              alert("该节点下有相同的区域名称,不能添加！");
			            }
                       else if(judgeName==1){
                         window.location="<%=request.getContextPath()%>/area/areaadd!addArea.shtml?parentid="+id+"&statename="+encodeURI(encodeURI(statename))+"";
					    }
					   
					},
					error:function(data){
					  alert("出错了");
					}																							          						    
	 		      });
	 		 
                }
		       
	           }
			  }
	        }
	      //删除区域  
	       function deleteArea(){
	       
	           var id= document.getElementById("id").value; 
	           var rootId=1;
	           if(id==""){
	            alert("请选择一个节点");
	           }
	           else{
	              if(id==rootId){
	                alert("root节点不能被删除");
	               }
	                       
               else{
                       
		           window.location="<%=request.getContextPath()%>/area/areadelete!deleteArea.shtml?id="+id;
	               }
	           }
	        }
	       //编辑区域
	       function editArea(){
	           
	           var id= document.getElementById("id").value;
	           var parentId=document.getElementById("parentId").value;
	           var statename=document.getElementById("statename").value;
	           var rootId=1;
	           
	           if(id==""){
                 alert("请选择一个节点");
               }               
               else{
                  if(id==rootId){
                    alert("root节点不能被修改");
                   }
               else{
                  if(!/^[\u0391-\uFFE5\w]+$/.test(statename)){
                     $("#msg").html("<font color='red'>区域名为空或者不正确，请重新输入</font>");
                      return ;
                    }
                  else{
                    $.ajax({
		   			url:"<%=path%>/area/areaedit!judgeName.shtml?id="+parentId+"&statename="+encodeURI(encodeURI(statename))+"",
		   			type:'post',
		   			dataType:'json',
	       			cache:false, 
           			success:function(data){      															
					     var judgeName=data.judgeName;
			          if(judgeName==0){
			        
			              alert("该节点下有相同的区域名称,不能修改！");
			            }
                       else if(judgeName==1){
                          window.location="<%=request.getContextPath()%>/area/areaedit!editArea.shtml?id="+id+"&statename="+encodeURI(encodeURI(statename))+"";
					    }
					   
					},
					error:function(data){
					  alert("出错了");
					}																							          						    
	 		      });
                    
                    }    
		           
	             }
	           }
	        }
		
</script>
 
  </head>
  
  <body>
      <div  id="async_json_1" style="float:left;width: 180px;height: 430px" class="jstree jstree-5 jstree-default jstree-focused main">
       </div>
  <div class="main" style="height: 700px;">
      <div class="buttongroup" style="padding-left:150px" >
  
          <button onclick="addArea()" class="graybtn">增加</button>
          <button onclick="editArea()" class="graybtn">修改</button>
          <button onclick="deleteArea()" class="graybtn">删除</button> 
       </div>   
       <div style="float:left" >
           <form method="post" id="addForm" >
              <div class="from">
                 <input type="hidden" id="id"/>
                 <input type="hidden" id="judgeName"/>
                 <input  type="hidden" id="length"/>
                 <input type="hidden" id="parentId"/>
                 <input type="text" name="statename" id="statename" class="required"/><span id="msg"></span>
                 <font color="red"><s:fielderror fieldName="statename"/></font>
              </div>
          </form>
      </div>
  </div>
 
 
  
  </body>
</html>
