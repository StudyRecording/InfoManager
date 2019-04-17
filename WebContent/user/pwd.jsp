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
<script language="JavaScript" src="js/jquery.js"></script>
</head>
<style>
	#btn{
		width:137px;
		height:35px; 
		background-color:orange;
		font-size:16px;
		font-weight:bold;
		color:dark;
		cursor:pointer;
		} 
</style>
<script type="text/javascript">
	$(function(){
		$("#fm").submit(function(){
			if($("#newPwd").val()==""){
				alert("新密码不能为空");
				return false;
			}else if($("#cfPwd").val()==""){
				alert("确认密码不能为空");
				return false;
			}else if($("#newPwd").val()!=$("#cfPwd").val()){
				alert("两次密码不一致");
				return false;
			}else{}
			return true;
		})
	})
</script>
<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">个人信息</a></li>
    <li><a href="#">修改密码</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>修改密码</span></div>
    <form action="userservlet" method="post" id="fm" target="_top">
    
    	<input type="hidden" name="oper" value="pwd">
    	<ul class="forminfo">
    	<li><label>新密码</label><input name="newPwd" id="newPwd" type="text" class="dfinput" /><i></i></li>
    	<li><label>确认密码</label><input name="" id="cfPwd" type="text" class="dfinput" /><i></i></li>
    	<li><label>&nbsp;</label><input type="submit" id="btn" value="确定"></li>
    </ul>
    
    </form>
    </div>


</body>

</html>