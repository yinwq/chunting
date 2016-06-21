<script type="text/javascript">
	function checkForm(){
		var userName=document.getElementById("userName").value;
		var password=document.getElementById("password").value;
		var rPassword=document.getElementById("rPassword").value;
		var dormBuildId=document.getElementById("dormBuildId").value;
		var dormName=document.getElementById("dormName").value;
		var name=document.getElementById("name").value;
		var sex=document.getElementById("sex").value;
		var tel=document.getElementById("tel").value;
		if(userName==""||password==""||rPassword==""||name==""||sex==""||tel==""||dormBuildId==""||dormName==""){
			document.getElementById("error").innerHTML="信息填写不完整！";
			return false;
		} else if(password!=rPassword){
			document.getElementById("error").innerHTML="密码填写不一致！";
			return false;
		}
		return true;
	}
	
	$(document).ready(function(){
		$("ul li:eq(1)").addClass("active");
	});
</script>
<div class="data_list">
		<div class="data_list_title">
		<c:choose>
			<c:when test="${student.studentId!=null }">
				修改商品信息
			</c:when>
			<c:otherwise>
				添加商品
			</c:otherwise>
		</c:choose>
		</div>
		<form action="/goods/add.jhtml" method="post" onsubmit="return checkForm()">
			<div class="data_form" >
				<input type="hidden" id="studentId" name="studentId" value="${goods.id }"/>
					<table align="center">
						<tr>
							<td><font color="red">*</font>商品名：</td>
							<td><input type="text" id="goodsName"  name="goodsName" value="${goods.goodsName }"  style="margin-top:5px;height:30px;" /></td>
						</tr>
						<tr>
							<td><font color="red">*</font>商品类型：</td>
							<td>
								<select id="goodsType" name="goodsType" style="margin-top:5px;height:40px;">
									<option value="0">请选择...</option>
									<option value="1">三草两木</option>
									<option value="2">珍慕彩妆</option>
								</select>
							</td>
						</tr>
						<tr>
							<td><font color="red">*</font>总代价：</td>
							<td><input type="text" id="totalAgentPrice"  name="totalAgentPrice" value="${goods.totalAgentPrice }"  style="margin-top:5px;height:30px;" /></td>
						</tr>
						<tr>
							<td><font color="red">*</font>一级价：</td>
							<td><input type="text" id="firstAgentPrice"  name="firstAgentPrice" value="${goods.firstAgentPrice }"  style="margin-top:5px;height:30px;" /></td>
						</tr>
						<tr>
							<td><font color="red">*</font>二级价：</td>
							<td><input type="text" id="secondAgentPrice"  name="secondAgentPrice" value="${goods.secondAgentPrice }"  style="margin-top:5px;height:30px;" /></td>
						</tr>
						<tr>
							<td><font color="red">*</font>三级价：</td>
							<td><input type="text" id="thirdAgentPrice"  name="thirdAgentPrice" value="${goods.thirdAgentPrice }"  style="margin-top:5px;height:30px;" /></td>
						</tr>
						<tr>
							<td><font color="red">*</font>微商价：</td>
							<td><input type="text" id="derivativePrice"  name="derivativePrice" value="${goods.derivativePrice }"  style="margin-top:5px;height:30px;" /></td>
						</tr>
						<tr>
							<td><font color="red">*</font>市场价：</td>
							<td><input type="text" id="marketPrice"  name="marketPrice" value="${goods.marketPrice }"  style="margin-top:5px;height:30px;" /></td>
						</tr>
						<tr>
							<td><font color="red">*</font>库存：</td>
							<td><input type="text" id="goodsStock"  name="goodsStock" value="${goods.goodsStock }"  style="margin-top:5px;height:30px;" /></td>
						</tr>
					</table>
					<div align="center">
						<input type="submit" class="btn btn-primary" value="保存"/>
						&nbsp;<button class="btn btn-primary" type="button" onclick="javascript:window.location='/goods/list.jhtml'">返回</button>
					</div>
					<div align="center">
						<font id="error" color="red">${error }</font>
					</div>
			</div>
		</form>
</div>