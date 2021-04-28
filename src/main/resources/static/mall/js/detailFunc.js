(function(){
	//disable previous page 
	debugger;
	$(".previousPage").css("pointer-events", "none").css("color","grey");
});  
  
  
   $("#zv-cqa-select-sort").change(function(){

      paging(2);
      });
      //下一页
      $( ".nextPage" ).click(function(){
	   paging(0);
	   $(".previousPage").css("pointer-events", "auto").css("color","#009e96");
	   });
	   //上一页
	      $( ".previousPage" ).click(function(){
	   paging(1);
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
						$("#ZVCQuestionsArea").find(".zv-cqa").remove();
					  	}
				    
                    var ar = result.data.list;
                    for(let i = 0; i <ar.length;i++){
	
					el = $(".hiddenQaDiv").clone().removeClass("hiddenQaDiv");
					el.find(".zv-cqa-q-text").html(result.data.list[i].question);
					
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