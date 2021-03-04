/*
 * The MIT License
 *
 * Copyright 2021 Yi Wang.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package shape;

/**
 * A class of Rectangular
 *
 * @author Yi Wang
 */
public class Rectangular extends Shape {

    private double length;
    private double height;

    public Rectangular() {
        this.length = 1;
        this.height = 1;
    }

    public Rectangular(double length, double height) {
        this.length = length;
        this.height = height;
    }

    public Rectangular(Rectangular rectangular) {
        this.length = rectangular.length;
        this.height = rectangular.height;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Rectangular other = (Rectangular) obj;
        if (Double.doubleToLongBits(this.length) != Double.doubleToLongBits(other.length))
            return false;
        if (Double.doubleToLongBits(this.height) != Double.doubleToLongBits(other.height))
            return false;
        return true;
    }

    @Override
    public String toString() {
        String str = "";

        str += String.format("%-10s: %.2f\n", "Length", length);
        str += String.format("%-10s: %.2f\n", "Height", height);

        return str;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

}
