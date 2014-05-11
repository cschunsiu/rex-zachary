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
public class HealthItem implements Serializable {
    
    private String itemType;
    private double healthRestore;
    private String description;
    private String name;

    public HealthItem() {
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public double getHealthRestore() {
        return healthRestore;
    }

    public void setHealthRestore(double healthRestore) {
        this.healthRestore = healthRestore;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "HealthItem{" + "itemType=" + itemType + ", healthRestore=" + healthRestore + ", description=" + description + ", name=" + name + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.itemType);
        hash = 11 * hash + (int) (Double.doubleToLongBits(this.healthRestore) ^ (Double.doubleToLongBits(this.healthRestore) >>> 32));
        hash = 11 * hash + Objects.hashCode(this.description);
        hash = 11 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HealthItem other = (HealthItem) obj;
        if (!Objects.equals(this.itemType, other.itemType)) {
            return false;
        }
        if (Double.doubleToLongBits(this.healthRestore) != Double.doubleToLongBits(other.healthRestore)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }  
}
