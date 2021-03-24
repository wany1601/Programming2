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
package bookrentingstore;

/**
 * A simple class for Employee
 *
 * @author Yi Wang
 */
public class Employee extends User {

    private double salary;

    public Employee() {
        super();
        this.salary = salary;
    }

    public Employee(double salary, String id, String name, String gender, String email) {
        super(id, name, gender, email);
        this.salary = salary;
    }

    public Employee(Employee employee) {
        super(employee);
        this.salary = employee.salary;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + super.hashCode();
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.salary)
                ^ (Double.doubleToLongBits(this.salary) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Employee other = (Employee) obj;
        if (!super.equals(other))
            return false;
        if (Double.doubleToLongBits(this.salary) != Double.doubleToLongBits(other.salary))
            return false;
        return true;
    }

    @Override
    public String toString() {
        String str = "";

        str += super.toString();
        str += String.format("%-10s:%.2f\n", "Salary", salary);

        return str;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
