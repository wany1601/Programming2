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

import java.util.ArrayList;

/**
 *
 * @author Yi Wang
 */
public class BookStore {

    protected static ArrayList<Item> items = new ArrayList<>();
    protected static ArrayList<Employee> employees = new ArrayList<>();
    protected static ArrayList<Customer> customers = new ArrayList<>();

    private static void addItem(Item item) {
        for (Item itemInStore : items)
            if (item.equals(itemInStore)) {
                itemInStore.amount += item.amount;
                return;
            }

        items.add(item);
    }

    private static void addEmployee(Employee employee) {
        employees.add(employee);
    }

    private static void addCustomer(Customer customer) {
        customers.add(customer);
    }

    private static ArrayList<Item> searchItem(String keyword) {
        ArrayList<Item> results = new ArrayList<>();

        for (Item item : items)
            if (item instanceof Book && ((Book) item).title.contains(keyword))
                results.add(item);
            else if (item instanceof Cd && ((Cd) item).name.contains(keyword))
                results.add(item);

        return results;
    }

    private static void payEmployeesPoints() {
        for (Employee employee : employees)
            employee.setPoint(employee.getPoint() + employee.calcPoint());
    }

}
