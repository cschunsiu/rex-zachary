/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.zombiesHunting.view;

import byui.cit260.zombiesHunting.control.GameControl;
import byui.cit260.zombiesHunting.model.InventoryItem;
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
                //display sorted list of inventory items
                this.viewInventory();
                break;
            case 'E': //Exit the program
                return;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;            
        }
    }

    private void viewInventory() {
        //get sorted list of inventory items
        //InventoryItem[] inventory = GameControl.getSortedInventoryList();
        //Display Title
        System.out.println("\nList of Inventory Items");
        
        //Display description
        System.out.println("Description" + "\t" +
                           "Required" + "\t" +
                           "In Stock");
                           
        //for each inventory Item
        /*
        for (InventoryItems InventoryItem : inventory){
            System.out.println(inventoryItems.getDescription() + "\t   " +
                               inventoryItems.getQuantityInStock() );
        }
        */
           //Display description
           //Display number in stock
        System.out.println("\n***Called veiwInventory stub function"); //To change body of generated methods, choose Tools | Templates.
    }

}
