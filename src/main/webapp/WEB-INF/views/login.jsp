<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Login Page</title>
    <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
    <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
    <META HTTP-EQUIV="Expires" CONTENT="0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/bootstrap.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-2.2.3.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/bootstrap.min.js"></script>
 <%--   <script type="text/javascript"  src="${pageContext.request.contextPath}/statics/js/myjs.js"></script>--%>
    <script type="text/javascript">
        //使用 jquery + ajax 提交表单
        $(function(){

            $("#login").click(function (){
                var allData = {'name':$("#userName").val() , 'password':$("#password").val()}
                $.ajax({
                    type:"post",
                    url:"${pageContext.request.contextPath}/loginCheck",
                    contentType:"application/json;charset=utf-8",
                    dataType:"json",
                    data:JSON.stringify(allData),
                    error: function(XMLHttpRequest, textStatus, errorThrown) {
                        alert(XMLHttpRequest.status);
                        alert(XMLHttpRequest.readyState);
                        alert(textStatus);
                        alert(errorThrown)
                    },
                    success:function(data){
                        var response=data['result'];
                        if(response==="false"){
                            alert(data["error"]);
                            window.location.href="/login";
                        }
                        else { alert("恭喜登陆成功！");
                            window.location.href="/items/queryItems";}
                    }
                })
            });

            $("#login").onkeyup= $("#login").click;
        })

    </script>
</head>
<body>
<c:if test="${! empty error}">
    <font color="red">${error}</font>
</c:if>

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
    <table  style="width: 500px;" class="table table-striped table-hover table-bordered">
        <tr><td>用户名:</td>
            <td><input type="text" name="userName" id="userName" autofocus autocomplete="on" placeholder="用户名"/></td>
        </tr>

        <tr><td>密  码:</td>
            <td><input type="password" id="password" placeholder="密码"/></td>
        </tr>

        <tr><td colspan="2" align="center">
            <button id="login" class="btn btn-success btn-sm">登录</button>
            <button id="reset"  class="btn btn-sm">重置</button>
            &nbsp;&nbsp;还没有账号?<a href="/register">注册</a>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
