<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% String url = request.getScheme()+"://"+ request.getServerName()+request.getRequestURI()+"?"+request.getQueryString(); %>
<html>
<body>
	<script type="text/javascript">
		window.location.href = '${request.contextPath}/chunting/login/toLogin.jhtml';
	</script>
</body>
</html>
