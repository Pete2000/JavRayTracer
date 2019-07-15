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
public class Vector3D 
{
    public double x, y, z;
    
    public Vector3D()
    {
        x = 0.0;
        y = 0.0;
        z = 0.0;             
    }
    
    public Vector3D(double x, double y, double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public Vector3D(Point3D p)
    {
        this.x = p.x;
        this.y = p.y;
        this.z = p.z;
    }
    
    public Vector3D(Vector3D vector)
    {
        x = vector.x;
        y = vector.y;
        z = vector.z;
    }
    
    public Vector3D add(Vector3D vector)
    {
        return new Vector3D(x+vector.x, y+vector.y, z+vector.z);
    }
    public Vector3D add(Normal normal)
    {
        return new Vector3D(x+normal.x, y+normal.y, z+normal.z);
    }
    
    public Vector3D sub(Vector3D vector)
    {
        return new Vector3D(x-vector.x, y-vector.y, z-vector.z);
    }
    public Vector3D sub(Normal normal)
    {
        return new Vector3D(x-normal.x, y-normal.y, z-normal.z);
    }
    public Vector3D mult(double scalar)
    {
        return new Vector3D(x*scalar,y*scalar,z*scalar);
    }
    
    
    public double dot (Vector3D vector)
    {
        return x*vector.x + y*vector.y +z*vector.z;
    }
    
    public double dot(Point3D point)
    {
        return x*point.x + y*point.y +z*point.z;
    }
    
    public double dot(Normal normal)
    {
        return x*normal.x + y*normal.y + z*normal.z;
    }
    
    public Vector3D cross(Vector3D vector)
    {
        return new Vector3D(this.y*vector.z-this.z*vector.y, this.z*vector.x-this.x*vector.z, this.x*vector.y-this.y*vector.x);
    }
    
    public double length()
    {
        return Math.sqrt(x*x+y*y+z*z);
    }
    
    public void normalize()
    {
        double magnitude = Math.sqrt(x*x + y*y + z*z);
        
        x /= magnitude;
        y /= magnitude;
        z /= magnitude;
    }
}
