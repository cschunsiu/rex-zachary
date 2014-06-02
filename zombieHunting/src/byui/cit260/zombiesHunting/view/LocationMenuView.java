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
public class LocationMenuView {
    private static final String MENU = "\n"
        + "\n-------------------------------------------"
        + "\n Location Menu                                |"
        + "\n-------------------------------------------"
        + "\nN - Next Location"
        + "\nX - Stay Here"
        + "\nC - Construction Site"
        + "\nA - Airport"
        + "\nU - SuperMarket"
        + "\nS - School"
        + "\nM - Mall"
        + "\nL - Laboratory"
        + "\n-------------------------------------------";
    
    public void displayMenu() {
    
        char selection;
        do {
            System.out.println(MENU); //display main menu
            
            String input = this.getInput(); //users selection
            selection = input.charAt(0);    //first character
            
            this.doAction(selection);
            
        }while (selection != 'X');
           
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
                case 'N': //These are the choices on the menu
                case 'X':
                case 'C':
                case 'A':
                case 'U':
                case 'S':
                case 'M':
                case 'L':
                    validInput = true;
                    break;
                default:
                    System.out.println("Invalid input - please select one of the"
                                     + "options from the menu in uppercase form");
                    System.out.println(MENU); //display location menu
                    break;
            }//end switch statement
        } //end while loop
        
        return input;
    }//end getInput function
    
    public void doAction(char choice){
        
        switch (choice) {
            case 'N': //Next Location
                System.out.println("\n*** You have chosen to move to new location***");
                break;
            case 'C': //Construction Site
                System.out.println("\n*** You have moved to the Construction Site ***");
                break;
            case 'A': //Airport
                System.out.println("\n*** You have moved to the Airport ***");
                break;
            case 'U': //SuperMarket
                System.out.println("\n*** You have moved to the SuperMarket ***");
                break;
            case 'S': //School
                System.out.println("\n*** You have moved to the School ***");
                break;
            case 'M': //Mall
                System.out.println("\n*** You have moved to the Mall ***");
                break;
            case 'L': //Laboratory
                System.out.println("\n*** You have moved to the Laboratory ***");
                break;
            case 'X': //Stay Here
                return;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;            
        }
    }

}
