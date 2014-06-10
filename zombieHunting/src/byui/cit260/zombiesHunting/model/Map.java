/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.zombiesHunting.model;

import java.io.Serializable;

/**
 *
 * @author ChunShing
 */
public class Map implements Serializable{
    
    //private String compass;
    //private double totalZombies;
    private double totalColumns;
    private double totalRows;
    private Location[][] locations;

    public Location[][] getLocations() {
        return locations;
    }

    public void setLocations(Location[][] locations) {
        this.locations = locations;
    }

    public Map() {
    }
    
    public Map(int numRows, int numColumns){
        
        
        
        if (numRows < 1 || numColumns < 1){
            System.out.println("The number of rows and columns must be > zero");
            return;
        }
        this.totalRows = numRows;
        this.totalColumns = numColumns;
        
        this.locations = new Location[numRows][numColumns];
        //this.locations = new Location;
        
        for (int row = 0; row < Constants.MAP_ROW_COUNT; row++){
           for (int column = 0; column < Constants.MAP_COLUMN_COUNT; column++){
               
               //create and initialize new Location object instance
               Location location = new Location();
               location.setColumn(column);
               location.setRow(row);
               
               //assign the Location object to the current position in array
               locations[row][column] = location;
           }
        }
    }

    public double getTotalColumns() {
        return totalColumns;
    }

    public void setTotalColumns(double totalColumns) {
        this.totalColumns = totalColumns;
    }

    public double getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(double totalRows) {
        this.totalRows = totalRows;
    }

}
