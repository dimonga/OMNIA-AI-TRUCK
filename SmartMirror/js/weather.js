/********************************************************

    Magic Mirror project by Akshay Kore

    website: www.akor.in
    blog: https://medium.com/@akshaykore
    twitter: https://twitter.com/akshaykore
    facebook: https://www.facebook.com/akshaykore
    email: akshaykore[at]gmail.com
    
    Get weather information
    Get API Key from here: https://openweathermap.org/current

*********************************************************/

function getweather() {
    
    var city = "Tallinn"; //add your current city name here
    
    var appid_weather = "" ; //add your app ID here 
  
    //HTTP request for weather data
    var apiCall = 'http://api.openweathermap.org/data/2.5/weather?q=' + city + '&appid=' + appid_weather;

    $.getJSON(apiCall, weatherCallback);

    function weatherCallback(weatherdata){
        var temperature = Math.round(weatherdata.main.temp - 273.15); //CONVERT KELVIN TO DEG CELSIUS
        
        console.log(weatherdata.main);
        
        var weather_element = document.getElementById("weather");
            weather_element.innerHTML = temperature + " °C";
                                        }
}
    
getweather();
//call weather data every minute
setInterval(getweather, 60000);