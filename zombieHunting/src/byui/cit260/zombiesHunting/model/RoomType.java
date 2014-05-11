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
public class RoomType {
    private int numZombies;
    private String roomName;
    private String searchableFurniture;

    public RoomType() {
    }

    public int getNumZombies() {
        return numZombies;
    }

    public void setNumZombies(int numZombies) {
        this.numZombies = numZombies;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getSearchableFurniture() {
        return searchableFurniture;
    }

    public void setSearchableFurniture(String searchableFurniture) {
        this.searchableFurniture = searchableFurniture;
    }

    @Override
    public String toString() {
        return "RoomType{" + "numZombies=" + numZombies + ", roomName=" + roomName + ", searchableFurniture=" + searchableFurniture + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.numZombies;
        hash = 47 * hash + Objects.hashCode(this.roomName);
        hash = 47 * hash + Objects.hashCode(this.searchableFurniture);
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
        final RoomType other = (RoomType) obj;
        if (this.numZombies != other.numZombies) {
            return false;
        }
        if (!Objects.equals(this.roomName, other.roomName)) {
            return false;
        }
        if (!Objects.equals(this.searchableFurniture, other.searchableFurniture)) {
            return false;
        }
        return true;
    }
    
    
}
