/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.zombiesHunting.view;

import java.util.Scanner;

/**
 *
 * @author Computer
 */
public class PlayerMenuView {
    private static final String MENU = "\n"
        + "\n-------------------------------------------"
        + "\n Player Menu                               |"
        + "\n-------------------------------------------"
        + "\nM - Move to new location"
        + "\nS - Search"
        + "\nI - Access inventory"
        + "\nE - Exit"    
        + "\n-------------------------------------------";
    
    public void displayMenu() {
    
        char selection;
        do {
            System.out.println(MENU); //display main menu
            
            String input = this.getInput(); //users selection
            selection = input.charAt(0);    //first character
            
            this.doAction(selection);
            
        }while (selection != 'E');
           
    }
    
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
            
            selection = input.charAt(0);
            if (selection == 'M' || selection == 'S' || selection == 'I' || selection == 'E'){
                validInput = true;               
            }  
                else{ 
                    System.out.println("Invalid input - please select one of the"
                                     + "options from the menu in uppercase form");
                    System.out.println(MENU); //display main menu
            }//end switch statement
        } //end while loop     
        return input;
    }//end getInput function
    
    public void doAction(char choice){
        
        switch (choice) {
            case 'M': //move to a new location
                LocationMenuView locationMenu = new LocationMenuView();
                locationMenu.displayMenu();
                break;
            case 'S': //Search
                break;
            case 'I': //Access inventory
                break;
            case 'E': //Exit the program
                return;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;            
        }
    }

}
