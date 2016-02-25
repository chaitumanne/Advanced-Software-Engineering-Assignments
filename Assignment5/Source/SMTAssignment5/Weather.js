/**
 * Created by VARSHA-PC on 2/17/2016.
 */
var app = angular.module('weatherapp',[])

app.controller('ctrl',function($scope,$http){

    document.getElementById('destination-input').onkeydown = function(e){
        if(e.keyCode === 13){
            $scope.checkWeather = function (e) {
                var source = document.getElementById('origin-input').value;
                var destination = document.getElementById('destination-input').value;
                document.getElementById("weatherStatus").style.display = "block";
                $http.get('http://api.openweathermap.org/data/2.5/weather?q='+source+'&units=imperial&appid=aecc1ada15291787e9f4ec95ab382165').success(function(data) {
                    $scope.sourceCity=data.name;
                    $scope.sourceDesc = data.weather[0].main;
                    $scope.sourceTempid= data.main.temp;
                    $scope.sourceWindSpeed = data.wind.speed;
                    $scope.sourceIcon=data.weather[0].icon;
                })
                $http.get('http://api.openweathermap.org/data/2.5/weather?q='+destination+'&units=imperial&appid=aecc1ada15291787e9f4ec95ab382165').success(function(data) {
                    $scope.DestinationCity=data.name;
                    $scope.DestinationDesc = data.weather[0].main;
                    $scope.DestinationTempid= data.main.temp;
                    $scope.DestinationWindSpeed = data.wind.speed;
                    $scope.DestinationIcon=data.weather[0].icon;
                })
            }
        }
    }
});