var myApp = angular.module("myApp", []);

(function(app){
    "use strict";
    app.controller("MyController", function($scope, $http){
        $scope.firstName='kobe';
        $scope.lastName='bryant';
        $scope.getName=function(){
            return this.firstName+'-'+this.lastName;
        }
    });
})(myApp);