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
public class ZombieControlTest {

    public ZombieControlTest() {
    }

    /**
     * Test of calcMovementSpeed method, of class ZombieControl.
     */
    @Test
    public void testCalcMovementSpeed() {
        System.out.println("calcMovementSpeed");

        /**
         * ******************
         * Test case#1
         */
        System.out.println("\tTest case #1");

        double movementSpeed = 10.0;
        double health = 90.0;

        double expResult = 9.0;

        ZombieControl instance = new ZombieControl();

        double result = instance.calcMovementSpeed(movementSpeed, health);

        assertEquals(expResult, result, 0.0001);
        // TODO review the generated test code and remove the default call to fail.
    /**
     * ******************
     * Test case#2
     */
  
        System.out.println("\tTest case #2");
        movementSpeed = -1.0;
        health = 90.0;

        expResult = -1.0;

        instance = new ZombieControl();

        result = instance.calcMovementSpeed(movementSpeed, health);

        assertEquals(expResult, result, 0.0001);
        // TODO review the generated test code and remove the default call to fail.

        /**
         * ******************
         * Test case#3
         */
        System.out.println("\tTest case #3");
        movementSpeed = 10.0;
        health = -1.0;

        expResult = -1.0;

        instance = new ZombieControl();

        result = instance.calcMovementSpeed(movementSpeed, health);

        assertEquals(expResult, result, 0.0001);
        // TODO review the generated test code and remove the default call to fail.

        /**
         * ******************
         * Test case#4
         */
        System.out.println("\tTest case #4");
        movementSpeed = 10.0;
        health = 0.0;

        expResult = 0.0;

        instance = new ZombieControl();

        result = instance.calcMovementSpeed(movementSpeed, health);

        assertEquals(expResult, result, 0.0001);
        // TODO review the generated test code and remove the default call to fail.
       

        /**
         * ******************
         * Test case#5
         */
        System.out.println("\tTest case #5");
        movementSpeed = 0.0;
        health = 90.0;

        expResult = 0.0;

        instance = new ZombieControl();

        result = instance.calcMovementSpeed(movementSpeed, health);

        assertEquals(expResult, result, 0.0001);
        // TODO review the generated test code and remove the default call to fail.

        /**
         * ******************
         * Test case#6
         */
        System.out.println("\tTest case #6");
        movementSpeed = 10.0;
        health = 100.0;

        expResult = 10.0;

        instance = new ZombieControl();

       result = instance.calcMovementSpeed(movementSpeed, health);

        assertEquals(expResult, result, 0.0001);
        // TODO review the generated test code and remove the default call to fail.
    }

}
