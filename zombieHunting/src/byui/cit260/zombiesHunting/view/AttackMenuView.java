/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.zombiesHunting.view;

import byui.cit260.zombiesHunting.model.Game;
import byui.cit260.zombiesHunting.model.WeaponItem;
import java.util.Scanner;
import zombiehunting.ZombieHunting;

/**
 *
 * @author Computer
 */
public class AttackMenuView {

    public AttackMenuView() {
    }
   
    private static final String MENU = "\n"
        + "\n                ATTACK!                    "
        + "\n-------------------------------------------"
        + "\n Fire the Gun in which direction?          |"
        + "\n-------------------------------------------"
        + "\nW - Up"
        + "\nS - Down"
        + "\nA - Left"
        + "\nD - Right"
        + "\n-------------------------------------------";
    
    public void display(){
        System.out.println(MENU);
    }
    
    public void attack(){
        
        char selection;
        do {
            System.out.println(MENU); //display help menu
            
            String input = this.getInput(); //users selection
            selection = input.charAt(0);    //first character
            
            this.doAction(selection);
            
        }while (selection != 'Q');
    }
        
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
    
    public int getWeapon(){
        boolean validInput = false;
        int weaponPos = 0;
        Scanner keyboard = new Scanner(System.in);
        char selection;
        /******************
        public final static int RIFLE = 0;
        public final static int ROCKET_LAUNCHER = 1;
        public final static int ASSAULT_RIFLE = 2;
        *****************/
        do
        {
            //prompt user for name
            System.out.println("\tChoose a weapon:");
            System.out.println("0 for Rifle");
            System.out.println("1 for Rocket Launcher");
            System.out.println("2 for Assault Rifle");
            System.out.println("Choose option:");
            
        } while(weaponPos >= 0 && weaponPos <= 3);//end while loop
        
        return weaponPos;
    }//end getInput function
    
}
