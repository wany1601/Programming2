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
package exceptionhandling;

import java.io.IOException;
import java.util.Random;

/**
 *
 * @author Yi Wang
 */
public class ExceptionHandling {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int num = 5;
        Random rand = new Random();
//        int num2 = rand.nextInt(num);           // [0, 1, 2, 3, 4]
//        int result = 0;
//        int[] nums = {1, 2, 1, 3};
//
//        try {
//            for (int i = 0; i < 10; i++)        // new ArrayIndexOutOfBoundException();
//                result = num / nums[i];         // may throw ArithmeticException
//            // when java throws an exception, an object of that kind of excetion is create
//            //
//        } //        catch (ArrayIndexOutOfBoundsException e) {
//        //
//        //
//        //        }
//        catch (ArithmeticException e) {                 // () indicate what kind of exception the handler can handle
//            result = 0;
//            // turn off the detector
//        } //
//        //        } catch (ClassCastException e) {
//        //            result = -1;
//        //        } catch (RuntimeException e) {
//        //
//        //        }
//        catch (Exception e) {
//            System.out.print(e.getClass() + ": ");
//            System.out.println(e.getMessage());
//
//            StackTraceElement[] stes = e.getStackTrace();
//
//            for (StackTraceElement ste : stes)
//                System.out.println("\t\t at " + ste);
//
//            System.exit(1);      // stop the execusion
//        }
        try {
            switch (0) {
                case 0:
                    m1();
                    break;
                case 1:
                    m2();
                    break;
                case 2:
                    m3();
                    break;
            }
        } catch (ArithmeticException e) {
            System.out.println("Cannot divid by zero");
        }
    }

    // "throws" means throws the exception or error back to whoever calls the method
    public static void m1() throws ArithmeticException, TwoNumberTheSameException {
        Random rand = new Random();
        int num1 = 2;//rand.nextInt(5);
        int num2 = 2;//rand.nextInt(5);
        if (num1 == num2)
            throw new TwoNumberTheSameException(num1 + "");  // "throw" ring the alarm
        int result = num1 / 0;
        System.out.println();      // Runtime exception: Arithmatic
    }

    public static void m2() throws ArithmeticException {
        Random rand = new Random();
        System.out.println(rand.nextInt(10) / rand.nextInt(10));      // Runtime exception: Arithmatic
    }

    public static void m3() throws ArithmeticException {
        Random rand = new Random();
        System.out.println(rand.nextInt(50) / rand.nextInt(50));      // Runtime exception: Arithmatic
    }

}
