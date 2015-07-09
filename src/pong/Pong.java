/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import javax.swing.JFrame;



public class Pong {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Game panel = new Game();
        JFrame application = new JFrame();
        application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        application.add(panel);
        application.setSize(420,250);
        application.setVisible(true);
    }
    
}
