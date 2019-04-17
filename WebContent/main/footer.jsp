<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />

</head>

<body>
	<div class="footer">
    <span>仅供学习交流，请勿用于任何商业用途</span>
    <i>版权所有 2014 uimaker.com</i>    
    </div>    
</body>
</html>