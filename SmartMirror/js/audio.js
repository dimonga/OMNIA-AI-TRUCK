/********************************************************

    Magic Mirror project by Akshay Kore

    website: www.akor.in
    blog: https://medium.com/@akshaykore
    twitter: https://twitter.com/akshaykore
    facebook: https://www.facebook.com/akshaykore
    email: akshaykore[at]gmail.com
    
    This file plays the sound after the mirror asnwers 
    a question. 

*********************************************************/

//select div element to pick sound. The sound is embedded in the HTML file.
var magic_sound = document.getElementById("magic");

//function to play the sound
var play_magic_sound = function(){
    magic_sound.play();
}

/********************************************************

KEEP THIS COMMENTED. USE FOR TESTING.

//play_magic_sound();

*********************************************************/

 