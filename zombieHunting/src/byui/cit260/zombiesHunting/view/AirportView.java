/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.zombiesHunting.view;

import byui.cit260.zombiesHunting.control.PlayerControl;

/**
 *
 * @author Computer
 */
public class AirportView extends View{


    
    public AirportView(){
        super("\n"
        + "\n                Airport                    "
        + "\n-------------------------------------------"
        + "\n Move                                      |"
        + "\n-------------------------------------------"
        + "\nW - Up"
        + "\nS - Down"
        + "\nA - Left"
        + "\nD - Right"
        + "\nP - Pick up item"
        + "\nE - Back"
        + "\n-------------------------------------------");
     }
    
    @Override
    public void doAction(String choice){
        
        switch (choice){
            case "W": 
                PlayerControl.movePlayer("U");
                break;
            case "S": 
                System.out.println("Move Down");
                break;
            case "A": 
                System.out.println("Move Left");
                break;
            case "D": 
                System.out.println("Move Right");
                break;
            case "P": 
                System.out.println("Pick up item");
                break;
            case "E": 
                return;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;            
        }
    }
}