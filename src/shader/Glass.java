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
import main.Tracer;
import static main.Tracer.mix;
//import static main.Tracer.trace;
import utility.Color;
import utility.Normal;
import utility.Point3D;
import utility.Ray;
import utility.Vector3D;

public class Glass extends Shader{

    @Override
    public Color compute(Normal nhit, Point3D phit, GeometricObject object, Ray ray, boolean inside, int depth) {
        double bias = 1e-4;
        Color reflection= new Color();
        double facingratio = - ray.direction.dot(nhit);            
        double fresneleffect = mix(Math.pow( 1 - facingratio, 3 ), 1, 0.1);
            
            
        Vector3D refldir = ray.direction.sub(nhit.mult(2).mult(ray.direction.dot(nhit)));
        refldir.normalize();
        Ray newray = new Ray(phit.add(nhit.mult(bias)),refldir);
                
                
        reflection = Tracer.trace(newray,depth+1);
            
            
            
        Color refraction = new Color(0,0,0);
            
        double ior = 1.1, eta = (inside) ? ior : 1 / ior;
        double cosi = -nhit.dot(ray.direction);
        double k = 1 - eta * eta * (1 - cosi * cosi);
        Vector3D refrdir = ray.direction.mult(eta).add(nhit.mult(eta*cosi-Math.sqrt(k)));
        refrdir.normalize();
        Ray newray1 = new Ray(phit.sub(nhit.mult(bias)),refrdir);
        refraction = Tracer.trace(newray1, depth+1);

            
        Color colRiflessione = reflection.mult(fresneleffect);
        Color colRifrazione = refraction.mult(1 - fresneleffect).mult(object.transparency);
        Color colEsterno = colRiflessione.addi(colRifrazione);
        return colEsterno.mult(object.color);
    }
    
}
