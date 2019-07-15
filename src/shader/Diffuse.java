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
package shader;


import geometry.GeometricObject;
import java.util.ArrayList;
import main.Driver;
import utility.Color;
import utility.Normal;
import utility.Point3D;
import utility.Ray;
import utility.Vector3D;

public class Diffuse extends Shader
{
    double bias = 1e-4;

    @Override
    public Color compute( Normal nhit, Point3D phit, GeometricObject object,Ray ray, boolean inside, int depth) {
            double bias = 1e-4;
            Color transmission = null;
            Vector3D lightDirection = new Vector3D();
            Color resultColor = new Color(0,0,0);
            int i;
            int y = 0;
            int conta = 0;
            for (i = 0; i < Driver.world.objects.size(); i++ )
            {
                    
                if(Driver.world.objects.get(i).coloredVerticies.size()>0)
                {
                    conta = 0;
                    GeometricObject obj = Driver.world.objects.get(i);
                    Color tmpColor = new Color(0,0,0);
                    for(y = 0; y < obj.coloredVerticies.size(); y++ )
                    {
                        conta++;
                        lightDirection = obj.coloredVerticies.get(y).vertice.sub_vec(phit);
                        lightDirection.normalize();
                        for(int j = 0; j < Driver.world.objects.size(); j++ )
                        {
                            transmission = new Color(1,1,1); 
                            if (i != j)
                            {
                                double t  = Driver.world.objects.get(j).hit(new Ray(phit.add(nhit.mult(bias)), lightDirection));
                                if( t != 0.0 )
                                {
                                    transmission = new Color(0,0,0);
                                    break;
                                }
                            }

                        }
                        tmpColor.add(object.color.mult(transmission).mult(Math.max(0.0,nhit.dot(lightDirection))).mult(obj.coloredVerticies.get(y).colore));
                    }
                    tmpColor.divide(conta);
                    resultColor.add(tmpColor);
                }                
            }
            
            return resultColor;
        
    }
    
}
