<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<html>
<head>
    <title>itemDetails</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/bootstrap.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-2.2.3.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/bootstrap.min.js"></script>

</head>
<body>
<a href="/items/queryItems">返回</a>&nbsp&nbsp&nbsp<a href="/logout">退出</a>
<div class="container">
<table  style="width: 500px;" class="table table-striped table-hover table-bordered">
    <tr><td>商品名称</td> <td>${item.name}</td></tr>
    <tr><td>商品价格</td><td>${item.price}</td></tr>
    <tr><td>商品图片</td>
        <td><c:if test="${! empty item.pic}">
               <img src="/pic/${item.pic}" height="100" width="100"/>
            </c:if>
        </td>
    </tr>
    <tr><td>商品生产日期</td>
        <td style="align-content: center"><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
    </tr>
    <tr><td>商品描述</td><td>${item.detail}</td></tr>
</table>
</div>
</body>
</html>
