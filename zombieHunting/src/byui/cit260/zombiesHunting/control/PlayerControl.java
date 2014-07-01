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
import byui.cit260.zombiesHunting.model.Zombie;
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
        
        //int maxRow = map[player.getRoom()].getTotalRows() - 1;
        //int maxColumn = map[player.getRoom()].getTotalColumns() - 1;
        
        int maxRow = 18;
        int maxColumn = 23;
        
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
            Boolean blocked = temp.isBlocked();
            String nextScene = temp.getDescription();
            //boundary checking
            if (nextScene == "z"){
                int currentRow = player.getRowPosition();
                int currentColumn = player.getColumnPosition();
                
                PlayerControl.attackZombie();
                MapControl.moveActorsToLocation(row, column, player.getRoom());
                inBounds = true;
                
                Scene reset = new Scene();
                oldLocations[currentRow][currentColumn].setScene(reset);
            }
            else if (nextScene == "E"){
                int currentRow = player.getRowPosition();
                int currentColumn = player.getColumnPosition();
            
                MapControl.moveActorsToLocation(0, 0, player.getRoom() + 1);
                inBounds = true;
                
                Scene reset = new Scene();
                oldLocations[currentRow][currentColumn].setScene(reset);
            }
            else if (column >= 0 && 
                row >= 0 && 
                column <= maxRow && 
                column <= maxColumn &&
                !blocked){
            
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

    public static double calcAccuracy(int ammo, int hittingAmmo){
    
        if (ammo < hittingAmmo){
            return 1;
        }    
        double accuracy = hittingAmmo/ammo;
        return accuracy;
    }
    
    private static void attackZombie() {
        Zombie enemy = new Zombie(10);
        Game game = ZombieHunting.getCurrentGame();
        int playerAttack = 30;
        int zombieHealth = 100;
        //
        while (zombieHealth > 0){
            zombieHealth = zombieHealth - playerAttack;
        }

    }
}
