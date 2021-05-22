var MouseOnSearchResultUl  //全局变量
     //download by niu 20210514
$("#downloadsale").on('click',function(){
	        debugger;
	        var ids = [];
	        $('input:checkbox:checked').parent().next().map(function (){
			    ids.push($(this).text())
			    return ids;
			})
			if (ids == null ){
			    swal("请选择一条记录" ,{
				icon:"success",
				});
			    return
		    }
	  	    $.ajax({
            type: 'POST',//方法类型
            url: '/admin/goodsSale/download',
            contentType: 'application/json',
            data: JSON.stringify(ids),
            //data:1,
            
            success: function (result) {
	        //サーバーが成功した場合
                if (result.resultCode == 200) {
	              debugger;
	             // var url = window.location.assign(result.data);
	              Download(result.data);
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
function Download(url) {
   document.getElementById('my_iframe').src = url;
};
    //DIY add by niu 2021/05/20
        debugger;
    new AjaxUpload('#col-119', {
        action: '/admin/uploadtest/file',
        name: 'file',
        autoSubmit: true,
        responseType: "json",
        onSubmit: function (file, extension) {
            if (!(extension && /^(jpg|jpeg|png|gif|csv)$/.test(extension.toLowerCase()))) {
                alert('只支持jpg、png、gif、csv格式的文件！');
                return false;
            }
        },
        onComplete: function (file, r) {
            if (r != null && r.resultCode == 200) {
              swal("uploadがOKです！" ,{
								icon:"success",
							});
            } else {
                alert("error");
            }
        }
    });
    
    //ajax与后台通信，查找查询履历
$( "#keywordSale" ).focus(function(){
	var keyword = $( "#keywordSale" ).val();
	if(keyword != ""){
		$( "#keywordSale" ).trigger("keyup");
	}
});		
//鼠标移开时候删除elements的内容delete elements when focus out
$("#keywordSale").focusout(function(){
	if(MouseOnSearchResultUl)
	return;
    clearResultList()
	//hide #searchResultUl
	$("#searchResultUl").hide();
});
  //add by niu  2021/05/21 ajax あいまい検索
$("#keywordSale").keyup(function(){
	debugger;
	var keyword = $("#keywordSale").val();
	    $.ajax({
            type: 'get',//方法类型  //method = "POST"
            url: "/goods/searchSale?name="+keyword,  //Post送信先のurl
            dataType:"json",
            success: function (json_data) {
			debugger;
			clearResultList();
			showResultForLikeSearch(json_data);
			debugger;
	   	    var list = json_data.data.list[0];
		    var str = list.name;
		/*    var arr = str.split(" ");
		    // arr.filter(keyword => keyword.includes(keyword),length > 2);  
		    for (var i=0;i<arr.length;i++){
			  if(arr[i].includes(keyword)){
				keyword = arr[i];
			  }
		    }  */
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
function showResultForLikeSearch(result){
	var list = result.data.list;
	for(var i = 0; i< list.length; i++){
		var el = $(".dumyLi").clone().removeClass("dumyLi");
		var link = el.find("a");
		link.text(list[i].name);
		$(".dumyLi").before(el);
	}
	$("#searchResultUl").show();
	appendToSearchBar($("#searchResultUl"));
}
function appendToSearchBar(el){
	debugger;
	var searchBar = $("#keywordSale");//jquery object
	//var searchBar = document.getElementById("keyword");//dom
	var rect = searchBar[0].getBoundingClientRect();//转换成dom加[0]  convert jquery object to dom by searchBar[0]
	console.log(rect.top,rect.right,rect.bottom,rect.left);
	var sbHeight = searchBar.height();
	el.css({top: rect.top + sbHeight,left: rect.left,position:'absolute'});//相对定位relative  绝对定位absolute
	}
$("#searchResultUl").mousemove(function(){
	MouseOnSearchResultUl = true;
});
$("#searchResultUl").mouseleave(function(){
	MouseOnSearchResultUl = false;
})

//modal 2021/05/22
$(function(){
  //テキストリンクをクリックしたら
 $("#modal-open").click(function(){
      //body内の最後に<div id="modal-bg"></div>を挿入
     $("body").append('<div id="modal-bg"></div>');
    //画面中央を計算する関数を実行
      modalResize();
    //モーダルウィンドウを表示
      $("#modal-bg,#modal-main").fadeIn("slow");
    //画面のどこかをクリックしたらモーダルを閉じる
      $("#modal-bg,#modal-main").click(function(){
      $("#modal-main,#modal-bg").fadeOut("slow",function(){
    //挿入した<div id="modal-bg"></div>を削除
      $('#modal-bg').remove() ;
         });
 
        });
 
    //画面の左上からmodal-mainの横幅・高さを引き、その値を2で割ると画面中央の位置が計算できます
     $(window).resize(modalResize);
      function modalResize(){
 
            var w = $(window).width();
            var h = $(window).height();
 
            var cw = $("#modal-main").outerWidth();
            var ch = $("#modal-main").outerHeight();
 
        //取得した値をcssに追加する
            $("#modal-main").css({
                "left": ((w - cw)/2) + "px",
                "top": ((h - ch)/2) + "px"
          });
     }
   });
});
