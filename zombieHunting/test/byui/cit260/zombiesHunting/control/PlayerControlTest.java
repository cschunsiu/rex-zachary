/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.zombiesHunting.control;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ChunShing
 */
public class PlayerControlTest {
    
    public PlayerControlTest() {
    }

    /**
     * Test of calcAccuracy method, of class PlayerControl.
     */
    @Test
    public void testCalcAccuracy() {
        System.out.println("calcAccuracy");
        /**
         * *Test#1***
         */
        System.out.println("\tTest case #1");
        double ammo = 100.0;
        double hittingAmmo = 80.0;
        PlayerControl instance = new PlayerControl();
        double expResult = 0.8;
        double result = instance.calcAccuracy(ammo, hittingAmmo);
        assertEquals(expResult, result, 0.0001);
        // TODO review the generated test code and remove the default call to fail.
        
        /**
         * *Test#2***
         */
        System.out.println("\tTest case #2");
        ammo = 60.0;
        hittingAmmo = 40.0;
        instance = new PlayerControl();
        expResult = 0.6667;
        result = instance.calcAccuracy(ammo, hittingAmmo);
        assertEquals(expResult, result, 0.0001);
        // TODO review the generated test code and remove the default call to fail.
        
        
        /**
         * *Test#3***
         */
        System.out.println("\tTest case #3");
        ammo = 80.0;
        hittingAmmo = 100.0;
        instance = new PlayerControl();
        expResult = 1.0;
        result = instance.calcAccuracy(ammo, hittingAmmo);
        assertEquals(expResult, result, 0.0001);
        // TODO review the generated test code and remove the default call to fail.
        
                /**
         * *Test#4***
         */
        System.out.println("\tTest case #4");
        ammo = 10.0;
        hittingAmmo = 80.0;
        instance = new PlayerControl();
        expResult = 1.0;
        result = instance.calcAccuracy(ammo, hittingAmmo);
        assertEquals(expResult, result, 0.0001);
        // TODO review the generated test code and remove the default call to fail.
        
                /**
         * *Test#5***
         */
        System.out.println("\tTest case #5");
        ammo = 0.0;
        hittingAmmo = 10.0;
        instance = new PlayerControl();
        expResult = 1.0;
        result = instance.calcAccuracy(ammo, hittingAmmo);
        assertEquals(expResult, result, 0.0001);
        // TODO review the generated test code and remove the default call to fail.
        
                /**
         * *Test#6***
         */
        System.out.println("\tTest case #6");
        ammo = 10.0;
        hittingAmmo = 0.0;
        instance = new PlayerControl();
        expResult = 0.0;
        result = instance.calcAccuracy(ammo, hittingAmmo);
        assertEquals(expResult, result, 0.0001);
        // TODO review the generated test code and remove the default call to fail.
        
                /**
         * *Test#7***
         */
        System.out.println("\tTest case #7");
        ammo = 200.0;
        hittingAmmo = 0.0;
        instance = new PlayerControl();
        expResult = 0.0;
        result = instance.calcAccuracy(ammo, hittingAmmo);
        assertEquals(expResult, result, 0.0001);
        // TODO review the generated test code and remove the default call to fail.      
    }
    
}
