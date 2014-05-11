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
    
    private String destination;
    private String compass;
    private double totalZombies;
    private double totalColumns;
    private double totalRows;

    public Map() {
    }

    @Override
    public String toString() {
        return "Map{" + "destination=" + destination + ", compass=" + compass + ", totalZombies=" + totalZombies + ", totalColumns=" + totalColumns + ", totalRows=" + totalRows + '}';
    }
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getCompass() {
        return compass;
    }

    public void setCompass(String compass) {
        this.compass = compass;
    }

    public double getTotalZombies() {
        return totalZombies;
    }

    public void setTotalZombies(double totalZombies) {
        this.totalZombies = totalZombies;
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
