/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.zombiesHunting.control;

import byui.cit260.zombiesHunting.Exceptions.GameControlException;
import byui.cit260.zombiesHunting.Exceptions.MapControlException;
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
    private static Zombie[] zombieList;
    private static WeaponItem[] weapons;
    private static Map[] rooms; //Contains the map for each room

    public static WeaponItem[] getWeapons() {
        return weapons;
    }

    public static void setWeapons(WeaponItem[] weapons) {
        GameControl.weapons = weapons;
    }

    public static Zombie[] getZombieList() {
        return zombieList;
    }

    public static void setZombieList(Zombie[] zombieList) {
        GameControl.zombieList = zombieList;
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

    public static Map[] getRooms() {
        return rooms;
    }

    public static void setRooms(Map[] rooms) {
        GameControl.rooms = rooms;
    }
    
    public static void startNewGame() throws GameControlException{
        
        //create a new game
        GameControl.game = new Game();
        
        //save as current game
        ZombieHunting.setCurrentGame(game);
        
        //save player in game
        GameControl.game.setPlayer(ZombieHunting.getPlayer());
        //Zombie[] zombieList;
        
        try{
           InventoryItem[] inventoryList = GameControl.createInventoryList();
           zombieList = GameControl.createZombieList();
           WeaponItem[] weapons = GameControl.createWeaponList();
           rooms = GameControl.createMap();
        }
        catch(ArrayStoreException rayErr){
            rayErr.getMessage();
            rayErr.printStackTrace();
        }
        
        game.setInventory(inventoryList);
        game.setZombies(zombieList);
        game.setInventoryWeapons(weapons);
        game.setGameMaps(rooms);
        
        //move player to starting position
        try{
           MapControl.moveActorsToLocation(0,0,Constants.CONSTRUCTION_SITE1);
        }
        catch (MapControlException ex){
                   System.out.println(ex.getMessage());
               }
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
       zombieList = new Zombie[Constants.NUM_ZOMBIE]; 
       
       Zombie zombie = new Zombie();
       zombie.setDescription("Zombieeeeee");
       //zombie.setNumber(Constants.NUMZOMBIE);
       zombieList[Constants.ZOMBIE]= zombie;

       Zombie boomer = new Zombie();
       boomer.setDescription("BOOmerrrrr");
       //boomer.setNumber(Constants.NUMBOOMER);
       zombieList[Constants.BOOMER]= boomer;
       
       Zombie tiny = new Zombie();
       tiny.setDescription("Tinyyyyyyyyyyyy");
       //tiny.setNumber(Constants.NUMTINY);
       zombieList[Constants.TINY]= tiny;
       
       SortedZombie(zombieList);
       
       return zombieList;
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

    private static Map[] createMap() {

       //Map map = new Map(Constants.STANDARD_ROWS,Constants.STANDARD_COLUMNS);
       Map[] maps = new Map[Constants.NUM_SCENES];
            
       InventoryItem[] itemList = createInventoryList();
       Scene[] scenes = new Scene[Constants.NUM_SCENES];
            
       //set the sizes for each map object
       GameControl.setMapSizes(maps);
       createScenes(maps, itemList, scenes); //create scenes in game

       return maps;
       //return rooms;
    }

    private static void assignScenesToLocations(Map map, Scene[] scenes)
    {
        /**********************************************************************
         * The standard map sizes are:
         * Columns = 20  Rows = 15
         * For every room each Scene needs to be assigned a location within the 
         * map. Only locations with an item, wall, or any other special object
         * need to be assigned a scene.
         * There are 11 different rooms in the game that each need to be assigned
         * Scenes.
         * To adjust or check to see what types of scenes need to be assigned to 
         * each location check the createScenes function below.
         **********************************************************************/
        Location[][] locations = map.getLocations();
        
        locations[0][0].setScene(scenes[Constants.CONSTRUCTION_SITE1]);
        locations[0][1].setScene(scenes[Constants.CONSTRUCTION_SITE2]);
    
        locations[1][0].setScene(scenes[Constants.AIRPORT1]);
        locations[1][1].setScene(scenes[Constants.AIRPORT2]);
        
        locations[2][0].setScene(scenes[Constants.SUPER_MARKET1]);
        locations[2][1].setScene(scenes[Constants.SUPER_MARKET2]);
        
        locations[3][0].setScene(scenes[Constants.SCHOOL1]);
        locations[3][1].setScene(scenes[Constants.SCHOOL2]);
        
        locations[4][0].setScene(scenes[Constants.MALL1]);
        locations[4][1].setScene(scenes[Constants.MALL2]);
        
        locations[5][0].setScene(scenes[Constants.LABORATORY]);

    }
    
    
    //List of inventory to be found in each scene
    private static Scene[] createScenes(Map[] maps, InventoryItem[] itemList, Scene[] scenes) {
     InventoryItem[] roomItemList = new InventoryItem[3];
    //cONSTRUCTION site#1   
     
    Location[][] locations = maps[Constants.CONSTRUCTION_SITE1].getLocations();
    Scene wall = new Scene(true, "x");
    Scene zombie = new Scene (false, "z");
    locations[0][0].setScene(wall);
    
    //create walls
    for (int y = 0; y < Constants.STANDARD_ROWS; y++){
       Scene temp = new Scene();
       temp.setBlocked(true);
       temp.setDescription("x");
    if (y != 6){ 
       locations [y][5].setScene(temp);
       }
    }
   
    locations[11][2].setScene(zombie);
    
    Zombie[] activeZombie = new Zombie [1];
    activeZombie[0] = new Zombie(11,2,Constants.CONSTRUCTION_SITE1,"A");
    maps[Constants.CONSTRUCTION_SITE1].setZombies(activeZombie);
    
    Scene exit = new Scene(false, "E");
    locations[10][10].setScene(exit);
    
    maps[Constants.CONSTRUCTION_SITE1].setLocations(locations);
    
    /*******************************************************************/
    Scene ConstructionSite2 = new Scene(true, "Construction Site #2");

    scenes[Constants.CONSTRUCTION_SITE2] = ConstructionSite2;
       
    locations = maps[Constants.CONSTRUCTION_SITE2].getLocations();
    wall = new Scene(true, "x");
    locations[0][0].setScene(wall);
       
    for (int y = 0; y < Constants.STANDARD_ROWS; y++){
       Scene temp = new Scene();
       temp.setBlocked(true);
       temp.setDescription("x");
    if (y != 6){ 
       locations [y][5].setScene(temp);
       }
    }
    
    //activeZombie[0] = new Zombie(11,2,Constants.CONSTRUCTION_SITE2,"A");
    maps[Constants.CONSTRUCTION_SITE2].setZombies(activeZombie);
      
    for (int x = 6; x < Constants.STANDARD_COLUMNS; x++){
        if (x != 10){
            locations[7][x].setScene(wall);
        }
    }
    
    locations[10][10].setScene(exit);
    
    maps[Constants.CONSTRUCTION_SITE2].setLocations(locations);
    
    /*******************************************************************/
    //Airport#1
    Scene Airport1 = new Scene(true, "Airport #1");
    roomItemList = new InventoryItem[3];
    roomItemList[0] = itemList[Constants.RIFLE];
    roomItemList[1] = itemList[Constants.FIRST_AID_KIT];
    roomItemList[2] = itemList[Constants.ASSAULT_RIFLE];

    scenes[Constants.AIRPORT1] = Airport1;
       
    locations = maps[Constants.AIRPORT1].getLocations();
    wall = new Scene(true, "x");
    locations[0][0].setScene(wall);
       
    for (int y = 0; y < Constants.STANDARD_ROWS; y++){
       Scene temp = new Scene();
       temp.setBlocked(true);
       temp.setDescription("x");
    if (y != 6){ 
       locations [y][5].setScene(temp);
       }
    }
    
    //activeZombie[0] = new Zombie(11,2,Constants.AIRPORT1,"A");
    maps[Constants.AIRPORT1].setZombies(activeZombie);
    
    for (int x = 6; x < Constants.STANDARD_COLUMNS; x++){
    if (x != 10){
        locations[7][x].setScene(wall);
        }
    }
    
    for (int y = 1; y < 7; y++){
        locations [y][9].setScene(wall);
    }
    
    locations[10][10].setScene(exit);
    
    maps[Constants.AIRPORT1].setLocations(locations);
    
    /**********************************************************/
    //Airport#2
    Scene Airport2 = new Scene(true, "Airport #2");
    roomItemList = new InventoryItem[3];
    roomItemList[0] = itemList[Constants.RIFLE];
    roomItemList[1] = itemList[Constants.FIRST_AID_KIT];
    roomItemList[2] = itemList[Constants.ASSAULT_RIFLE];

    scenes[Constants.AIRPORT2] = Airport2;
       
    locations = maps[Constants.AIRPORT2].getLocations();
    locations[0][0].setScene(wall);
          
    for (int y = 0; y < Constants.STANDARD_ROWS; y++){
       Scene temp = new Scene();
       temp.setBlocked(true);
       temp.setDescription("x");
    if (y != 6){ 
       locations [y][5].setScene(temp);
       }
    }
    
    //activeZombie[0] = new Zombie(11,2,Constants.AIRPORT2,"A");
    maps[Constants.AIRPORT2].setZombies(activeZombie);
    
    for (int x = 6; x < Constants.STANDARD_COLUMNS; x++){
    if (x != 10){
        locations[7][x].setScene(wall);
        }
    }
    
    for (int y = 1; y < 7; y++){
        locations [y][9].setScene(wall);
    }
    
    for (int x = 10; x < Constants.STANDARD_COLUMNS - 4; x++){
        locations [1][x].setScene(wall);
    }
    locations[10][10].setScene(exit);
    
    maps[Constants.AIRPORT2].setLocations(locations);
    
    /****************************************************************/
    //Supermartket#1
    Scene Supermarket1 = new Scene(true, "Supermarket #1");
    roomItemList = new InventoryItem[3];
    roomItemList[0] = itemList[Constants.RIFLE];
    roomItemList[1] = itemList[Constants.FIRST_AID_KIT];
    roomItemList[2] = itemList[Constants.ASSAULT_RIFLE];

    scenes[Constants.SUPER_MARKET1] = Supermarket1;
       
    locations = maps[Constants.SUPER_MARKET1].getLocations();
    wall = new Scene(true, "x");
    //locations[0][0].setScene(wall);
       
    GameControl.createSuperMarketScene(locations);
    
    //activeZombie[0] = new Zombie(11,2,Constants.SUPER_MARKET1,"A");
    maps[Constants.SUPER_MARKET1].setZombies(activeZombie);
  
    maps[Constants.SUPER_MARKET1].setLocations(locations);
    
    /******************************************************************/
    //Supermarket 2    
    Scene Supermarket2 = new Scene(true, "Supermarket #2");
    roomItemList = new InventoryItem[3];
    roomItemList[0] = itemList[Constants.RIFLE];
    roomItemList[1] = itemList[Constants.FIRST_AID_KIT];
    roomItemList[2] = itemList[Constants.ASSAULT_RIFLE];

    scenes[Constants.SUPER_MARKET2] = Supermarket2;
       
    locations = maps[Constants.SUPER_MARKET2].getLocations();
    wall = new Scene(true, "x");
    
    GameControl.createSuperMarketScene(locations);
    
    //activeZombie[0] = new Zombie(11,2,Constants.SUPER_MARKET2,"A");
    maps[Constants.SUPER_MARKET2].setZombies(activeZombie);
    
    for (int x = 1; x < 5; x++){  
       locations[5][x].setScene(wall);
    }
    
    maps[Constants.SUPER_MARKET2].setLocations(locations);
    
/*************************************************************************/    
    //School #1
    Scene School1 = new Scene(true, "School #1");
    roomItemList = new InventoryItem[3];
    roomItemList[0] = itemList[Constants.RIFLE];
    roomItemList[1] = itemList[Constants.FIRST_AID_KIT];
    roomItemList[2] = itemList[Constants.ASSAULT_RIFLE];

    scenes[Constants.SCHOOL1] = School1;
       
    locations = maps[Constants.SCHOOL1].getLocations();
    wall = new Scene(true, "x");
    
    GameControl.createSchoolScene(locations);
    
    //activeZombie[0] = new Zombie(11,2,Constants.SCHOOL1,"A");
    maps[Constants.SCHOOL1].setZombies(activeZombie);
    
    maps[Constants.SCHOOL1].setLocations(locations);
    
    /*************************************************************/
    //School #2
    Scene School2 = new Scene(true, "School #2");
    roomItemList = new InventoryItem[3];
    roomItemList[0] = itemList[Constants.RIFLE];
    roomItemList[1] = itemList[Constants.FIRST_AID_KIT];
    roomItemList[2] = itemList[Constants.ASSAULT_RIFLE];

    scenes[Constants.SCHOOL2] = School2;
       
    locations = maps[Constants.SCHOOL2].getLocations();
    
    GameControl.createSchoolScene(locations);
    
    //activeZombie[0] = new Zombie(11,2,Constants.SCHOOL2,"A");
    maps[Constants.SCHOOL2].setZombies(activeZombie);
    
    maps[Constants.SCHOOL2].setLocations(locations);
    
    /**************************************************************/
    //Mall #1   
    Scene Mall1 = new Scene(true, "Mall #1");
    roomItemList = new InventoryItem[3];
    roomItemList[0] = itemList[Constants.RIFLE];
    roomItemList[1] = itemList[Constants.FIRST_AID_KIT];
    roomItemList[2] = itemList[Constants.ASSAULT_RIFLE];

    scenes[Constants.MALL1] = Mall1;
       
    locations = maps[Constants.MALL1].getLocations();
    GameControl.createMallScene(locations);
    
    //activeZombie[0] = new Zombie(11,2,Constants.MALL1,"A");
    maps[Constants.MALL1].setZombies(activeZombie);
    
    maps[Constants.MALL1].setLocations(locations);
    
    /**************************************************************/
    //Mall #2
    Scene Mall2 = new Scene(true, "Mall #2");
    roomItemList = new InventoryItem[3];
    roomItemList[0] = itemList[Constants.RIFLE];
    roomItemList[1] = itemList[Constants.FIRST_AID_KIT];
    roomItemList[2] = itemList[Constants.ASSAULT_RIFLE];

    scenes[Constants.MALL2] = Mall2;
       
    locations = maps[Constants.MALL2].getLocations();
    
    //activeZombie[0] = new Zombie(11,2,Constants.MALL2,"A");
    maps[Constants.MALL2].setZombies(activeZombie);

    GameControl.createMallScene(locations);
    maps[Constants.MALL2].setLocations(locations);
    
    /********************************************************************/
    //Laboratory 
    Scene Laboratory = new Scene(true, "Laboratory");
    roomItemList = new InventoryItem[3];
    roomItemList[0] = itemList[Constants.RIFLE];
    roomItemList[1] = itemList[Constants.FIRST_AID_KIT];
    roomItemList[2] = itemList[Constants.ASSAULT_RIFLE];

    scenes[Constants.LABORATORY] = Laboratory;
       
    //activeZombie[0] = new Zombie(11,2,Constants.LABORATORY,"A");
    maps[Constants.LABORATORY].setZombies(activeZombie);
    
    locations = maps[Constants.LABORATORY].getLocations();
    GameControl.createLabScene(locations);
    maps[Constants.LABORATORY].setLocations(locations);
 
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

    private static void setMapSizes(Map[] rooms) {
        
        //for now this sets every room in the game to a set size. The code
        //will need to be adjusted if we want rooms of variable lengths.
        for (int i = 0; i < Constants.TOTAL_ROOMS; i++){
            Map temp = new Map(Constants.STANDARD_ROWS, Constants.STANDARD_COLUMNS);
            temp.setTotalColumns(Constants.STANDARD_COLUMNS);
            temp.setTotalRows(Constants.STANDARD_ROWS);
            
            rooms[i] = temp;
        }
    }

    private static void createSuperMarketScene(Location[][] locations) {
    
    Scene wall = new Scene(true, "x");
    Scene exit = new Scene(false, "E");
        
    for (int y = 0; y < Constants.STANDARD_ROWS; y++){
       Scene temp = new Scene();
       temp.setBlocked(true);
       temp.setDescription("x");
    if (y != 6){ 
       locations [y][5].setScene(temp);
       }
    }
    

    
    for (int x = 6; x < Constants.STANDARD_COLUMNS; x++){
    if (x != 10){
        locations[7][x].setScene(wall);
        }
    }
    
    for (int y = 1; y < 7; y++){
        locations [y][9].setScene(wall);
    }
    
    for (int x = 10; x < Constants.STANDARD_COLUMNS - 4; x++){
        locations [1][x].setScene(wall);
    }
    
    for (int x = 0; x < 5; x++){
       if (x != 4){
       locations[3][x].setScene(wall);
       }
    }
    
    locations[10][10].setScene(exit);
    }

    /********************************************************/
    private static void createSchoolScene(Location[][] locations) {
        Scene wall = new Scene(true, "x");
        Scene exit = new Scene(false, "E");
        
        for (int y = 0; y < Constants.STANDARD_ROWS; y++){
          Scene temp = new Scene();
          temp.setBlocked(true);
          temp.setDescription("x");
        if (y != 6){ 
          locations [y][5].setScene(temp);
          }
       } 
    
        for (int y = 0; y < Constants.STANDARD_ROWS; y++){
          Scene zombie = new Scene (false, "z");
          locations[y][18].setScene(zombie);
        }
    
        for (int x = 6; x < Constants.STANDARD_COLUMNS; x++){
           if (x != 10){
              locations[7][x].setScene(wall);
           }
        }
    
        for (int y = 1; y < 7; y++){
            locations [y][9].setScene(wall);
        }
    
        for (int x = 10; x < Constants.STANDARD_COLUMNS - 4; x++){
            locations [1][x].setScene(wall);
        }
        
        for (int x = 0; x < 5; x++){
            if (x != 4){
               locations[3][x].setScene(wall);
            }
        }
        
        for (int x = 1; x < 5; x++){  
           locations[5][x].setScene(wall);
        }
        
        locations[10][10].setScene(exit);
    }
    
    private static void createMallScene(Location[][] locations) {
        Scene wall = new Scene(true, "x");
        Scene exit = new Scene(false, "E");
        
        for (int y = 0; y < Constants.STANDARD_ROWS; y++){
          Scene temp = new Scene();
          temp.setBlocked(true);
          temp.setDescription("x");
        if (y != 6){ 
          locations [y][5].setScene(temp);
          }
        } 
    
        for (int y = 0; y < Constants.STANDARD_ROWS; y++){
          Scene zombie = new Scene (false, "z");
          locations[y][18].setScene(zombie);
        }
    
        for (int x = 6; x < Constants.STANDARD_COLUMNS; x++){
           if (x != 10){
              locations[7][x].setScene(wall);
           }
        }
    
        for (int y = 1; y < 7; y++){
            locations [y][9].setScene(wall);
        }
    
        for (int x = 10; x < Constants.STANDARD_COLUMNS - 4; x++){
            locations [1][x].setScene(wall);
        }
        
        for (int x = 0; x < 5; x++){
            if (x != 4){
               locations[3][x].setScene(wall);
            }
        }
        
        for (int x = 1; x < 5; x++){  
           locations[5][x].setScene(wall);
        }
        
        locations[10][10].setScene(exit);
    }
    
    private static void createLabScene(Location[][] locations) {
        Scene wall = new Scene(true, "x");
        Scene exit = new Scene(false, "E");
        
        for (int y = 0; y < Constants.STANDARD_ROWS; y++){
          Scene temp = new Scene();
          temp.setBlocked(true);
          temp.setDescription("x");
        if (y != 6){ 
          locations [y][5].setScene(temp);
          }
       } 
    
        for (int y = 0; y < Constants.STANDARD_ROWS; y++){
          Scene zombie = new Scene (false, "z");
          locations[y][18].setScene(zombie);
        }
    
        for (int x = 6; x < Constants.STANDARD_COLUMNS; x++){
           if (x != 10){
              locations[7][x].setScene(wall);
           }
        }
    
        for (int y = 1; y < 7; y++){
            locations [y][9].setScene(wall);
        }
    
        for (int x = 10; x < Constants.STANDARD_COLUMNS - 4; x++){
            locations [1][x].setScene(wall);
        }
        
        
        for (int x = 0; x < 5; x++){
            if (x != 4){
               locations[3][x].setScene(wall);
            }
        }
        
        for (int x = 1; x < 5; x++){  
           locations[5][x].setScene(wall);
        }
        Scene cure = new Scene(false, "C");
        locations[8][8].setScene(cure);
    }
    
}
