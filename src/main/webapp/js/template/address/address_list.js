//初始化，加载完成后执行
$(function(){
	init();
	//search();
	
	//保存商品
	$("#save_goods").click(function(){
		next_handler = 0;
		$("#base_info_form").submit();      
	});
	//分页跳转
	$(".page").on("click","span a",function(){
		var page = $(this).attr("page");
		$("#pageNo").val(page);
		search();
	});
	
	//搜索按钮
	$("#search").on("click",function(){
		search();
	});
	var base_vali = $("#base_info_form").validate({
		rules:{
			goodsName:{
	        	required:true,
	        	maxlength:50
	        },
	        goodsType:{
	        	required:true
	        },
	        /*totalAgentPrice:{
	        	required:true,
	        	number:true
	        },*/
	        firstAgentPrice:{
	        	required:true,
	        	number:true
	        },
	        secondAgentPrice:{
	        	required:true,
	        	number:true
	        },
	        thirdAgentPrice:{
	        	required:true,
	        	number:true
	        },
	        derivativePrice:{
	        	required:true,
	        	number:true
	        },
	        marketPrice:{
	        	required:true,
	        	number:true
	        },
	        goodsStock:{
	        	required:true,
	        	digits:true
	        }
	    },
	    messages:{
	    	goodsName:{
	        	required:"请填写商品名称",
	        	maxlength:$.validator.format("商品名称不得多于{0} 个字符")
	    	},
	    	goodsType:{
	        	required:"请选择商品类型"
	        },
	        totalAgentPrice:{
	        	required:"请填写总代价",
	        	number:"输入正确的价格"
	        },
	        firstAgentPrice:{
	        	required:"请填写一级价",
	        	number:"输入正确的价格"
	        },
	        secondAgentPrice:{
	        	required:"请填写二级价",
	        	number:"输入正确的价格"
	        },
	        thirdAgentPrice:{
	        	required:"请填写三级价",
	        	number:"输入正确的价格"
	        },
	        derivativePrice:{
	        	required:"请填写微商价",
	        	number:"输入正确的价格"
	        },
	        marketPrice:{
	        	required:"请填写市场价",
	        	number:"输入正确的价格"
	        },
	        goodsStock:{
	        	required:"请填写库存",
	        	digits:"请输入整数"
	        }
	    },
	    errorPlacement: function (error, element) { //指定错误信息位置
	  		if (element.is(':radio') || element.is(':checkbox')) { //如果是radio或checkbox
	 			error.appendTo(element.parent()); //将错误信息添加当前元素的父结点后面
	 		} else if(element.is($("input[name='startTime']"))) {//如果是开始时间
	 			error.appendTo(element.parent());
	 		} else {
	   			error.insertAfter(element);
	 		}
			},
	    submitHandler:function(){
	    	if(save_base_info()){
				if(next_handler == 0){
					window.location.href=base + "/goods/list.jhtml";
				}
			}
		}
	}); 
})

//初始化
function init(){
	$("ul li:eq(2)").addClass("active");
	$('.form_datetime').datetimepicker({
	    language:  'en',
	    weekStart: 1,
	    todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 1,
		minView: 2,
		forceParse: 0,
	});
}


//搜索按钮绑定回车事件
/*document.onkeydown = function(event){
	if (event.keyCode == 13) {
		event.cancelBubble = true;
		event.returnValue = false;
		search();
	}
} */
 
 
//修改每页显示条数时，要从第一页开始查起
function research() {
	//得到select的option集合
	var setPageSize=$("#setPageSize").val();
	$("#pageSize").val(setPageSize);
	//切换显示条数后默认查第一页
	$("#pageNo").val(1);
	//调用查询方法
	search();
}
 	
var search_param = "";
function search_param_set(){
	search_param = $("#search_form").serialize();
	var pageSize=$('#pageSize').val();
	var pageNo=$('#pageNo').val();
	search_param = search_param + "&pageSize=" + pageSize + "&pageNo=" + pageNo;
}
 	
//搜索
function search(){
	search_param_set();
	$.ajax({
		type: "POST",
		async: false,
		url: base + "/goods/goods_list.jhtml",
		data:search_param,
		dataType:"json",
		success: function (result) {
			var pageNo=result.pageNo;
	   		var pageSize=result.pageSize;
	    	var totalCount=result.totalSize;
	    	var list = result.resultList;
	    	$(".tbody tr").remove();
	    	//填充列表
	    	$.each(list, function(index, detail) {
				var tr = $('<tr></tr>');
				//商品名
				tr.append('<td>'+detail.goodsName+'</td>');
				//商品类型
				var goodsTypeStr = "";
				if(detail.goodsType == 1){
					goodsTypeStr = "三草两木";
				}else if(detail.goodsType == 2){
					goodsTypeStr = "珍慕彩妆";
				}
				tr.append('<td>'+goodsTypeStr+'</td>');
				//总代价
				tr.append('<td>'+detail.totalAgentPrice+'</td>');
				//一级价
				tr.append('<td>'+detail.firstAgentPrice+'</td>');
				//二级价
				tr.append('<td>'+detail.secondAgentPrice+'</td>');
				//三级价
				tr.append('<td>'+detail.thirdAgentPrice+'</td>');
				//微商价
				tr.append('<td>'+detail.derivativePrice+'</td>');
				//市场价
				tr.append('<td>'+detail.marketPrice+'</td>');
				//库存
				tr.append('<td>'+detail.goodsStock+'</td>');
				//创建时间
				tr.append('<td>'+detail.createTimeStr+'</td>');
				//操作
				var optTd='<td><button class="btn btn-mini btn-info" type="button" onclick="thisEdit('+detail.id+')">编辑</button>&nbsp;<button class="btn btn-mini btn-danger" type="button" onclick="thisDel('+detail.id+')">删除</button></td>';
				tr.append(optTd);
				$(".tbody").append(tr);
			});
			setPage(totalCount,pageSize,pageNo);
			
		}
	});
}

function save_base_info(){
	returnflag = false;
	$.ajax({
    	type:"POST",
    	url:base + "/goods/add.jhtml",
    	data:$("#base_info_form").serialize(),
    	dataType:"json",
    	async:false,
    	success:function(result){
    		if(result.success == true && result.data != undefined){
        		$("#id").val(result.data.id);         
        		alert("保存成功！");
        		returnflag = true;
      		}
    	},
    	error:function(){
      		alert("保存失败！");       
    	} 
  	});
  return returnflag;
}  

//编辑商品
function thisEdit(goodsId){
	window.location=base + "/goods/to_add.jhtml?id="+goodsId;
}
//删除商品
function thisDel(goodsId) {
	if(confirm("您确定要删除这条记录吗？")) {
		$.ajax({
	    	type:"GET",
	    	url:base + "/goods/delete.jhtml",
	    	data:{id:goodsId},
	    	dataType:"json",
	    	async:false,
	    	success:function(result){
	    		if(result.success == true){
	        		alert("删除成功！");
	        		window.location=base + "/goods/list.jhtml";
	      		}
	    	},
	    	error:function(){
	      		alert("删除失败！");       
	    	} 
	  	});
		
	}
}

//分页
function setPage(totalCount,pageSize,pageNo){
	$("#pageNo").val(pageNo);
	$("#pageSize").val(pageSize);
	//总页数
	var pageCount = (totalCount%pageSize)==0?(totalCount/pageSize):(Math.ceil(totalCount/pageSize));
	var pageDiv = '';
	if(pageCount != 0){
		//首页
		if(pageNo == 1){
			pageDiv+='<span title="首页" class="disabled">首页</span>';
			pageDiv+='<span title="上一页" class="disabled">上一页</span>';
		}else{
			pageDiv+='<span title="首页"><a href="javascript:void(0);" page="1">首页</a></span>';
			pageDiv+='<span title="上一页"><a href="javascript:void(0);" page="'+(pageNo-1)+'">上一页</a></span>';
		}
		//默认显示6条
		if(((pageCount-pageNo)+1) >= 6){
			for(var i=0;i<6;i++){
				if(i==0){
					pageDiv+='<span class="current" title="第'+pageNo+'页">pageNo</span>';
				}else{
					pageDiv+='<span title="第'+(pageNo+i)+'页"><a href="javascript:void(0);" page="'+(pageNo+i)+'">'+(pageNo+i)+'</a></span>';
				}
			}
		}else{
			for(var i=1;i<=pageCount;i++){
				if(i==pageNo){
					pageDiv+='<span class="current" title="第'+pageNo+'页">'+pageNo+'</span>';
				}else{
					pageDiv+='<span title="第'+i+'页"><a href="javascript:void(0);" page="'+i+'">'+i+'</a></span>';
				}
			}
		}
		//下一页
		if(pageNo==pageCount){
			pageDiv+='<span title="下一页" class="disabled">下一页</span>';
			pageDiv+='<span title="尾页" class="disabled">尾页</span>';
		}else{
			pageDiv+='<span title="下一页"><a href="javascript:void(0);" page="'+(pageNo+1)+'">下一页</a></span>'
			pageDiv+='<span title="尾页"><a href="javascript:void(0);" page="'+pageCount+'">尾页</a></span>'
		}
		$(".pg_count").	text("共"+totalCount+"条");
	}else{
		$(".pg_count").	text("");
	}
	$(".page").html(pageDiv);
	$("#setPageSize option").each(function(){
		if($(this).val() == pageSize){
			$(this).siblings().removeAttr("selected");
			$(this).attr("selected","selected");
		}
		
	});
}