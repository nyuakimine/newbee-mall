/*$("#zv-cqa-select-sort").change( function(){
  var page = $("#currentPageNum").text();
  var url = "/goods/qaSort";
  var data = {
    "page":page
  };
 });*/
 debugger;
      $(function(){
	//disable previous page 	  
	  $(".previousPage").css("pointer-events", "none").css("color","grey");
	  });   
      $("#zv-cqa-select-sort").change(function(){
      paging(2);
      });     
      //下一页
      $( ".nextPage" ).click(function(){
	  debugger;
	  paging(0);
	  $(".previousPage").css("pointer-events", "auto").css("color","#009e96");
	   });
	   //上一页
	  $( ".previousPage" ).click(function(){
	  paging(1);
	  });	
	  

	 //レビューをもっと見るイベント
	  $("#showMoreReviewsBtn").click(function(){
	    var goodsId = getGoodsId();
	
	    var data = {
		  "goodsId":goodsId
	    };
	  	    $.ajax({
            type: 'POST',//方法类型
            url: '/goods/showMoreReview',
            contentType: 'application/json',
            data: JSON.stringify(goodsId),
            success: function (result) {
	//サーバーが成功した場合
                if (result.resultCode == 200) {
				debugger;	
						var list = result.data;
						if(list === undefined){
								swal("error", {
                        icon: "error",
                    });
							
						}
						if(list != undefined && list.length != 0){
							for(i =0; i<list.length; i++){
								var el = $(".hiddenList").clone().removeClass("hiddenList");
								/*el.find(".g-clip").html(list[i].id);*/
								el.find(".hidSpForRevId").html(list[i].id);
								el.find(".helpNumSpan").on("click",helpNumClickFunc);
								$(".hiddenList").before(el);
							}
						}		
					/*	swal("質問ご登録ありがとうございました！" ,{
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
       
  })
  
	  $("#ZVPostQuestionButton").click(function(){	
		
		var question = $("#ZVQuestionTextarea").val();
		//get url
	/*	var path = window.location.pathname;
		//split with / 
		var ar = path.split("/");
		//get array 
		var len = ar.length;
		var goodsId = ar[len-1];
		debugger;*/
		var goodsId = getGoodsId();
	    data = {
		  "question":question,
		  "goodsId":goodsId
	    };	   
	    $.ajax({
            type: 'POST',//方法类型
            url: '/goods/insertQa',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (result) {
	//サーバーが成功した場合
                if (result.resultCode == 200) {
				debugger;					
						swal("質問ご登録ありがとうございました！" ,{
							icon:"success",
						});
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
 
	debugger;   
	function paging(num){
	//alert("Handlerfor .click() called." );   
	 
    var page = $("#currentPageNo").text();
    var pageNo = 0;
    console.log("current page: ",page);
	//console.log("selected value ",$('#zv-cqa-select-sort :selected').text());
	var url = "/goods/qaSort";
	
	if(num == 0){
		//下页
		 pageNo = parseInt(page) + 1;
	}else if (num == 1){
		//上页
		 pageNo = parseInt(page) - 1;
	}else{
		 pageNo = 1 
	}
	   data = {
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
							$("#ZVCQuestionsArea").find(".delete").remove();
					  	}
				        var ar = result.data.list;
	                    if(ar.length>0){
							$("#ZVCQuestionsArea").find(".zv-cqa").remove();
					    }
	                    for(let i=0; i<ar.length;i++){
							var qa =$(".hiddenQaDiv").clone().removeClass("hiddenQaDiv");
							qa.find(".zv-cqa-q-text").html(ar[i].question);
							$("#detailFooter").before(qa);
							//qa.appendTo("#ZVCQuestionsArea");
					    }
	                    for(let i = 0; i <ar.length;i++){
		
							el = $($(".hiddenQaDiv")[0]).clone().removeClass("hiddenQaDiv");
							el.find(".zv-cqa-question").html(result.data.list[i].question);
							el.find(".zv-cqa-q-info").html(result.data.list[i].submitDate);
							el.find(".zv-cqa-a-text").html(result.data.list[i].answer);
		     				el.find(".zv-cqa-a-info").html(result.data.list[i].answerDate);
							el.find(".zv-helpful zv-helpful-yes zv-helpful-yes-58746").html(result.data.list[i].helpedNum);
							$("#detailFooter").before(el);
							/*qa.appendTo("#ZVCQuestionsArea");*/
						}
                } else {
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
 //レビューの参考になった人数
	  function helpNumClickFunc() {
			debugger;	
		var reviewId = $( this ).parent().find(".hidSpForRevId").text();
		var data = {
			"reviewId" : reviewId 
		}
		var _this = $( this );
		var url = "/goods/helpNum"
			debugger;	
	     $.ajax({
            type: 'POST',//方法类型
            url: url,
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (result) {
	//サーバーが成功した場合
                if (result.resultCode == 200) {
				debugger;	
				_this.text("参考になった("+result.data+"人)");
		
					/*	swal("質問ご登録ありがとうございました！" ,{
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
       
  }
       
function getGoodsId(){
	    var path = window.location.pathname;
		//split with / 
		var ar = path.split("/");
		//get array 
		var len = ar.length;
		var goodsId = ar[len-1];
		
		return goodsId;
}