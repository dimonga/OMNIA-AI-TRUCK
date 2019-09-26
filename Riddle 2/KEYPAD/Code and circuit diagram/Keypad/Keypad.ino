                                 
#include <Keypad.h>  // Include the Keypad library
#include <plcLib.h>  // Include the plcLib library
#include <Wire.h> 
#include <LiquidCrystal_I2C.h>
LiquidCrystal_I2C lcd(0x27, 2, 1, 0, 4, 5, 6, 7, 3, POSITIVE); 
int code = 519628374;  //The code I used, you can change it
int tot,i1,i2,i3,i4,i5,i6,i7,i8,i9;
char c1,c2,c3,c4,c5,c6,c7,c8,c9;
char keyPress = 0;   // Holds the currently pressed key value (if any)
const byte ROWS = 4; // Keypad has four rows
const byte COLS = 3; // Keypad has three columns
int buzzer = 5;  //Buzzer is connected to pin 5
int NN = 3; //Signal to neural network riddle is going to pn 3
int smartmirror = 2; //Signal to relay connected to smart mirror is connected to pin 2
// Define the Keymap
char keys[ROWS][COLS] = {
  {'1','2','3'},
  {'4','5','6'},
  {'7','8','9'},
  {'*','0','#'}
};


byte rowPins[ROWS] = { 11, 6, 7, 9 }; //ROW1, ROW2, ROW3 and ROW4 connected to pins 2,7,6,4 of the keypad and pins 11, 6, 7, 9 of arduino
byte colPins[COLS] = { 10, 12, 8 }; // COL1, COL2 and COL3 connected to pins 3,1,5 of the keypad and pins 10,12,8 of arduino
// Create the Keypad
Keypad myKeypad = Keypad( makeKeymap(keys), rowPins, colPins, ROWS, COLS );

void setup() {
  setupPLC();                 // Define input / output pins
  Serial.begin(9600);      // open the serial port at 9600 bps.
  pinMode(buzzer,OUTPUT);
  lcd.begin(16,2);//Defining 16 columns and 2 rows of lcd display
  lcd.clear();
  lcd.setBacklight(LOW);
  pinMode(A0,INPUT_PULLUP);
  pinMode(smartmirror,OUTPUT);
  pinMode(NN,OUTPUT);
  digitalWrite(buzzer, HIGH);
}
int m=0;
void loop()
{
     int sensorValue = analogRead(A0);
     Serial.println(sensorValue);
     if (sensorValue > 903)
     {
      m=1;
     }
m ==1;
     if (m ==1)
     {
      lcd.setCursor(0, 0);
  lcd.print("Paina * Press *");
  //lcd.setCursor(0, 1);
  //lcd.print(sensorValue);
      lcd.setBacklight(HIGH);
      delay(300);
      lcd.setBacklight(LOW);
      delay(100);
      char keypressed = myKeypad.getKey();  //The getKey fucntion keeps the program runing, as long you didn't press "*" the whole thing bellow wouldn't be triggered
         if (keypressed == '*')             // and you can use the rest of you're code simply
        
             {
               lcd.setBacklight(HIGH);
               digitalWrite(buzzer, LOW);
               delay(100);
               digitalWrite(buzzer, HIGH);
               lcd.clear();
               lcd.setCursor(0, 0);
               lcd.print("Input password");
               delay(1000);
               lcd.clear();
               lcd.setCursor(0, 0);
               lcd.print("Anna Salasana");                  //when the "*" key is pressed you can enter the passcode
                    keypressed = myKeypad.waitForKey();  // here all programs are stopped until you enter the four digits then it gets compared to the code abov
                    digitalWrite(buzzer, LOW);
                   delay(100);
                   digitalWrite(buzzer, HIGH);
                    if (keypressed != NO_KEY)
                      {
                       c1 = keypressed;
                       lcd.setCursor(0, 1);
                       lcd.print("*");
                       }

                    keypressed = myKeypad.waitForKey();
                    digitalWrite(buzzer, LOW);
                   delay(100);
                   digitalWrite(buzzer, HIGH);

                    if (keypressed != NO_KEY)
                      {
                       c2 = keypressed;
                       lcd.setCursor(1, 1);
                       lcd.print("*");
                       }
                     keypressed = myKeypad.waitForKey();
                   digitalWrite(buzzer, LOW);
                   delay(100);
                   digitalWrite(buzzer, HIGH);
                   
                   if (keypressed != NO_KEY)
                      {
                       c3 = keypressed;
                       lcd.setCursor(2, 1);
                       lcd.print("*");
                       }
                       
                      keypressed = myKeypad.waitForKey();
                      digitalWrite(buzzer, LOW);
                   delay(100);
                   digitalWrite(buzzer, HIGH);
                   
                   if (keypressed != NO_KEY)
                      {
                       c4 = keypressed;
                       lcd.setCursor(3, 1);
                      lcd.print("*");
                       }
                       
                       keypressed = myKeypad.waitForKey();
                       digitalWrite(buzzer, LOW);
                       delay(100);
                       digitalWrite(buzzer, HIGH);
                       
                       if (keypressed != NO_KEY)
                      {
                       c5 = keypressed;
                       lcd.setCursor(4, 1);
                      lcd.print("*");
                       }
                       keypressed = myKeypad.waitForKey();
                       digitalWrite(buzzer, LOW);
                       delay(100);
                       digitalWrite(buzzer, HIGH);
                        if (keypressed != NO_KEY)
                      {
                       c6 = keypressed;
                       lcd.setCursor(5, 1);
                      lcd.print("*");
                       }
                       keypressed = myKeypad.waitForKey();
                       digitalWrite(buzzer, LOW);
                       delay(100);
                       digitalWrite(buzzer, HIGH);
                        if (keypressed != NO_KEY)
                      {
                       c7 = keypressed;
                       lcd.setCursor(6, 1);
                      lcd.print("*");
                       }
                       keypressed = myKeypad.waitForKey();
                       digitalWrite(buzzer, LOW);
                       delay(100);
                       digitalWrite(buzzer, HIGH);
                        if (keypressed != NO_KEY)
                      {
                       c8 = keypressed;
                       lcd.setCursor(7, 1);
                      lcd.print("*");
                       }
                       keypressed = myKeypad.waitForKey();
                       digitalWrite(buzzer, LOW);
                       delay(100);
                       digitalWrite(buzzer, HIGH);
                        if (keypressed != NO_KEY)
                      {
                       c9 = keypressed;
                       lcd.setCursor(8, 1);
                      lcd.print("*");
                       }
                     
                     i1=(c1-48)*100000000;        
                     i2=(c2-48)*10000000;
                     i3=(c3-48)*1000000;
                     i4=(c4-48)*100000;
                     i5=(c5-48)*10000;
                     i6=(c6-48)*1000;
                     i7=(c7-48)*100;
                     i8=(c8-48)*10;
                     i9=(c9-48);
                     tot=i1+i2+i3+i4+i5+i6+i7+i8+i9;
                     Serial.print (tot);
                     
         if (tot == code) //if the code is correct you trigger whatever you want here it just print a message on the screen
         {
          digitalWrite(buzzer, LOW);
          delay (200); 
          digitalWrite(buzzer, HIGH);
          delay(100);
          digitalWrite(buzzer, LOW);
          delay(200);
          digitalWrite(buzzer, HIGH);
          delay(100);
          digitalWrite(buzzer, LOW);
          delay(200);
          digitalWrite(buzzer, HIGH);
          delay(100);
          digitalWrite(buzzer, LOW);
          delay(200);
          digitalWrite(buzzer, HIGH);
          delay(100);
          digitalWrite(buzzer, LOW);
          delay(200);
          digitalWrite(buzzer, HIGH);
          delay(100);
          
          lcd.clear();
          lcd.setCursor(0, 0);
          lcd.print("Correct Password");
          lcd.setCursor(0, 1);
          lcd.print("Salasana Oikein");
          lcd.setBacklight(HIGH);
          digitalWrite(smartmirror,HIGH);
         while(1) {
          digitalWrite(smartmirror,HIGH);
            digitalWrite(NN,HIGH);
          }
         }

         else //if the code is wrong you get another thing
         {
          digitalWrite(buzzer, LOW);
          delay (200);
          digitalWrite(buzzer, HIGH);
          delay(500);
          digitalWrite(buzzer, LOW);
          delay(200);
          digitalWrite(buzzer, HIGH);
          delay(500);
          digitalWrite(buzzer, LOW);
          delay(200);
          digitalWrite(buzzer, HIGH);
          delay(500);
          
          lcd.clear();
          lcd.setCursor(0, 0);
          lcd.print(" ");         
          lcd.clear();
          lcd.setCursor(4, 0);
          lcd.print("Salasana ");
          lcd.setCursor(2, 1);
          lcd.print("ei ole oikein");
          delay (2000);
          lcd.clear();
           lcd.setCursor(3, 0);
          lcd.print("Wrong Code ");
          lcd.setCursor(3, 1);
          lcd.print("Try again");
          delay (2000);
          
         lcd.clear();
          
         }
              }
     }

}
