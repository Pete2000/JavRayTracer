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
import utility.Ray;

public class Orthographic extends Projection
{
    @Override
    public Ray createRay(Point2D point)
    {
        Ray ray = new Ray();
        ray.origin.x = Driver.world.viewplane.size*point.x;
        ray.origin.y = Driver.world.viewplane.size*point.y;
        ray.origin.z = 100;
        
        ray.direction.x = 0.0;
        ray.direction.y = 0.0;
        ray.direction.z = -1.0;
        
        return ray;
        
    }
}
