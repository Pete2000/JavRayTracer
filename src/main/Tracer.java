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


import geometry.GeometricObject;
import geometry.Sphere;
import geometry.Triangle;
import utility.Color;
import utility.Normal;
import utility.Point2D;
import utility.Point3D;
import utility.Ray;
import utility.Vector3D;


public class Tracer 
{
    public static int maxdepth = 5;
    public double min = Double.MAX_VALUE;
    
    public static double mix(double a, double b, double mix)
    {
        return b*mix+a*(1-mix);
    }
    public static Color trace(Ray ray, int depth)
    {   
        Color color = new Color();
        
        
        
        GeometricObject object = null; 
        
        boolean hit = false;
        double temp = 0;
        Point3D phit = new Point3D();
        Normal nhit = new Normal();
        Point3D center = new Point3D();
                
        double min = Double.MAX_VALUE;
        Color tempColor = new Color(0,0,0);
         
        object = Utility.intersects(ray);
        min = Utility.min;
        hit = Utility.hit;
        
        Color reflection = new Color();
        
        if(hit == false) return Driver.world.background;
        
        Color surfacecolor = new Color(0.0F,0.0F,0.0F);
        phit = ray.origin.add(ray.direction.mult(min));
        
        if(object instanceof Triangle){
            Vector3D v0 =new Vector3D(((Triangle) object).vertici[0]) ;
            Vector3D v1 =new Vector3D(((Triangle) object).vertici[1]) ;
            Vector3D v2 =new Vector3D(((Triangle) object).vertici[2]) ;
            Vector3D v0v1 = v1.sub(v0);
            Vector3D v0v2 = v2.sub(v0); 
            nhit = new Normal(v0v1.cross(v0v2));
            nhit.normalize();
        }
        else{
        
        nhit.x = phit.sub(object.center).x;
        nhit.y = phit.sub(object.center).y;
        nhit.z = phit.sub(object.center).z;
        nhit.normalize();
        }
        double bias = 1e-4;
        boolean inside = false;
            
        if(ray.direction.dot(nhit) > 0) 
        {
            nhit.x= -nhit.x;
            nhit.y= -nhit.y;
            nhit.z= -nhit.z;
            inside = true;
        }
        surfacecolor = object.shader.compute(nhit, phit, object,ray,inside,depth);
        return surfacecolor;
    }
    
}
