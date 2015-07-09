/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener{

    @Override
    //Set mouse event listeners
    public void mouseClicked(MouseEvent e) {
        if(STATE.State==STATE.MENU){
            //Set number of players based on which menu button was clicked
            if(Menu.onePlayer.contains(e.getX(),e.getY()))
                Game.setNumPlayers("1P");
            else if(Menu.twoPlayer.contains(e.getX(),e.getY()))
                Game.setNumPlayers("2P");
        }
        else if(STATE.State==STATE.INSTRUCTIONS){
            //Start the game
            if(Instructions.startGame.contains(e.getX(),e.getY()))
                STATE.State=STATE.GAME;
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
