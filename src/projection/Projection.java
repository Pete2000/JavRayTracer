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

import utility.Point2D;
import utility.Point3D;
import utility.Ray;
import utility.Vector3D;

public abstract class Projection 
{
    public Point3D eye;
    public Point3D lookat;
    public double distance;
    public Vector3D u, v, w;
    
    public abstract Ray createRay(Point2D point);
    
    public void compute_uvw()
    {
        w = eye.sub_vec(lookat);
        w.normalize();
        
        Vector3D up = new Vector3D(0.00424, 1.0, 0.00764);
        
        u = up.cross(w);
        u.normalize();
        
        v = w.cross(u);
        v.normalize();
    }
    
}
