/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.zombiesHunting.control;

import byui.cit260.zombiesHunting.model.Constants;
import byui.cit260.zombiesHunting.model.Game;
import byui.cit260.zombiesHunting.model.HealthItem;
import byui.cit260.zombiesHunting.model.InventoryItems;
import byui.cit260.zombiesHunting.model.Location;
import byui.cit260.zombiesHunting.model.Map;
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

    private static InventoryItems[] createInventoryList() {
        
       //System.out.println("*** calling stub function createInventoryList ***");
        
       //There are 5 different inventory items as of now.
       InventoryItems inventoryList[] = new InventoryItems[Constants.NUM_INVENTORY_ITEMS]; 
       
       InventoryItems rifle = new InventoryItems();
       rifle.setDescription("Rifle");
       rifle.setQuantity(Constants.NUMRIFLE);
       inventoryList[Constants.RIFLE]= rifle;
       
       InventoryItems assaultRifle = new InventoryItems();
       assaultRifle.setDescription("Assault Rifle");
       assaultRifle.setQuantity(Constants.NUMASSAULT_RIFLE);
       inventoryList[Constants.ASSAULT_RIFLE]= assaultRifle;
       
       InventoryItems rocketLauncher = new InventoryItems();
       rocketLauncher.setDescription("Rocket Launcher");
       rocketLauncher.setQuantity(Constants.NUMLAUNCHER);
       inventoryList[Constants.ROCKET_LAUNCHER]= rocketLauncher;
       
       InventoryItems firstAidKit = new InventoryItems();
       firstAidKit.setDescription("First Aid Kit");
       firstAidKit.setQuantity(Constants.NUMFIRST_AID);
       inventoryList[Constants.FIRST_AID_KIT]= firstAidKit;
       
       InventoryItems bandage = new InventoryItems();
       bandage.setDescription("Bandage");
       bandage.setQuantity(Constants.NUMBANDAGE);
       inventoryList[Constants.BANDAGE]= bandage;
       
       return inventoryList;
    }
       
    public static void sortStringExchange(InventoryItems inventoryList[]){
        InventoryItems temp;

        for (int i = 0; i < inventoryList.length - 1; i++){
            for (int j = i + 1; j < inventoryList.length; j++){  
                if (inventoryList[i].getDescription().compareToIgnoreCase(inventoryList[j].getDescription()) > 0){                                             // ascending sort
                    temp = inventoryList[i];
                    inventoryList[i] = inventoryList[j];    // swapping
                    inventoryList[j] = temp; 
                } 
            } 
        } 
    } 
    
    private static void createActorList() {
       System.out.println("*** Calling createActorList stub function ***");
    }

    private static void createZombies() {
       System.out.println("*** Calling createZombies stub function ***");
    }

    private static void createMap() {

       Map map = new Map(20,20);
       
       System.out.println("*** Calling createMap stub function ***");
    }

    private static InventoryItems InventoryItems() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
