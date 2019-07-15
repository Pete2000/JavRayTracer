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
package main;

import geometry.GeometricObject;
import utility.Ray;

public class Utility {

    public static double min;
    public static boolean hit;
    
public static GeometricObject intersects(Ray ray)
{
    hit = false;
    min = Double.MAX_VALUE;
    GeometricObject object = null;
    double temp = 0;
    
    for(int i = 0; i < Driver.world.objects.size(); i++)
        {
            GeometricObject oggetto = Driver.world.objects.get(i);
            if (!(oggetto.coloredVerticies== null || oggetto.coloredVerticies.size()<= 0)){
            continue;
            }
            temp = oggetto.hit(ray);
                    
            if (temp != 0.0 && temp < min)
            {
                min = temp;
                hit = true;
                
                object = oggetto;
                
                continue;
                
            }
        }
        return object;
        
                
}  
}
