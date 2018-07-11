<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品订单查看页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/bootstrap.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-2.2.3.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/bootstrap.min.js"></script>
</head>
<body>

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

<div class="jumbotron">
    <h1>恭喜 ${user.name} 登录成功</h1>
    <p>欢迎查看您的订单详细信息:</p>
</div>
<div class="container">
        <table style="width: 700px;" class="table table-striped table-hover table-bordered">
            <thead>
             <tr>
                <th>购买者</th>
                <th>订单编号</th>
                <th>订单详单编号</th>
                <th>商品编号</th>
                <th>商品名称</th>
                <th>商品价格</th>
                <th>商品详情</th>
                <th>查看商品</th>
                <th>修改商品信息</th>
             </tr>
            </thead>
            <tbody>
                <c:forEach var="userOrderWrapper" items="${userOrderWrapperList}">
                        <c:forEach var="order" items="${userOrderWrapper.ordersList}">
                                    <c:forEach var="orderDetail" items="${order.orderDetailList}">
                                    <tr>
                                        <td>${userOrderWrapper.user.name}</td>
                                        <td>${order.id}</td>
                                        <td>${orderDetail.id}</td>
                                        <td>${orderDetail.item.id}</td>
                                        <td>${orderDetail.item.name}</td>
                                        <td>${orderDetail.item.price}</td>
                                        <td>${orderDetail.item.detail}</td>
                                        <td><a href="${pageContext.request.contextPath}/items/queryItemsById/${orderDetail.item.id}">查看商品</a></td>
                                        <td><a href="${pageContext.request.contextPath}/items/editItemsById/${orderDetail.item.id}">修改商品</a></td>
                                    </tr>
                                    </c:forEach>
                        </c:forEach>
                </c:forEach>
            </tbody>
        </table>
       </div><br/>
<a href="/logout">退出</a>
</body>
</html>
