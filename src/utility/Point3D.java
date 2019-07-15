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
public class Point3D {
    public double x, y, z;
    
    
    public Point3D()
    {
        x = 0.0;
        y = 0.0;
        z = 0.0;
    }
    public Point3D (double x, double y, double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public Point3D(Point3D point)
    {
        x = point.x;
        y = point.y;
        z = point.z;
    }
    
    public Point3D clone()
    {
       return new Point3D(this); 
    }
    
    public Point3D add (Point3D point)
    {
        return new Point3D(x+point.x, y+point.y, z+point.z);
    }
    public Point3D add (Vector3D vector)
    {
        return new Point3D(x+vector.x, y+vector.y, z+vector.z);
    }
    public Point3D add (Normal normal)
    {
        return new Point3D(x+normal.x, y+normal.y, z+normal.z);
    }
    
    public Point3D sub(Point3D point)
    {
        return new Point3D(x-point.x, y-point.y, z-point.z);
    }
    public Point3D sub(Normal normal)
    {
        return new Point3D(x-normal.x, y-normal.y, z-normal.z);
    }
    
    
    public Vector3D sub_vec(Point3D point)
    {
        return new Vector3D(x-point.x, y-point.y, z-point.z);
    }
    
    public double dot(Point3D point)
    {
        return x*point.x + y*point.y + z*point.z;
    }
    
    public double dot (Normal normal)
    {
        return x*normal.x + y*normal.y + z*normal.z;
    }
    
    public double dot (Vector3D vector)
    {
        return x*vector.x + y*vector.y + z*vector.z;
    }
    
    
}
