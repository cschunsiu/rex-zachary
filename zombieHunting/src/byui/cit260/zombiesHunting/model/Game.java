/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.zombiesHunting.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author ChunShing
 */
public class Game implements Serializable{
    
    private String bestTime;
    private double bestZombieKill;
    private WeaponItem[] inventoryWeapons;
    private Zombie[] zombies;
    private HealthItem[] healthItems;
    private Map[] gameMaps; //need a map for every scene
    private Player player;
    private InventoryItem[] inventory;

    public Game() {
    }

    public Map[] getGameMaps() {
        return gameMaps;
    }

    public void setGameMaps(Map[] gameMaps) {
        this.gameMaps = gameMaps;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public WeaponItem[] getInventoryWeapons() {
        return inventoryWeapons;
    }

    public void setInventoryWeapons(WeaponItem[] inventoryWeapons) {
        this.inventoryWeapons = inventoryWeapons;
    }

    public Zombie[] getZombies() {
        return zombies;
    }

    public void setZombies(Zombie[] zombies) {
        this.zombies = zombies;
    }

    public HealthItem[] getHealthItems() {
        return healthItems;
    }

    public void setHealthItems(HealthItem[] healthItems) {
        this.healthItems = healthItems;
    }
    
    public InventoryItem[] getInventory() {
        return inventory;
    }

    public void setInventory(InventoryItem[] inventory) {
        this.inventory = inventory;
    }


}