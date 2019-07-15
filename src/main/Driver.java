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

import java.awt.image.BufferedImage;
import projection.Orthographic;
import projection.Perspective;
import projection.Projection;
import scene.World;
import utility.Image;
import sampling.RegularSample;
import utility.Color;
import utility.Point2D;
import utility.Point3D;
import utility.Ray;



public class Driver 
{
    public static World world;
    private static Image image;
    private static Tracer tracer;
    private static RegularSample sampler;
    private static Projection projection;
    
    public static void main(String[] args)
    {
        int n=0;
        double tx=0;
        double ty=0;
        world = new World(1600, 900, 1.0);

        Finestra f = new Finestra();
        for(tx=0; tx<10;tx+=0.04){
            ty+=0.04;
            long start = System.nanoTime();
            
            world.aggiorna(tx, ty);
            if(world.reset==true){
                ty=0;
            }
            tracer = new Tracer();
            sampler = new RegularSample(4);
            projection = new Perspective(new Point3D(3, 2.0, 10.00), new Point3D(0.0,      0, -20), 30);
            Color pixel = new Color(0,0,0);
            image = new Image("./output/"+n+".png");
            n++;
            
            for (int y = 0; y < world.viewplane.height; y++)
            {
                for (int x = 0; x < world.viewplane.width; x++)
                {
                    Point2D point = new Point2D(x - Driver.world.viewplane.width /2+0.5,y - Driver.world.viewplane.height /2+0.5);
                    Ray ray = Driver.projection.createRay(point);
                    pixel = Tracer.trace(ray,0);
                    Driver.image.buffer.setRGB(x, Driver.world.viewplane.height-y-1, pixel.toInteger());
                    f.v.aggiorna(image.buffer);
                }
            }
            
            
            
            image.write("PNG");
            
            
            long end = System.nanoTime();
            System.out.println("Loop time : " + (end-start)/1000000000.0F);
        }
    }
}
