<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<html>
<head>
    <title>editItem</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/bootstrap.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-2.2.3.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/myjs.js"></script>
    <!--引入 myjs.js 处理 多部件图片名字改变时同步刷新 img 标签里的 src -->
</head>
<body>
<a href="/items/queryItems">返回</a>&nbsp&nbsp&nbsp<a href="/logout">退出</a>
<div class="container">
<form method="post" action="/items/editItem/${item.id}" enctype="multipart/form-data">
  <table  style="width: 500px;" class="table table-striped table-hover table-bordered">
      <tr><td>商品名称</td> <td><input type="search" name="name" value="${item.name}"/></td></tr>
      <tr><td>商品价格</td><td><input type="number" name="price" min="0" max="999999" value="${item.price}"/></td></tr>
      <tr><td>商品图片</td>
          <td><c:if test="${! empty item.pic}">
              <input type="hidden" name="pic" value="${item.pic}"/>
              <img src="/pic/${item.pic}" id="show" height="100" width="100"/>
          </c:if>
              <input id="file0" type="file" name="itemPic"/>
          </td>
      </tr>
      <tr><td>商品生产日期</td>
          <td><input name="createtime" style="align-content: center" type="datetime-local" value="
              <fmt:formatDate value="${item.createtime}" pattern="yyy-MM-dd HH:mm:ss"/>"/>
          </td></tr>
      <tr><td>商品描述</td><td><input type="<textarea name=" cols="30" rows="10" name="detail" value="${item.detail}"/></td></tr>
      <tr><td colspan="2" align="center"><input type="submit" value="修改"> </td></tr>
  </table>
</form>
</div>
</body>
</html>
