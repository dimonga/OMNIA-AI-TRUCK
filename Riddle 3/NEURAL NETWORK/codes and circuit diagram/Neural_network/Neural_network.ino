int val1,val2,val3,val4,val5;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
pinMode(10,OUTPUT); //
pinMode(9,OUTPUT); // GREEN LED
pinMode(7,OUTPUT); //Signal wire going to timmy robot
pinMode(8,OUTPUT); //RED LED
pinMode(3,INPUT); //signal from keypad
pinMode(A0,INPUT_PULLUP);
pinMode(A2,INPUT_PULLUP);
pinMode(A3,INPUT_PULLUP);
}

void loop() {
  // put your main code here, to run repeatedly:
val1= analogRead(A0);
val2=analogRead(A1);
val3=analogRead(A2);
val4=analogRead(A3);
val5= digitalRead(3); //from keypad


if ( val1 >= 958 && val1 <= 970  && val2 == 1023 && val3 >= 25 && val3 <= 28 && val4 == 1023  && val5==1)
{
  digitalWrite(10,10); // almost Ground for the middle  row
  digitalWrite(9,HIGH); //green led on
  digitalWrite(8,LOW); //Red Led ON
  delay(1000); //some delay for suspense
  digitalWrite(7,HIGH); //signal to timmy
  
}
else
{
  if (val5 == 1) // If the keypad password is correct active neural network
  {
  digitalWrite(9,LOW); //green led off
  digitalWrite(8,HIGH); //Red LED ON
  }
  else
  { //neutal network off is no password is input in keypad
  digitalWrite(9,LOW); 
  digitalWrite(8,LOW);
  }
}

Serial.print(val1);
Serial.print("    ");
Serial.print(val2);
Serial.print("    ");
Serial.print(val3);
Serial.print("    ");
Serial.print(val4);
Serial.print("    ");
Serial.print(val5);
Serial.println("    ");
//delay(700);*/

}
