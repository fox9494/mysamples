<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="my" uri="/WEB-INF/tlds/frame.tld" %>
<%@taglib prefix ="s" uri ="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>一级渠道列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	
	<link rel="stylesheet" href="<%=path%>/css/task.css" type="text/css"/>
	<link rel="stylesheet" href="<%=path%>/css/jquery-ui-1.9.2.custom.css" type="text/css"/>
	<script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery-ui-1.9.2.custom.js"></script>
	<script type="text/javascript" src="<%=path%>/js/table.js"></script>
	<script src="<%=path %>/js/jquery.XYTipsWindow.2.8.js" type="text/javascript"></script>

	<script type="text/javascript">
	//删除一级渠道
	function deleteChannel(){		 
        var  array=getId(); 
          if(array.length==0){
             return;
          }        
         var msg = "确认删除该数据?"
         if(confirm(msg)==true){
         		window.location="<%=path%>/firstChanel/firstChannelDel!deleteChannel.shtml?ids="+array;
         	}			
		 else{
		 	return;
		 }
		 
		}
	
	 function getId(){
		var array = new Array(); 		
        var flag;
        var param="";   
        $("input[name='selectFlag']:checkbox").each(function() {   
                    if ($(this).attr("checked")) {     
                        flag = true;   
                    }  
        });  
        if (flag) {  
        $("input[name='selectFlag']:checkbox").each(function() { 
                      if ($(this).attr("checked")) {                
                           array.push($(this).val()); 
                      }  
        });                   
 					
        } else {  
            alert("请至少选择一条数据"); 
        }  		
		return array;
       }
 //全选
function checkAll(){
         if($("input[name='all']:checkbox").attr("checked")){
             $("input[name='selectFlag']:checkbox").each(function(){
               $(this).attr("checked",true);          
             });            
         }else{
             $("input[name='selectFlag']:checkbox").each(function(){
               $(this).attr("checked",false);
             });          
         }        
       }
   //修改渠道
   function modifyChannel(){
   				var array = new Array();
   				array = getId(); 				
   				if(array.length>1&&array.length!=0){
   						alert("一次必须选择一条数据！"); 					
   					return;
   				}
   				else if(array.length==1){
   						var msg = "确认修改此条数据？" 
   						if(confirm(msg)==true){
   								window.location="<%=path %>/firstChanel/firstChannelEdit!input.shtml?ids="+array;
   						}else{
   								return;
   							}  						
   				}  				
   			}
   			
   	//先判断是否还有子渠道		
   	function isHaveChannel(){
   						var  array=getId(); 
				          if(array.length==0){
				             return;
				          } 	
   					$.ajax({
		 						url:'<%=path%>/firstChanel/firstChannelDel!isHaveChannel.shtml?ids='+array,
		 						type:'post',
		 						dataType:'json',
		 						cache:false,
		 						success:function(data){		 								
		 								if(data.flag==true){
		 									 var msg = "确认删除该数据?"
										         if(confirm(msg)==true){
										         		window.location="<%=path%>/firstChanel/firstChannelDel!deleteChannel.shtml?ids="+array;
										         		
										         	}			
												 else{
												 	return;
												 }	
						 				}
		 								else if(data.flag==false){
		 										var msg = "选择的一级渠道包含有子渠道，是否删除？";
		 										if(confirm(msg)==true){
		 												window.location="<%=path%>/firstChanel/firstChannelDel!deleteChannel.shtml?ids="+array;
		 											}else{
		 											return;
		 											}
		 									}
		 							}
		 						});
   			}
   	
	</script>
  </head>
  
  <body>
  <div class="main">
	    <div id="top" class="btarea line">
	    	<a href="<%=path%>/firstChanel/firstChannelAdd!input.shtml" class="graybtn">新增渠道</a>
	    	<a href="javascript:void(0)" onclick="modifyChannel()" class="graybtn">修改渠道</a>
	    	<a href="javascript:void(0)" onclick="isHaveChannel()" class="graybtn">删除渠道</a>
	    </div>    
  <form action="<%=path %>/firstChanel/firstchannelList!searchList.shtml" >
    <div class="list">
	    <table cellspacing="0" border="0">
	    	<tr class="head">	    		
		    		<th>
		    			<input type="checkbox" name="all" onclick="checkAll()">全选</input>
		    		</th>		    		
	    		<td>渠道CODE</td>
	    		<td>渠道名称</td>
	    		<td>行业</td>
	    		<td>联系人</td>
	    		<td>联系电话</td>
	    		<td>邮箱地址</td>
	    	</tr>
	    	<s:iterator value="pageBean.list" id="firstChannel">	    	
	    	<tr >	    		    		    		
	    			<th>
	    				<input type="checkbox" name="selectFlag" value="<s:property value='#firstChannel.id'/>"></input>
	    			</th>		    		
	    		<td><s:property value="#firstChannel.levelCode"/></td>
	    		<td><s:property value="#firstChannel.channelName"/></td>
	    		<td><s:property value="#firstChannel.TChannelIndustry.name"/></td>
	    		<td><s:property value="#firstChannel.contactPerson"/></td>
	    		<td><s:property value="#firstChannel.mobile"/></td>
	    		<td><s:property value="#firstChannel.email"/></td>
	    	</tr>
	    	</s:iterator>
	    </table> 
	    <div >
	    	<my:page total="${pageBean.allRow}" pageSize="${pageBean.pageSize}" showNum="2" currentPage="${pageBean.currentPage}"></my:page>
	    </div>
	  </div>
    </form>    
   </div>
  </body>
</html>
