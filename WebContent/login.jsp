<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>  
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎登录后台管理系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script src="js/cloud.js" type="text/javascript"></script>

<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});  
</script> 

</head>

<body style="background-color:#df7611; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


<div class="logintop">    
    <span>欢迎登录后台管理界面平台</span>    
    
    </div>
    
    <div class="loginbody">
    
    <span class="systemlogo"></span> 
    <c:choose>
    	
    	<c:when test="${flag==1}">
    		<div style="text-align: center;">
    			<span style="font-size: 15px;color:red;">修改密码成功</span>
    		</div>
    	</c:when>
    	<c:when test="${flag==2}">
    		<div style="text-align: center;">
    			<span style="font-size: 15px;color:red;">注册成功</span>
    		</div>
    	</c:when>
    	<c:when test="${flag==3}">
    		<div style="text-align: center;">
    			<span style="font-size: 15px;color:red;">登录失效，请重新登录</span>
    		</div>
    	</c:when>
    	<c:otherwise>
    	</c:otherwise>
    </c:choose>
    <%
    	session.removeAttribute("flag");
    %>
    
    <%
    	//登录失败显示
    	Object obj = request.getAttribute("flag2");
    	if("success".equals(obj)){
    %>
    
    	<div style="text-align: center;">
    		<span style="font-size: 15px;color:red;">用户名或密码错误</span>
    	</div>
    
    <%} %>
    
<%--     <%
    	//修改密码显示
    	Object pwd = session.getAttribute("pwd");
    	if("newPwd".equals(pwd)){
    %>
    
    	<div style="text-align: center;">
    		<span style="font-size: 15px;color:red;">修改密码成功</span>
    	</div>
    
    <%} 
    	session.removeAttribute("pwd");
    %>
    
    <%
    	//注册成功显示
    	Object reg = session.getAttribute("reg");
    	if("reg".equals(reg)){
    %>
    
    	<div style="text-align: center;">
    		<span style="font-size: 15px;color:red;">注册成功</span>
    	</div>
    
    <%} 
    	session.removeAttribute("reg");
    %>
    
    
     <%
    	//查询个人信息时Session失效时显示
    	Object query = session.getAttribute("query");
    	if("query".equals(query)){
    %>
    
    	<div style="text-align: center;">
    		<span style="font-size: 15px;color:red;">登录失效，请重新登录</span>
    	</div>
    
    <%} 
    	session.removeAttribute("query");
    %>
     --%>
    <div class="loginbox loginbox1">
    <form action="userservlet" method="post">
    	<input name="oper" type="hidden" value="login" />
    	<ul>
    		<li><input name="uname" type="text" class="loginuser" placeholder="用户名"  /></li>
    		<li><input name="pwd" type="password" class="loginpwd" placeholder="密码" /></li>
    	<!-- 	<li class="yzm">
    			<span><input name="" type="text" value="验证码" onclick="JavaScript:this.value=''"/></span><cite>X3D5S</cite> 
    		</li> -->
    		<li><input  type="submit" class="loginbtn" value="登录"  /><label><a href="user/reg.jsp">注册</a></label><label><a href="#">忘记密码？</a></label></li>
    	</ul>
    
    </form>
    
    
    </div>
    
    </div>
    
    
    <div class="loginbm">哥们学习用的，勿用于任何商业用途</div>
	
    
</body>
</html>