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

import java.util.Objects;

/**
 * A simple class of Publication
 *
 * @author Yi Wang
 */
public class Publication {

    private String id;
    private String title;
    private double price;

    private static int nextId = 1;

    public Publication() {
        this.id = String.format("%04d", nextId++);
        this.title = "";
        this.price = 0;
    }

    public Publication(String title, double price) {
        this.id = String.format("%04d", nextId++);
        this.title = title;
        this.price = price;
    }

    public Publication(Publication publication) {
        this.id = String.format("%04d", nextId++);
        this.title = publication.title;
        this.price = publication.price;
    }

    // ArrayList VS LinkedList      -> ArrayList: elements are continuously stored; LinkedList: elements are not continuously stored
    // List VS Set                  -> List: can have repeated value, support order; Set: cannot have repeated value, does not support order
    // HashSet<String> authors = new HashSet<>();
    // authors.add("Yi");   // for loop to go through all objects in the set, if java finds "yi", the will not add the new one, else add
    // so this part java has to call the equals() for n times, and calling the equals() method is very slow
    // hashcode() is a method that uses hash technology, that calcualte a special (not unique) integer number for an object
    // "Yi" -> 15343, this number is calcuated based on the values of the data members of the object
    // the hashcode is special but not unique, that is to say there is a very very low chance that two objects have very different
    // values of data members, but the hashcode can accidently be the same.
    // f(x): if you give me a x (the object), I can calculate a y (integer) for you
    // when you want to compare two objects, first calcuate the hashcode for the object, and then compare the hashcode with the hashcode
    // of other objects, if the hashcode are not the same, then the two objects are for sure not the same, so there is no need to call the
    // equals() to compare the two objects (that will save a lot of time). If two objects have the same hashcode, it does not mean the two
    // objects are the same, high chance the two objects are not the same (not 100%), then Java will call the equals() to compare the two
    // objects to decide if the two objects are really the same or not. But this will significantly decrease the chance you have to call
    // the equals() when you want to compare an object with others.
    // 27312   99111  15343
    // HashSet<Publication> ps
    // f(x) = ax1 + bx2 + cx3 + dx4 + e
    @Override
    public int hashCode() {
        int hash = 5;           // e
        hash = 53 * hash + Objects.hashCode(this.id);           // "0001" ->  731
        hash = 53 * hash + Objects.hashCode(this.title);        // "Advanced Java" -> 1921
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.price)
                ^ (Double.doubleToLongBits(this.price) >>> 32));
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
        final Publication other = (Publication) obj;
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price))
            return false;
        if (!Objects.equals(this.id, other.id))
            return false;
        if (!Objects.equals(this.title, other.title))
            return false;
        return true;
    }

    @Override
    public String toString() {
        String str = "";

        str += String.format("%-10s:%s\n", "ID", id);
        str += String.format("%-10s:%s\n", "Title", title);
        str += String.format("%-10s:%s\n", "Price", price);

        return str;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
