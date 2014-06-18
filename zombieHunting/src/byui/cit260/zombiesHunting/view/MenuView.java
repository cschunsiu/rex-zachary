/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.zombiesHunting.view;

import java.util.Scanner;

/**
 *
 * @author ChunShing
 */
public abstract class MenuView implements ViewInterface{
    
    private String MENU;
    
    public MenuView(String MENU){
        this.MENU = MENU;
    }
    
    @Override
        public void display() {
    
        String selection = null;
        do {
            System.out.println(MENU); //display main menu
            
            selection = this.getInput(); //users selection
            
            this.doAction(selection);
            
        }while (!selection.equals("E"));
           
    }
   
    @Override
    public String getInput(){
        boolean validInput = false;
        String input = null;
        Scanner keyboard = new Scanner(System.in);
        char selection;
        
        while(!validInput)
        {
            //prompt user for name
            System.out.println("Choose option:");
            
            //get name from keyboard
            input = keyboard.nextLine();
            input = input.trim();
            
            if (input.length() > 0){ 
                validInput = true;
            }
        } //end while loop
        
        return input;
    }//end getInput function
    
    
}
