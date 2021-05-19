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
	var url = "admin//goods/sale";
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
