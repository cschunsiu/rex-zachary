/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.zombiesHunting.view;

import byui.cit260.zombiesHunting.control.ProgramControl;
import byui.cit260.zombiesHunting.model.Player;
import java.util.Scanner;

/**
 *
 * @author Computer
 */
public class StartProgramView {
    public void startProgram(){
        // display the banner
        this.displayBanner();
        
        // get player name
        String playersName = this.getPlayersName();
        if (playersName == null)
            return;
        
        Player player = ProgramControl.createPlayer(playersName);
        
        //display welcome message
        this.displayWelcomeMessage(player);
        
        //display main menu
        MainMenuView mainMenuView = new MainMenuView();
        mainMenuView.display();
    }
    
    public void displayBanner() {
        System.out.println("\n\n***********************************************");
        
        System.out.println("*                                             *"
                        + "\n* It is the year 2050 and the world has become*"
                        + "\n* a zombie wasteland. Rumors have spread that *"
                        + "\n* a team of scientists have created a cure    *"
                        + "\n* that would cure the world of the zombie     *"
                        + "\n* plague. As a member of a team of survivors, *"
                        + "\n* it is up to you to retrieve the cure and    *"
                        + "\n* return it to the camp so that it may be     *"
                        + "\n* distributed to the rest of the world.       *");
        
        System.out.println("*                                             *"
                        + "\n*                Good luck                    *"
                        + "\n*                                             *");
        
        System.out.println("***********************************************");
    }
    
    public String getPlayersName(){
        boolean validName = false;
        String playersName = null;
        Scanner keyboard = new Scanner(System.in);
        
        while(!validName)
        {
            //prompt user for name
            System.out.println("Enter your name:");
            
            //get name from keyboard
            playersName = keyboard.nextLine();
            playersName = playersName.trim();
            
            //if user decides to quit
            if (playersName.toUpperCase().equals("Q")){
                return null;
            }
            
            //if name invalid
            if (playersName.length() < 2) {
                System.out.println("Invalid name - the name must have "
                                 + "no blanks and be greater than one "
                                 + "character in length");
            }
            else
            {
                //signals that a valid name has been entered
                validName = true; 
            }
        }
        
        return playersName;
    }

    public void displayWelcomeMessage(Player player) {
        System.out.println("\n\n********************************************");
        System.out.println("\t Welcome to the game " + player.getName());
        System.out.println("\t Stay safe and don't die!");
        System.out.println("********************************************");
    }
}
