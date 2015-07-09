/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Instructions {
    public static Rectangle startGame = new Rectangle(270,165,120,30);
    
    public void render(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        Font titleFont = new Font("TimesRoman", Font.BOLD, 40);
        g.setFont(titleFont);
        g.setColor(Color.WHITE);
        g.drawString("INSTRUCTIONS", 60, 47);
        
        Font textFont = new Font("TimesRoman", Font.BOLD, 20);
        g.setFont(textFont);
        g.drawString("Player 1", 20, 95);
        g.drawString("Player 2", 280, 95);
        
        g2d.draw(startGame);
        g.drawString("Start Game", 277,188);
        
        Font instructionFont = new Font("TimesRoman", Font.BOLD, 14);
        g.setFont(instructionFont);
        g.drawString("UP Key: Move Up", 20, 115);
        g.drawString("DOWN Key: Move Down", 20, 135);
        g.drawString("W: Move Up", 280, 115);
        g.drawString("S: Move Down", 280, 135);
        
        g.drawString("P: Pause/Resume", 137, 175);
        g.drawString("R: Restart", 160, 195);
    }
}
