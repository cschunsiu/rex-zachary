/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.zombiesHunting.control;

import byui.cit260.zombiesHunting.model.WeaponItem;

/**
 *
 * @author ChunShing
 */
public class PlayerControl {
    public double calcAccuracy(double ammo, double hittingAmmo){
    
        if (ammo < hittingAmmo){
            return 1;
        }    
        double accuracy = hittingAmmo/ammo;
        return accuracy;
    }
}
