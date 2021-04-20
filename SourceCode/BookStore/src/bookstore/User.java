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
import java.util.Objects;
import java.util.Random;

/**
 * A simple class of User
 *
 * @author Yi Wang
 */
public abstract class User extends Person implements Gift {

    private String id;
    private int point;

    public User() {
        super();
        this.id = "";
        this.point = 0;
    }

    public User(String id, int point, String name, String gender, String phoneNo, String email) {
        super(name, gender, phoneNo, email);
        this.id = id;
        this.point = point;
    }

    public User(User user) {
        super(user);
        this.id = user.id;
        this.point = user.point;
    }

    public abstract int calcPoint();

    @Override
    public boolean pointToGift(Item item) {
        final int cost = 100;

        if (point < cost || !item.isIsGift())
            return false;

        point -= cost;

        item.setAmount(item.getAmount() - 1);
        return true;
    }

    @Override
    public boolean pointToGift(String type) {
        final int cost = 70;

        if (point < cost)
            return false;

        point -= cost;

        ArrayList<Item> gifts = new ArrayList<>();

        for (Item item : BookStore.items)
            if (item.isIsGift())
                if ((type.equals("Book") && item instanceof Book)
                        || (type.equals("Cd") && item instanceof Cd))
                    gifts.add(item);

        Random rand = new Random();
        Item gift = gifts.get(rand.nextInt(gifts.size()));
        gift.setAmount(gift.getAmount() - 1);
        return true;
    }

    @Override
    public boolean pointToGift() {
        final int cost = 50;

        if (point < cost)
            return false;

        point -= cost;

        ArrayList<Item> gifts = new ArrayList<>();

        for (Item item : BookStore.items)
            if (item.isIsGift())
                gifts.add(item);

        Random rand = new Random();
        Item gift = gifts.get(rand.nextInt(gifts.size()));
        gift.setAmount(gift.getAmount() - 1);
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + super.hashCode();
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + this.point;
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
        final User other = (User) obj;
        if (!super.equals(other))
            return false;
        if (this.point != other.point)
            return false;
        if (!Objects.equals(this.id, other.id))
            return false;
        return true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

}
