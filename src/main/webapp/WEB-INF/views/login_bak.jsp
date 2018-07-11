<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/bootstrap.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-2.2.3.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/bootstrap.min.js"></script>
</head>
<body>

<div class="has-error center-block">
<c:if test="${! empty error}">
    <font color="red">${error}</font>
</c:if>
</div>

<!--导航-->
<nav class="navbar navbar-default">
    <div class="container">
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">首页</a></li>
            <li><a href="#">关于</a></li>
            <li><a href="${pageContext.request.contextPath}/login">登录</a></li>
        </ul>
    </div>
</nav>


<div class="container">
<form id="loginForm" action="/loginCheck" method="post">
    <table  style="width: 500px;" class="table table-striped table-hover table-bordered">
        <tr><td>用户名:</td>
            <td><input type="text" name="name"/></td>
        </tr>

        <tr><td>密  码:</td>
            <td><input type="password" name="password"/></td>
        </tr>

        <tr><td colspan="2" align="center"> <input type="submit" value="登录"/>&nbsp&nbsp<input type="reset" value="重置"/>&nbsp&nbsp还没有账号?<a href="/register">注册</a></td>
        </tr>
    </table>
</form>
</div>
</body>
</html>
