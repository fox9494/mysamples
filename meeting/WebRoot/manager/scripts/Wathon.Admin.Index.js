/**
 * @author hs.li
 * 管理后台首页的JS
 */
Wathon.Admin.Index = Wathon.Admin.prototype = {

	/**
	 * 初始化页面
	 */
	init : function(el) {

		/**
		 * 主框架加载
		 */
		if (this.panelMain == null) {

			panelMain = new Ext.Viewport( {
				layout : "border",
				items : [ this.top, this.bottom, {
					region : 'west',
					title : '功能菜单',
					collapsible : true,
					split : true,
					width : 225,
					minSize : 175,
					maxSize : 400,
					layout : 'fit',
					margins : '0 0 0 5',
					items : [ new Ext.Panel( {
						layout : 'accordion', //设为accordion布局
						height : '100',
						items : this.functionNames
					}) ]
				}, this.maincontent ]
			});

		}

		/**
		 * 以下是工具栏的加载
		 */
		this.toolbar.render("panelToolbar");
		/* this.toolbar.add( {
			text : "管理菜单",
			iconCls : "bmenu",
			menu : [ {
				id : "mnuMain",
				items : [ {
					text : "更改密码...",
					id : "mnuChangePassword",
					checkHandler : this.mnuChangePassword_click
				} ]
			} ]
		});*/

	},

	panelMain : null,
	functionNames : null,//菜单名

	addmenus : function(items) {
		for ( var item in items) {
			if (typeof (items[item]) == 'array'
					|| typeof (items[item]) == 'object') {
				var menu = items[item];
				submenus = menu.items;
				var html = '';
				for ( var key in submenus) {
					if (typeof (submenus[key]) == 'array'
							|| typeof (submenus[key]) == 'object') {
						html += "<li style=\"cursor: pointer;height:18px;list-style-type:none;margin:5px 8px;\" onclick=\"Wathon.Admin.Index.opennewWindow('"
								+ submenus[key].href
								+ "','"
								+ submenus[key].title.substring(submenus[key].title.indexOf("&nbsp;"),submenus[key].title.length)
								+ "','"
								+ item
								+ "_"
								+ key
								+ "')\" > "
								+ submenus[key].title
								+ "</li>"
					}
				}
				menu.html = html;
				delete menu.items;
				items[item] = menu;
			}
		}

		this.functionNames = items;
	},

	/**
	 * 页头
	 */
	top : new Ext.BoxComponent( {
		region : "north",
		el : "panelTop",
		margins : "0 0 5 0"
	}),

	toolbar : new Ext.Toolbar(),

	/**
	 * 页脚
	 */
	bottom : new Ext.BoxComponent( {
		region : "south",
		el : "panelBottom",
		margins : "5 0 0 0"
	}),

	/**
	 * 工具箱
	 */
	toolbox : {
		region : 'west',
		title : '功能菜单',
		collapsible : true,
		split : true,
		width : 225,
		minSize : 175,
		maxSize : 400,
		layout : 'fit',
		margins : '0 0 0 5',
		items : [ new Ext.Panel( {
			layout : 'accordion', //设为accordion布局
			height : '100',
			items : this.functionNames
		}) ]
	},

	/**
	 * 主内容
	 */
	maincontent : new Ext.TabPanel( {
		region : 'center',
		margins : '0 5 0 0',
		deferredRender : false,
		activeTab : 0,
		
		items : [ {
			contentEl : 'panelContent',
			title : '首页',
			style : "padding:5px;",
			closable : true,
			autoScroll : true,
			html:'欢迎使用国信证券管家系统'
		} ]
	}),

	/*
	 * 以下的是事件
	 */

	/**
	 * 更改密码菜单事件
	 */
	mnuChangePassword_click : function() {
		alert("您点击了更改密码");
	},

	opennewWindow : function(url, name, panelId) {
		this.maincontent.remove(panelId);
		this.maincontent
				.add(
						{
							id:panelId,
							title : name,
							iconCls : 'tabs',
							html : '<iframe src="' + url + '" frameborder=0 marginheight=0 marginwidth=0 width="100%" height=100% ></iframe>',
							closable : true
						}).show();
	}
}

/*
Ext.onReady(function() {

	Ext.state.Manager.setProvider(new Ext.state.CookieProvider());

	var index = Wathon.Admin.Index;
	if (items == null) {
		alert("加载菜单出错");
	} else {
		index.addmenus(items);
	}

	index.init();

})*/

