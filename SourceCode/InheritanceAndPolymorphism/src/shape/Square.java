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
 * A class of Square
 *
 * @author Yi Wang
 */
public class Square extends Rectangular implements Drawable {

    public Square() {
        super();
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(Square square) {
        super(square);
    }

    /**
     * Draws a square
     *
     * Example: side = 4
     *
     * +------+ | | | | +------+
     */
    @Override
    public void draw() {
        int rowLength = (int) getSide() * 2;
        int colLength = (int) getSide();

        // for the first row
        System.out.print("+");
        for (int i = 0; i < rowLength - 2; i++)
            System.out.print("-");
        System.out.println("+");

        // for the middle part
        for (int i = 0; i < colLength - 2; i++) {
            System.out.print("|");
            for (int j = 0; j < rowLength - 2; j++)
                System.out.print(" ");
            System.out.println("|");
        }

        // for the last row
        System.out.print("+");
        for (int i = 0; i < rowLength - 2; i++)
            System.out.print("-");
        System.out.println("+");
    }

    @Override
    public String toString() {
        return String.format("%-10s: %.2f\n", "Side", getLength());
    }

    public double getSide() {
        return getLength();
    }

    public void setSide(double side) {
        setHeight(side);
        setLength(side);
    }

    public static void main(String[] args) {
        Square square = new Square(4);
        square.draw();
        square.printInfor();
    }

}
