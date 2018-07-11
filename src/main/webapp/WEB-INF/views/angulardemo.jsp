<html>
<head>
    <title>angular 演示</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <style>
        span{
            display:block;
        }
    </style>
</head>
<body ng-app="myApp">
  <div ng-controller="MyController">
   <input type="text" ng-model="firstName"/>
      <span>firstName: {{firstName}}</span>
   <input type="text" ng-model="lastName"/>
      <span>lastName:{{lastName}}</span>
      <span>{{getName()}}</span>
  </div>

<script type="text/javascript" src="/statics/js/angular.js"></script>
<script type="text/javascript" src="/statics/js/angularcontroller.js"></script>
</body>
</html>
