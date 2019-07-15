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

import java.util.ArrayList;
import utility.Color;
import utility.Point3D;
import utility.Ray;
import shader.Shader;

public abstract class GeometricObject 
{
    public Color color;
    public Point3D center;
    public double transparency, reflection;
    public String nome;
    public Shader shader;
    public ArrayList<ColoredVertex> coloredVerticies=new ArrayList();
    
    public abstract double hit(Ray ray);
    
}
