int room2button = 12;   //Room2 emergency button
int room2led =11;  //LED of emergency button 2
int room1button = 10; //Room 1 emergency button
int room1led =9; //LED of emergency button 1
int lock =8; //signal to relay for opening the door
int timmy=7; //signal from timmy
int buzzer=3; //Negative high buzzer connected 
                        

void setup()
{
    pinMode(room2button,INPUT_PULLUP);  
    pinMode(room1button,INPUT_PULLUP); 
     pinMode(timmy,INPUT_PULLUP); //to receive signal from timmy
  Serial.begin(9600);
  pinMode(room2led,OUTPUT); 
  digitalWrite(room2led,HIGH); 
    pinMode(room1led,OUTPUT); 
     pinMode(lock,OUTPUT); 
    pinMode(buzzer,OUTPUT); 
  digitalWrite(room1led,HIGH);
    digitalWrite(lock,HIGH); //Turn on the lock on startup
    digitalWrite(buzzer,HIGH);
    
}

void loop()
{
  
    int room1value= digitalRead(room1button);
  Serial.print(room1value);
  int room2value= digitalRead(room2button);
  Serial.print(room2value);
  int timmyvalue= digitalRead(timmy);
  Serial.println(timmyvalue);

  if (room1value== 0 || room2value == 0 || timmyvalue == 0) //if timmy sends signal or emergency button is pressed
  {
    digitalWrite(buzzer,LOW);  // makes sounds while turning on
    delay(300);
    digitalWrite(buzzer,HIGH);
    delay(200);
   digitalWrite(buzzer,LOW);
    delay(200);
    digitalWrite(buzzer,HIGH);
    delay(200);
    
    digitalWrite(lock,LOW); //Turns off the relay and opens the door
    delay(30000); 
    digitalWrite(lock,HIGH); //Turns off the relay and closes the door after 30 seconds
  
    digitalWrite(buzzer,LOW); // makes sounds while turning off
    delay(100);
    digitalWrite(buzzer,HIGH);
    delay(200);
   digitalWrite(buzzer,LOW);
    delay(100);
    digitalWrite(buzzer,HIGH);
    delay(200);
     digitalWrite(buzzer,LOW);
    delay(100);
    digitalWrite(buzzer,HIGH);
 
    
  }
  
    
  

}
