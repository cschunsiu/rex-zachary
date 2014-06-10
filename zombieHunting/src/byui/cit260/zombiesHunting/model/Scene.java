/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.zombiesHunting.model;

import java.util.Objects;

/**
 *
 * @author Zach
 */
public class Scene {
    private boolean wall; //can player pass through?
    private InventoryItem[] items; 
    private String description;
    
    //private String itemList;
    //private int itemLocation;
    //private String roomMap;

    //create overloaded constructor 
    public Scene() {
    }

    public Scene(boolean wall, String description) {
        this.wall = wall;
        this.description = description;
    }

    
    public boolean isWall() {
        return wall;
    }

    public void setWall(boolean wall) {
        this.wall = wall;
    }

    public InventoryItem[] getItems() {
        return items;
    }

    public void setItems(InventoryItem[] items) {
        this.items = items;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
        
}
