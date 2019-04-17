<%@ page language="java" contentType="text/html; charset=utf8" import="hu.web.pojo.*,java.util.List,java.util.ArrayList"
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
        
        <tbody>
        
        <c:forEach items="${userList }" var="u">
        	<tr>
       			<td>${u.uid }</td>
       			<td>${u.uname } </td>
       			<td>${u.pwd }</td>
       			
       			<td>${u.sex=='1'?'男':'女' }</td>
       			
       			<td>${u.sex }</td>
       			<td> ${u.birth }</td>
       		
        
        	</tr> 
        </c:forEach>
       <%--  <%
        	List<User> list = (ArrayList<User>)request.getAttribute("userList");
        	for(User u:list){
        %>
        
        <tr>
       		<td><%=u.getUid() %></td>
       		<td><%=u.getUname() %></td>
       		<td><%=u.getPwd() %></td>
       		<%
       			if("1".equals(u.getSex())){
       		%>
       		<td>男</td>
       		<%}else{ %>
       		<td>女</td>
       		<%} %>
       		<td><%=u.getAge() %></td>
       		<td><%=u.getBirth() %></td>
       		
        
        </tr> 
        <%} %> --%>

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