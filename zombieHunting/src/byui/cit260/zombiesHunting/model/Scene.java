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
    private boolean blocked; //can player pass through?
    private InventoryItem item;
    //private InventoryItem[] items; 
    private String description; //text to represent the scene.
    
   
    public Scene() {
        blocked = false;
        description = " ";
    }
    
    //create overloaded constructor
    public Scene(boolean blocked, String description) {
        this.blocked = blocked;
        this.description = description;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public InventoryItem getItem() {
        return item;
    }

    public void setItem(InventoryItem item) {
        this.item = item;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
        
}
