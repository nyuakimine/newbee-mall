   $("#zv-cqa-select-sort").change(function(){
	var page = $("#currentPageNo").text();
	var url = "/goods/qaSort";
	var url = "/goods/qaSort";
	var data = {
		"page":page
	           };
	debugger;    
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
				    
                    /*var ar = result.data.list;*/
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
        })
      })