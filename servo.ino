#include    <Servo.h>          //Servo library
 
Servo servo_test;        //initialize a servo object for the connected servo  
                
int angle = 0;    
 
void setup() 
{ 
  Serial.begin(9600);
  servo_test.attach(13); 
  servo_test.write(0);    
  // attach the signal pin of servo to pin9 of arduino
} 
  
void loop() 
{
    int a=0;
    if (Serial.available() > 0) {  
    char rx_byte = Serial.read();       // get the character

    Serial.println(rx_byte);
    // check if a number was received
    if ((rx_byte == '0') || (rx_byte == '1')) {
      Serial.print("Data received: ");
      Serial.println(rx_byte);
      a++;
      if(rx_byte == '1')
        {
          for(angle = 0; angle < 180; angle += 1)   // command to move from 0 degrees to 180 degrees 
  {                                  
    servo_test.write(angle);                //command to rotate the servo to the specified angle
    delay(15);                       
  } 
 
  delay(1000);
  
  for(angle = 180; angle>=0; angle--)     // command to move from 180 degrees to 0 degrees 
  {                                
    servo_test.write(angle);              //command to rotate the servo to the specified angle
    delay(15);                       
  } 
  
  exit(0);
        }
    
      
    }
    else {
      Serial.println("number is not either 0 or 1.");
    }
    }
delay(2000);
}