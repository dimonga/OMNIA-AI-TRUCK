/********************************************************

    Magic Mirror project by Akshay Kore

    website: www.akor.in
    blog: https://medium.com/@akshaykore
    twitter: https://twitter.com/akshaykore
    facebook: https://www.facebook.com/akshaykore
    email: akshaykore[at]gmail.com
    
    Wikipedia search

*********************************************************/

function getwiki(input){
        clearall();
    
        play_magic_sound(); //plays sound when script runs successfully
    
        var wikiapicall = "https://en.wikipedia.org/w/api.php?action=opensearch&search="+ input +"&format=json&callback=?";
        
        $.getJSON(wikiapicall, wikicallback);
        
        function wikicallback(wikidata){
            
            console.log(wikidata);
            
            //add wiki answer to HTML
            var wiki_title = document.getElementById("wikititle");
                wiki_title.innerHTML = wikidata[1][0];
            var wiki_answer = document.getElementById("wikianswer");
                wiki_answer.innerHTML = wikidata[2][0];
            var wiki_source = document.getElementById("wikisource");
                wiki_source.innerHTML = wikidata[3][0];
        }
        
        //clears the answer from the html file after an interval of 60 seconnds
        setTimeout(clearall, 60000);
}
    
