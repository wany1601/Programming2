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
package hotel;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * A lobby class, only contains an array of clocks
 *
 * @author Yi Wang
 */
public class Lobby {

    private static Clock[] clocks = new Clock[5];

    public static void main(String[] args) {
        // find the local system time
        int hr = LocalDateTime.now().getHour();
        int mi = LocalDateTime.now().getMinute();
        int se = LocalDateTime.now().getSecond();

        // A simple way to modify the hour for another city
        clocks[0] = new Clock(hr + 5, mi, se, "London");
        clocks[1] = new Clock(hr + 6, mi, se, "Paris");
        clocks[2] = new Clock(hr, mi, se, "Montreal");
        clocks[3] = new Clock(hr - 9, mi, se, "Beijing");
        clocks[4] = new Clock(hr - 8, mi, se, "Tokyo");
        System.out.println(Arrays.toString(clocks));
    }

}
