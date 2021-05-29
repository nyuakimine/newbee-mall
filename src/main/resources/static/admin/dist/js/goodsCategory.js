//メニュー
var MouseOnSearchResultUl  //全局变量
 $("#button2").click(function(){	
	var keyword = $( "#button2" ).val();
		    $.ajax({
            type: 'POST',//方法类型
            url: '/searchHistory/getSearchHistory',
            contentType: 'application/json',
            //data: JSON.stringify(keyword),
            success: function (result) {
				//サーバーが成功した場合
                if (result.resultCode == 200) {
				debugger;
				    clearResultList();					
					showResult(result);
                } else {
                    	swal(result.message, {
                        icon: "error",
                    });
                }
                
            },
            error: function () {
                swal("操作失败", {
                    icon: "error",
                });
             }
         })
});
$("#button2").focusout(function(){
	if(MouseOnSearchResultUl)
	return;
    clearResultList()
	//hide #searchResultUl
	$("#searchResultUl").hide();
})
function clearResultList(){
	$("#searchResultUl").children().toArray().forEach(function(value,index,array){
		var incFlag = $(value).attr('class').includes("dumyLi");
		if(!incFlag){
			$(value).remove();
		}
	})
}
function showResult(result){
	var list = result.data;
	//href="/goods/detail/10700"
	var _href = "/goods/detail/";
	for(var i = 0; i< list.length; i++){
		var el = $(".dumyLi").clone().removeClass("dumyLi");
		var link = el.find("a");
		link.text(list[i].goodsName);
		link.attr("href", _href + list[i].goodsId);
		$(".dumyLi").before(el);
	}
	$("#searchResultUl").show();
	appendToSearchBar($("#searchResultUl"));
}
function appendToSearchBar(el){
	debugger;
	var searchBar = $("#button2");//jquery object
	//var searchBar = document.getElementById("button2");//dom
	var rect = searchBar[0].getBoundingClientRect();//转换成dom加[0]  convert jquery object to dom by searchBar[0]
	console.log(rect.top,rect.right,rect.bottom,rect.left);
	//var sbHeight = searchBar.height();
	//el.height(rect.top + sbHeight)
	//el.left(rect.left);
	el.css({top: rect.top,left: rect.right,position:'fixed'});//相对定位relative  绝对定位absolute
	}
$("#searchResultUl").mousemove(function(){
	MouseOnSearchResultUl = true;
});
$("#searchResultUl").mouseleave(function(){
	MouseOnSearchResultUl = false;
})

	      
$(document).ready(function () {
	 $("#checkbox1").prop('checked', flase); 
     //$(".fontSize").text(" 家电 数码 手机");
  
});
