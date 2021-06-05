var MouseOnSearchResultUl  //全局变量
 $(".button3").click(function(){	
	var categoryId = $(this).parent().find("#secondCategory").val();
	
		    $.ajax({
            type: 'POST',//方法类型
            url: '/admin/secondCategory',
            contentType: 'application/json',
            data: JSON.stringify(categoryId),
            success: function (result) {
				//サーバーが成功した場合
                if (result.resultCode == 200) {
				debugger;
				    clearResultList();					
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
$(".button3").focusout(function(){
	if(MouseOnSearchResultUl)
	return;
    clearResultList()
	//hide #searchResultUl
	$(".secondCategoryId").hide();
})
function clearResultList(){
	$(".secondCategoryId").children().toArray().forEach(function(value,index,array){
		var incFlag = $(value).attr('class').includes("dumyLi");
		if(!incFlag){
			$(value).remove();
		}
	})
}
function showResult(result){
	//campaignName
	var gsM = result.data.gsM;
	var option = "";
	for(var i = 0; i< gsM.length; i++){
		option += '<option value=\"'+gsM[i].id+'\">' + gsM[i].name + '</option>'
		$('.secondOption').html(option);
		}
    //categoryName
	var cm = result.data.cm;
	for(var i = 0; i< cm.length; i++){
		var el = $(".dumyLi").clone().removeClass("dumyLi");
		var cn = el.find("a");
		cn.text(cm[i].categoryName);
		
/*		var startDate = (cm[i].startDate).split("T");
		$(".startDateSecond").val(startDate[0]);
		var endDate = (cm[i].endDate).split("T");
		$(".endDateSecond").val(endDate[0]);*/
		
		$(".dumyLi").before(el);
	}
	$(".secondCategoryId").show();
	appendToSearchBar($(".secondCategoryId"));
}
function appendToSearchBar(el){
	debugger;
	var searchBar = $(".button3");//jquery object
	//var searchBar = document.getElementById("button2");//dom
	var rect = searchBar[0].getBoundingClientRect();//转换成dom加[0]  convert jquery object to dom by searchBar[0]
	console.log(rect.top,rect.right,rect.bottom,rect.left);
	//var sbHeight = searchBar.height();
	//el.height(rect.top + sbHeight)
	//el.left(rect.left);
	el.css({top: rect.top,left: rect.right,position:'fixed'});//相对定位relative  绝对定位absolute
	}
$(".secondCategoryId").mousemove(function(){
	MouseOnSearchResultUl = true;
});
$(".secondCategoryId").mouseleave(function(){
	MouseOnSearchResultUl = false;
})
//2021/06/01
  $(".checkId").change(function() {
   var ischecked = $(this).is(':checked');
 if (!ischecked) {
	var categoryId = $(this).val();
debugger;
 $.ajax({
  type: 'POST',//方法类型
  url: '/admin/delete/categoryId',
  contentType: 'application/json',
  data: JSON.stringify(categoryId),
  success: function(result) {
   if (result.resultCode == 200) {
	swal("削除されました！" ,{
						icon:"success",
					});
   } else {
    swal(result.message, {
     icon: "error",
    });
   }
   ;
  },
  error: function() {
   swal("操作失败", {
    icon: "error",
   });
  }
 });
  }  else{
   var id =$(this).parent().parent().find(".custom-select1").val();
   var startDate = $(this).parent().find(".startDate").val();
   var endDate =$(this).parent().find(".endDate").val();
   var categoryId = $(this).val();
   var data = {
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
			debugger;					
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
            swal("有効期限外！", {
                icon: "error",
            });
         }
     })
}
});
//2021/06/01 modal 
$(function(){
	$("#modal-open").click(function(){
		$(".modal").fadeIn();
	});
	$("#datequxiao").click(function(){
		$(".modal").fadeOut();
	});
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
			debugger;					
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