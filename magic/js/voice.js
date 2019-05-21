/********************************************************

    Magic Mirror project by Akshay Kore

    website: www.akor.in
    blog: https://medium.com/@akshaykore
    twitter: https://twitter.com/akshaykore
    facebook: https://www.facebook.com/akshaykore
    email: akshaykore[at]gmail.com
    
    Edit this file to set custom voice commands

*********************************************************/

if (annyang) {
    
  // Set custom voice commands 
  
    var commands = {
		'yes': say_greeting,
		'no': say_greeting,
        // 'hey yo': say_greeting, //says the greeting 
    
        // 'wiki *tag': getwiki, //gets wiki answer
      
        // 'dodo *tag': getwolfram, //gets wolfram short answer
      
        // 'reload': reloadfunction, //reloads page
      
        // 'clear': clearall, //clears all answers
      
    /********************************************************
    
        You can add any custom command or delete existing
        commands over here. Although I'd suggest not deleting 
        any exisiting commands.
        
        Find documentation here: https://www.talater.com/annyang/
        
    *********************************************************/  
    
                    };

    // Add our commands to annyang
    annyang.addCommands(commands);

    // Start listening.
    annyang.start();
}