#include <Wire.h> // Must include Wire library for I2C
#include <SparkFun_MMA8452Q.h>

MMA8452Q accel;

void setup() {
  Serial.begin(9600);
  accel.init();
}

void loop() {
  if (accel.available())
  {
    accel.read();
    printCalculatedAccels();
    Serial.println(); 
  }
}

void printCalculatedAccels()
{ 
  Serial.print(accel.cx, 3);
  Serial.print(",");
  Serial.print(accel.cy, 3);
  Serial.print(",");
  Serial.print(accel.cz, 3);
  Serial.print(",");
}

