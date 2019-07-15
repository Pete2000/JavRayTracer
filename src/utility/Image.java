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
package utility;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import main.Driver;

public class Image 
{
    public BufferedImage buffer;
    public File image;
    
    public Image(String filename)
    {
        image = new File(filename);
        buffer = new BufferedImage(Driver.world.viewplane.width, Driver.world.viewplane.height, BufferedImage.TYPE_INT_RGB);
    }
    
    public void write(String filetype)
    {
        try {
            ImageIO.write(buffer, filetype, image);
        } catch (IOException ex) {
            System.out.println("Could not write image");
            System.exit(1);
        }
    }
}
