/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.zombiesHunting.control;

import byui.cit260.zombiesHunting.Exceptions.MapControlException;
import byui.cit260.zombiesHunting.model.Game;
import byui.cit260.zombiesHunting.model.Location;
import byui.cit260.zombiesHunting.model.Map;
import byui.cit260.zombiesHunting.model.Player;
import byui.cit260.zombiesHunting.model.Scene;
import byui.cit260.zombiesHunting.model.WeaponItem;
import byui.cit260.zombiesHunting.model.Zombie;
import byui.cit260.zombiesHunting.view.AttackMenuView;
import byui.cit260.zombiesHunting.view.LaboratoryView;
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
            Scene temp;
            String nextScene = null;
            Boolean blocked = true;
            
            if (row >= 0 && column >= 0){
                temp = oldLocations[row][column].getScene();
                blocked = temp.isBlocked();
                nextScene = temp.getDescription();
            }
            
            //boundary checking
            if (nextScene == "z"){
                int currentRow = player.getRowPosition();
                int currentColumn = player.getColumnPosition();
                
                PlayerControl.attackZombie();
                
                try{
                MapControl.moveActorsToLocation(row, column, player.getRoom());
                }
                catch (MapControlException ex){
                   System.out.println(ex.getMessage());
               }
                inBounds = true;
                
                Scene reset = new Scene();
                oldLocations[currentRow][currentColumn].setScene(reset);
            }
            else if (nextScene == "E"){ //exit
                int currentRow = player.getRowPosition();
                int currentColumn = player.getColumnPosition();
            
                try{
                MapControl.moveActorsToLocation(0, 0, player.getRoom() + 1);
                }
                catch (MapControlException ex){
                   System.out.println(ex.getMessage());
                }
                inBounds = true;
                
                Scene reset = new Scene();
                oldLocations[currentRow][currentColumn].setScene(reset);
            }
            else if(nextScene == "C"){
                LaboratoryView laboratory = new LaboratoryView();
                laboratory.displayEndGame(); 
                inBounds = true;
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
               try{
                  MapControl.moveActorsToLocation(row, column, player.getRoom());
               }
               catch (MapControlException ex){
                   System.out.println(ex.getMessage());
               }
               Scene reset = new Scene();
               oldLocations[currentRow][currentColumn].setScene(reset);
                              
            }
            else{
                //System.out.println("ERROR: boundary in the way. Choose a"
                //                 + " different direction to travel.");
                //reprompt for new input
                direction = PlayerControl.getInput();               
            }
            
        }//end while
                
        try{
           map[player.getRoom()].displayMap();
        }
        catch(ArrayIndexOutOfBoundsException mapErr){
            mapErr.getMessage();
            mapErr.printStackTrace();
        }
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
        WeaponItem[] weapon = game.getInventoryWeapons();
         
        AttackMenuView attack = new AttackMenuView();
        int weaponChoice = attack.getWeapon();
        attack.display();
        
        int playerAttack = 30;
        int zombieHealth = 100;
        //
        while (zombieHealth > 0){
            zombieHealth = zombieHealth - playerAttack;
        }
    }
}
