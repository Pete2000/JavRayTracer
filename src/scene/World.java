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
package scene;
import utility.*;
import geometry.*;
import geometry.GeometricObject;
import java.util.ArrayList;
import shader.Diffuse;
import shader.Glass;
import utility.Color;

public class World 
{
    public ViewPlane viewplane;
    public ArrayList<GeometricObject> objects;
    public Color background;
    public boolean reset=false;
        
    public    double xzero=-20;
    public    double yzero=2;
    public    int velocitax = 6;
    public    double velocitay = 12;
        
    
    public World(int width, int height, double size)
    {
        viewplane = new ViewPlane(width, height, size);
        background = new Color(0.8f, 0.8f, 0.8f);        
    }
    
    public void aggiorna(double tx, double ty){
        this.reset= false;
    
        objects = new ArrayList<>();
        
        double y= yzero+((velocitay*ty)-(9.8*ty*ty)/2);
        
        //t in cui tocca il pavimento
        double delta = (velocitay*velocitay)-4*(-9.8/2)*(yzero+1);
        double touch=0;
        if(delta==0){
            touch= -velocitay/(-9.8);
        } else 
            if(delta>0)
        {
            touch=(-velocitay-Math.sqrt(delta))/(-9.8);
        }
        
        System.out.println(touch);
        if(ty>= touch){
            this.reset= true;
            velocitay= velocitay * (-0.8);
            yzero= y; 
            System.out.println("Y: "+y);
            
        }
        System.out.println("Y: "+y);
        objects.add(new Sphere("a dx",    new Point3D(xzero+velocitax*tx,   y   , -7), 3, new Color(0.65, 0.77, 0.97), 0.6, 0.6f, new Glass()));
        objects.add(new Sphere("in mezzo",new Point3D(0.0,      0, -20),    4, new Color(1.00, 0.32, 0.36), 1, 0.5f,new Diffuse()));
        objects.add(new Sphere("a sx",    new Point3D(-5.5,      0, -15),  3, new Color(0.0, 0.0, 1.00), 1, 0.0f,new Diffuse()));
        
        Sphere luce = new Sphere("luce", new Point3D(-20,     50, 20),     3   , new Color(0.00, 0.00, 0.00), 0, 0.0f,new Diffuse());
        objects.add(luce);
        for(double i=0; i<=10; i +=0.25)
        {
            
            luce.coloredVerticies.add(new ColoredVertex( new Point3D(-20,10+i,20) , new Color(1.0,1.0,1.0)));
        }
        objects.add(new Sphere("piano",new Point3D(0.0, -10004.0, -20), 10000, new Color(1.0f, 0.98f, 0.51f), 0, 0.0f,new Diffuse()));
        
            }
    
}

