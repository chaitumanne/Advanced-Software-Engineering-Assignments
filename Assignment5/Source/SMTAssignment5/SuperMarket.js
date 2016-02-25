/**
 * Created by VARSHA-PC on 2/24/2016.
 */
var app = angular.module('supermarket',[])
console.log("1");
app.controller('ctrl',function($scope,$http){
    console.log("2");
    document.getElementById('productName').onclick = function(){
            $scope.findMarket = function () {
                var productName = document.getElementById('productName').value;
                console.log(productName);
                $http.get('http://www.supermarketapi.com/api.asmx/SearchByProductName?APIKEY=236a7ba5f9&ItemName='+productName).success(function(data) {
                    console.log(data);
                    //$scope.sourceCity=data.Itemname;
                    //$scope.sourceDesc = data.ItemCategory;
                })
            }
    }
});