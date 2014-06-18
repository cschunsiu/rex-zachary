/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.zombiesHunting.view;

import byui.cit260.zombiesHunting.control.GameControl;
import byui.cit260.zombiesHunting.control.ProgramControl;
import java.util.Scanner;

/**
 *
 * @author Computer
 */
public class MainMenuView extends MenuView{
    
        
    public MainMenuView(){
        super("\n"
        + "\n-------------------------------------------"
        + "\n Main Menu                                |"
        + "\n-------------------------------------------"
        + "\nG - Start Game"
        + "\nH - Help"
        + "\nS - Save Game"
        + "\nE - Exit Game"
        + "\n-------------------------------------------");
  }
    public MainMenuView(String MENU) {
        super(MENU);
    }

    public void doAction(char choice){
        
        switch (choice) {
            case 'G': //display the game menu
                GameControl.startNewGame();
                PlayerMenuView playerMenu = new PlayerMenuView();
                playerMenu.displayMenu();
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
