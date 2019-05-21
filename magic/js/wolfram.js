/********************************************************

    Magic Mirror project by Akshay Kore

    website: www.akor.in
    blog: https://medium.com/@akshaykore
    twitter: https://twitter.com/akshaykore
    facebook: https://www.facebook.com/akshaykore
    email: akshaykore[at]gmail.com
    
    Wolfram short answers.
    Get API Key from here: https://products.wolframalpha.com/short-answers-api/documentation/

*********************************************************/

function getwolfram(input){
        
        var appid_wolfram = ""; //add your app ID here
            
        clearall();
        play_magic_sound();
        
        var wolframapicall = "http://api.wolframalpha.com/v1/spoken?appid=" + appid_wolfram + "&i=" + input + "&units=metric";
        
        $.get(wolframapicall, wolframcallback);
        
        function wolframcallback(wolframans){
            console.log("success");
            
            var mirror_question = document.getElementById("mirrorquestion");
                mirror_question.innerHTML = input;
            var mirror_answer = document.getElementById("mirroranswer");
                mirror_answer.innerHTML = wolframans;
        }
    
        //clears the answer from the html file after an interval of 60 seconnds
        setTimeout(clearall, 60000);
}


    