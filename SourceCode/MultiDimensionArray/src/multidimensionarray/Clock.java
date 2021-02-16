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
package multidimensionarray;

import java.util.Arrays;

/**
 * A simple Clock class for testing Arrays.equals() and Arrays.deepEquals()
 *
 * @author Yi Wang
 */
public class Clock {

    private int hr;
    private int mi;
    private int se;

    public Clock(int hr, int mi, int se) {
        this.hr = hr;
        this.mi = mi;
        this.se = se;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Clock other = (Clock) obj;
        if (this.hr != other.hr)
            return false;
        if (this.mi != other.mi)
            return false;
        if (this.se != other.se)
            return false;
        return true;
    }

    public static void main(String[] args) {
        Clock c1 = new Clock(0, 0, 0);
        Clock c2 = new Clock(0, 0, 0);
        Clock c3 = new Clock(0, 0, 0);
        Clock c4 = new Clock(0, 0, 0);

        Clock[] cs1 = {c1, c2};
        Clock[] cs2 = {c3, c4};

        // reference of cs1 and cs2
        System.out.println(cs1 == cs2);
        // calling equals() in Clock class to comapre c1 and c3, c2 and c4
        System.out.println(Arrays.equals(cs1, cs2));
        // calling equals() to compare c1 and c3, c2 and c4
        System.out.println(Arrays.deepEquals(cs1, cs2));
    }
}
