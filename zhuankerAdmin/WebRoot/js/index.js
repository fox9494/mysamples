
( function() {

$( document ).ready( function() {
	
	$(".nav").accordion({
        speed: 500,
	    closedSign: '[+]',
		openedSign: '[-]'
	});
    
    // 初始化tab
    $( "#tabs" ).tabs({
        tabTemplate: '<li><a href="#{href}">#{label}</a><a class="close" href="#">x</a></li>',
        cache: true
    })
    .bind( "tabsadd", function( event, ui ) {
        $( this ).tabs( "select", "#" + ui.panel.id );
    });
    
    // 动态绑定关闭tab的事件
    $( ".ui-tabs-nav a.close" ).live( "click", function( e ) {
        e.preventDefault();
        var index = $( ".ui-tabs-nav li" ).index( $( this ).parent());
        $( "#tabs" ).tabs( "remove", index );
    });
    
    // 点击添加tab页事件
    $( ".nav a" ).click( function( e ) {
        e.preventDefault();
        var url = $( this ).attr( "href" );
        if (url == "#"){
        	return;
        }
        var tabid = $( this ).attr( "id" );
        var label = $( this ).attr( "title" );
        addTab( tabid, url, label );
    });
    
});

// 添加tab的接口
function addTab( id, url, label ) {
    var mainTab = $( "#tabs" );
    var added = false;
    $( "iframe", mainTab ).each( function( i ) {
        var src = this.src.substring( this.src.lastIndexOf( "/" ) + 1 );
        var url_suffix = url.substring(url.lastIndexOf( "/" ) + 1); 
        if ( src == url_suffix ) {
            added = $( this );
        }
    });
    
    if ( added ) {
        //mainTab.tabs( "select", "#" + added.parent().attr( "id" ));
        mainTab.tabs( "remove", "#" + added.parent().attr( "id" ));
        //return;
    }
    
    var panel = $( "<div/>" ).attr({
        "id": id
    }).appendTo( mainTab );
    
    mainTab.tabs( "add", "#" + id, label );
    
    $( "<iframe/>" ).attr({
        "frameBorder": "0",
        "scrolling": "no",
        "allowTransparency": "true",
        "src": url
    }).css({
        "width": "100%",
        "height": "100%"
    }).load( function() {
        var iframe = $( this );
        iframe.height( iframe.contents().find( "body" ).height());
    }).appendTo( panel );
}

})();