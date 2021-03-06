<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>蠢婷出货管理系统登录</title>
<link href="${base}/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="${base}/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<script src="${base}/bootstrap/js/jQuery.js"></script>
<script src="${base}/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript">
	function checkForm() {
		var username = document.getElementById("username").value;
		var password = document.getElementById("password").value;
		if (username == null || username == "") {
			document.getElementById("error").innerHTML = "用户名不能为空";
			return false;
		}
		if (password == null || password == "") {
			document.getElementById("error").innerHTML = "密码不能为空";
			return false;
		}
		return true;
	}
</script>

<style type="text/css">
	  body {
        padding-top: 250px;
        padding-bottom: 40px;
        background-image: url('${base}/images/bg.jpg');
        background-position: center;
		background-repeat: no-repeat;
		background-attachment: fixed;
      }
      
      .radio {
      	padding-top: 10px;
       	padding-bottom:10px;
      }
      
      .form-signin-heading{
      	text-align: center;
      }

      .form-signin {
        max-width: 300px;
        padding: 19px 29px 0px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-signin .form-signin-heading,
      .form-signin .checkbox {
        margin-bottom: 10px;
      }
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }
</style>

</head>
<body>
<div class="container">
      <form name="myForm" class="form-signin" action="${base}/login/loginAdmin.jhtml" method="post" onsubmit="return checkForm()">
        <h2 class="form-signin-heading"><font color="gray">蠢婷出货管理系统</font></h2>
        <input id="username" name="username" value="${admin.username }" type="text" class="input-block-level" placeholder="用户名...">
        <input id="password" name="password" value="${admin.password }" type="password" class="input-block-level" placeholder="密码..." >
        <!--<label class="checkbox">
          <input id="remember" name="remember" type="checkbox" value="remember-me">记住我 &nbsp;&nbsp;&nbsp;&nbsp; <font id="error" color="red">${error }</font>  
        </label>-->
        <div class="">
	        <button class="btn btn-large btn-primary" type="submit">登录</button>
	        &nbsp;&nbsp;&nbsp;&nbsp;
	        <button class="btn btn-large btn-primary" type="button" >重置</button>
	    </div>

		<p align="center" style="padding-top: 15px;">版权所有  2016  Yinwq  <a href="http://www.chungting.com" target="_blank">www.chungting.com</a></p>
      </form>
</div>
</body>
</html>