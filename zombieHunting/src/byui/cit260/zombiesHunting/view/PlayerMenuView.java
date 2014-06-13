/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.zombiesHunting.view;

import byui.cit260.zombiesHunting.control.GameControl;
import byui.cit260.zombiesHunting.model.Game;
import byui.cit260.zombiesHunting.model.InventoryItem;
import byui.cit260.zombiesHunting.model.Zombie;
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
        + "\nZ - View Zombie"
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
            if (selection == 'M' || selection == 'S' || selection == 'I' || selection == 'E' || selection =='Z'){
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
            case 'I': //View inventory
                //display sorted list of inventory items
                this.viewInventory();
                break;
            case 'V': //view the map
                this.displayMap();
                break;
            case 'Z': //View Zombie
                //display sorted list of inventory items
                this.viewZombie();
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
        System.out.println("\nList of Inventory Items");
        
        //Display description
        System.out.println("Description" + "\t" +
                           "Required" + "\t" +
                           "In Stock");
                           
        //for each inventory Item
        for (InventoryItem InventoryItem : inventory){
            System.out.println(InventoryItem.getDescription() + "\t   " +
                               InventoryItem.getQuantity() );
        }
    }
    
     public void viewZombie() {
        //get sorted list of inventory items
        //InventoryItem[] inventory = GameControl.getInventoryList();
        Game game = ZombieHunting.getCurrentGame();
        Zombie[] zombie = game.getZombies();
        //Display Title
        System.out.println("\nList of Zombie");
        
        //Display description
        System.out.println("Description" + "\t" +
                           "Number" + "\t");
                           
        //for each inventory Item
        for (Zombie Zombie : zombie){
            System.out.println(Zombie.getDescription() + "\t   " +
                               Zombie.getNumber() );
        }
    }
     
    private void displayMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
