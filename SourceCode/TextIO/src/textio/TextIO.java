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
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
    public static void main(String[] args) {

        /*
        Input
         */
//        String path = "C:\\Users\\andre\\Desktop\\TextIO\\hello.txt";       // absolute path
//        String path = "txt\\student.csv";       // relative path
//        System.out.println(readStudentData(path));

        /*
        Output
         */
        String path = "numMatrix.csv";
        int num = 999;
        int[] nums = {1, 2, 3, 4, 5};
        int[][] numss = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {0, 0, 0}};
        writeFileTable(path, numss);

    }

    public static String readFile(String path) {
        // Step 1: create a File object
        File file = new File(path);     // java does not care if the path is correct
//        Scanner input = null;
        String str = "";

        // try with resouces, if we have to first creat the link, and then cut the link,
        // why should we always have to cut it by ourselves?
        // so you just need to create the link (create the scanner object between the ()),
        // and Java will automatically cut the link after we finish the try-catch
        try ( Scanner input = new Scanner(file)) {
            str = input.nextLine();
        } catch (IOException e) {
            System.out.println(String.format("File %s does not exist", path));
        }

        // and there is a chance java cannot find this file or cannot open the file
        // in this case, java will throw an exception (IOException), which is a checked execption
        return str;
    }

    public static int readFile2(String path) {
        File file = new File(path);

        int num = 0;

        try ( Scanner input = new Scanner(file)) {
            num = input.nextInt();
        } catch (IOException e) {
            System.out.println(String.format("%s: %s", e.getClass(), e.getMessage()));
        } catch (InputMismatchException e) {
            System.out.println(String.format("File %s does not exist", path));
        }

        return num;
    }

    /**
     * Read only one row a b c d e f g
     *
     * @param path
     * @return
     */
    public static int[] readFile3(String path) {
        File file = new File(path);
        String row = "";
        int len = 5;
        int[] nums = new int[len];

        try ( Scanner input = new Scanner(file)) {
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
            System.out.println(String.format("File %s does not exist", path));
        }
        return nums;
    }

    /**
     * Read many rows but one column
     *
     * a
     *
     * b
     *
     * c
     *
     * d
     *
     * @param path the path of the file
     * @return
     */
    public static ArrayList<Integer> readFile4(String path) {
        File file = new File(path);
        ArrayList<Integer> nums = new ArrayList<>();

        try ( Scanner input = new Scanner(file)) {
            while (input.hasNext()) {        // boolean method to check if the scanner reach the end of the file or not
                try {
                    nums.add(Integer.parseInt(input.next()));
                } catch (NumberFormatException e) {
                    nums.add(-1);
                }
            }
        } catch (IOException e) {
            System.out.println(String.format("File %s does not exist", path));
        }

        return nums;
    }

    /**
     * Read data from StudentData.txt and store all information of students in
     * an ArrayList.
     *
     * @param path the path of the file
     * @return the arraylist of student that contains information of all
     * students
     */
    public static ArrayList<Student> readStudentData(String path) {
        File file = new File(path);

        ArrayList<Student> students = new ArrayList<>();

        try ( Scanner input = new Scanner(file)) {
            input.nextLine();           // read the header, but not touch it

            while (input.hasNext()) {           // read multi-row
                String row = input.nextLine();
                String[] data = row.split(",");     // {"0001", "yi", "wang", "registered", "98", "78"}

                String id = data[0];
                String fname = toTitleCase(data[1]);
                String lname = toTitleCase(data[2]);
                double score1;
                double score2;
                boolean registered = !data[3].toLowerCase().contains("un");
                try {
                    score1 = Double.parseDouble(data[4]);
                } catch (java.lang.NumberFormatException e) {
                    score1 = -1;
                }
                try {
                    score2 = Double.parseDouble(data[5]);
                } catch (java.lang.NumberFormatException e) {
                    score2 = -1;
                }
                double[] scores = {score1, score2};

                Student student = new Student(id, fname, lname, registered, scores);
                students.add(student);
            }

            // read the data
        } catch (IOException e) {
            System.out.println(String.format("File %s does not exist", path));
        }

        return students;
    }

    public static boolean isNumValid(String str) {
        char[] chas = str.toCharArray();

        for (char c : chas)
            if (!Character.isDigit(c))
                return false;

        return true;
    }

    /**
     * Converts a string to title case
     *
     * @param str the original string
     * @return the string in title case, like "Xxxxx"
     */
    public static String toTitleCase(String str) {
        return Character.toUpperCase(str.charAt(0)) + str.substring(1).toLowerCase();
    }

    /**
     * Writes data to a file
     *
     * @param path the path of the output file
     * @param num the data to write
     */
    public static void writeFile(String path, int num) {
        // Step 1: create File object
        File file = new File(path);

        // Step 2: create FileWriter object
        try ( FileWriter fw = new FileWriter(file, true)) {
            fw.write(num + "\n");
//            PrintWriter pw = new PrintWriter(fw);
//            pw.println(pw);
        } catch (IOException e) {
            System.out.println("Writing file failed");
        }
    }

    /**
     * Writes a row of data into a file
     *
     * @param path the path of the file
     * @param nums the data to write: 1 2 3 4 5
     */
    public static void writeFileRow(String path, int[] nums) {
        File file = new File(path);

        try ( FileWriter fw = new FileWriter(file, true)) {
            for (int num : nums)
                fw.write(num + ",");
        } catch (IOException e) {
            System.out.println(String.format("%s: %s", e.getClass(), e.getMessage()));
        }
    }

    /**
     * Writes a column of data into a file
     *
     * @param path the path of the file
     * @param nums the data to write
     */
    public static void writeFileCol(String path, int[] nums) {
        File file = new File(path);

        try ( FileWriter fw = new FileWriter(file, true)) {
            for (int num : nums)
                fw.write(num + "\n");

        } catch (IOException e) {
            System.out.println(String.format("%s: %s", e.getClass(), e.getMessage()));
        }

    }

    /**
     * Writes a matrix of data into a file
     *
     * @param path the path of the file
     * @param numss the data to write
     */
    public static void writeFileTable(String path, int[][] numss) {
        File file = new File(path);

        try ( FileWriter fw = new FileWriter(file, true)) {
            for (int[] nums : numss) {
                for (int num : nums)
                    fw.write(num + ",");
                fw.write("\n");
            }

        } catch (IOException e) {
            System.out.println(String.format("%s: %s", e.getClass(), e.getMessage()));
        }
    }

}
