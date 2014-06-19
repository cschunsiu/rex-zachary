/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.zombiesHunting.view;

import java.util.Scanner;

/**
 *
 * @author Computer
 */
public class LocationMenuView extends View{
    
    public LocationMenuView(){
        super("\n"
        + "\n-------------------------------------------"
        + "\n Location Menu                             |"
        + "\n-------------------------------------------"
        + "\nN - Next Location"
        + "\nC - Construction Site"
        + "\nA - Airport"
        + "\nU - SuperMarket"
        + "\nS - School"
        + "\nM - Mall"
        + "\nL - Laboratory"
        + "\nE - Stay Here"
        + "\n-------------------------------------------");
    }
    
    @Override
    public void doAction(String choice){
        
        switch (choice) {
            case "N": //Next Location
                System.out.println("\n*** You have chosen to move to new location***");
                break;
            case "C": //Construction Site
                System.out.println("\n*** You have moved to the Construction Site ***");
                break;
            case "A": //Airport
                System.out.println("\n*** You have moved to the Airport ***");
                break;
            case "U": //SuperMarket
                System.out.println("\n*** You have moved to the SuperMarket ***");
                break;
            case "S": //School
                System.out.println("\n*** You have moved to the School ***");
                break;
            case "M": //Mall
                System.out.println("\n*** You have moved to the Mall ***");
                break;
            case "L": //Laboratory
                System.out.println("\n*** You have moved to the Laboratory ***");
                break;
            case "E": //Stay Here
                return;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;            
        }
    }

    public void startNewGame(){
        System.out.println("\n*** called startNewGame function ***");
        
        //GameControl.createNewGame(ZombieHunting.getPlayer())
    }
}
