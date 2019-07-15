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

import shader.Shader;
import utility.Color;
import utility.Normal;
import utility.Point3D;
import utility.Ray;

public class Plane extends GeometricObject
{
    
    private Normal normal;
    
    public Plane(Point3D center, Normal normal, Color color, double transparency, double reflection, Shader shader)
    {
        this.center = new Point3D(center);
        this.normal = new Normal(normal);
        this.color = new Color(color);
        this.transparency = transparency;
        this.reflection = reflection;
        this.shader = shader;
    }
    
    public double hit(Ray ray)
    {
        double t = center.sub(ray.origin).dot(normal)/ray.direction.dot(normal);
        
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
