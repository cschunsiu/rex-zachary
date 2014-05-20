/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.zombiesHunting.control;

/**
 *
 * @author ChunShing
 */
public class ZombieControl {
    public double calcMovementSpeed(double movementSpeed, double health){
        if (movementSpeed<0){
            return -1;
        }
        if (health <0){
            return -1;
        }
        double modifiedSpeed = movementSpeed*(health/100);
        return modifiedSpeed;
    }
    
}
