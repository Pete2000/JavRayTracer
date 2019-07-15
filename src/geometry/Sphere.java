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
package geometry;

import utility.Color;
import utility.Point3D;
import utility.Ray;
import shader.Shader;

public class Sphere extends GeometricObject
{
    
    private double radius;
    
    public Sphere(String nome, Point3D center, double radius, Color color, double reflection, double transparency, Shader shader )
    {
        this.center = new Point3D(center);
        this.radius = radius;
        this.color = new Color(color);
        this.transparency = transparency;
        this.reflection = reflection;
        this.nome = nome;
        this.shader = shader;
    }
    
    public double hit(Ray ray)
    {
        double a = ray.direction.dot(ray.direction);
        double b = 2*ray.origin.sub(center).dot(ray.direction);
        double c = ray.origin.sub(center).dot(ray.origin.sub(center))-radius*radius;
        double discriminant = b*b-4*a*c;
        
        if (discriminant < 0.0)
        {
            return 0.0;
        }
        else
        {
            double t = (-b - Math.sqrt(discriminant))/(2*a);
            
            if (t > 10E-9)
            {
                return t;
            }
            else
            {
                return 0.0;
            }
        }
    }
}
