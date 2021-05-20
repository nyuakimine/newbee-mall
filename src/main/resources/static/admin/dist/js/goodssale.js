 //2021/05/19  sale
 debugger;
      $(function(){
	//disable previous page 	  
	  $(".previousPageSale").css("pointer-events", "none").css("color","grey");
	  });   
      $("#zv-cqa-select-sort").change(function(){
      paging(2);
      });     
      //下一页
      $( ".nextPageSale" ).click(function(){
	  debugger;
	  paging(0);
	  $(".previousPageSale").css("pointer-events", "auto").css("color","#009e96");
	   });
	   //上一页
	  $( ".previousPageSale" ).click(function(){
	  paging(1);
	  });	
	debugger;   
	function paging(num){
	//alert("Handlerfor .click() called." );   
	 
    var page = $("#currentPageNoN").text();
    var pageNo = 0;
    console.log("current page: ",page);
	var url = "/admin/goods/sale";
	if(num == 0){
		//下页
		 pageNo = parseInt(page) + 1;
	}else if (num == 1){
		//上页
		 pageNo = parseInt(page) - 1;
	}else{
		 pageNo = 1 
	}
	   var data = {
		"page":pageNo
	           };	    
        $.ajax({
            type: 'POST',//方法类型
            url: url,
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (result) {
	//サーバーが成功した場合
                if (result.resultCode == 200) {
	                    var el;
	                    if(result.data.list.length > 0){

							$(".campaignTable").find(".delete").remove();
					  	}
				        var ar = result.data.list;
				        
					    debugger;
	                       for(let i = 0; i <ar.length;i++){
		
							el = $($(".hidden")[0]).clone().removeClass("hidden");
							el.find(".saleId").html(ar[i].id);
							el.find(".saleName").html(ar[i].name);
							el.find(".saleStart").html(ar[i].startDate);
		     				el.find(".saleEnd").html(ar[i].endDate);
		     				el.find(".saleFlag").html(ar[i].flag);
							$("#detailFooter").before(el);
							//qa.appendTo("#ZVCQuestionsArea");
						}
              } 
                else {
                    swal(result.message, {
                        icon: "error",
                    });
                }
                ;
            },
            error: function () {
                swal("操作失败", {
                    icon: "error",
                });
            }
        });
       }
       //download by niu 20210514
$("#downloadsale").on('click',function(){
	      debugger;
	      
	/*       var ids = getIds();
	    var data = {
		  "ids":ids
	    };*/
	        var _data = [1]
	  	    $.ajax({
            type: 'POST',//方法类型
            url: '/admin/goodsSale/download',
            contentType: 'application/json',
            data: JSON.stringify(_data),
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
    new AjaxUpload('#testUploadGoodsCoverImg', {
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
                $("#goodsCoverImg").attr("src", r.data);
                $("#goodsCoverImg").attr("style", "width: 128px;height: 128px;display:block;");
                return false;
            } else {
                alert("error");
            }
        }
    });

 //search 2021/05/20
 var MouseOnSearchResultUl  //全局变量
//ajax与后台通信，查找查询履历
$( "#keyword" ).focus(function(){
	var keyword = $( "#keyword" ).val();
	if(keyword != ""){
		$( "#keyword" ).trigger("keyup");
	}
	//console.log("focused");
		    $.ajax({
            type: 'POST',//方法类型
            url: '/admin/searchHistory/getSearchHistory',
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
            url: "/admin/goods/search?goodsName="+keyword,  //Post送信先のurl
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
//click if mouse is over search result
	/*function checkIfMouseOver(){
		var rect = document.getElementById("searchResultUl").getBoundingClientRect();
	}*/
$("#searchResultUl").mousemove(function(){
/*	var msg = "Handler for .mousemove() called at ";
	msg += event.pageX + "," + event.pageY;
	$("#log"),append("<div>"+ msg + "</div>");*/
	MouseOnSearchResultUl = true;
});
$("#searchResultUl").mouseleave(function(){
	MouseOnSearchResultUl = false;
})
//insert
function keywordInsert(keyword){	
	debugger;
			//var keyword = $("#keyword").val();
			/*var id = getId();*/
		    data = {
			  "keyword":keyword,
			 /* "id":id*/
		    };	   
		    $.ajax({
	            type: 'POST',//方法类型
	            url: '/admin/goods/insertKeyword',
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
       