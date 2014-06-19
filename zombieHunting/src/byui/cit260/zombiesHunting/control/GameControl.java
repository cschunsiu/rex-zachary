/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.zombiesHunting.control;

import byui.cit260.zombiesHunting.model.Constants;
import byui.cit260.zombiesHunting.model.Game;
import byui.cit260.zombiesHunting.model.HealthItem;
import byui.cit260.zombiesHunting.model.InventoryItem;
import byui.cit260.zombiesHunting.model.Location;
import byui.cit260.zombiesHunting.model.Map;
import byui.cit260.zombiesHunting.model.Scene;
import byui.cit260.zombiesHunting.model.WeaponItem;
import byui.cit260.zombiesHunting.model.Zombie;
import zombiehunting.ZombieHunting;

/**
 *
 * @author Computer
 */
public class GameControl {
    
    private static Game game;
    private static InventoryItem[] inventoryList;
    private static Zombie[] ZombieList;
    private static WeaponItem[] weapons;

    public static WeaponItem[] getWeapons() {
        return weapons;
    }

    public static void setWeapons(WeaponItem[] weapons) {
        GameControl.weapons = weapons;
    }


    public static Zombie[] getZombieList() {
        return ZombieList;
    }

    public static void setZombieList(Zombie[] ZombieList) {
        GameControl.ZombieList = ZombieList;
    }
 
    public static InventoryItem[] getInventoryList() {
        return inventoryList;
    }

    public static void setInventoryList(InventoryItem[] inventoryList) {
        GameControl.inventoryList = inventoryList;
    }
    
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
        
        InventoryItem[] inventoryList = GameControl.createInventoryList();
        
        GameControl.createActorList();
        Zombie[] zombieList = GameControl.createZombieList();
        WeaponItem[] weapons = GameControl.createWeaponList();
        
        GameControl.createMap();
        
        game.setInventory(inventoryList);
        game.setZombies(zombieList);
        game.setInventoryWeapons(weapons);
        
        //move player to starting position
        MapControl.moveActorsToStartingLocation(0,0);
    }

    public static InventoryItem[] createInventoryList() {
        
       //There are 5 different inventory items as of now.
       inventoryList = new InventoryItem[Constants.NUM_INVENTORY_ITEMS]; 
       
       InventoryItem rifle = new InventoryItem();
       rifle.setDescription("Rifle     ");
       rifle.setQuantity(Constants.NUMRIFLE);
       inventoryList[Constants.RIFLE]= rifle;
       
       InventoryItem assaultRifle = new InventoryItem();
       assaultRifle.setDescription("Assault Rifle");
       assaultRifle.setQuantity(Constants.NUMASSAULT_RIFLE);
       inventoryList[Constants.ASSAULT_RIFLE]= assaultRifle;
       
       InventoryItem rocketLauncher = new InventoryItem();
       rocketLauncher.setDescription("Rocket Launcher");
       rocketLauncher.setQuantity(Constants.NUMLAUNCHER);
       inventoryList[Constants.ROCKET_LAUNCHER]= rocketLauncher;
       
       InventoryItem firstAidKit = new InventoryItem();
       firstAidKit.setDescription("First Aid Kit");
       firstAidKit.setQuantity(Constants.NUMFIRST_AID);
       inventoryList[Constants.FIRST_AID_KIT]= firstAidKit;
       
       InventoryItem bandage = new InventoryItem();
       bandage.setDescription("Bandage     ");
       bandage.setQuantity(Constants.NUMBANDAGE);
       inventoryList[Constants.BANDAGE]= bandage;
       
       SortedInventory(inventoryList);
       
       return inventoryList;
    }
       
    private static void SortedInventory(InventoryItem inventoryList[]){
        InventoryItem temp;

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

    public static Zombie[] createZombieList() {
        
       //There are 3 different Zombie.
       ZombieList = new Zombie[Constants.NUM_ZOMBIE]; 
       
       Zombie zombie = new Zombie();
       zombie.setDescription("Zombieeeeee");
       zombie.setNumber(Constants.NUMZOMBIE);
       ZombieList[Constants.ZOMBIE]= zombie;

       Zombie boomer = new Zombie();
       boomer.setDescription("BOOmerrrrr");
       boomer.setNumber(Constants.NUMBOOMER);
       ZombieList[Constants.BOOMER]= boomer;
       
       Zombie tiny = new Zombie();
       tiny.setDescription("Tinyyyyyyyyyyyy");
       tiny.setNumber(Constants.NUMTINY);
       ZombieList[Constants.TINY]= tiny;
       
       SortedZombie(ZombieList);
       
       return ZombieList;
    }
    
    private static void SortedZombie(Zombie ZombieList[]){
        Zombie temp;

        for (int i = 0; i < ZombieList.length - 1; i++){
            for (int j = i + 1; j < ZombieList.length; j++){  
                if (ZombieList[i].getDescription().compareToIgnoreCase(ZombieList[j].getDescription()) > 0){                                             // ascending sort
                    temp = ZombieList[i];
                    ZombieList[i] = ZombieList[j];    // swapping
                    ZombieList[j] = temp; 
                } 
            } 
        } 
    } 
    
    public static void setGame(Game game) {
        GameControl.game = game;
    }
    
    private static void createActorList() {
       System.out.println("*** Calling createActorList stub function ***");
    }

    private static Map createMap() {

       Map map = new Map(20,10);
       
       InventoryItem[] itemList = createInventoryList();
       Scene[] scenes = createScenes(itemList); //create scenes in game
       
       //assign Scenes to Location
       GameControl.assignScenesToLocations(map, scenes);
       //System.out.println("*** Calling createMap stub function ***");
       return map;
    }

    private static void assignScenesToLocations(Map map, Scene[] scenes)
    {
        Location[][] locations = map.getLocations();
        
        locations[0][0].setScene(scenes[Constants.CONSTRUCTION_SITE1]);
        locations[0][1].setScene(scenes[Constants.CONSTRUCTION_SITE2]);
    
    /*adding*/
    /*
        locations[1][0].setScene(scenes[Constants.AIRPORT1]);
        locations[1][1].setScene(scenes[Constants.AIRPORT2]);
        
        locations[2][0].setScene(scenes[Constants.SUPER_MARKET1]);
        locations[2][1].setScene(scenes[Constants.SUPER_MARKET2]);
        
        locations[3][0].setScene(scenes[Constants.SCHOOL1]);
        locations[3][1].setScene(scenes[Constants.SCHOOL2]);
        
        locations[4][0].setScene(scenes[Constants.MALL1]);
        locations[4][1].setScene(scenes[Constants.MALL2]);
        
        locations[4][0].setScene(scenes[Constants.LABORATORY]);
    */
        
        
        
                
        
    }

    //List of inventory to be found in each scene
    private static Scene[] createScenes(InventoryItem[] itemList) {
        
    Scene[] scenes = new Scene[Constants.NUM_SCENES];
    
    Scene ConstructionSite1 = new Scene(true, "Construction Site #1");
    InventoryItem[] roomItemList = new InventoryItem[3];
    roomItemList[0] = itemList[Constants.RIFLE];
    roomItemList[1] = itemList[Constants.FIRST_AID_KIT];
    roomItemList[2] = itemList[Constants.ASSAULT_RIFLE];
    ConstructionSite1.setItems(roomItemList);
    scenes[Constants.CONSTRUCTION_SITE1] = ConstructionSite1;
 
    Scene ConstructionSite2 = new Scene(true, "Construction Site #2");
    //roomItemList = new InventoryItem[3];
    roomItemList[0] = itemList[Constants.RIFLE];
    roomItemList[1] = itemList[Constants.FIRST_AID_KIT];
    roomItemList[2] = itemList[Constants.ASSAULT_RIFLE];
    scenes[Constants.CONSTRUCTION_SITE2] = ConstructionSite2;

    /*
    Scene Airport1 = new Scene(true, "Airport #1");
    roomItemList = new InventoryItem[3];
    roomItemList[0] = itemList[Constants.RIFLE];
    roomItemList[1] = itemList[Constants.FIRST_AID_KIT];
    roomItemList[2] = itemList[Constants.ASSAULT_RIFLE];
    scenes[Constants.AIRPORT1] = Airport1;
    
    Scene Airport2 = new Scene(true, "Airport #2");
    roomItemList = new InventoryItem[3];
    roomItemList[0] = itemList[Constants.RIFLE];
    roomItemList[1] = itemList[Constants.FIRST_AID_KIT];
    roomItemList[2] = itemList[Constants.ASSAULT_RIFLE];
    scenes[Constants.AIRPORT2] = Airport2;
    */
    return scenes;
    }

    //WeaponItem[] weapons
    //Creates the players List of weapons
    private static WeaponItem[] createWeaponList() {
       weapons = new WeaponItem[Constants.NUMBER_OF_WEAPON_ITEMS]; 
       
       //rifle
       WeaponItem rifle  = new WeaponItem();
       rifle.setDescription("Rifle");
       rifle.setAmmo(Constants.STANDARD_RIFLE_AMMO);
       rifle.setClipSize(Constants.RIFLE_CLIP);
       rifle.setDamage(Constants.RIFLE_DAMAGE);
       weapons[Constants.RIFLE]= rifle;
       
       //ROCKET_LAUNCHER
       WeaponItem rocketLauncher  = new WeaponItem();
       rocketLauncher.setDescription("Rocket Launcher");
       rocketLauncher.setAmmo(Constants.STANDARD_ROCKET_LAUNCHER_AMMO);
       rocketLauncher.setClipSize(Constants.ROCKET_LAUNCHER_CLIP);
       rocketLauncher.setDamage(Constants.ROCKET_LAUNCHER_DAMAGE);
       weapons[Constants.ROCKET_LAUNCHER]= rocketLauncher;
       
       //Assault rifle
       WeaponItem assaultRifle  = new WeaponItem();
       assaultRifle.setDescription("Assault Rifle");
       assaultRifle.setAmmo(Constants.STANDARD_ASSAULT_RIFLE_AMMO);
       assaultRifle.setClipSize(Constants.ASSAULT_RIFLE_CLIP);
       assaultRifle.setDamage(Constants.ASSAULT_RIFLE_DAMAGE);
       weapons[Constants.ASSAULT_RIFLE]= assaultRifle;
       
       return weapons;
    }
}
