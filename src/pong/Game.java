/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;


public class Game extends JPanel implements ActionListener{
    
    
    
    
    
    private final Menu menu;
    private final Instructions instructions;
    private static Timer timer;
    private static Ball ball;
    private static PlayerPaddle player1, player2;
    public final static int GAME_WIDTH=400, GAME_HEIGHT=200;
    private static int player1Score, player2Score;
    private final Font scoreFont = new Font("TimesRoman", Font.PLAIN, 30);
    
    
    public Game(){
        setBackground(Color.BLACK);
        timer = new Timer(15 ,this);
        timer.start();
        
        instructions=new Instructions();
        menu=new Menu();
        
        //Set key bindings for key presses
        getInputMap().put(KeyStroke.getKeyStroke("UP"), "Player 1 Up");
        getActionMap().put("Player 1 Up", new KeyAction("UP"));
        
        getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "Player 1 Down");
        getActionMap().put("Player 1 Down", new KeyAction("DOWN"));
        
        getInputMap().put(KeyStroke.getKeyStroke("W"), "Player 2 Up");
        getActionMap().put("Player 2 Up", new KeyAction("W"));
        
        getInputMap().put(KeyStroke.getKeyStroke("S"), "Player 2 Down");
        getActionMap().put("Player 2 Down", new KeyAction("S"));
        
        //Set key bindings for key releases
        getInputMap().put(KeyStroke.getKeyStroke("released UP"), "Player 1 Up Released");
        getActionMap().put("Player 1 Up Released", new KeyAction("released UP"));
        
        getInputMap().put(KeyStroke.getKeyStroke("released DOWN"), "Player 1 Down Released");
        getActionMap().put("Player 1 Down Released", new KeyAction("released DOWN"));
        
        getInputMap().put(KeyStroke.getKeyStroke("released W"), "Player 2 Up Released");
        getActionMap().put("Player 2 Up Released", new KeyAction("released W"));
        
        getInputMap().put(KeyStroke.getKeyStroke("released S"), "Player 2 Down Released");
        getActionMap().put("Player 2 Down Released", new KeyAction("released S"));
        
        getInputMap().put(KeyStroke.getKeyStroke("P"), "Pause");
        getActionMap().put("Pause", new KeyAction("P"));
        
        getInputMap().put(KeyStroke.getKeyStroke("R"), "Restart");
        getActionMap().put("Restart", new KeyAction("R"));
        
        this.addMouseListener(new MouseInput());        
    }
    
    //Move the ball and paddles when the timer ticks. Also check if the ball hit a paddle
    //and if a player scored
    public void move(){
        ball.move();
        player1.move();
        player2.move();
        checkCollision();
        checkPointScored();
    }
    
    //Check if the ball hit a paddle
    public void checkCollision(){
        double strikePosition;
        //Check if ball intersects either paddle
        if(ball.getBounds().intersects(player1.getBounds())||ball.getBounds().intersects(player2.getBounds())){
            //If ball intersects the left paddle change ball's direction based on where it hit the paddle
            if(ball.getBounds().intersects(player1.getBounds()))
                strikePosition=ball.getBounds().y+ball.getBounds().height/2-(player1.getBounds().y+player1.getBounds().height/2);
            //If ball intersects the right paddle change ball's direction based on where it hit the paddle
            else
                strikePosition=ball.getBounds().y+ball.getBounds().height/2-(player2.getBounds().y+player2.getBounds().height/2);
            strikePosition=2*Math.sin((strikePosition/25)*75*Math.PI/180);
            ball.changeDirection(strikePosition);
            //Move the ball a second time to prevent it from getting stuck in a paddle
            ball.move();
        }
    }
    
    //If the ball goes beyond the games x bounds then check to see which player scored
    public void checkPointScored(){
        if(ball.getBounds().x<-50||ball.getBounds().x>450){
            if(ball.getBounds().x<-50)
                player2Score++;
            else
                player1Score++;
            ball.reset();
        }
    }
    
    //Set the number of players based on which menu button was clicked
    public static void setNumPlayers(String numPlayers){
        ball = new Ball();
        player2=new PlayerPaddle(390);
        player1Score=0;
        player2Score=0;
        
        //If number of players is one, create a computer player
        if(numPlayers=="1P"){
            player1=new ComputerPaddle(0, ball);
        }
        else if(numPlayers=="2P"){
            player1=new PlayerPaddle(0);
        }
        
        //Show instructions
        STATE.State=STATE.INSTRUCTIONS;
    }
    
    
    
    //Render game board
    private void render(Graphics g){
        g.drawLine(200,0,200,200);
        g.setFont(scoreFont);
        g.drawString(""+player1Score,150,30);
        g.drawString(""+player2Score,240,30);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        //If state is menu, render menu
        //If state is instructions, render instructions
        //If state is game, render the game
        if(STATE.State==STATE.GAME){
            this.render(g);
            ball.render(g);
            player1.render(g);
            player2.render(g);
        }
        
        else if(STATE.State==STATE.INSTRUCTIONS){
            instructions.render(g);
        }
        
        else if(STATE.State==STATE.MENU){
            menu.render(g);
        }
    }
    
    //Implement timer ticks
    @Override
    public void actionPerformed(ActionEvent e){
        if(STATE.State==STATE.GAME)
            this.move();
        repaint();
    }
    
    //Implement key bindings
    private class KeyAction extends AbstractAction{
        private String keyPressed;
        public KeyAction(String key){
            keyPressed=key;
        }
        
        @Override
        public void actionPerformed(ActionEvent e){
            if(STATE.State==STATE.GAME){
                switch (keyPressed) {
                    case "UP":
                        player2.setdy(-3);
                        break;
                        
                    case "DOWN":
                        player2.setdy(3);
                        break;
                        
                    case "W":
                        player1.setdy(-3);
                        break;
                        
                    case "S":
                        player1.setdy(3);
                        break;
                        
                    case "P":
                        if(timer.isRunning())
                            timer.stop();
                        else
                            timer.restart();
                        break;
                        
                    case "R":
                        STATE.State=STATE.MENU;
                        
                    case "released UP":
                    case "released DOWN":
                        player2.setdy(0);
                        break;
                    case "released W":
                    case "released S":
                        player1.setdy(0);
                        break;
                }
            }
        }
    }
}
