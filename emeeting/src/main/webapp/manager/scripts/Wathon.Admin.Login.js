/**
 * @author hs.li
 * 登陆页面的JS
 */
Wathon.Admin.Login = Wathon.Admin.prototype = {
	
	/**
	 * 初始化页面
	 */
	init:function(el){

		if(! frmLogin){
			var frmLogin = new Ext.form.FormPanel({
				title: '登录管理后台',
				labelWidth: 80,
				bodyStyle:'padding:8px',
				frame:true,
				width:350,
				defaults: {width: 230},
				defaultType: 'textfield',
		
		        items: [{
					id:"txtUserName",
		            fieldLabel: '账号',
		            name: 'username',
					allowBlank:false,
		            anchor:'100%'
		        },{
					id:"txtPassword",
		            fieldLabel: '密码',
		            name: 'password',
					allowBlank:false,
					inputType :"password",
		            anchor: '100%'
		        }],		
					
				buttons:[{
					id:"btnLogin",
					text:"登录",
					handler:function(){
						Wathon.Admin.Login.post();
					}			
				}]		
			});
		}
		
		frmLogin.render(el);
	
	},
	
	/**
	 * 登陆
	 */
	post:function(){
		var username = $("#txtUserName");
		var password = $("#txtPassword");
		
		$.ajax({
			url:"common/login.php",
			dataType:"json",
			data:"username="+username.val() + "&password="+password.val(),
			type:"post",
			success:function(results){
				switch(results.success){
					case -1:
						Wathon.Admin.showMessage("对不起，应用程序发生异常,登录失败。");
						break;
					case 0:
						Wathon.Admin.showMessage("对不起，您的账号或密码错误，请重新输入。");
						username.focus();
						break;
					case 1:
						Wathon.Admin.showMessage("登录成功。",1);
						break;
				}
			}
		})
	},
}

