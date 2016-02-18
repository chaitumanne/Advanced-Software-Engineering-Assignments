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


   /* $scope.getWeatherStart = function() {
        var start = document.getElementById('origin-input').value;
        $http.get('http://api.openweathermap.org/data/2.5/weather?q='+start+'&appid=aecc1ada15291787e9f4ec95ab382165&units=metric').success(function(data) {
            console.log(data);
            $scope.city=data.name;
            $scope.desc = data.weather[0].main;
            $scope.tempid= data.main.temp;
            $scope.windspeed = data.wind.speed;
            $scope.icon=data.weather[0].icon;
        })
    };
    $scope.getWeatherEnd = function() {
        var end = document.getElementById('destination-input').value;
        $http.get('http://api.openweathermap.org/data/2.5/weather?q='+end+'&appid=aecc1ada15291787e9f4ec95ab382165&units=metric').success(function(data) {
            console.log(data);
            $scope.cityEnd=data.name;
            $scope.descEnd = data.weather[0].main;
            $scope.tempidEnd= data.main.temp;
            $scope.windspeedEnd = data.wind.speed;
            $scope.iconEnd=data.weather[0].icon;
        })
    };*/
});

function visibilityMode(){
    document.getElementById("weatherStatus").style.visibility = "visible";
}