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
 * @author Zach
 */
public class Location implements Serializable{
    private String requiredItems;
    private int coordinates;

    public Location() {
    }

    public String getRequiredItems() {
        return requiredItems;
    }

    public void setRequiredItems(String requiredItems) {
        this.requiredItems = requiredItems;
    }

    public int getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "Location{" + "requiredItems=" + requiredItems + ", coordinates=" + coordinates + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.requiredItems);
        hash = 29 * hash + this.coordinates;
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
        final Location other = (Location) obj;
        if (!Objects.equals(this.requiredItems, other.requiredItems)) {
            return false;
        }
        if (this.coordinates != other.coordinates) {
            return false;
        }
        return true;
    }
    
    
}
