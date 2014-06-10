
( function() {
	$(document).ready(function(){  
		function tableTrHover() {   
		    $(".list tr").hover(function() {   
		        $(this).addClass("hover"); // 鼠标经过添加hover样式   
		    }, function() {   
		        $(this).removeClass("hover"); // 鼠标离开移除hover样式   
		    });   
		}  
		tableTrHover(); 
	});
	
	/*
	 $(function() {
		    $(".datepicker").datepicker();
		  }); 
		
		$(".btarea a").click(function(){
			$.XYTipsWindow({
				___title:"标题",
				___content:"iframe:"+"../upfile/",
				___width:"586",
				___height:"258",
				___drag:"___boxTitle",
				___showbg:true
			});
		});*/

})();