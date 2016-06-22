<link rel="stylesheet" type="text/css" href="/css/page.css">
<script type="text/javascript" src="/js/template/goods/goods_list.js"></script>
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
});
</script>

<script type="text/javascript">
	
 
</script>

<div class="data_list">
	<div class="data_list_title">
		商品列表
	</div>
	<input type="hidden" id="pageSize" value="5"/>
	<input type="hidden" id="pageNo" value=""/>
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
			<tbody class="tbody">
			</tbody>
		</table>
	</div>
	<div align="center"><font color="red">${error }</font></div>
	<!-- 页面底部显示 -->
	<div style="overflow: hidden;margin-bottom: 5px;">
		<div class="dataTables_length">
			<label>
				<span>每页</span>
				<select id="setPageSize" onchange="research()" class="setPageSize" aria-controls="" size="1" name="">
					<option value="5">5</option>
					<option value="10">10</option>
					<option value="25">25</option>
					<option value="50">50</option>
					<option value="100">100</option>
				</select>
				<span>条记录</span>
			</label>
		</div>
		<div class="pg" style="float: right;">
			<span class="page">
			</span>
			<span class="pg_count"></span>
			<div class="clear"></div>
		</div>
	</div>
</div>