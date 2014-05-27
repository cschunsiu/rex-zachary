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

    /**
     * Test of calcDamage method, of class ZombieControl.
     */
     @Test
    public void testCalcDamage() {
        /******************************
        * For Test cases #1, #2, #7 their
        * result will depend on whether the
        * zombie hits or misses. If the zombie 
        * misses, the function will return zero
        * for their damage dealt.
        *******************************/
        
        /*****************************
        * Test case #1 & #2
        * Test case # 1 = Zombie hits
        * Test case #2 = Zombie miss
        * If the Zombie's attack misses Then the function
        * should return 0.
        ******************************/
        System.out.println("\ncalcDamage");
        System.out.println("\tTest case #1 & #2");
        double attackPt = 10.0;
        double health = 90.0;
        ZombieControl instance = new ZombieControl();
        double expResult = 9.0;
        double otherResult = 0.0;
        double result = instance.calcDamage(attackPt, health);
        assert(result == otherResult || result == expResult);
        
        /**************
        * Test case #3
        ***************/
        System.out.println("\tTest case #3");
        attackPt = -1.0;
        health = 90.0;
        instance = new ZombieControl();
        expResult = -1;
        result = instance.calcDamage(attackPt, health);
        assertEquals(expResult, result, 0.0);
        
        /**************
        * Test case #4
        ***************/
        System.out.println("\tTest case #4");
        attackPt = 10;
        health = -1;
        instance = new ZombieControl();
        expResult = -1;
        result = instance.calcDamage(attackPt, health);
        assertEquals(expResult, result, 0.0);
        
        /**************
        * Test case #5
        ***************/
        System.out.println("\tTest case #5");
        attackPt = 10;
        health = 0;
        instance = new ZombieControl();
        expResult = 0;
        result = instance.calcDamage(attackPt, health);
        assertEquals(expResult, result, 0.0);
        
        /**************
        * Test case #6
        ***************/
        System.out.println("\tTest case #6");
        attackPt = 0;
        health = 90;
        instance = new ZombieControl();
        expResult = 0;
        result = instance.calcDamage(attackPt, health);
        assertEquals(expResult, result, 0.0);

        /**************
        * Test case #7
        ***************/
        System.out.println("\tTest case #7");
        attackPt = 10;
        health = 100;
        instance = new ZombieControl();
        expResult = 10;
        otherResult = 0;
        result = instance.calcDamage(attackPt, health);
        assert(result == expResult || result == otherResult);
    }

}
