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

public class Menu{  
    
    public static Rectangle onePlayer = new Rectangle(150,75,100,30);
    public static Rectangle twoPlayer = new Rectangle(150,125,100,30);
    
    public void render(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        Font titleFont = new Font("TimesRoman", Font.BOLD, 50);
        g.setFont(titleFont);
        g.setColor(Color.WHITE);
        g.drawString("PONG", 125, 50);
        
        Font textFont = new Font("TimesRoman", Font.BOLD, 16);
        g.setFont(textFont);
        g2d.draw(onePlayer);
        g.drawString("One Player", 158, 98);
        g2d.draw(twoPlayer);
        g.drawString("Two Player", 158, 148);
    }
}
