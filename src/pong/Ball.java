/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File;
import java.util.Random;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Ball {
    private int xPos, dx;
    private double yPos, dy;
    private final int MAX_Y=200, BALL_WIDTH=10, BALL_HEIGHT=10;
    private final Random random;
    private File bounce = new File("./res/Blip_Select2.wav");
    
    public Ball(){
        random = new Random();
        dy=0;
        
        //Set the ball to move either left or right randomly
        dx=5*(random.nextInt(2)*2-1);
        xPos=200; yPos=MAX_Y/2;
    }
    
    public void move(){
        //Change direction if ball hits a wall
        if(yPos+10>=MAX_Y||yPos<=0){
            dy*=-1;
            playSound(bounce);
        }
        
        xPos+=dx;
        yPos+=dy;
    }
    
    public void changeDirection(double dy){
        //Change direction if ball hits a paddle and change angle that ball travels
        dx*=-1;
        this.dy=dy;
        playSound(bounce);
    }
    
    public int getdx(){
        return dx;
    }
    
    //Reset the position of the ball to the center after a player scores
    public void reset(){
        dy=0;
        dx=5*(random.nextInt(2)*2-1);
        xPos=200; yPos=MAX_Y/2;
    }
    
    private void playSound(File sound){
        try{
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(sound));
            clip.start();
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    public Rectangle getBounds(){
        return new Rectangle(xPos, (int) yPos, BALL_WIDTH, BALL_HEIGHT);
    }
    
    public void render(Graphics g){
        g.fillRect(xPos, (int) yPos, BALL_WIDTH, BALL_HEIGHT);
    }
}
