/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.zombiesHunting.view;

import byui.cit260.zombiesHunting.control.GameControl;
import byui.cit260.zombiesHunting.model.Game;
import byui.cit260.zombiesHunting.model.InventoryItem;
import java.util.Scanner;
import zombiehunting.ZombieHunting;

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
        + "\nI - View inventory"
        + "\nV - View Map"
        + "\nH - Help"
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
            if (selection == 'M' || 
                selection == 'S' || 
                selection == 'I' || 
                selection == 'E' ||
                selection == 'H' ||
                selection == 'V'){
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
                System.out.println("\n*** Called Search ***");
                break;
            case 'I': //View inventory
                //display sorted list of inventory items
                this.viewInventory();
                break;
            case 'V': //view the map
                this.displayMap();
                break;
            case 'H':
                HelpMenuView helpMenu = new HelpMenuView();
                helpMenu.displayMenu();
                break;
            case 'E': //Exit the program
                return;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;            
        }
    }

    public void viewInventory() {
        //get sorted list of inventory items
        //InventoryItem[] inventory = GameControl.getInventoryList();
        Game game = ZombieHunting.getCurrentGame();
        InventoryItem[] inventory = game.getInventory();
        //Display Title
        System.out.println("\nList of Inventory Items\n");
        
        //Display description
        System.out.println("Description" + "\t" +
                           "In Stock");
                           
        //for each inventory Item
        for (InventoryItem InventoryItem : inventory){
            System.out.println(InventoryItem.getDescription() + "\t   " +
                               InventoryItem.getQuantity() );
        }
    }
    
    private void displayMap() {
        System.out.println("****Stub for display map in PlayerMenuView Class****");
    }

}
