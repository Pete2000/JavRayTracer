/* 
 * Copyright (C) 2019 Pietro Caforio
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author studente
 */
public class VisualizzatoreImmagine extends JPanel
{
    public BufferedImage img;
    public VisualizzatoreImmagine() {
        this.img = null;
        
        
    }
    public void aggiorna(BufferedImage immagine)
    {
        img = immagine;
        repaint();
    }
    
    public void paint(Graphics g)
    {
        super.paint(g);
        g.drawImage(img,0,0,null);
    }
}
