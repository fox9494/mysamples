<%@ page language="java"  pageEncoding="utf-8"%>
<%@include file="common/libs.jsp" %>

<!DOCTYPE HTML >
<html><!-- doctype和html都不写，即使html5 -->
  <head>
    
    <title>主页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@include file="common/scripts.jsp" %>
	
	<script type="text/javascript">
        $(document).ready(function() {
            var element = $('#page').omBorderLayout({
           	   panels:[{
           	        id:"north-panel",
           	        title:"This is north panel",
           	        region:"north",
           	        resizable:true,
           	        collapsible:true,
           	     	closable: true
           	    },{
           	        id:"south-panel",
           	        title:"This is south panel",
           	        region:"south",
           	        resizable:true,
           	        collapsible:true,
           	        height:80,
           	        header:false
           	    },{
           	        id:"center-panel",
           	     	header:false,
           	        region:"center"
           	    },{
           	        id:"west-panel",
           	        resizable:true,
           	        collapsible:true,
           	        title:"This is west panel",
           	        region:"west",width:150
           	    },{
           	        id:"east-panel",
           	        resizable:true,
           	        collapsible:true,
           	        title:"This is east panel",
           	        region:"east",
           	        width:150
           	    }],
           	    hideCollapsBtn : true,
           	    spacing : 7
            });
        });
    </script>
	
  </head>
  
  <body>
      <div id="page">
    	<div id="north-panel">north</div>
    	<div id="center-panel" style="padding: 0 10px;">center</div>
    	<div id="east-panel">east</div>
    	<div id="west-panel">west</div>
    	<div id="south-panel">sorth</div>
     </div>
     
    
  </body>
</html>
