var app = angular.module('supermarket',[])
app.controller('marketctrl',function($scope,$http){
    document.getElementById('productName').onclick = function(){
            $scope.findMarket = function () {
                var productName = document.getElementById('productName').value;
                console.log(productName);
                $http.get('http://api.openweathermap.org/data/2.5/weather?q='+productName+'&units=imperial&appid=aecc1ada15291787e9f4ec95ab382165').success(function(data) {
                    console.log(data);
                    //$scope.sourceCity=data.Itemname;
                    //$scope.sourceDesc = data.ItemCategory;
                })
            }
    }
});