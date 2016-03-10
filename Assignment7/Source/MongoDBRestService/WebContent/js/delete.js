var app = angular.module("myApp2", [])

app.controller("DeleteController", function ($scope, $http, $httpParamSerializerJQLike) {

    $scope.pageClass = 'deleteFunc';
$scope.deleteFunc = function(userName) {
	console.log("inside login function");
$http({
    method: 'DELETE',
    url : 'http://localhost:8040/MongoDBRestService/controlService/deleteUser?userName='+userName,
    
    contentType: "application/json"
}).success(function() {
    $scope.userName ="";
    
    $scope.msg ="Account has been deleted successfully";
        })
}
    
}); 
				   