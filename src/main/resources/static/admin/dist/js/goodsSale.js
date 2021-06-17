  //download csv by niu 2021/05/14
$("#downloadsale").on('click',function(){
	        debugger;
	        var ids = [];
			var format=$("#inputGroupSelect04").val();
			$('input:checkbox:checked').parent().next().map(function (){
			    ids.push($(this).text())
			    return ids;
			})
			var index = ids.indexOf("Campaign ID");
			  if (index > -1) {
			  ids.splice(index, 1);
			}
			var data = {
				"ids": ids,
				"format": format
			}
		
			if (!ids){
			    swal("请选择一条记录" ,{
				icon:"warning",
				});
			    return
		    }
	  	    $.ajax({
            type: 'POST',//方法类型
            url: '/admin/goodsSale/download',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (result) {
	        //サーバーが成功した場合
                if (result.resultCode == 200) {
	              debugger;
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
  //DIY add by niu upload 2021/05/20
new AjaxUpload('#col-120', {
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
              swal("uploadがOKです！" ,{
								icon:"success",
							});
            } else {
                alert("error");
            }
        }
 });
// 2021/05/22 Listen for click on toggle checkbox 
$('#select-all').click(function(event) {   
    if(this.checked) {
        // Iterate each checkbox
        $(':checkbox').each(function() {
            this.checked = true;                        
        });
    } else {
        $(':checkbox').each(function() {
            this.checked = false;                       
        });
    }
});
//2021/05/24 modal 154-199
$(function(){
	$("#modal-open").click(function(){
		$(".modal").fadeIn();
	});
	$("#datequxiao").click(function(){
		$(".modal").fadeOut();
	});
});
//2021/05/24 insertSale 绑定modal上的保存按钮
$("#saveSaleButton").click(function(){	
	var name = $("#campaignSaleName").val();
	var startDate = $("#startDateSale").val();
	var endDate = $("#endDateSale").val();
	var campaign = $("#campaignSale").val();
	var content1 = $("#content1Sale").val();
	var content2 = $("#content2Sale").val();
	var content3 = $("#content3Sale").val();
	var content4 = $("#content4Sale").val();
	var content5 = $("#content5Sale").val();
	var flag = $("#flagSale").val();
    var data = {
	"name":name,
	"startDate":startDate,
	"endDate":endDate,
	"campaign": campaign,
	"content1": content1,
	"content2": content2,
	"content3": content3,
	"content4": content4,
	"content5": content5,
	"flag": flag,
    };	  
    $.ajax({
        type: 'POST',//方法类型
        url: '/admin/goods/insertSale',
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
//2021/05/24 sort niuxiaofeng 201-271
$(function(){
  // カラムのクリックイベント
  $("th").click(function(){
    // ★span要素の独自属性（sort）の値を取得
    var sortClass = $(this).find("span").attr("sort");
    var sortFlag = "asc";
    // 初期化
    $("table thead tr span").text("");
    $("table thead tr span").attr("sort", "");
    // 空欄チェック
    if(isBlank(sortClass) || sortClass == "asc") {
      $(this).find("span").text("▼");
      // ★独自属性（sort）の値を変更する
      $(this).find("span").attr("sort", "desc");
      sortFlag = "desc";
    } else if(sortClass == "desc") {
      $(this).find("span").text("▲");
      $(this).find("span").attr("sort", "asc"); 
      sortFlag = "asc";
    }
    var element = $(this).attr("id");
    sort(element, sortFlag);
  });
  /******** 共通関数 ********/
  function sort(element, sortFlag) {
    // ソート
    // ★sort()で前後の要素を比較して並び変える。※対象が文字か数値で処理を変更
    var arr = $("table tbody tr").sort(function(a, b) {
      if ($.isNumeric($(a).find("td").eq(element).text())) {
        // ソート対象が数値の場合
        var a_num = Number($(a).find("td").eq(element).text());
        var b_num = Number($(b).find("td").eq(element).text());

        if(isBlank(sortFlag) || sortFlag == "desc") {
          // 降順
          return b_num - a_num;
        } else {
          // 昇順
          return a_num - b_num;
        }
      } else {
        // ソート対象が数値以外の場合
        var sortNum = 1;
        if($(a).find("td").eq(element).text() 
             > $(b).find("td").eq(element).text()) {
          sortNum = 1;
        } else {
          sortNum = -1;
        }
        if(isBlank(sortFlag) || sortFlag == "desc") {
          // 降順
          sortNum *= (-1) ;
        }

        return sortNum;
      }
    });
  // 表を置き換える  ★html()要素を置き換える
    $("table tbody").html(arr);
  }
  //バリデーションチェック
  function isBlank(data){
    if (data.length ==0 || data == ''){
      return true;
    } else {
      return false;
    }
  }
});
//csv
$(function() {
  // テーブルからデータを取得
  var table = $('order-table tr').map(function(i) {
    return $(this).find('th td').map(function() {
      return $(this).text() 
    });
  });
  // CSVデータ整形
  var csv = table.map(function(i, row){return row.toArray().join(',');}).toArray().join('\r\n');
  // Excelの文字化け対策
  var bom = new Uint8Array([0xEF, 0xBB, 0xBF])
});
//絞り込み検索 改修 2021/05/25
$(function() {
     $('#kennsaku').on('click', function() {
         $('table tbody tr').hide()
             .filter(":contains('" + ($('#searchSale').val()) + "')")
             .show();
     })
 })