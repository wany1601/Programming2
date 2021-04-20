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
public class Customer extends User {

    private int vipLevel;
    private ArrayList<Item> itemsInCart;
    private static int nextCustomerId;

    public Customer() {
        super();
        this.vipLevel = 0;
        this.itemsInCart = new ArrayList<>();
    }

    public Customer(int vipLevel, ArrayList<Item> itemsInCart, String id, int point, String name, String gender, String phoneNo, String email) {
        super(id, point, name, gender, phoneNo, email);
        this.vipLevel = vipLevel;
        this.itemsInCart = itemsInCart;
    }

    public Customer(Customer customer) {
        super(customer);
        this.vipLevel = customer.vipLevel;
        this.itemsInCart = new ArrayList<>(customer.itemsInCart);
    }

    private boolean updateVip() {
        int[] costs = {50, 100, 150};

        if (vipLevel < 0 || vipLevel >= costs.length)
            return false;

        if (getPoint() < costs[vipLevel])
            return false;

        vipLevel++;
        setPoint(getPoint() - costs[vipLevel]);
        return true;
    }

    public void addItemToCart(Item item, int amount) {
        Item item2 = new Item(item);

        item2.setAmount(amount);

        itemsInCart.add(item2);
    }

    public double calcPrice() {
        double sum = 0;

        for (Item item : itemsInCart)
            sum += item.getPrice() * item.getAmount();

        return sum;
    }

    public int calcPoint() {
        double extraPointThreshould = 200;
        double extraPoint = 20;
        double[] ratios = {0, 0.05, 0.1, 0.15};

        double price = calcPrice();
        int sum = (int) price;

        sum += (int) (price * ratios[vipLevel]);

        if (price > extraPointThreshould)
            sum += extraPoint;

        return sum;
    }

    public boolean checkout() {

        for (int i = 0; i < itemsInCart.size(); i++) {
            boolean enoughProdoct = false;

            for (Item itemInStore : BookStore.items)
                if (itemsInCart.get(i).equals(itemInStore)
                        && itemInStore.getAmount() >= itemsInCart.get(i).getAmount())
                    enoughProdoct = true;

            if (!enoughProdoct)
                return false;

        }

        int newPoint = calcPoint();
        double price = calcPrice();

        setPoint(getPoint() + newPoint);

        for (Item itemInCart : itemsInCart) {
            for (Item itemInStore : BookStore.items)
                if (itemInCart.equals(itemInStore)) {
                    itemInStore.setAmount(itemInStore.getAmount() - itemInCart.getAmount());
                    itemsInCart.remove(itemInCart);
                }
        }

        return true;
    }

}
