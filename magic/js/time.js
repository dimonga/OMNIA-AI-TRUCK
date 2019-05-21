/********************************************************

    Magic Mirror project by Akshay Kore

    website: www.akor.in
    blog: https://medium.com/@akshaykore
    twitter: https://twitter.com/akshaykore
    facebook: https://www.facebook.com/akshaykore
    email: akshaykore[at]gmail.com
    
    Gets the system Date and time.

*********************************************************/


var changetime = function(){
    
    var date = new Date();

    /////////date
    //day
    var daytoday = date.getDay();

    switch (daytoday) {
        case 0:
            day = "Sun";
            break;
        case 1:
            day = "Mon";
            break;
        case 2:
            day = "Tue";
            break;
        case 3:
            day = "Wed";
            break;
        case 4:
            day = "Thu";
            break;
        case 5:
            day = "Fri";
            break;
        case 6:
            day = "Sat";
                        }

    //date
    var datetoday = date.getDate();

    //month
    var monthtoday = date.getMonth();

    switch (monthtoday){
        case 0:
            month = "Jan";
            break;
        case 1:
            month = "Feb";
            break;
        case 2:
            month = "Mar";
            break;
        case 3:
            month = "Apr";
            break;
        case 4:
            month = "May";
            break;
        case 5:
            month = "Jun";
            break;
        case 6:
            month = "Jul";
            break;
        case 7:
            month = "Aug";
            break;
        case 8:
            month = "Sep";
            break;
        case 9:
            month = "Oct";
            break;
        case 10:
            month = "Nov";
            break;
        case 11:
            month = "Dec";    
                            }

    //time
    var hourtoday = date.getHours();
    var ampm = "AM"

    if (hourtoday > 12){
        ampm = "PM";
        var newhour = hourtoday - 12;
        hourtoday = newhour;
                        }

    var minutestoday = date.getMinutes();
    
    var time_element = document.getElementById("time");
        if (minutestoday < 10){
            time_element.innerHTML = hourtoday + " : 0" + minutestoday + " " + ampm;
                            }
        else{
            time_element.innerHTML = hourtoday + " : " + minutestoday + " " + ampm;
            }
    
    var date_element = document.getElementById("date");
        date_element.innerHTML = day + ", " + datetoday + " " + month; 
    
}

//change time once
changetime();

//change the time every 15 seconds
setInterval(changetime, 15000);

