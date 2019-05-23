/********************************************************

    Magic Mirror project by Akshay Kore

    website: www.akor.in
    blog: https://medium.com/@akshaykore
    twitter: https://twitter.com/akshaykore
    facebook: https://www.facebook.com/akshaykore
    email: akshaykore[at]gmail.com
    
    Says "hey sexy!"
    Edit this file to change the greeting text.

*********************************************************/


var say_greeting = function(){
    clearall();
    var greeting_element = document.getElementById("greeting");
    
    /********************************************************
        Change this to change greeting.
    *********************************************************/
    greeting_element.innerHTML = "hey sexy!"; 
    
    //Greeting fades out after 7 seconds. Change this to change the fadeout time
    setTimeout(clearall, 7000);
}


/********************************************************

KEEP THIS COMMENTED. USE FOR TESTING.

//say_greeting();

*********************************************************/

