<%@ page import="cn.ziming.my.shop.entity.User" %>
<%--
  Created by IntelliJ IDEA. To change this template use File | Settings | File Templates.
  User: martin | Date: 2019/4/17 | Time: 22:33
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成功</title>
</head>
<body>
<%--<%--%>
    <%--// 获取session--%>
    <%--User user = (User) session.getAttribute("user");--%>
    <%--String timeStamp = session.getAttribute("timeStamp").toString();--%>
<%--%>--%>
登陆成功 <br>
${timeStamp}
${sessionScope.user.uid}
${sessionScope.user.uname}
${sessionScope.user.email}
<%--登陆成功 登录时间:<%=timeStamp %> <br>--%>
<%--您的用户名为:<%=user.getUname() %> <br>--%>
<%--您的登陆ID为:<%=user.getEmail() %> <br>--%>
<%--您的登陆密码为:<%=user.getPwd() %>--%>
</body>
</html>
