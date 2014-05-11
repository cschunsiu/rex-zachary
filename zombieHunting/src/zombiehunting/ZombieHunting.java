/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zombiehunting;

import byui.cit260.zombiesHunting.model.Game;
import byui.cit260.zombiesHunting.model.HealthItem;
import byui.cit260.zombiesHunting.model.Location;
import byui.cit260.zombiesHunting.model.Map;
import byui.cit260.zombiesHunting.model.Player;
import byui.cit260.zombiesHunting.model.RoomLocation;
import byui.cit260.zombiesHunting.model.RoomType;
import byui.cit260.zombiesHunting.model.WeaponItem;
import byui.cit260.zombiesHunting.model.Zombie;

/**
 *
 * @author ChunShing
 */
public class ZombieHunting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    //This section of code tests the Player class
    //It has been tested and it works
        Player playerOne = new Player();
        Game gameOne = new Game();
        WeaponItem weaponItemOne = new WeaponItem();
        HealthItem healthItemOne = new HealthItem();
        Map mapOne = new Map();
        
        mapOne.setDestination("Mall");
        mapOne.setCompass("North,East,South,West");
        mapOne.setTotalZombies(100);
        mapOne.setTotalColumns(200);
        mapOne.setTotalRows(100);
        
        healthItemOne.setItemType("potion");
        healthItemOne.setHealthRestore(100);
        healthItemOne.setDescription("Use to restore health");
        healthItemOne.setName("Ibuprofen");
        
        playerOne.setName("Bill");
        playerOne.setHealth(10.00);
        
        gameOne.setBestTime("1:00");
        gameOne.setBestZombieKill(200);
        
        weaponItemOne.setWeaponType("shotgun");
        weaponItemOne.setDamage(100);
        weaponItemOne.setReloadSpeed(0.5);
        weaponItemOne.setDescription("APK200");
        
        String mapInfo = mapOne.toString();
        System.out.println(mapInfo);
        
        String healthItemInfo = healthItemOne.toString();
        System.out.println(healthItemInfo);
        
        String weaponItemInfo = weaponItemOne.toString();
        System.out.println(weaponItemInfo);
        
        String gameInfo = gameOne.toString();
        System.out.println(gameInfo);
        
        String playerInfo = playerOne.toString();
        System.out.println(playerInfo);
        
    //This section of code tests the Zombie class
    //tested
        Zombie testZombie = new Zombie();
        
        testZombie.setZombieType("Normal");
        testZombie.setAttackPt(10);
        testZombie.setSpeed(5);
        
        String zombieInfo = testZombie.toString();
        System.out.println(testZombie);
        
    //This section of code tests the Location class
        Location locationTest = new Location();
        
        locationTest.setRequiredItems("Key");
        locationTest.setCoordinates(64);
        
        String locationInfo = locationTest.toString();
        System.out.println(locationInfo);
        
    //This section of code tests the RoomLocation class
        RoomLocation roomLocationTest = new RoomLocation();
        
        roomLocationTest.setItemList("guns");
        roomLocationTest.setItemLocation(64);
        roomLocationTest.setRoomMap("kitchen");
        
        String roomLocationInfo = roomLocationTest.toString();
        System.out.println(roomLocationInfo);
        
    //This section of code tests the RoomType class
        RoomType roomTypeTest = new RoomType();
        
        roomTypeTest.setNumZombies(5);
        roomTypeTest.setRoomName("Main kitchen");
        roomTypeTest.setSearchableFurniture("pantry");
        
        String roomTypeInfo = roomTypeTest.toString();
        System.out.println(roomTypeInfo);
    }
}
