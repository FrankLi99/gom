<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>注册页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/bootstrap.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-2.2.3.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/bootstrap.min.js"></script>
</head>
    <body>
    <c:if test="${!empty errorMsg}">
        <font color="red">${errorMsg}</font>
    </c:if>
    <c:if test="${!empty alreadyExists}">
        <font color="red">${alreadyExists}</font>
    </c:if>
        <div class="container">

            <form method="post" action="/registerUser">
                <table style="width: 500px;" class="table table-striped table-hover table-bordered">
                <tr><td>注册用户名:</td>
                    <td><input type="text" name="name" autofocus/></td>
                </tr>
                <tr><td>注册密码:</td>
                    <td><input type="password" name="password"/></td>
                </tr>
                <tr><td>邮箱地址:</td>
                    <td><input type="email" name="email"/></td>
                </tr>
                <tr><td colspan="2" align="center"><input type="submit" value="注册"/>&nbsp&nbsp已有账号？<a href="/login">登录</a></td></tr>
                </table>
            </form>
        </div>
    </body>
</html>
