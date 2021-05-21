var MouseOnSearchResultUl  //全局变量
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
	var keyword = $( "#keyword" ).val();
	if(keyword != ""){
		$( "#keyword" ).trigger("keyup");
	}
		    $.ajax({
            type: 'POST',//方法类型
            url: '/searchHistory/getSearchHistory',
            contentType: 'application/json',
            //data: JSON.stringify(keyword),
            success: function (result) {
	//サーバーが成功した場合
                if (result.resultCode == 200) {
				debugger;					
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
//鼠标移开时候删除elements的内容delete elements when focus out
$("#keyword").focusout(function(){
	if(MouseOnSearchResultUl)
	return;
    clearResultList()
	//hide #searchResultUl
	$("#searchResultUl").hide();
})
//ajax あいまい検索
$("#keyword").keyup(function(){
	debugger;
	var keyword = $("#keyword").val();
	    $.ajax({
            type: 'get',//方法类型  //method = "POST"
            url: "/goods/search?goodsName="+keyword,  //Post送信先のurl
            //contentType: 'application/json',
            //data: JSON.stringify(keyword),
            dataType:"json",
            success: function (json_data) {
			debugger;
			clearResultList();
			showResultForLikeSearch(json_data);
			debugger;
	   	    var list = json_data.data.list[0];
		    var str = list.goodsName;
		    var arr = str.split(" ");
		    // arr.filter(keyword => keyword.includes(keyword),length > 2);  
		    for (var i=0;i<arr.length;i++){
			  if(arr[i].includes(keyword)){
				keyword = arr[i];
			  }
		    }  
            keywordInsert(keyword);
		},
		error: function() {
			debugger;
			alert("Service Error. Pleasy try again later.");
		}
	});
		
});
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

function showResultForLikeSearch(result){
	var list = result.data.list;
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
	var searchBar = $("#keyword");//jquery object
	//var searchBar = document.getElementById("keyword");//dom
	var rect = searchBar[0].getBoundingClientRect();//转换成dom加[0]  convert jquery object to dom by searchBar[0]
	console.log(rect.top,rect.right,rect.bottom,rect.left);
	var sbHeight = searchBar.height();
	//el.height(rect.top + sbHeight)
	//el.left(rect.left);
	el.css({top: rect.top + sbHeight,left: rect.left,position:'absolute'});//相对定位relative  绝对定位absolute
	}
$("#searchResultUl").mousemove(function(){
	MouseOnSearchResultUl = true;
});
$("#searchResultUl").mouseleave(function(){
	MouseOnSearchResultUl = false;
})
//insert
function keywordInsert(keyword){	
	debugger;
			var keyword = $("#keyword").val();
		    data = {
			  "keyword":keyword,
			 /* "id":id*/
		    };	   
		    $.ajax({
	            type: 'POST',//方法类型
	            url: '/goods/insertKeyword',
	            contentType: 'application/json',
	            data: JSON.stringify(data),//data:keyword变量
	            success: function (result) {
		//サーバーが成功した場合
	                if (result.resultCode == 200) {
					debugger;					
							/*swal("質問ご登録ありがとうございました！" ,{
								icon:"success",
							});*/
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
	      };
       