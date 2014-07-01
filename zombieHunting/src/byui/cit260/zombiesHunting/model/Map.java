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
    
    //private int totalZombies;
    private int totalColumns;
    private int totalRows;
    private int numScenes = 0;
    private Scene[] scenes;
    private Location[][] locations; //one for every square on the map.

    public Location[][] getLocations() {
        return locations;
    }

    public void displayMap(){
        //display top border
        System.out.println("_________________________________________");
        
        for (int row = 0; row < totalRows; row++ ){
            for (int column = 0; column < totalColumns; column++){
                System.out.print("|"); //row divider
                Scene temp = locations[row][column].getScene();
                
                if (temp == null){
                   Scene square = new Scene();
                   locations[row][column].setScene(square);
                   System.out.print(square.getDescription());
                }
                else{
                    System.out.print(temp.getDescription());
                }
         
                               
            }
            System.out.println("|");
        }
        
        //print bottom border
        System.out.println("-----------------------------------------");
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
        
        for (int row = 0; row < numRows; row++){
           for (int column = 0; column < numColumns; column++){
               
               //create and initialize new Location object instance
               Location location = new Location();
               location.setColumn(column);
               location.setRow(row);
               
               //assign the Location object to the current position in array
               locations[row][column] = location;
           }
        }
        
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public void setTotalColumns(int totalColumns) {
        this.totalColumns = totalColumns;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getNumScenes() {
        return numScenes;
    }

    public void setNumScenes(int numScenes) {
        this.numScenes = numScenes;
    }

    public Scene[] getScenes() {
        return scenes;
    }

    public void setScenes(Scene[] scenes) {
        this.scenes = scenes;
    }
}
