<%@ page language="java" contentType="text/html; charset=utf8" import="hu.web.pojo.*"
    pageEncoding="utf8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="/infomanager/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="/infomanager/js/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
	
	//退出
	$("#out").click(function(){
		var flag=window.confirm("你真的要退出吗？");
		if(flag){
			window.top.location.href="/infomanager/userservlet?oper=out";
			
		}
	})
})	
</script>


</head>

<body style="background:url(images/topbg.gif) repeat-x;">

    <div class="topleft">
    <a href="main.html" target="_parent"><img src="/infomanager/images/logo.png" title="系统首页" /></a>
    </div>
        
    
            
    <div class="topright">    
    <ul>
    
    <li><a href="javascript:void(0)" id="out" >退出</a></li>
    </ul>
     
    <div class="user">
    <%-- <span><%=((User)session.getAttribute("user")).getUname() %>></span> --%>
    <span>${sessionScope.user.uname }</span>
    <span>${applicationScope.count }</span>
    
    </div>    
    
    </div>

</body>
</html>