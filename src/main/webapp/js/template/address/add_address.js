//初始化，加载完成后执行
$(function(){
	init();
	
	$("#province , #city").on("change",function(){
		var parentId = $(this).val();
		var nextSelect = $(this).next();
		//选择请选择的情况
		if(parentId == 0){
			if($(this).attr("id") == "province"){
				var options = $("#city").find("option");
    			options.not(options[0]).remove();
    			
    			var options = $("#county").find("option");
    			options.not(options[0]).remove();
			}else if($(this).attr("id") == "city"){
				var options = $("#county").find("option");
    			options.not(options[0]).remove();
			}
		}else{
			getArea(parentId , nextSelect);
		}
	});
	//保存商品
	$("#save_goods").click(function(){
		next_handler = 0;
		$("#base_info_form").submit();      
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
					window.location.href="${base}/goods/list.jhtml";
				}
			}
		}
	}); 
})

//初始化
function init(){
	//初始化省级
	var province = $("#province");
	getArea(0,province);

	//初始化
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


function getArea(parentId , level){
	$.ajax({
    	type:"POST",
    	url:base + "/address/areas.jhtml",
    	data:{parentId:parentId},
    	dataType:"json",
    	async:false,
    	success:function(result){
    		if(result.success == true && result.data != undefined){
    			var options = level.find("option");
    			options.not(options[0]).remove();
        		var list = result.data.aeraList;
        		$.each(list, function(index, detail) {
        			var option = $('<option value="'+detail.areaId+'">'+detail.areaName+'</option>');
        			level.append(option);
        		});
      		}
    	},
    	error:function(){
      		alert("初始化省份失败！");       
    	} 
  	});
}

function save_base_info(){
	returnflag = false;
	$.ajax({
    	type:"POST",
    	url:"${base}/goods/add.jhtml",
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