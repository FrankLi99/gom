<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>json test</title>
    <script src="${pageContext.request.contextPath}/statics/js/jquery-2.2.3.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        function jsonRequest(){
            var allData = {name:$("#name").val(),password:$("#password").val()}
            $.ajax({
                type:'post',
                url:'${pageContext.request.contextPath}/jsonrequest',
                contentType:'application/json;charset=utf-8',
                data:JSON.stringify(allData),
                success:function(data){
                    alert(data.name+'--'+data.password);
                }
            })
        }

        function keyValueRequest(){
            $.ajax({
                type:'post',
                url:'${pageContext.request.contextPath}/keyvaluerequest',
                data:'name=liyu&password=root123',
                success:function(data){
                    alert(data.name+"-----"+data.password);
                }
            })
        }
    </script>
</head>
<body ng-app="">

<input id="name" type="text" ng-model="userName" placeholder="用户名"/>
<input id="password" type="password" placeholder="密码"/>
  <input type="button" value="jsonrequest" onclick="jsonRequest()"/>
<input type="button" value="keyvaluerequest" onclick="keyValueRequest()" />

<div>您输入的用户名为：<span>{{userName}}</span></div>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/angular.js"></script>
</body>
</html>
