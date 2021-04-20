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

import java.util.Objects;

/**
 *
 * @author Yi Wang
 */
public class Item {

    protected String itemNo;
    protected double price;
    protected int amount;
    protected String category;
    protected boolean isGift;

    public Item() {
        this.itemNo = "";
        this.price = 0;
        this.amount = 0;
        this.category = "";
        this.isGift = false;
    }

    public Item(String itemNo, double price, int amount, String category, boolean isGift) {
        this.itemNo = itemNo;
        this.price = price;
        this.amount = amount;
        this.category = category;
        this.isGift = isGift;
    }

    public Item(Item item) {
        this.itemNo = itemNo;
        this.price = price;
        this.amount = amount;
        this.category = category;
        this.isGift = isGift;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.itemNo);
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.price)
                ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 17 * hash + Objects.hashCode(this.category);
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
        final Item other = (Item) obj;
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price))
            return false;
        if (this.amount != other.amount)
            return false;
        if (!Objects.equals(this.category, other.category))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Item{" + "itemNo=" + itemNo + ", price=" + price + ", amount=" + amount + ", category=" + category + ", isGift=" + isGift + '}';
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isIsGift() {
        return isGift;
    }

    public void setIsGift(boolean isGift) {
        this.isGift = isGift;
    }

}
