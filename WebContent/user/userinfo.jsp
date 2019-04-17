<%@ page language="java" contentType="text/html; charset=utf8" import="hu.web.pojo.*"
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
<script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>


</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">个人信息</a></li>
    <li><a href="#">查看个人信息</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th>编号</th>
        <th>姓名</th>
        <th>密码</th>
        <th>性别</th>
        <th>年龄</th>
        <th>出生日期</th>
        
        </tr>
        </thead>
        <%
        	HttpSession hs=request.getSession();
        	User user = (User)hs.getAttribute("user");
        	if(user==null){
        		hs.setAttribute("flag", 3);
        		response.sendRedirect("/infomanager/login.jsp");
        	}
        	int id=user.getUid();
        	String name=user.getUname();
        	String pwd=user.getPwd();
        	String sex=user.getSex();
        	if(sex.equals("1")){
        		sex="男";
        	}else{
        		sex="女";
        	}
        	
        	int age=user.getAge();
        	String birth=user.getBirth();
        		
        	
        	
        %>
        <tbody>
        <tr>
       		<td><%=id %></td>
       		<td><%=name %></td>
       		<td><%=pwd %></td>
       		
       		<td><%=sex %></td>
       		
       		<td><%=age %></td>
       		<td><%=birth %></td>
       		
        
        </tr> 

        </tbody>
    </table>
    
   
    
    
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
    
    
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>