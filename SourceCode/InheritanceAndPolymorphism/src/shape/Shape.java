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
 * A class of Shape
 *
 * @author Yi Wang
 */
public abstract class Shape {

    /**
     * Calculates the area of a shape
     *
     * @return the area of a shape
     */
    public abstract double calcArea();      // abstract method, with no body

    /**
     * Calculates the perimeter of a shape
     *
     * @return the perimeter of a shape
     */
    public abstract double calcPerimeter();      // abstract method, with no body

    /**
     * Normal methods are allowed
     */
    private static void print(Ellipse e) {
        e.print();
    }

    @Override
    public String toString() {
        return "I am a boring shape, I don't even know what shape I am.";
    }

    public static void main(String[] args) {
//        Circle c = new Circle();
//        Ellipse e = new Ellipse();
        Ellipse e = new Circle();
        Shape.print(e);

        // auto-casting
        int num = 5;
        double num2 = num;      // put something less accurate to something more accurate

        // manual-casting
        double num3 = 3.14;
        int num4 = (int) num3;        // put something more accurate to something less accurate

        // auto-casting
        Ellipse e1 = new Circle();          // auto casting

        // manual-casting
        Circle c1 = (Circle) e1; // manual casting

        Ellipse e2 = new Ellipse();
        System.out.println(e2 instanceof Circle);

    }
}
