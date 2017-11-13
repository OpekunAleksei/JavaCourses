/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.utils;


import com.senla.hotel.utils.Logger;
import java.util.Scanner;
import com.senla.ui.managers.Builder;
import com.senla.ui.managers.Navigator;

public class Helper {
    private Scanner in = new Scanner(System.in);
    private Navigator navigator = new Navigator();
    private Builder builder = new Builder();
    private Logger logger = new Logger();


    public Navigator getNavigator() {
        return navigator;
    }

    public String getStringInput(){
   try{
       return in.next();
   }catch (Exception e){
    logger.writeErrToFile(e);
System.err.println("Chek your imput data");
        return null;
   }    
}

    public Integer getIntegerInput(){
   try{
       return in.nextInt();
   }catch (Exception e){
    logger.writeErrToFile(e);
System.err.println("Chek your imput data");
        return null;
   }    
}


    public Builder getBuilder() {
        return builder;
    }

}
