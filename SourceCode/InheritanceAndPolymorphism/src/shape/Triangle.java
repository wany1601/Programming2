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
 * A simple class of Triangle
 *
 * @author Yi Wang
 */
public class Triangle extends Shape {

    private double sideA;
    private double sideB;
    private double angleC;      // degree

    public Triangle() {
        this.sideA = 1;
        this.sideB = 1;
        this.angleC = 90;
    }

    public Triangle(double sideA, double sideB, double angleC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.angleC = angleC;
    }

    public Triangle(Triangle triangle) {
        this.sideA = triangle.sideA;
        this.sideB = triangle.sideB;
        this.angleC = triangle.angleC;
    }

    @Override
    public double calcArea() {
        return sideA * sideB * Math.sin(Math.toRadians(angleC)) / 2;
    }

    @Override
    public double calcPerimeter() {
        double sideC = Math.sqrt(sideA * sideA + sideB * sideB
                - 2 * sideA * sideB * Math.cos(Math.toRadians(angleC)));
        return sideA + sideB + sideC;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Triangle other = (Triangle) obj;
        if (Double.doubleToLongBits(this.sideA) != Double.doubleToLongBits(other.sideA))
            return false;
        if (Double.doubleToLongBits(this.sideB) != Double.doubleToLongBits(other.sideB))
            return false;
        if (Double.doubleToLongBits(this.angleC) != Double.doubleToLongBits(other.angleC))
            return false;
        return true;
    }

    @Override
    public String toString() {
        String str = "";

        str += String.format("%-10s: %.2f\n", "Side A", sideA);
        str += String.format("%-10s: %.2f\n", "Side B", sideB);
        str += String.format("%-10s: %.2f\n", "Angle C", angleC);

        return str;
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public double getAngleC() {
        return angleC;
    }

    public void setAngleC(double angleC) {
        this.angleC = angleC;
    }

}
