/* CODE BY DIPESH CHANDER MONGA, @DIMONGA FOR RIDDLE 1 OF THE ESCAPE ROOM CALLED PAUL THE ROBOT
 */


int detect_pin =3; // SENSOR CONNECTED TO THE FRONT OF PAUL TO DETECT OBSTACLES
int power_pin=4; //SENSOR CONNECTED TO THE RIGHT OF PAUL TO DETECT THE SIGNAL FROM FOOD BOWL
int power_pin2=2; // EXTRA SENSOR CONNECTED TO THE RIGHT OF PAUL TO DETECT THE SIGNAL FROM FOOD BOWL IF THE SENSOR AT 4th Pin FAILS
int speed_left = 10; // PIN TO CONTROL THE SPEED OF LEFT SIDE MOTORS
int speed_right = 11; // PIN TO CONTROL THE SPEED OF RIDE SIDE MOTORS
int speedval =110; // INITIAL SPEED OF THE ROBOT
int speedval2 =120; // A BIT MORE FASTER SPEED TO GIVE EXTRA TORQUE
const int leftForward = 7;  // PIN TO CONTROL THE LEFT FORWARD MOTION
const int leftBackward = 6; // PIN TO CONTROL THE LEFT BACKWARD MOTION
const int rightForward = 9; // PIN TO CONTROL THE RIGHT FORWARD MOTION
const int rightBackward = 8; // PIN TO CONTROL THE RIGHT BACKWARD MOTION

void setup() {
  // put your setup code here, to run once:
  // DEFINING THE INPUTS AND OUTPUTS
pinMode(leftForward , OUTPUT);
  pinMode(leftBackward , OUTPUT);
  pinMode(rightForward , OUTPUT);
  pinMode(rightBackward , OUTPUT);
  pinMode(speed_left , OUTPUT);
  pinMode(speed_right , OUTPUT);
   Serial.begin (9600);
  pinMode(detect_pin, INPUT);
  pinMode(power_pin, INPUT);
  pinMode(power_pin2, INPUT);
  

}

void faster_forward(){ //FUNCTION TO MOVE THE ROBOT A BIT FASTER IN FORWARD DIRECTION
   analogWrite(speed_left,speedval2); 
   analogWrite(speed_right,speedval2);
  digitalWrite(leftForward , LOW);
  digitalWrite(leftBackward , HIGH);
  digitalWrite(rightForward , LOW);
  digitalWrite(rightBackward , HIGH);
}

void forward(){ //FUNCTION TO MOVE THE ROBOT NORMAL SPEED
  analogWrite(speed_left,speedval);
   analogWrite(speed_right,speedval);
  digitalWrite(leftForward , LOW);
  digitalWrite(leftBackward , HIGH);
  digitalWrite(rightForward , LOW);
  digitalWrite(rightBackward , HIGH);
 //  delay(timef);
}
void backward(){ //FUNCTION TO MOVE THE ROBOT BACKWARD
  analogWrite(speed_left,speedval);
   analogWrite(speed_right,speedval);
  digitalWrite(leftForward , HIGH);
  digitalWrite(leftBackward , LOW);
  digitalWrite(rightForward , HIGH);
  digitalWrite(rightBackward , LOW);
 //  delay(timef);
}
void stops(){ //TO STOP THE ROBOT
  analogWrite(speed_left,0);
   analogWrite(speed_right,0);
  digitalWrite(leftForward , LOW);
  digitalWrite(leftBackward , LOW);
  digitalWrite(rightForward , LOW);
  digitalWrite(rightBackward , LOW);
  // delay(timef);
}
int detectValue; // VARIABLE TO STORE THE DETECTION PIN VALUE
int onValue;// VARIABLE TO STORE THE POWER PIN VALUE
int onValue2;
int i = 1;
 int m =0;
void loop() 
{
 
 detectValue = digitalRead(detect_pin);
 onValue = digitalRead(power_pin);
  onValue2 = digitalRead(power_pin2);
 if ( i == 1 && (onValue ==0|| onValue2 ==0)) //IF EITHER OF THE SENSORS ON THE RIGHT DETECTS A SIGNAL FROM FOODBOWL, THE ROBOT STARTS MOVING
 {
// THE ROBOT RUNS HITS THE OBSTACLE RUNS AGAIN AND ITS AGAIN THE OBSTACLE
  Serial.println("i ==1" );
  forward();
  delay(1000);
  stops();
   delay(300);
  backward();
  delay(500);
  stops();
  forward();
  delay(700);
  stops();
   delay(300);
  backward();
  delay(400);
  stops();
  i=2; // PASSES THE CONTROL TO NEXT STEP
  }
 
  
  
  if (i==2)
  {

    //IR SENSOR ON FRONT ACTIVATES AND NOW ROBOT STOPS IF THERE IS ANY OBSTACLE IN FROM OF IT
    Serial.println("i ==2");
   
  if (detectValue==0)
   {
  
    Serial.println("i ==2 M ==0" );
     if (m ==0 )
   {
     Serial.println("i ==2 M ==0 BACKWARDS" );
   backward(); 
    delay(400); 
   
   }
     Serial.println("i ==2 M ==1 STOPS" );
     stops();
    m=m+1;
   }
   
  if (detectValue==1)
   {
    faster_forward();
    delay(300);
    forward();
     Serial.println("i ==3 , forward");
   }
    }
 
 
}

 
