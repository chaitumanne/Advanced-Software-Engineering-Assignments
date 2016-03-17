var app = angular.module('weather',[])

app.controller('ctrl',function($scope,$http){

    document.getElementById('cityName').onclick = function(){
            $scope.checkWeather = function () {
                var cityName = document.getElementById('cityName').value;
                //var destination = document.getElementById('destination-input').value;
                document.getElementById("weatherStatus").style.display = "block";
                $http.get('http://api.openweathermap.org/data/2.5/weather?q='+cityName+'&units=imperial&appid=aecc1ada15291787e9f4ec95ab382165').success(function(data) {
                    $scope.sourceCity=data.name;
                    $scope.sourceDesc = data.weather[0].main;
                    $scope.sourceTempid= data.main.temp;
                    $scope.sourceWindSpeed = data.wind.speed;
                    $scope.sourceIcon=data.weather[0].icon;
                })
                
            }
    }
});