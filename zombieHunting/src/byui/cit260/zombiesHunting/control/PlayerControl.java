/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.zombiesHunting.control;

import byui.cit260.zombiesHunting.model.Game;
import byui.cit260.zombiesHunting.model.Location;
import byui.cit260.zombiesHunting.model.Map;
import byui.cit260.zombiesHunting.model.Player;
import byui.cit260.zombiesHunting.model.Scene;
import byui.cit260.zombiesHunting.model.WeaponItem;
import java.util.Scanner;
import zombiehunting.ZombieHunting;

/**
 *
 * @author ChunShing
 */
public class PlayerControl {

    public static void movePlayer(String direction) {
        Game game = ZombieHunting.getCurrentGame();
        Player player = game.getPlayer();
        Map[] map = game.getGameMaps();
        
        int maxRow = map[player.getRoom()].getTotalRows() - 1;
        int maxColumn = map[player.getRoom()].getTotalColumns() - 1;
        
        boolean inBounds = false;
        
        while(!inBounds)
        {
            int row = player.getRowPosition();
            int column = player.getColumnPosition();
            
            switch(direction){
                case "W": //up
                    row = row - 1;
                    break;
                case "S": //down
                    row = row + 1;
                    break;
                case "A": //left
                    column = column - 1;
                    break;
                case "D": //right
                    column = column + 1;
                    break;
                default:
                    System.out.println("Invalid movement direction");
                    System.out.println("W:up S:down A:left D:right");
                    break;
            }//end switch
            
            //get the scene description for the next tile.
            Location[][] oldLocations = map[player.getRoom()].getLocations();
            Scene temp = oldLocations[row][column].getScene();
            String newLocation = temp.getDescription();
            //boundary checking
            if (column >= 0 && 
                row >= 0 && 
                column <= maxRow && 
                column <= maxColumn &&
                newLocation != "x"){
            
               inBounds = true;
                
               
               // get the player's current location
               int currentRow = player.getRowPosition();
               int currentColumn = player.getColumnPosition();
               MapControl.moveActorsToLocation(row, column, player.getRoom());
               
               Scene reset = new Scene();
               oldLocations[currentRow][currentColumn].setScene(reset);
                              
            }
            else{
                System.out.println("ERROR: boundary in the way. Choose a"
                                 + " different direction to travel.");
                //reprompt for new input
                direction = PlayerControl.getInput();
                
            }
            
        }//end while
                

        map[player.getRoom()].displayMap();
    }

    private static String getInput() {
        boolean validInput = false;
        String input = null;
        Scanner keyboard = new Scanner(System.in);
        char selection;
        
        while(!validInput)
        {
            //prompt user for choice
            System.out.println("Choose direction:");
            
            //get name from keyboard
            input = keyboard.nextLine();
            input = input.trim();
            
            if (input.length() > 0){ 
                validInput = true;
            }
        } //end while loop
        
        return input;
    }//end getInput function
    
    public static double calcAccuracy(double ammo, double hittingAmmo){
    
        if (ammo < hittingAmmo){
            return 1;
        }    
        double accuracy = hittingAmmo/ammo;
        return accuracy;
    }
}
