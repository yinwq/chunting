<link rel="stylesheet" type="text/css" href="${base}/css/page.css">
<script type="text/javascript" src="${base}/js/vendor/jquery-validation/dist/jquery.validate.js" ></script>
<script type="text/javascript" src="${base}/js/base/formatData.js"></script>
<script type="text/javascript" src="${base}/js/vendor/laydate/laydate.js"></script>
<script type="text/javascript" src="${base}/js/template/address/address_list.js"></script>

<div class="data_list">
	<div class="data_list_title">
		地址列表
	</div>
	<input type="hidden" id="pageSize" value=""/>
	<input type="hidden" id="pageNo" value=""/>
	<form name="search_form" id="search_form" class="form-search" style="padding-bottom: 0px">
			<button class="btn btn-success" type="button" style="margin-right: 50px;" onclick="javascript:window.location='${base}/address/to_add.jhtml'">添加</button>
			<span class="data_search">
				<span>创建时间段：</span>
				<input id="strat_time" name="startTime" value="${startTime}"  onclick="laydate({istime:true, format: 'YYYY-MM-DD hh:mm:ss'})" type="text">
				-
				<input id="end_time" name="endTime" value="${endTime}"  onclick="laydate({istime:true, format: 'YYYY-MM-DD hh:mm:ss'})" type="text">
           		<span style="margin-left:50px;">地址类型：</span>
				<select id="goodsType" name="goodsType" style="width: 100px;">
					<option value="">请选择</option>
					<option value="1">代理</option>
					<option value="2">客户</option>
				</select>
				<span style="margin-left:50px;">收货人：</span>
				&nbsp;<input id="goodsName" name="goodsName" type="text"  style="width:150px;" class="search-query" value="${goodsName }">
				&nbsp;<button type="button" id="search" class="btn btn-info" onkeydown="if(event.keyCode==13) search()">搜索</button>
			</span>
	</form>
	<div>
		<table class="table table-striped table-bordered table-hover datatable">
			<thead>
				<tr>
				<th>收货人</th>
				<th>地址类型</th>
				<th>省市县/区</th>
				<th>详细地址</th>
				<th>电话</th>
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