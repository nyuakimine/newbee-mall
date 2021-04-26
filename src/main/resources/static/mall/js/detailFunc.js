   $("#zv-cqa-select-sort").change(function(){
	var page = $("#currentPageNo").text();
	var url = "/goods/qaSort";
	var url = "/goods/qaSort";
	var date = {
		"page":page
	           };
	debugger;   
    console.log("data",data);  
        $.ajax({
            type: 'POST',//方法类型
            url: url,
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (result) {
	//サーバーが成功した場合
                if (result.resultCode == 200) {                    
                    swal("保存成功", {
                        icon: "success",
                    });
                  
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