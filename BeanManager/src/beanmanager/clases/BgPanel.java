/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanmanager.clases;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/**
 *
 * @author Rodrigo
 */
public class BgPanel extends JPanel{
    
    Image img;
    
    public BgPanel(Image img)
    {
        this.img = img;
    }
    
    @Override
    public  void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int x = super.getWidth();
        int y = super.getHeight();
        img = img.getScaledInstance(x, y, Image.SCALE_DEFAULT);
        g.drawImage(img, 0, 0, null);
    }
}
