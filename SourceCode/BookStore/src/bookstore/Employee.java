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
package bookstore;

/**
 *
 * @author Yi Wang
 */
public class Employee extends User {

    private double salary;
    private static int nextEmployeeId = 1;

    public Employee() {
        super();
        this.salary = salary;
        setId(String.format("E%04d", nextEmployeeId++));
    }

    public Employee(double salary, String id, int point, String name, String gender, String phoneNo, String email) {
        super(id, point, name, gender, phoneNo, email);
        this.salary = salary;
        setId(String.format("E%04d", nextEmployeeId++));
    }

    public Employee(Employee employee) {
        super(employee);
        this.salary = employee.salary;
        setId(String.format("E%04d", nextEmployeeId++));
    }

    @Override
    public int calcPoint() {
        double ratio = 0.01;
        return (int) (salary * ratio);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static int getNextEmployeeId() {
        return nextEmployeeId;
    }

    public static void setNextEmployeeId(int nextEmployeeId) {
        Employee.nextEmployeeId = nextEmployeeId;
    }

}
