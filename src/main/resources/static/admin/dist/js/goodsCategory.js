var MouseOnSearchResultUl  //全局变量
var arr = [];
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
	//获取category级别的list
	var cm = result.data.cm;
	//获取goodsSale的list
	var gsM = result.data.gsM;
	//cloneUL模板
	var cloneUl = $(".secondCategoryId").clone().removeClass("secondCategoryId");
	for (var i = 0; i < cm.length; i++) {
		var option = "";
		var se = $('<select/>',{class: "custom-select1"}).css({ "width": "20%", });
		var el = cloneUl.find(".dumyLi").clone().removeClass("dumyLi");
		for (var j = 0; j < gsM.length; j++) {
			option += '<option value=\"' + gsM[j].id + '\">' + gsM[j].name + '</option>'//<option value="gsM[i].id">gsM[i].name</option>
			se.html(option);
			if (gsM[j].id == cm[i].id && gsM[j].id != null) {
				se.val(gsM[j].id);
				//找到checkbox位置
				el.find(".checkId").prop('checked', true);
			}
		}
		el.find("input:first-child").before(se);
		//找到categoryName
		var cn = el.find("a");
		cn.text(cm[i].categoryName);
		//找到时间的位置，同一行第四个开始
		var sd = el.find("input:nth-child(6)");
		var ed = el.find("input:nth-child(8)");
		sd.val(cm[i].startDate);
		ed.val(cm[i].endDate);
		var ci = el.find("input:nth-child(3)");
		ci.val(cm[i].categoryId);
		//clone第二个ul模板
		//cloneUl.find(".button4").attr('onclick','secondButton()');
		el.find(".button4").attr('onclick', 'secondButton(this,' + cm[i].categoryId + ')');
		el.find(".checkId").attr('onchange', 'checkPopup(this)');
		debugger;
		cloneUl.find(".dumyLi").before(el);
		//popup关闭button
		cloneUl.find("#closeButton").click(function() {
			debugger;
			cloneUl.find("#closeBut").remove();
		})
		//arr.push({"categoryId":cm[i].categoryId,"cloneUl":cloneUl})
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
function checkPopup(thi){
	 debugger;
   var flag = $(thi).is(':checked');
   var id =$(thi).parent().parent().find(".custom-select1").val();
   var startDate = $(thi).parent().find(".startDate").val();
   var endDate =$(thi).parent().find(".endDate").val();
   var categoryId = $(thi).parent().find(".hiddenCategoryId").val();
   var data = {
	"flag":flag,
	"id":id,
	"startDate":startDate,
	"endDate":endDate,
	"categoryId":categoryId
    };
     $.ajax({
        type: 'POST',//方法类型
        url: '/admin/goods/inserTbcategory',
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function (result) {
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
        error: function () {
            swal("有効期限外", {
                icon: "error",
            });
         }
     })
}	

//2021/06/01 modal 
	$("#modal-open").click(function(){
		$(".modal").fadeIn();
	});
	$("#datequxiao").click(function(){
		$(".modal").fadeOut();
	});

//2021/06/01 insertSale 绑定modal上的保存按钮
$("#saveSaleButton").click(function(){	
	var primaryGoodsId = $("#primaryGoodsId").val();
	var subGoodsId = $("#subGoodsId").val();
    var data = {
	"primaryGoodsId":primaryGoodsId,
	"subGoodsId":subGoodsId,
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
  
/*function clickMe(_this){
	console.log(_this);
}*/
//获取赠送商品的goodsId
/*$("#saveGoodsButton").click(function(){	

  $(function () {
  var goodsId =$("#primaryGoodsId").val(); 
  
       $.ajax({
        type: 'POST',//方法类型
        url: '/admin/goods/subGoods',
        contentType: 'application/json',
        data: JSON.stringify(goodsId),
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
         }
     })
     });
});*/