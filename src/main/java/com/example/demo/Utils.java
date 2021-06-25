package com.example.demo;

public class Utils {
    private int speed;

   public static boolean checkHighwayLegalspeed (int speed){
       if (speed > 120) {
           return false;
       }
       else return true;
   }
    public static boolean checkUrbanLegalspeed (int speed){
        if (speed > 90) {
            return false;
        }
        else return true;
    }


}
