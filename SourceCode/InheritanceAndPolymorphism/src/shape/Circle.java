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
 * A simple class of Circle
 *
 * @author Yi Wang
 */
public class Circle extends Ellipse {

    public Circle() {
        super();
    }

    public Circle(double radius) {
        super(radius, radius);
    }

    public Circle(Circle circle) {
        super(circle);
    }

    @Override
    public void print() {
        System.out.println("I am red");
    }

    @Override
    public String toString() {
        return String.format("%-10s: %.2f\n", "Radius", getMajorAxis());
    }

    public double getRadius() {
        return getMajorAxis();
    }

    public void setRadius(double radius) {
        setMajorAxis(radius);
        setMinorAxis(radius);
    }
}
