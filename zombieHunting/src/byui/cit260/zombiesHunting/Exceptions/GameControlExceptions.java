/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.zombiesHunting.Exceptions;

/**
 *
 * @author Computer
 */
public class GameControlExceptions extends Exception{

    public GameControlExceptions() {
    }
        
    public GameControlExceptions(String message){
        super(message);
    }
    
    public GameControlExceptions(Throwable cause) {
        super(cause);
    }
    
    public GameControlExceptions(String message, Throwable cause) {
        super(message, cause);
    }
}
