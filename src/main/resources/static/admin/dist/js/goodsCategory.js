var arr = [];//全局变量
function secondButton(thi,categoryId){
	     debugger;
		if (arr.includes(categoryId)){
			return;
		}
		arr.push(categoryId);
		    $.ajax({
            type: 'POST',//方法类型
            url: '/admin/secondCategory',
            contentType: 'application/json',
            data: JSON.stringify(categoryId),
            success: function (result) {
	          debugger;
				//サーバーが成功した場合
                if (result.resultCode == 200) {
					showResult(thi,result);
	
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
	});
};
function showResult(thi,result){
	//var list = result.data.list;
	//获取category级别的list
	var list = result.data.list;
	//获取goodsSale的list
	var gsM = result.data.gsM;
	//cloneUL模板
	var cloneUl = $(".secondCategoryId").clone().removeClass("secondCategoryId");
	for (var i = 0; i < list.length; i++) {
		var option = "";
		var temp = "";
		var se = $('<select/>',{class: "custom-select1"}).css({ "width": "20%", });
		var el = cloneUl.find(".dumyLi").clone().removeClass("dumyLi");
		for (var j = 0; j < gsM.length; j++) {
			option += '<option value=\"' + gsM[j].id + '\">' + gsM[j].name + '</option>'//<option value="gsM[i].id">gsM[i].name</option>
			se.html(option);
			if (gsM[j].id == list[i].id && gsM[j].id != null) {
				temp = gsM[j].id;
				//找到checkbox位置
				el.find(".checkId").prop('checked', true);
			}
			if(temp != ""){
				se.val(temp);
				}
		}
		el.find("input:first-child").before(se);
		//找到categoryName,goodsName
		var cn = el.find("a");
	    cn.text(list[i].categoryName);
		cn.text(list[i].goodsName);
		var categoryId = el.find("#hiddenCategoryId");
		var goodsCategoryId = el.find("#hiddenGoodsCategoryId");
		var goodsId = el.find("#hiddenGoodsId");
		var startDate = el.find("#startDateUl");
		var endDate = el.find("#endDateUl");
		startDate.val(list[i].startDate);
		endDate.val(list[i].endDate);
		categoryId.val(list[i].categoryId);
		goodsId.val(list[i].goodsId);
		goodsCategoryId.val(list[i].goodsCategoryId)
		//clone第二个ul模板
		//cloneUl.find(".button4").attr('onclick','secondButton()');
		el.find(".button4").attr('onclick', 'secondButton(this,' + list[i].categoryId + ')');
		el.find(".checkId").attr('onchange', 'checkPopup(this)');
		debugger;
		cloneUl.find(".dumyLi").before(el);
		//popup关闭button
		cloneUl.find("#closeButton").click(function() {
			debugger;
			cloneUl.find("#closeBut").remove();
			arr.pop(categoryId);
		})
	}
	cloneUl.show();
	//appendToSearchBar(thi,cloneUl);
	var rect = thi.getBoundingClientRect();//转换成dom加[0]  convert jquery object to dom by searchBar[0]
	console.log(rect.top,rect.right,rect.bottom,rect.left);
	//var sbHeight = searchBar.height();
	//el.height(rect.top + sbHeight)
	//el.left(rect.left);
	cloneUl.css({top: rect.top,left: rect.right,position:'fixed'});//相对定位relative  绝对定位absolute  fixed
	$(".wrapper").append(cloneUl);
}
//2021/06/01
function checkPopup(thi) {
	debugger;
	var flag = $(thi).is(':checked');
	var id = $(thi).parent().find(".custom-select1").val();
	var goodsId = $(thi).parent().find("#hiddenGoodsId").val();
	var startDate = $(thi).parent().find("#startDateUl").val();
	var endDate = $(thi).parent().find("#endDateUl").val();
	$("#campaignSet").find("#hiddenPrimaryGoodsId").val(goodsId);
	$("#campaignSet").find("#hiddenModalStartDate").val(startDate);
	$("#campaignSet").find("#hiddenModalEndDate").val(endDate);
		if (id == 1) {
			debugger;
			var goodsName = $(thi).parent().find(".modalGoodsName").text();
			var goodsCategoryId = $(thi).parent().find("#hiddenGoodsCategoryId").val();
			$("#campaignSet").find("#primaryGoodsId").val(goodsName);
			$("#campaignSet").find("#hiddenModalCategoryId").val(goodsCategoryId);
		var data = {
			"goodsId": goodsId,
			"flag": flag,
			"goodsCategoryId": goodsCategoryId,
		};
		$.ajax({
			type: 'POST',//方法类型
			url: '/admin/subGoodsName',
			contentType: 'application/json',
			data: JSON.stringify(data),
			success: function(result) {
				if (result.resultCode == 200) {
					debugger;
					if (!flag) {
						swal("ご削除出来ました！", {
							icon: "success",
						});
					} else {
						var goodsList = result.data;
						for (var i = 0; i < goodsList.length; i++) {
							$("#modalSubGoodsName").append('<option value=\"' + goodsList[i].goodsId + '\">' + goodsList[i].goodsName + '</option>');
						}
					}
				} else {
					swal(result.message, {
						icon: "error",
					});
				}
			},
			error: function() {
				swal("操作失败", {
					icon: "error",
				});
			}
		})
		if (goodsId&&flag&&id==1) {
			$("#campaignSet").modal('show');
		} 
		return;

	}
else {
		var categoryId = $(thi).parent().find("#hiddenCategoryId").val();
		var data = {
			"flag": flag,
			"id": id,
			"startDate": startDate,
			"endDate": endDate,
			"categoryId": categoryId
		};
		$.ajax({
			type: 'POST',//方法类型
			url: '/admin/insertAndDeleteCategory',
			contentType: 'application/json',
			data: JSON.stringify(data),
			success: function(result) {
				//サーバーが成功した場合
				if (result.resultCode == 200) {
					if (data.flag) {
						swal("ご挿入出来ました！", {
							icon: "success",
						});
					} else {
						swal("ご削除出来ました！", {
							icon: "success",
						});
					}
				} else {
					swal(result.message, {
						icon: "error",
					});
				}

			},
			error: function() {
				swal("有効期限外", {
					icon: "error",
				});
			}
		})
	}
}	
//2021/06/01 insertSale 绑定modal上的保存按钮
$("#saveSaleButton").click(function(){	
	debugger;
	var primaryGoodsId = $("#hiddenPrimaryGoodsId").val();
	var subGoodsId = $("#modalSubGoodsName").val();
	var startDate = $("#hiddenModalStartDate").val();
	var endDate = $("#hiddenModalEndDate").val();
	var categoryId = $("#hiddenModalCategoryId").val();
	var campaginId = 1;
    var data = {
	"campaginId":campaginId,
	"primaryGoodsId":primaryGoodsId,
	"subGoodsId":subGoodsId,
	"startDate":startDate,
	"endDate":endDate,
	"categoryId":categoryId,
    };	  
    $.ajax({
        type: 'POST',//方法类型
        url: '/admin/goods/primaryGoods',
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function (result) {
//サーバーが成功した場合
            if (result.resultCode == 200) {
					swal("ご登録ありがとうございました！" ,{
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
	$(".modal").fadeOut();
  });