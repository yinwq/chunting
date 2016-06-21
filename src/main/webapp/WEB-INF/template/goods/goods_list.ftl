<script type="text/javascript">
$(document).ready(function(){
	$("ul li:eq(1)").addClass("active");
	$('.form_date').datetimepicker({
	    language:  'en',
	    weekStart: 1,
	    todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 2,
		forceParse: 0
	});
	$('.datatable').dataTable( {        				
		 "oLanguage": {
				"sUrl": "/DormManage/media/zh_CN.json"
		 },
		"bLengthChange": false, //改变每页显示数据数量
		"bFilter": false, //过滤功能
		"aoColumns": [
			null,
			null,
			null,
			null,
			null,
			null,
			null,
			null,
			{ "asSorting": [ ] },
			{ "asSorting": [ ] }
		]
	});
	$("#DataTables_Table_0_wrapper .row-fluid").remove();
});

window.onload = function(){ 
	$("#DataTables_Table_0_wrapper .row-fluid").remove();
};
	function recordDelete(recordId) {
		if(confirm("您确定要删除这条记录吗？")) {
			window.location="record?action=delete&recordId="+recordId;
		}
	}
	
</script>

<script type="text/javascript">
	//初始化，加载完成后执行
	window.onload=function(){
		search();
	};
	//搜索按钮绑定回车事件
	document.onkeydown = function(event){
		if (event.keyCode == 13) {
			event.cancelBubble = true;
			event.returnValue = false;
			search();
		}
	} 
 
	//下一步
	function next(){
		//得到当前选中项的页号
		var id=$("#pageNum option:selected").val();
		//计算下一页的页号
		var nextPage=parseInt(id)+1;
		//得到select的option集合
		var list=document.getElementById("pageNum").options;
		//得到select中，下一页的option
		var nextOption=list[nextPage-1];
		//修改select的选中项
		nextOption.selected=true;
		//调用查询方法
		search();
	}
 
	//上一步
	function previous(){
		//得到当前选中项的页号
		var id=$("#pageNum option:selected").val();
		//计算上一页的页号
		var previousPage=parseInt(id)-1;
		//得到select的option集合
		var list=document.getElementById("pageNum").options;
		//得到select中，上一页的option
		var previousOption=list[previousPage-1];
		//修改select的选中项
		previousOption.selected=true;
		//调用查询方法
		search();
	}
 
	//修改每页显示条数时，要从第一页开始查起
	function research() {
		//得到select的option集合
		var list=document.getElementById("pageNum").options;
		//得到select中，第一页的option
		var nextOption=list[0];
		//修改select的选中项
		nextOption.selected=true;
		//调用查询方法
		search();
	}
 
	//搜索，模糊查询学生违纪信息
	function search(){
		//得到查询条件
		//var searchString=$("#searchString").val();
		//得到每页显示条数
		var pageSize=$("#pageSize").val();
		//得到显示第几页
		var pageNum=$("#pageNum").val();

		$.ajax({
			type: "POST",
			async: false,
			url: "/goods/list.jhtml",
			data:{
			"pageSize":pageSize,
			"pageNum":pageNum,
			},
			dataType:"text",
			success: function (data) {
 
				//将json字符串转为json对象
				var pageEntity=JSON.parse(data);
 				//得到结果集
				var obj=pageEntity["rows"];
 
				//将除模板行的thead删除，即删除之前的数据重新加载 
				$("thead").eq(0).nextAll().remove(); 
				//将获取到的数据动态的加载到table中 
    			for (var i = 0; i < obj.length; i++) { 
    				 //获取模板行，复制一行 
     				var row = $("#tem").clone(); 
 
					//给每一行赋值
					row.find("#studentId").text(obj[i].studentId); //学号
					row.find("#studentName").text(obj[i].studentName); //学生姓名 
					row.find("#courseId").text(obj[i].courseId);  //课程名称 
					row.find("#examRoomId").text(obj[i].examRoomId);  //考场号
					row.find("#className").text(obj[i].className);  //所属班级 
					row.find("#teacherId").text(obj[i].teacherId);  //监考教师Id
 
				    //将新行添加到表格中 
				    row.appendTo("#table"); 
    			} 
    			//当前记录总数
    			var pageNumCount=pageEntity["total"];
    			//当前记录开始数
			    var pageNumBegin=(pageNum-1)*pageSize+1;
			    //当前记录结束数
			    var pageNumEnd=pageNum*pageSize
			    //如果结束数大于记录总数，则等于记录总数
			    if(pageNumEnd>pageNumCount){
			     pageNumEnd=pageNumCount;
			}
    		//得到总页数
    		var pageCount;
    		if(pageNumCount/pageSize==0){
     			pageCount=pageNumCount/pageSize;
    		}else{
     			pageCount=Math.ceil(pageNumCount/pageSize);
    		}
 
    		//输出"显示第 1 至 10 项记录，共 57 项"
    		document.getElementById("DataTables_Table_0_info").innerHTML=
     		"显示第"+pageNumBegin.toString()
     		+" 至 "+pageNumEnd.toString()
     		+" 项记录，共 "+pageNumCount.toString()+" 项";
 
    		//显示所有的页码数
		    var pageSelect =document.getElementById("page");
		    var pageOption="";
		    var flag;
    		//删除select下所有的option，清除所有页码
    		document.getElementById("pageNum").options.length=0;
    		for(var i=0;i<pageCount;i++){
    			flag=(i+1).toString();
    			var option;
    			//如果等于当前页码
    			if(flag==pageNum){
				    //实例化一个option,则当前页码为选中状态
				    option=new Option(flag, flag, false, true);
    			}else{
    				option=new Option(flag, flag, false, false);
    			}
    			//将option加入select中
    			document.getElementById("pageNum").options.add(option);
    		}
 
    		//如果总记录数小于5条，则不显示分页
    		if((pageNumCount-5)<0){
    			document.getElementById("bottomTool").style.display="none";
    		}else{
    			document.getElementById("bottomTool").style.display="";
    		}
 
    		/**给上一步下一步加颜色**/
    		//判断是否只有一页
    		if(pageCount==1){
				//如果只有一页，上一步，下一步都为灰色
				$("#previousPage").css("color","#AAA");//给上一步加灰色
    			$("#nextPage").css("color","#AAA");//给下一步加灰色
    		}else if(pageNum-1<1){
     			//如果是首页,则给上一步加灰色，下一步变蓝
     			$("#previousPage").css("color","#AAA");//给上一步加灰色
     			$("#nextPage").css("color","#00F");//给下一步加蓝色
			}else if(pageNum==pageCount){
				//如果是尾页,则给上一步加蓝色，下一步灰色
				$("#previousPage").css("color","#00F");//给上一步标签加蓝色
				$("#nextPage").css("color","#AAA");//给下一步标签加灰色
			}else{
				//上一步为蓝色，下一步为绿色
				$("#previousPage").css("color","#00F");//给上一步加蓝色
				$("#nextPage").css("color","#00F");//给下一步加蓝色
			}
		}
	});
}
 
</script>

<div class="data_list">
	<div class="data_list_title">
		商品列表
	</div>
	<form name="myForm" class="form-search" method="post" action="record?action=search" style="padding-bottom: 0px">
			<button class="btn btn-success" type="button" style="margin-right: 50px;" onclick="javascript:window.location='/goods/to_add.jhtml'">添加</button>
			<span class="data_search">
				<span class="controls input-append date form_date" style="margin-right: 10px" data-date="" data-date-format="yyyy-mm-dd" data-link-format="yyyy-mm-dd">
                	<input id="startDate" name="startDate" style="width:120px" placeholder="起始日期" type="text" value="${startDate }" readonly >
                	<span class="add-on"><i class="icon-remove"></i></span>
					<span class="add-on"><i class="icon-th"></i></span>
           		</span>
				<span class="controls input-append date form_date" style="margin-right: 10px" data-date="" data-date-format="yyyy-mm-dd" data-link-format="yyyy-mm-dd">
                	<input id="endDate" name="endDate" style="width:120px;" placeholder="终止日期" type="text" value="${endDate }" readonly>
                	<span class="add-on"><i class="icon-remove"></i></span>
					<span class="add-on"><i class="icon-th"></i></span>
           		 </span>
				<select id="buildToSelect" name="buildToSelect" style="width: 120px;">
				<option value="">全部宿舍楼</option>
				</select>
				<select id="searchType" name="searchType" style="width: 80px;">
					<option value="name">姓名</option>
				</select>
				&nbsp;<input id="s_studentText" name="s_studentText" type="text"  style="width:120px;" class="input-medium search-query" value="${s_studentText }">
				&nbsp;<button type="submit" class="btn btn-info" onkeydown="if(event.keyCode==13) myForm.submit()">搜索</button>
			</span>
	</form>
	<div>
		<table class="table table-striped table-bordered table-hover datatable">
			<thead>
				<tr>
				<th>商品名</th>
				<th>商品类型</th>
				<th>总代价</th>
				<th>一级价</th>
				<th>二级价</th>
				<th>三级价</th>
				<th>微商价</th>
				<th>市场价</th>
				<th>库存</th>
				<th>创建时间</th>
				<th>操作</th>
				</tr>
			</thead>
			<tbody>
			[#if goodsList?has_content]
				[#list goodsList as goods]
					<tr>
						<td>${goods.goodsName}</td>
						<td>
							[#if goods.goodsType == 1]
								三草两木
							[#elseif goods.goodsType == 2]
								珍慕彩妆
							[/#if]
						</td>
						<td>${goods.totalAgentPrice}</td>
						<td>${goods.firstAgentPrice}</td>
						<td>${goods.secondAgentPrice}</td>
						<td>${goods.thirdAgentPrice}</td>
						<td>${goods.derivativePrice}</td>
						<td>${goods.marketPrice}</td>
						<td>${goods.goodsStock}</td>
						<td>${goods.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
						<td>
							<button class="btn btn-mini btn-danger" type="button" onclick="recordDelete(${record.recordId })">删除</button>
						</td>
					</tr>
				[/#list]
			[/#if]
			</tbody>
		</table>
	</div>
	<div align="center"><font color="red">${error }</font></div>
	
	<!-- 页面底部显示 -->
	<!-- 每页显示几条记录 -->
	<div id="bottomTool" class="row-fluid" >
		<div class="span6" style="width:25%;;margin-right: 10px;">
			<div class="dataTables_length" id="DataTables_Table_0_length">
				<label>
					每页
					<select id="pageSize" onchange="research()" aria-controls="DataTables_Table_0" size="1" name="DataTables_Table_0_length">
						<option selected="selected" value="10">10</option>
						<option value="25">25</option>
						<option value="50">50</option>
						<option value="100">100</option>
					</select>
					条记录
				</label>
			</div>
		</div>
		<!-- 显示第 1 至 10 项记录，共 57 项 -->
		<div class="span6" style="width:25%;" >
			<div id="DataTables_Table_0_info" class="dataTables_info">显示第 1 至 10 项记录，共 57 项</div>
		</div>
		<!-- 第2页 -->
		<div class="span6" style="width:30%;">
			<div class="dataTables_paginate paging_bootstrap pagination">
				<ul id="previousNext">
					<li onclick="previous()" class="prev disabled"><a id="previousPage" href="#">← 上一页</a></li>
						<div id="page" style="float:left;">
							<select id="pageNum" onchange="search()" style="width:50PX;margin-right:1px;" aria-controls="DataTables_Table_0" size="1" name="DataTables_Table_0_length">
								<option selected="selected" value="1">1</option>
							</select>
						</div>
					<li class="next" onclick="next()"><a id="nextPage" href="#">下一页 → </a></li>
				</ul>
			</div>
		</div>
	</div>
</div>