/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;


//Create game states for main menu, instructions, and the game itself
public enum STATE {
    MENU, INSTRUCTIONS, GAME;
    public static STATE State = STATE.MENU;
}
