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
package textio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Yi Wang
 */
public class TextIO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        /*
        Input
         */
//        String path = "C:\\Users\\andre\\Desktop\\TextIO\\hello.txt";       // absolute path
        String path = "hello.txt";       // relative path
        System.out.println(readFile4(path));
    }

    public static String readFile(String path) {
        // Step 1: create a file object
        File file = new File(path);     // java does not care if the path is correct
//        Scanner input = null;
        String str = "";

        // try with resouces, if we have to first creat the link, and then cut the link,
        // why should we always have to cut it by ourselves?
        // so you just need to create the link (create the scanner object between the ()),
        // and Java will automatically cut the link after we finish the try-catch
        try (Scanner input = new Scanner(file)) {
            str = input.nextLine();
        } catch (IOException e) {
            System.out.println(String.format("File %s does not exist", path));
        }

        // and there is a chance java cannot find this file or cannot open the file
        // in this case, java will throw an exception (IOException), which is a checked execption
        return str;
    }

    public static int readFile2(String str) {
        File file = new File(str);

        int num = 0;

        try (Scanner input = new Scanner(file)) {
            num = input.nextInt();
        } catch (IOException e) {
            System.out.println(String.format("%s: %s", e.getClass(), e.getMessage()));
        } catch (InputMismatchException e) {
            // ????
        }

        return num;
    }

    /**
     * Read only one row
     *
     * @param path
     * @return
     */
    public static int[] readFile3(String path) {
        File file = new File(path);
        String row = "";
        int len = 5;
        int[] nums = new int[len];

        try (Scanner input = new Scanner(file)) {
            row = input.nextLine();             // extract everything

            String[] strs = row.split(" ");
            for (int i = 0; i < len; i++) {
                try {
                    nums[i] = Integer.parseInt(strs[i]) * 2;   // "1" -> 1       Integer.parseInt()
                } catch (NumberFormatException e) {
                    nums[i] = -1;
                }
            }

        } catch (IOException e) {

        }
        return nums;
    }

    /**
     * Read many rows but one column
     *
     * @param path the path of the file
     * @return
     */
    public static ArrayList<Integer> readFile4(String path) {
        File file = new File(path);
        ArrayList<Integer> nums = new ArrayList<>();

        try (Scanner input = new Scanner(file)) {
            while (input.hasNext()) {        // boolean method to check if the scanner reach the end of the file or not
                try {
                    nums.add(Integer.parseInt(input.next()));
                } catch (NumberFormatException e) {
                    nums.add(-1);
                }
            }
        } catch (IOException e) {
        }

        return nums;
    }
}
