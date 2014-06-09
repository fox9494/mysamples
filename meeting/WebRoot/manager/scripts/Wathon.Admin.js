/**
 * @author hs.li
 * Wathon 项目Javascript基本命名空间
 */

var Wathon = function(){}
	
Wathon.Admin = Wathon.prototype = {	
	
	/**
	 * 测试方法
	 */
	hello : function(){
		alert("Hello Wathon Team.");
	},
	
	/**
	 * 显示消息提示
	 * @param {Object} msg 消息内容
	 * @param {Object} type 类型 1成功 0错误
	 * @param {Object} animElName 动画来自的对象的名称
	 */
	showMessage:function(msg,type,animElName){
		
		var icon;
		if(type == 1){
			icon = Ext.MessageBox.INFO;
		}
		else{
			icon = Ext.MessageBox.ERROR;
		}
		
		Ext.Msg.show({
			title:"提示消息",
			msg:msg,
			buttons:Ext.Msg.OK,
			animEl:animElName,
			icon:icon
		});
	},
	
	/**
	 * 载入完成，关闭Loading
	 */
	closeLoading : function(){
		setTimeout(function(){
	        $('#loading').remove();
	        $('#loading-mask').fadeOut(500,function(){
				$(this).remove();
			});
	    }, 250);
	}
}

$(document).ready(function(){
	Wathon.Admin.closeLoading();
})