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
package sampling;

import java.util.Random;
import main.Driver;
import utility.Point2D;

public class JitteredSample extends Sample
{
    public Random random;
    
    public JitteredSample(int samples)
    {
        this.samples = samples;
        random = new Random();
    }
    public Point2D sample(int row, int col, int x, int y)
    {
        
        Point2D point = new Point2D(0,0);
        
        point.x = x - Driver.world.viewplane.width /2+(col+random.nextFloat())/samples;
        point.y = y - Driver.world.viewplane.width /2+(row+random.nextFloat())/samples;
        
        return point;
    }
    
    
}
