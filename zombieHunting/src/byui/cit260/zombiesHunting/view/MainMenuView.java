/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.zombiesHunting.view;

import byui.cit260.zombiesHunting.Exceptions.GameControlException;
import byui.cit260.zombiesHunting.control.GameControl;
import byui.cit260.zombiesHunting.control.ProgramControl;
import java.util.Scanner;

/**
 *
 * @author Computer
 */
public class MainMenuView extends View{
    
        
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


    @Override
    public void doAction(String choice){
        
        switch (choice) {
            case "G": //display the game menu
                try {
                   GameControl.startNewGame();
                }
                catch(GameControlException ex){
                   System.out.println(ex.getMessage());    
                }
                PlayerMenuView playerMenu = new PlayerMenuView();
                playerMenu.displayMenu();
                break;
            case "H": //display the help menu
                HelpMenuView helpMenu = new HelpMenuView();
                helpMenu.displayMenu();
                break;
            case "S": //save the current game to disk
                ProgramControl.saveGame();
                break;
            case "E": //Exit the program
                return;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;            
        }
    }
}
