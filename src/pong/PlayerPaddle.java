/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.Graphics;
import java.awt.Rectangle;


public class PlayerPaddle {
    private int yPos, dy=0;
    private final int xPos;
    protected final int MAX_Y=200, PADDLE_WIDTH=10, PADDLE_HEIGHT=50;
    
    public PlayerPaddle(int x){
        xPos=x;
        yPos=75;
    }  
    
    //If paddle is within game bounds allow it to move
    public void move(){
        if((yPos+PADDLE_HEIGHT<=MAX_Y&&dy>0)||(yPos>=0&&dy<0))
        yPos+=dy;
    }
    
    public void setdy(int dy){
        this.dy=dy;
    }
    
    public void sety(int y){
        yPos=y;
    }
    
    public int getdy(){
        return dy;
    }
    
    public Rectangle getBounds(){
        return new Rectangle(xPos, (int) yPos, PADDLE_WIDTH, PADDLE_HEIGHT);
    }
    
    public void render(Graphics g){
        g.fillRect(xPos, (int) yPos, PADDLE_WIDTH, PADDLE_HEIGHT);
    }
}
