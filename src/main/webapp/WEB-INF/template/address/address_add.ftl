<script type="text/javascript" src="/js/vendor/jquery-validation/dist/jquery.validate.js" ></script>
<script type="text/javascript" src="/js/template/address/add_address.js"></script>
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
			[#if address.id?has_content]
				修改地址
			[#else]
				添加地址
			[/#if]
		</div>
		<form action="/goods/add.jhtml" id="base_info_form" method="post" onsubmit="return checkForm()">
			<div class="data_form" >
				<input type="hidden" id="id" name="id" value="${address.id}"/>
				<table align="center">
					<tr>
						<td><font color="red">*</font>收货人：</td>
						<td><input type="text" id="receiptPerson"  name="goodsName" value="${address.receiptPerson}"  style="margin-top:5px;height:30px;" /></td>
					</tr>
					<tr>
						<td><font color="red">*</font>地址类型：</td>
						<td>
							<select id="addressType" name="addressType" style="margin-top:5px;height:40px;">
								<option value="1" [#if address.addressType == 1]selected="selected"[/#if] >代理</option>
								<option value="2" [#if address.addressType == 2]selected="selected"[/#if] >客户</option>
							</select>
						</td>
					</tr>
					<tr>
						<td><font color="red">*</font>省市县/区：</td>
						<td>
							<select id="province" name="province" style="margin: 5px 15px 5px 0;height:40px;width:150px;">
								<option value="0">请选择</option>
							</select>
							<select id="city" name="city" style="margin: 5px 15px 5px 0;height:40px;width:150px;">
								<option value="0">请选择</option>
							</select>
							<select id="county" name="county" style="margin: 5px 15px 5px 0;height:40px;width:150px;">
								<option value="0">请选择</option>
							</select>
						</td>
					</tr>
					<tr>
						<td><font color="red">*</font>详细地址：</td>
						<td><input type="text" id="addressDetail"  name="addressDetail" value="${address.addressDetail}"  style="margin-top:5px;height:30px;" /></td>
					</tr>
					<tr>
						<td><font color="red">*</font>电话：</td>
						<td><input type="text" id="secondAgentPrice"  name="secondAgentPrice" value="${goods.secondAgentPrice}"  style="margin-top:5px;height:30px;" /></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<div>
								<input type="button" class="btn btn-primary" id="save_address" value="保存"/>
								&nbsp;<button class="btn btn-primary" type="button" onclick="javascript:window.location='/address/list.jhtml'">返回</button>
							</div>
						</td>
					</tr>
				</table>
				
				<div align="center">
					<font id="error" color="red">${error}</font>
				</div>
			</div>
		</form>
</div>