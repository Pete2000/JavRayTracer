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
package geometry;

import shader.Shader;
import utility.Color;
import utility.Point3D;
import utility.Ray;
import utility.Vector3D;

public class Triangle extends GeometricObject
{
    private double kEpsilon = 0.00001d;
    public Point3D[] vertici;
    
    public Triangle(String nome, Point3D[] vertici, Color color, double reflection, double transparency, Shader shader )
    {
        this.vertici = vertici;
        double mx,my,mz;
        mx = vertici[0].x + vertici[0].y + vertici[0].z;
        my = vertici[1].x + vertici[1].y + vertici[1].z;
        mz = vertici[2].x + vertici[2].y + vertici[2].z;
        Point3D centro = new Point3D(mx,my,mz);
        this.center = centro;
        this.color = new Color(color);
        this.transparency = transparency;
        this.reflection = reflection;
        this.nome = nome;
        this.shader = shader;
    }
    
    double rayTriangleIntersect(Vector3D orig, Vector3D dir) 
    {
        double t;
        Vector3D v0=new Vector3D(vertici[0]); 
        Vector3D v1=new Vector3D(vertici[1]); 
        Vector3D v2=new Vector3D(vertici[2]);
        // compute plane's normal
        Vector3D v0v1 = v1.sub(v0); 
        Vector3D v0v2 = v2.sub(v0); 
        
        Vector3D pvec = dir.cross(v0v2);
        double det = v0v1.dot(pvec);
        if(det < kEpsilon) return 0.0;
        else
            if(Math.abs(det) < kEpsilon) return 0;
        
        double invDet = 1 / det; 
 
        Vector3D tvec = orig.sub(v0); 
        double u = tvec.dot(pvec) * invDet; 
        if (u < 0 || u > 1) return 0.0; 
 
        Vector3D qvec = tvec.cross(v0v1); 
        double v = dir.dot(qvec) * invDet; 
        if (v < 0 || u + v > 1) return 0.0; 
 
        t = v0v2.dot(qvec) * invDet; 
 
        return t;
        
        /*
        // no need to normalize
        Vector3D N = v0v1.cross(v0v2); // N 
        

        // Step 1: finding P

        // check if ray and plane are parallel ?
        double NdotRayDirection = N.dot(dir); 
        if (Math.abs(NdotRayDirection) < kEpsilon) // almost 0 
            return 0.0; // they are parallel so they don't intersect ! 

        // compute d parameter using equation 2
        double d = N.dot(v0); 

        // compute t (equation 3)
        t = (N.dot(orig) + d) / NdotRayDirection; 
        // check if the triangle is in behind the ray
        if (t < 0) return 0.0; // the triangle is behind 

        // compute the intersection point using equation 1
        Vector3D P = orig.add(dir.mult(t)); 

        // Step 2: inside-outside test
        Vector3D C; // vector perpendicular to triangle's plane 

        // edge 0
        Vector3D edge0 = v1.sub(v0); 
        Vector3D vp0 = P.sub(v0); 
        C = edge0.cross(vp0); 
        if (N.dot(C) < 0) return 0.0; // P is on the right side 

        // edge 1
        Vector3D edge1 = v2.sub(v1); 
        Vector3D vp1 = P.sub(v1); 
        C = edge1.cross(vp1); 
        if (N.dot(C) < 0)  return 0.0; // P is on the right side 

        // edge 2
        Vector3D edge2 = v0.sub(v2); 
        Vector3D vp2 = P.sub(v2); 
        C = edge2.cross(vp2); 
        if (N.dot(C) < 0) return 0.0; // P is on the right side; 

        return t; // this ray hits the triangle */
    } 

    @Override
    public double hit(Ray ray) {
        Vector3D ro = new Vector3D(ray.origin);
        Vector3D rd = new Vector3D(ray.direction);
        double ris = rayTriangleIntersect(ro,rd);
        
        return ris;
    }
    
}
