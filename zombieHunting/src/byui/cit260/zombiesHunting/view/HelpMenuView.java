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
public class HelpMenuView {
    private static final String MENU = "\n"
        + "\n-------------------------------------------"
        + "\n Help Menu                                |"
        + "\n-------------------------------------------"
        + "\nG - What is the goal of the game?"
        + "\nM - How to move"
        + "\nI - How to access Inventory"
        + "\nW - How to use weapons and attack"
        + "\nQ - Quit"
        + "\n-------------------------------------------";
    
    public void displayMenu() {
            
        char selection;
        do {
            System.out.println(MENU); //display help menu
            
            String input = this.getInput(); //users selection
            selection = input.charAt(0);    //first character
            
            this.doAction(selection);
            
        }while (selection != 'Q');
    }

    public String getInput() {
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
            switch(selection){
                case 'G': //These are the choices on the menu
                case 'M':
                case 'I':
                case 'W':
                case 'Q':
                    validInput = true;
                    break;
                default:
                    System.out.println("Invalid input - please select one of the"
                                     + " options from the menu in uppercase form");
                    System.out.println(MENU); //display main menu
                    break;
            }//end switch statement
        } //end while loop
        
        return input;
    }

    public void doAction(char choice) {
               
        switch (choice) {
            case 'G': //display game's goal
                System.out.println("\n*** HelpMenu option G chosen ***");
                break;
            case 'M': //instructions on how to move
                System.out.println("\n*** HelpMenu option M chosen ***");
                break;
            case 'I': //Inventory Instructions
                System.out.println("\n*** HelpMenu option I chosen ***");
                break;
            case 'W': //Instructions on using weapons and attacking
                System.out.println("\n*** HelpMenu option W chosen ***");
            case 'Q': //Exit the help menu
                return;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;            
        }
    }
    
}
