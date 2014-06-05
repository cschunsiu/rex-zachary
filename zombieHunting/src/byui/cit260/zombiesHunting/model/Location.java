/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.zombiesHunting.model;

import java.io.Serializable;

/**
 *
 * @author Zach
 */
public class Location implements Serializable{
    private String requiredItems;
    //private int coordinates;
    private int row;
    private int column;
    
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public Location() {
    }

    public String getRequiredItems() {
        return requiredItems;
    }

    public void setRequiredItems(String requiredItems) {
        this.requiredItems = requiredItems;
    }
     
}
