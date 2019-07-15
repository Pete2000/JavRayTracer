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
public class Ray 
{
    public Point3D origin;
    public Vector3D direction;
            
    public Ray()
    {
        origin = new Point3D();
        direction = new Vector3D();
    }
    public Ray(Point3D origin, Vector3D direction)
    {
        this.origin = new Point3D(origin);
        this.direction = new Vector3D(direction);
    }
    
}
