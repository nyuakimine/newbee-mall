var MouseOnSearchResultUl  //全局变量
function secondButton(thi,categoryId){
	//var categoryId = $(".fontSize").parent().parent().find("#secondCategory").val();
		    $.ajax({
            type: 'POST',//方法类型
            url: '/admin/secondCategory',
            contentType: 'application/json',
            data: JSON.stringify(categoryId),
            success: function (result) {
	          debugger;
				//サーバーが成功した場合
                if (result.resultCode == 200) {
				    clearResultList();					
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
         })
};
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
function showResult(thi,result){
	//获取category级别的list
	var cm = result.data.cm;
	//获取goodsSale的list
	var gsM = result.data.gsM;
	var option = "";
	//cloneUL模板
	var cloneUl = $(".secondCategoryId").clone();
	for (var i = 0; i < gsM.length; i++) {
		var se = $('<select/>').css({"width": "20%",});
		option += '<option value=\"' + gsM[i].id + '\">' + gsM[i].name + '</option>'//<option value="gsM[i].id">gsM[i].name</option>
		se.html(option);
		var el = $(".dumyLi").clone().removeClass("dumyLi");
		for (var j = 0; j < cm.length; j++) {
			if (gsM[i].id == cm[j].id && gsM[i].id != null) {
			    se.val(gsM[i].id);
			}
		}
		el.find("input:first-child").before(se);
		//找到categoryName
		var cn = el.find("a");
		cn.text(cm[i].categoryName);
		//找到checkbox位置
		cloneUl.find(".secondCheckbox").prop('checked',true);
		//找到时间的位置，同一行第四个开始
		var sd = el.find("input:nth-child(5)");
		var ed = el.find("input:nth-child(7)");
		sd.val(cm[i].startDate);
		ed.val(cm[i].endDate);
		//clone第二个ul模板
	    cloneUl.find('.button4').attr('onClick','secondButton(' +thi +','+cm[i].categoryId+');');
		cloneUl.find(".dumyLi").before(el);
	}
	debugger;
	cloneUl.show();
	//appendToSearchBar(thi,cloneUl);
	var rect = thi.getBoundingClientRect();//转换成dom加[0]  convert jquery object to dom by searchBar[0]
	console.log(rect.top,rect.right,rect.bottom,rect.left);
	//var sbHeight = searchBar.height();
	//el.height(rect.top + sbHeight)
	//el.left(rect.left);
	cloneUl.css({top: rect.top,left: rect.right,position:'absolute'});//相对定位relative  绝对定位absolute
	$("#main").append(cloneUl);
}
function appendToSearchBar(thi,el){
	debugger;
	var rect = thi.getBoundingClientRect();//转换成dom加[0]  convert jquery object to dom by searchBar[0]
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
  
function clickMe(_this){
	console.log(_this);
}
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