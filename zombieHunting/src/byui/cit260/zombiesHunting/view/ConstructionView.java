/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.zombiesHunting.view;

import byui.cit260.zombiesHunting.control.PlayerControl;
import byui.cit260.zombiesHunting.model.Game;
import zombiehunting.ZombieHunting;

/**
 *
 * @author ChunShing
 */
public class ConstructionView extends View{
      
    public ConstructionView(){
        super("\n"
        + "\n            Construction Yard              "
        + "\n-------------------------------------------"
        + "\n Move                                      |"
        + "\n-------------------------------------------"
        + "\nW - Up"
        + "\nS - Down"
        + "\nA - Left"
        + "\nD - Right"
        + "\nG - Pick up item"
        + "\nE - Exit"
        + "\n-------------------------------------------");
     }
    

    
    @Override
    public void doAction(String choice){
        
        switch (choice){
            case "W":
                PlayerControl.movePlayer("W");
                break;
            case "S": 
                PlayerControl.movePlayer("S");
                break;
            case "A": 
                PlayerControl.movePlayer("A");
                break;
            case "D": 
                PlayerControl.movePlayer("D");
                break;
            case "G": 
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
