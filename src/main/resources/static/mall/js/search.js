$(function () {
    $('#keyword').keypress(function (e) {
        var key = e.which; //e.which是按键的值
        if (key == 13) {
            var q = $(this).val();
            if (q && q != '') {
                window.location.href = '/search?keyword=' + q;
            }
        }
    });
});

function search() {
    var q = $('#keyword').val();
    if (q && q != '') {
        window.location.href = '/search?keyword=' + q;
    }
}

//ajax与后台通信，查找查询履历
$( "#keyword" ).focus(function(){
	console.log("focused");
});
//ajax あいまい検索
$("#keyword").keyup(function(){
	console.log("Handler for .keyup() called.");
});	
function showResult(result){
	var list = result.data;
	//href="/goods/detail/10700"
	var _href = "/goods/detail";
	for(var i = 0; i< list.size(); i++){
		var link = $(".dumyLi").clone().removeClass("dumyLi").find("a");
		linl.text(list[i].goodsName);
		link.arrt("href",_href + list[i].goodsID);
	}
	$("#searchResultUl").show();
}
