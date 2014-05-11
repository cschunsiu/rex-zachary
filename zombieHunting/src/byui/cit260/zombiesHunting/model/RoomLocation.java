/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.zombiesHunting.model;

import java.util.Objects;

/**
 *
 * @author Computer
 */
public class RoomLocation {
    private String itemList;
    private int itemLocation;
    private String roomMap;

    public RoomLocation() {
    }
        
    public String getItemList() {
        return itemList;
    }

    public void setItemList(String itemList) {
        this.itemList = itemList;
    }

    public int getItemLocation() {
        return itemLocation;
    }

    public void setItemLocation(int itemLocation) {
        this.itemLocation = itemLocation;
    }

    public String getRoomMap() {
        return roomMap;
    }

    public void setRoomMap(String roomMap) {
        this.roomMap = roomMap;
    }

    @Override
    public String toString() {
        return "RoomLocation{" + "itemList=" + itemList + ", itemLocation=" + itemLocation + ", roomMap=" + roomMap + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.itemList);
        hash = 79 * hash + this.itemLocation;
        hash = 79 * hash + Objects.hashCode(this.roomMap);
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
        final RoomLocation other = (RoomLocation) obj;
        if (!Objects.equals(this.itemList, other.itemList)) {
            return false;
        }
        if (this.itemLocation != other.itemLocation) {
            return false;
        }
        if (!Objects.equals(this.roomMap, other.roomMap)) {
            return false;
        }
        return true;
    }
    
}
