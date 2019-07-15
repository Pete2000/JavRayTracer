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
public class Color 
{
    private double r, g, b;
    
    public Color()
    {
        r = 0.0F;
        g = 0.0F;
        b = 0.0F;
    }
    
    public Color(double r, double g, double b)
    {
        this.r = r;
        this.g = g;
        this.b = b;
    }
    
    public Color(Color color)
    {
        r = color.r;
        g = color.g;
        b = color.b;
    }
    
    public void add(Color color)
    {
        r += color.r;
        g += color.g;
        b += color.b;
    }
    public void sub(Color color)
    {
        r -= color.r;
        g -= color.g;
        b -= color.b;
    } 
    public Color addi(Color color)
    {
        return new Color(this.r+color.r,this.g+color.g,this.b+color.b);
    }
    public Color mult(double scalar)
    {
        return new Color(r*scalar,g*scalar,b*scalar);
    }
    public Color mult(Color scalar)
    {
        return new Color(r*scalar.r,g*scalar.g,b*scalar.b);
    }
    public void divide(int scalar)
    {
        r /= scalar;
        g /= scalar;
        b /= scalar;
    }
    
    public void divide(float scalar)
    {
        if (scalar!=0)
        {
            r /= scalar;
            g /= scalar;
            b /= scalar;
        }
    }
    public void normalize()
    {
        double magnitude = Math.sqrt(r*r + g*g + b*b);
        
        r /= magnitude;
        g /= magnitude;
        b /= magnitude;
    }
    public int toInteger()
    {
        return (int) (Math.min(1, r)*255)<<16| (int) (Math.min(1, g)*255)<<8| (int) (Math.min(1, b)*255);
    }
}
