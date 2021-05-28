//メニュー
var MouseOnSearchResultUl  //全局变量
//ajax与后台通信，查找查询履历
$( "#xialakuang" ).focus(function(){
	var keyword = $( "#xialakuang" ).val();
	if(keyword != ""){
		$( "#xialakuang" ).trigger("keyup");
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
$("#xialakuang").focusout(function(){
	if(MouseOnSearchResultUl)
	return;
    clearResultList()
	//hide #searchResultUl
	$("#searchResultUl").hide();
})
//ajax あいまい検索
$("#xialakuang").keyup(function(){
	debugger;
	var keyword = $("#xialakuang").val();
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
		    // arr.filter(keyword => keyword.includes(keyword));  
		    for (var i=0;i<arr.length;i++){
			  if(arr[i].includes(keyword)){
				keyword = arr[i];
			  }
		    }  
          /*  keywordInsert(keyword);*/
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

/*function showResultForLikeSearch(result){
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
*/
function appendToSearchBar(el){
	debugger;
	var searchBar = $("#xialakuang");//jquery object
	//var searchBar = document.getElementById("xialakuang");//dom
	var rect = searchBar[0].getBoundingClientRect();//转换成dom加[0]  convert jquery object to dom by searchBar[0]
	console.log(rect.top,rect.right,rect.bottom,rect.left);
	//var sbHeight = searchBar.height();
	//el.height(rect.top + sbHeight)
	//el.left(rect.left);
	el.css({top: rect.top,left: rect.right,position:'relative'});//相对定位relative  绝对定位absolute
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
			var keyword = $("#xialakuang").val();
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