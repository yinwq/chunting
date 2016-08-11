<script type="text/javascript" src="${base}/js/vendor/jquery-validation/dist/jquery.validate.js" ></script>
<script type="text/javascript" src="${base}/js/template/goods/goods_list.js"></script>
<style type="text/css">
	label {
		display:inline-block !important;
		margin: 5px 10px !important;
		color:red;
	}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		$("ul li:eq(1)").addClass("active");
	});
</script>
<div class="data_list">
		<div class="data_list_title">
			[#if goods.id?has_content]
				修改商品
			[#else]
				添加商品
			[/#if]
		</div>
		<form action="${base}/goods/add.jhtml" id="base_info_form" method="post" onsubmit="return checkForm()">
			<div class="data_form" >
				<input type="hidden" id="id" name="id" value="${goods.id}"/>
				<table align="center">
					<tr>
						<td><font color="red">*</font>商品名：</td>
						<td><input type="text" id="goodsName"  name="goodsName" value="${goods.goodsName}"  style="margin-top:5px;height:30px;" /></td>
					</tr>
					<tr>
						<td><font color="red">*</font>商品类型：</td>
						<td>
							<select id="goodsType" name="goodsType" style="margin-top:5px;height:40px;">
								<option value="1" [#if goods.goodsType == 1]selected="selected"[/#if] >三草两木</option>
								<option value="2" [#if goods.goodsType == 2]selected="selected"[/#if] >珍慕彩妆</option>
							</select>
						</td>
					</tr>
					<tr>
						<td><!--<font color="red">*</font>-->总代价：</td>
						<td><input type="text" id="totalAgentPrice"  name="totalAgentPrice" value="${goods.totalAgentPrice}"  style="margin-top:5px;height:30px;" /></td>
					</tr>
					<tr>
						<td><font color="red">*</font>一级价：</td>
						<td><input type="text" id="firstAgentPrice"  name="firstAgentPrice" value="${goods.firstAgentPrice}"  style="margin-top:5px;height:30px;" /></td>
					</tr>
					<tr>
						<td><font color="red">*</font>二级价：</td>
						<td><input type="text" id="secondAgentPrice"  name="secondAgentPrice" value="${goods.secondAgentPrice}"  style="margin-top:5px;height:30px;" /></td>
					</tr>
					<tr>
						<td><font color="red">*</font>三级价：</td>
						<td><input type="text" id="thirdAgentPrice"  name="thirdAgentPrice" value="${goods.thirdAgentPrice}"  style="margin-top:5px;height:30px;" /></td>
					</tr>
					<tr>
						<td><font color="red">*</font>微商价：</td>
						<td><input type="text" id="derivativePrice"  name="derivativePrice" value="${goods.derivativePrice}"  style="margin-top:5px;height:30px;" /></td>
					</tr>
					<tr>
						<td><font color="red">*</font>市场价：</td>
						<td><input type="text" id="marketPrice"  name="marketPrice" value="${goods.marketPrice}"  style="margin-top:5px;height:30px;" /></td>
					</tr>
					<tr>
						<td><font color="red">*</font>库存：</td>
						<td><input type="text" id="goodsStock"  name="goodsStock" value="${goods.goodsStock}"  style="margin-top:5px;height:30px;" /></td>
					</tr>
				</table>
				<div align="center">
					<input type="button" class="btn btn-primary" id="save_goods" value="保存"/>
					&nbsp;<button class="btn btn-primary" type="button" onclick="javascript:window.location='${base}/goods/list.jhtml'">返回</button>
				</div>
				<div align="center">
					<font id="error" color="red">${error}</font>
				</div>
			</div>
		</form>
</div>