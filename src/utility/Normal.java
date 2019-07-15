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


public class Normal 
{
    public double x, y, z;
    
    public Normal()
    {
         x = 0.0;
         y = 0.0;
         z = 0.0; 
    }
    
    public Normal(double x, double y, double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public Normal (Normal normal)
    {
        x = normal.x;
        y = normal.y;
        z = normal.z;
    }
    public Normal (Vector3D vec){
        x = vec.x;
        y = vec.y;
        z = vec.z;
    }
    
    public double dot(Normal normal)
    {
        return x*normal.x + y*normal.y + z*normal.z;
    }
    public double dot(Vector3D vector)
    {
        return x*vector.x + y*vector.y + z*vector.z;
    }
    public Normal mult(double scalar)
    {
        return new Normal(x*scalar,y*scalar,z*scalar);
    }
    
    public void normalize()
    {
        double magnitude = Math.sqrt(x*x + y*y + z*z);
        
        x /= magnitude;
        y /= magnitude;
        z /= magnitude;
    }
    
}
