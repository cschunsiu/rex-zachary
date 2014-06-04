/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.zombiesHunting.control;

import byui.cit260.zombiesHunting.model.Constants;
import static byui.cit260.zombiesHunting.model.Constants.RIFLE;
import byui.cit260.zombiesHunting.model.Game;
import byui.cit260.zombiesHunting.model.HealthItem;
import byui.cit260.zombiesHunting.model.WeaponItem;
import zombiehunting.ZombieHunting;

/**
 *
 * @author Computer
 */
public class GameControl {
    
    private static Game game;
    
    public static Game getGame() {
        return game;
    }
    
    public static void startNewGame(){
        
        //create a new game
        GameControl.game = new Game();
        
        //save as current game
        ZombieHunting.setCurrentGame(game);
        
        //save player in game
        GameControl.game.setPlayer(ZombieHunting.getPlayer());
        
        GameControl.createInventoryList();
        GameControl.createActorList();
        GameControl.createZombies();
        GameControl.createMap();
        
        //move player to starting position
        MapControl.moveActorsToStartingLocation(0,0);
    }

    private static void createInventoryList() {
        
       System.out.println("*** calling stub function createInventoryList ***");
       
       WeaponItem[] weapons =
               new WeaponItem[Constants.NUMBER_OF_WEAPON_ITEMS];
       
       weapons[RIFLE].setWeaponType ("Rifle");
       HealthItem[] healthItems = 
               new HealthItem[Constants.NUMBER_OF_HEALTH_ITEMS];
       
    }

    
    private static void createActorList() {
       System.out.println("*** Calling createActorList stub function ***");
    }

    private static void createZombies() {
       System.out.println("*** Calling createZombies stub function ***");
    }

    private static void createMap() {
       System.out.println("*** Calling createMap stub function ***");
    }
}
