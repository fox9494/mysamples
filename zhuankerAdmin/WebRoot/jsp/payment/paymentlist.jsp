<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="my" uri="/WEB-INF/tlds/frame.tld" %>
<%@taglib prefix ="s" uri ="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>用户结算</title>
    
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
	<script  type="text/javascript"src="<%=path%>/js/My97DatePicker/WdatePicker.js" ></script>			
	<script type="text/javascript">
	//选择id
	 function getId(){
		var array = new Array(); 		
		//用于保存 选中的那一条数据的ID   
        var flag;
        var param=""; //判断是否一个未选   
        $("input[name='selectFlag']:checkbox").each(function() { //遍历所有的name为selectFlag的 checkbox  
                    if ($(this).attr("checked")) { //判断是否选中    
                        flag = true; //只要有一个被选择 设置为 true  
                    }  
        });  
        if (flag) {  
        $("input[name='selectFlag']:checkbox").each(function() { //遍历所有的name为selectFlag的 checkbox  
                      if ($(this).attr("checked")) { //判断是否选中                
                           array.push($(this).val()); //将选中的值 添加到 array中                           
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
		//审核(只有状态为申请状态的才能审核)
		function check(){
				var  array=getId(); 
				 if(array.length==0){
				         return;
				     }		
				var msg = "确认审核？";
				if(confirm(msg)==true){
					window.location="<%=path%>/payment/payMentChecked!saveCheckedPayMent.shtml?ids="+array;
				} 
				else{
					return;
				}
			}
		//支付完成(只有状态为审核通过的才能支付完成)
		function payed(){
				var  array=getId(); 
				 if(array.length==0){
				         return;
				     }	
				var msg = "确认支付完成？";
				if(confirm(msg)==true){
					window.location="<%=path%>/payment/payMentPayed!savePayedPayMent.shtml?ids="+array;
				} 
				else{
					return;
				}
			}
		//取消兑换
		function unchecked(){
			var  array=getId(); 
				 if(array.length==0){
				         return;
				     }	
				var msg = "确认取消兑换？";
				if(confirm(msg)==true){
					window.location="<%=path%>/payment/payMentUnChecked!saveUnCheckedPayMent.shtml?ids="+array;
				} 
				else{
					return;
				}
			}

function checkDate(){
		if($("#start").val()!=""&&$("#end").val()!=""){				
				if($("#start").val()>$("#end").val()){
							alert("开始日期不能大于结束日期");
							return false;
					}
				}		
		if($("#start").val()!=""&&$("#end").val()==""){
				alert("结束算日期不能为空");
				return false;
			}
		if($("#start").val()==""&&$("#end").val()!=""){
				alert("开始日期不能为空");
				return false;
			}
		else{
				return true;
		}
	}
	</script>

  </head>
  
  <body >
  <div class="main">
    <div id="top" class="btarea line">   	
    		<a  onclick="javascript:check()">审核</a>
    		<a  onclick="javascript:payed()">支付完成</a>
    		<a  onclick="javascript:unchecked()">取消兑换</a>   	
    </div>
    
    <form action="<%=path %>/payment/payMentByParams!searchPayMentByParams.shtml" method="post" id="pay" onsubmit="return checkDate();">
    <div class="search">
    	<ul>
	    		<li style="width: 200px">
	    			<p>兑换申请日期:</p>
	    			
	    			<input name="startyear"  value="<s:property value='startyear' />" onclick="WdatePicker({el:$dp.$('startyear')})" style="width: 100px" id="start"/> 	    			
	    			
	    		</li>	    		
	    		<li style="width: 150px">
	    			<p>至</p>
	    			
	    			<input name="endyear"  value="<s:property value='endyear'/>" onclick="WdatePicker({el:$dp.$('endyear')})" id="end"/>	    			
	    		</li>	  			
	    		<li style="width: 180px">
	    			<p>申请状态:</p>
		    			<select name="exLog.status" >
			    			<option value="5" >---请选择---</option>
			    			<option value="0" <s:if test="exLog.status==0">selected="selected"</s:if>>申请</option>
			    			<option value="1" <s:if test="exLog.status==1">selected="selected"</s:if>>审核通过</option>
			    			<option value="2" <s:if test="exLog.status==2">selected="selected"</s:if>>审核不通过</option>
			    			<option value="3" <s:if test="exLog.status==3">selected="selected"</s:if>>已完成</option>
			    			<option value="4" <s:if test="exLog.status==4">selected="selected"</s:if>>异常</option>
		    			</select>
	    		</li>
    			<li style="width: 200px">
    				<p>用户帐户:</p><input name="exLog.TUserClient.userName" id="account" value="<s:property value='exLog.TUserClient.userName'/>"/>
    			</li>  			
    			<li>
    				<input value="查询"   class="button" type="submit"/>
    			</li>   		
    	</ul>
    </div>   	   	
    <div class="list">
	    <table cellspacing="0" border="0" style="word-break:break-all;" >
    			<tr class="head"> 			
    				<td width="6%">   					
    					<input type="checkbox"  name="all" onclick="checkAll()" >全选</input>
    				</td>
    				
    				<td width="10%">申请时间</td>
    				<td>用户帐户</td>
    				<td>物品名称</td>
    				<td>金币数</td>
    				<td>状态</td>
    				<td>目标账号</td>
    				<td>账号名称</td>
    				<td>银行名称</td>
    				<td>审核时间</td>
    				<td>完成时间</td>
    				<td width="10%">结果描述</td>
    			</tr>
    			<s:iterator value="pageBean.list" id="pay">
    			<tr >     				
    				<td>
    					<s:if test="#pay.status==3">
    						<input type="checkbox"  disabled="disabled"   value="<s:property value='#pay.id'/>" ></input>
    					</s:if>
						<s:elseif test="#pay.status==2">
							<input type="checkbox"   disabled="disabled"   value="<s:property value='#pay.id'/>"></input>
						</s:elseif>	
    					<s:else>
    						<input type="checkbox" name="selectFlag" value="<s:property value='#pay.id'/>"/>
    					</s:else>  					    					
    				</td> 			  				
    				<td><s:date name="#pay.submitDate" format="yyyy-MM-dd"/></td>
    				<td><s:property value="#pay.TUserClient.userName"/></td>
    				<td><s:property value="#pay.TGift.giftName"/></td>
    				<td><s:property value="#pay.giftGold"/></td>
    				<td>
	    				<s:if test="#pay.status==0">
	    					<span>申请</span>	
	    				</s:if>
    					<s:if test="#pay.status==1">
    						<span>审核通过</span>
    					</s:if>
    					<s:if test="#pay.status==2">
    						<span>审核不通过</span>
    					</s:if>
    					<s:if test="#pay.status==3">
    						<span>已完成</span>
    					</s:if>
    					<s:if test="#pay.status==4">
    						<span>异常</span>
    					</s:if>
    				</td>
    				<td><s:property value="#pay.targetCardNum"/></td>
    				<td><s:property value="#pay.targetAccountName"/></td>
    				<td><s:property value="#pay.targetBankType"/></td>
    				<s:if test="#pay.approvalDate==null">
    					<td><span>未审核</span></td>
    				</s:if>
    				<s:else>
    					<td><s:date name="#pay.approvalDate" format="yyyy-MM-dd"/></td>
    				</s:else>
    				<s:if test="#pay.finishDate==null">
    					<td><span>未完成</span></td>
    				</s:if>
    				<s:else>
    					<td><s:date name="#pay.finishDate" format="yyyy-MM-dd"/></td>   				
    				</s:else>    				
    				<td><s:property value="#pay.resultDesc"/></td>
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
