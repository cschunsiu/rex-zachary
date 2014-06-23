/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.zombiesHunting.view;

/**
 *
 * @author ChunShing
 */
public class Construction extends View{
    
    public Construction(){
        super("\n"
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
                System.out.println("Move Up");
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
