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
import byui.cit260.zombiesHunting.model.Scene;
import byui.cit260.zombiesHunting.model.Zombie;
import byui.cit260.zombiesHunting.view.LaboratoryView;
import java.util.Random;
import zombiehunting.ZombieHunting;

/**
 *
 * @author ChunShing
 */
public class ZombieControl {
    
    public double calcDamage (double attackPt, double health){
        if (attackPt < 0){
            return -1;
        }
        if (health < 0){
            return -1;
        }
        
        double damage;
        
        //This is to determine if the zombie misses.
        Random hitChance = new Random();
        int hitRoll = hitChance.nextInt(10);
        
        if (hitRoll <= 3){
            damage = 0;
        }
        else{
            damage = attackPt * (health/100);
        }
        
        return damage;
    }
    
    public double calcMovementSpeed(double movementSpeed, double health){
        if (movementSpeed<0){
            return -1;
        }
        if (health <0){
            return -1;
        }
        double modifiedSpeed = movementSpeed*(health/100);
        return modifiedSpeed;
    }
    
    /*********************************************************************
    * Zombies will be assigned a script to determine their pattern of 
    * movement. 
    **********************************************************************/
    public void moveZombie(Zombie zombie){
        Game game = ZombieHunting.getCurrentGame();
        Map[] map = game.getGameMaps();
        
        int currentRow = zombie.getRowPosition();
        int currentColumn = zombie.getColumnPosition();
        int maxRow = 18;
        int maxColumn = 23;
        
        String direction = " ";
        String script = zombie.getScript();
        
        /********************************************************************
        * Script A is for zombies who walk back and forth in a vertical line
        * cycles:
        * 0- up   1-down
        *********************************************************************/
        if (script == "A"){
            
            if(zombie.getCycle() == 0){
                direction = "W";
            }
            else if(zombie.getCycle() == 1){
                direction = "S";
            }
        }
        /********************************************************************
        * Script B is for zombies who walk back and forth in a horizontal line
        * cycles:
        * 0- left  1-right
        *********************************************************************/
        if (script == "B"){
            if (zombie.getCycle() == 0){
                direction = "A";
            }
            else if (zombie.getCycle() == 1){
                direction = "D";
            }
        }
      
        //Movement Control
        Location[][] oldLocations = map[zombie.getRoomPosition()].getLocations();
        Scene temp;
        String nextScene = null;
        Boolean blocked = true;
        
        int row = currentRow;
        int column = currentColumn;
        //alteration to direction
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
        }

        //use updated location to get the nextScene's info
        if (row >= 0 && column >= 0){
            temp = oldLocations[row][column].getScene();
            blocked = temp.isBlocked();
            nextScene = temp.getDescription();
        }
        boolean inBounds = false;
        
        while(!inBounds){
            //boundary checking
            if (nextScene == "z" || 
                nextScene == "E" || 
                nextScene == "C" ||
                nextScene == "x")  { //turn around
                
                //make zombie turn around during next move
                if (zombie.getCycle() == 0){
                    zombie.setCycle(1);
                }
                else {
                    zombie.setCycle(0);
                }
                
                inBounds = true;
             
            }
            else if (column >= 0 && 
                row >= 0 && 
                column <= maxRow && 
                column <= maxColumn &&
                !blocked){
            
               inBounds = true;
               //set new location info
               zombie.setColumnPosition(column);
               zombie.setRowPosition(row);
               
               //reset old scene
               Scene reset = new Scene();
               oldLocations[currentRow][currentColumn].setScene(reset);
                              
            }
            else{

            }
        }//end while loop
            
    }
}
