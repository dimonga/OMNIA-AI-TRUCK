/********************************************************

    Magic Mirror project by Akshay Kore

    website: www.akor.in
    blog: https://medium.com/@akshaykore
    twitter: https://twitter.com/akshaykore
    facebook: https://www.facebook.com/akshaykore
    email: akshaykore[at]gmail.com
    
    Clears the answers div periodically. 
    Relaod the page.

*********************************************************/

//clear all answers divs
var clearall = function(){
    document.getElementById("greeting").innerHTML = "";
    document.getElementById("wikititle").innerHTML = "";
    document.getElementById("wikianswer").innerHTML = "";
    document.getElementById("wikisource").innerHTML = "";
    document.getElementById("wikititle").innerHTML = "";
    document.getElementById("mirrorquestion").innerHTML = "";
    document.getElementById("mirroranswer").innerHTML = "";
}


//This function reloads the page
var reloadfunction = function(){location.reload();}

//interval set to 15 minutes. Clears everything in the interval.
setInterval(reloadfunction, 150000);