/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.zombiesHunting.view;

import byui.cit260.zombiesHunting.control.ProgramControl;
import java.util.Scanner;

/**
 *
 * @author Computer
 */
public class MainMenuView {
    private static final String MENU = "\n"
        + "\n-------------------------------------------"
        + "\n Main Menu                                |"
        + "\n-------------------------------------------"
        + "\nG - Start Game"
        + "\nH - Help"
        + "\nS - Save Game"
        + "\nE - Exit Game"
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
            switch(selection){
                case 'E': //These are the choices on the menu
                case 'H':
                case 'S':
                case 'G':        
                    validInput = true;
                    break;
                default:
                    System.out.println("Invalid input - please select one of the"
                                     + "options from the menu in uppercase form");
                    System.out.println(MENU); //display main menu
                    break;
            }//end switch statement
        } //end while loop
        
        return input;
    }//end getInput function
    
    public void doAction(char choice){
        
        switch (choice) {
            case 'G': //display the game menu
                GameMenuView gameMenu = new GameMenuView();
                gameMenu.displayMenu();
                break;
            case 'H': //display the help menu
                HelpMenuView helpMenu = new HelpMenuView();
                helpMenu.displayMenu();
                break;
            case 'S': //save the current game to disk
                ProgramControl.saveGame();
                break;
            case 'E': //Exit the program
                return;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;            
        }
    }

}
