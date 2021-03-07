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
    private void print() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        Square s = new Square();
        Rectangular r = new Square();
//        Shape sh = new Shape();
        Shape sh1 = new Square();

    }
}
