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
package projection;

import main.Driver;
import utility.Point2D;
import utility.Point3D;
import utility.Ray;

public class Perspective extends Projection
{
   
    
    public Perspective(Point3D eye, Point3D lookat, double FOV)
    {
        this.eye = new Point3D(eye);
        this.lookat = new Point3D(lookat);
        this.distance = Driver.world.viewplane.height/2/(Math.tan(Math.toRadians(FOV)));
        
        compute_uvw();
        
        
    }
     public Ray createRay(Point2D point)
    {
        Ray ray = new Ray(new Point3D(eye), u.mult(point.x).add(v.mult(point.y).sub(w.mult(distance))));
        ray.direction.normalize();
        
        return ray;
    }
    
}
