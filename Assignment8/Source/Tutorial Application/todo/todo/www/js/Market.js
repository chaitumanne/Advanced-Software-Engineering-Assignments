var app = angular.module('supermarket',[])
app.controller('marketctrl',function($scope,$http){
    document.getElementById('productName').onclick = function(){
            $scope.findMarket = function () {
                var productName = document.getElementById('productName').value;
                console.log(productName);
                var xmlhttp = new XMLHttpRequest();
                xmlhttp.open("GET", "http://www.supermarketapi.com/api.asmx/SearchByProductName?APIKEY=236a7ba5f9&ItemName="+productName , true);
                xmlhttp.onreadystatechange = function() {
    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
      myFunction(xmlhttp);
    }
  };
  
  xmlhttp.send(null);
                
           function myFunction(xml) {
  var x, i, xmlDoc, table;
  xmlDoc = xml.responseXML;
  table = "<tr><th>Artist</th><th>Title</th></tr>";
  x = xmlDoc.getElementsByTagName("productName")
  for (i = 0; i < x.length; i++) { 
    table += "<tr><td>" + 
    x[i].getElementsByTagName("Itemname")[0].childNodes[0].nodeValue +
    "</td><td>" +
    x[i].getElementsByTagName("ItemID")[0].childNodes[0].nodeValue +
    "</td></tr>";
  }
  document.getElementById("productName").innerHTML = table;
}     
            
            }
    }
});