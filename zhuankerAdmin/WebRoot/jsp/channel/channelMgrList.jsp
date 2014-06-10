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
    
    <title>My JSP 'channelMgrList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="<%=path%>/css/list2.css" type="text/css"/>
	<link rel="stylesheet" href="<%=path%>/css/jquery-ui-1.9.2.custom.css" type="text/css"/>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/js/jstree/themes/classic/style.css" />
	<script src="<%=request.getContextPath() %>/js/jquery-1.8.3.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath() %>/js/jquery.jstree.js" type="text/javascript"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.hotkeys.js"></script>
    <script type="text/javascript" src="<%=path%>/js/jquery-ui-1.9.2.custom.js"></script>
	<script type="text/javascript" src="<%=path%>/js/table.js"></script>
	<script type="text/javascript">
	$(function () { 
     $("#async_json_1").jstree({   
       "themes": {
                theme: 'classic'
            },
         "json_data" : {   
             "ajax" : {  
                 "url" : "<%=request.getContextPath()%>/channel/channelManager!findTree.shtml",
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
         "plugins" : [ "themes","json_data","ui","search","hotkeys","default-rtl" ] 
        
     })     
     .bind("loaded.jstree",function(e,data){
          var channelId= document.getElementById("channelId").value;
          var currentId= document.getElementById("newLeveCode").value;
          $("li[id="+channelId+"]").removeClass();
          $("li[id="+channelId+"]>a").addClass("jstree-clicked");
          $("li[id="+currentId+"]").removeClass();
          $("li[id="+currentId+"]>a").addClass("jstree-clicked");
	      data.inst.open_all(-1);//展开所有
    })
     .bind("select_node.jstree",function(e,data){
                
                  var superiorId=null;
				  var this_id=data.rslt.obj[0].id;			  
				  superiorId=$("#"+this_id).parent("ul").parent("li").attr("id");
				  document.getElementById("superiorId").value =superiorId;
				  var length= $("#"+this_id).children("ul").length;
				  document.getElementById("channelId").value = this_id;
				  var currentCode =data.rslt.obj[0].attributes.leveCode.value;	
				  var leveCode=	document.getElementById("leveCode").value;	
				  document.getElementById("newLeveCode").value=currentCode;	
				  
				  if(currentCode.replace(/[^\x00-\xff]/g,"xx").length<leveCode.replace(/[^\x00-\xff]/g,"xx").length){
				        
				        alert("该用户无权限操作该级节点!");			  
				   }
				  else{	
				    if(superiorId===undefined){
				  		 window.location="<%=request.getContextPath()%>/channel/showChannelList!findAllChannel.shtml?channelId="+this_id+"&length="+length+"&currentCode="+currentCode+"";		  						        
				    }
				    else{
				       window.location="<%=request.getContextPath()%>/channel/showChannelList!findAllChannel.shtml?channelId="+this_id+"&length="+length+"&currentCode="+currentCode+"&superiorId="+superiorId+"";				  
				    
				    }
				  
				   }
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
                url: "",
                cache:false,
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
		            "",
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
		         
		
		    $.ajax({
					  url: "<%=path%>/channel/channelManager!findByCode.shtml",
					  cache: false,
					  type: "post",
					  dataType :"json",
					  success: function(data){
					    $("#leveCode").attr("value",data);
					  }
		    });           
		 });
 
           //增加渠道
           function addChannel(){
            
               var rootId=1;
               var leveCode= document.getElementById("leveCode").value;	              	  
			   var currentCode = document.getElementById("newLeveCode").value;
               var channelId= document.getElementById("channelId").value;
               if(channelId!=null){
                  if(channelId==rootId){               
                  alert("不能在root节点下增加子渠道");
                   }
                   else{
                   
                       if(currentCode.replace(/[^\x00-\xff]/g,"xx").length<leveCode.replace(/[^\x00-\xff]/g,"xx").length){
				        alert("该用户无权限操作该级节点!");				  
				        }
				        else{
				             window.location="<%=request.getContextPath()%>/channel/channelAdd!initAddChannel.shtml?channelId="+channelId;	             				        
				        }                 
                   }
               }
                else {
	              alert("请选择一个节点");
	            }	            
	                      
	        }
	        //删除渠道
	       function deleteChannel(){
	           var leveCode= document.getElementById("leveCode").value;			  
			   var currentCode = document.getElementById("newLeveCode").value;
	           var rootId=1;
	           var id= document.getElementById("channelId").value; 
	           var superiorId=document.getElementById("superiorId").value;
		        
		       if(id!=""){
		           if(id==rootId){
                     alert("root节点不能被删除!");
                   }
                   else{                      
                      if(superiorId==rootId){                      
                         alert("一级渠道不能被删除");
                      }
                      else{
                            if(currentCode.replace(/[^\x00-\xff]/g,"xx").length<leveCode.replace(/[^\x00-\xff]/g,"xx").length){
				             alert("该用户无权限操作该级节点!");				  
			               } 
			               else{
			    		       window.location="<%=request.getContextPath()%>/channel/channelDelete!deleteChannel.shtml?id="+id;
                
                          }                          
                      }
                   }
		       }
		       else{		       
		         alert("请选择一个节点");
		       }		       	         	     
	        }
	        //编辑渠道
	       function editChannel(){
	           var leveCode= document.getElementById("leveCode").value;			  
			   var currentCode = document.getElementById("newLeveCode").value;
	           var rootId=1;  
	           var id= document.getElementById("channelId").value;
	           var superiorId=document.getElementById("superiorId").value;
	           			  
	            if(id!=""){
		           if(id==rootId){
                     alert("root节点不能被修改!");
                   }
                   else{                      
                      if(superiorId==rootId){                     
                         alert("一级渠道不能被修改");
                      }
                      else{
                            if(currentCode.replace(/[^\x00-\xff]/g,"xx").length<leveCode.replace(/[^\x00-\xff]/g,"xx").length){
				             alert("该用户无权限操作该级节点!");				  
			                  } 
			               else{			    
		                         window.location="<%=request.getContextPath()%>/channel/channelEdit!initEditChannel.shtml?channelId="+id;               
                               }                          
                        }
                   }
		       }
		       else{		       
		         alert("请选择一个节点");
		       }
		       	        	            
	        }
	    /*    
	    $(function(){
	       var finalChannel=0;
           var length= document.getElementById("length").value;
           if (length==""){//初始化页面，只显示非末节点
           		$("#finalchannel").hide();
           		return ;
           }
           
           if(length>finalChannel){
                 $("#finalchannel").hide();
           }
           
           if(finalChannel==length){
                 $("#nonFinalchannel").hide();
           }
           
         });  
         */   
	        
	    //添加渠道推送     
	    function addIndustryInvite(){
	        var id= document.getElementById("channelId").value;
	        if(id!=""){
	             window.location="<%=request.getContextPath()%>/channelinvite/channelInviteList!searchList.shtml?channelId="+id;
	        }else{
	             alert("请选择推送渠道");
	        }    
	    } 
	    
	    function searchInfoInstall(cur){		   
		      $.ajax({
		   			url:"<%=path%>/channel/showChannelList!findAllChannel2.shtml?currentPage="+cur+"&channelId="+document.getElementById("channelId").value+"",
		   			type:'post',
		   			dataType:'json',
	       			cache:false, 
           			success:function(data){
           			        
           			    if(data.totalPage>1){
           			     $("#nonFinal").html("");
           			     $.each(data.list,function(index,nonFinal){	
           			          		      
					         $("#nonFinal").append("<tr><td>"+nonFinal.childChannel+"</td><td>"+nonFinal.registUserNum+"</td><td>"+nonFinal.effectGold+"</td></tr>");				      
					     });
           			   }      			          															   
					   $("#currentPage").attr("value",data.currentPage);
					   $("#totalPage").attr("value",data.totalPage);
					   $("#showCurrentPage").html(data.currentPage);
					}																							          						    
	 	      });	  	       
		  }	
		  
</script>

  </head>
  
  <body>
  	<div class="btarea">
	   <a href="javascript:;"  onclick="return addChannel();">新增子渠道</a>
       <a href="javascript:;"  onclick="return editChannel();">修改子渠道</a>
       <a href="javascript:;"  onclick="return deleteChannel();">删除子渠道</a>
       <a href="javascript:;"  onclick="addIndustryInvite()">推广赚客网</a>
	</div>
	
	 <table width=100% style="height: 500px"  cellpadding="0" cellspacing="0"> 
		<tr>
			<td valign="top">
				<div class="main">
				    <div  id="async_json_1" style="height: 350px"></div>
				</div>
			</td>
			<!-- left end-->
			<!-- right -->
			<td width="80%" valign="top">
			 <form method="post" action=""> 
		       <input type="hidden"  id="leveCode"> 
		       <input type="hidden"  id="newLeveCode" value="<s:property value="currentCode"/>"></input>
			   <input type="hidden" name="channelId" id="channelId" value="<s:property value='channelId'/>"></input>
			   <input type="hidden" id="length" value='<s:property value="length"/>'></input>
			   <input type="hidden" id="superiorId" value='<s:property value="superiorId"/>' ></input>
			    <input type="hidden" id="currentPage"  value="<s:property value="pageBean.currentPage"/>" name="pageBean.currentPage"/>		        			    	        
		        <input type="hidden" id="totalPage"  value="<s:property value="pageBean.totalPage"/>" name="pageBean.totalPage"/>		        			
		    
				<div class="main">
					
					 <div class="list" id="nonFinalchannel">
			          <table cellspacing="0" border="0">
				    	<tr class="head">
				    		<td>子渠道名称</td>
				    		<td>注册用户数</td>
				    		<td>有效金币数</td>
				    		
				    	</tr>
				    	<tbody id="nonFinal">
				    	<s:iterator value="pageBean.list" id="nonFinalChannel">	    	
				    	<tr>	    		    	
				    		<td><s:property value="#nonFinalChannel.childChannel"/></td>
				    		<td><s:property value="#nonFinalChannel.registUserNum"/></td>
				    		<td><s:property value="#nonFinalChannel.effectGold"/></td>
				    	</tr>
				    	</s:iterator>
				    	</tbody>
				      </table> 
				      <div style="">
				      <s:if test="pageBean.allRow!=0">
		         	<div class="css" style="style">
						<a href="javascript:void(0)" onclick="searchInfoInstall(1)">首页</a>&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" onclick="searchInfoInstall(document.getElementById('currentPage').value-1)">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="javascript:void(0)" onclick="searchInfoInstall(document.getElementById('currentPage').value*1+1)">下一页</a>&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" onclick="searchInfoInstall(document.getElementById('totalPage').value)">尾页</a>
						一共有${pageBean.allRow}条记录 &nbsp;共${pageBean.totalPage}页&nbsp;当前是第<font id="showCurrentPage">${pageBean.currentPage}</font>页
						转到<input type="text" name="pageBean.currentPage"  style="width:35px; text-align: center;" onblur="this.value=this.value.replace(/[^\d\.]+/g,'')"
								onafterpaste="this.value=this.value.replace(/[^\d\.]+/g,'')" id="pagenum"/>&nbsp;页<input type="button" value="go" onclick="searchInfoInstall(document.getElementById('pagenum').value)"/>
			    	 </div>
		         	</s:if>
		         	<s:else>	         	    
		         		<div style="text-align:center;padding-top:5px;padding-right:5px;">
							未找到数据
				    	</div>
		         	</s:else>
				      </div>
				    </div>
				</div>
			  </form>
			</td>
		</tr>
	</table>
  </body>
</html>
