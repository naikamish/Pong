/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.Graphics;

public class ComputerPaddle extends PlayerPaddle{
    Ball ball;
    
    public ComputerPaddle(int x, Ball b){
        super(x);
        ball=b;
    }
    
    @Override
    public void move(){
        //Find the center y value of the ball and the center of the paddle
        int ballCenter=ball.getBounds().y+ball.getBounds().height/2;
        int paddleCenter=this.getBounds().y+this.getBounds().height/2;
        
        //If the ball is moving away from the computer, move the computer paddle to the center of the game board
        if(ball.getdx()<0){
            if(paddleCenter>ballCenter)
                this.setdy(-1);
            else if(paddleCenter<ballCenter)
                this.setdy(1);
            else
                this.setdy(0);
        }
        
        //If the ball is moving towards the computer, move the center of the computer paddle
            //towards the center of the ball
        else{
            if(paddleCenter>100)
                this.setdy(-1);
            else if(paddleCenter<100)
                this.setdy(1);
            else
                this.setdy(0);
        }
        if((this.getBounds().y+PADDLE_HEIGHT<=MAX_Y&&this.getdy()>0)||(this.getBounds().y>=0&&this.getdy()<0))
            this.sety(this.getBounds().y+=this.getdy());
    }
    
    
    
}
