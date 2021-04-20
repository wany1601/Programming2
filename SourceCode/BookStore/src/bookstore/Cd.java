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
public class Cd extends Item {

    protected String name;
    protected Person artist;
    private static int nextCdNo = 1;

    public Cd() {
        super();
        this.name = name;
        this.artist = artist;
        setItemNo(String.format("C%04d", nextCdNo++));
    }

    public Cd(String name, Person artist, String itemNo, double price, int amount, String category, boolean isGift) {
        super(itemNo, price, amount, category, isGift);
        this.name = name;
        this.artist = artist;
        setItemNo(String.format("C%04d", nextCdNo++));
    }

    public Cd(Cd cd) {
        super(cd);
        this.name = cd.name;
        this.artist = new Person(cd.artist);
        setItemNo(String.format("C%04d", nextCdNo++));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getArtist() {
        return artist;
    }

    public void setArtist(Person artist) {
        this.artist = artist;
    }

    public static int getNextCdNo() {
        return nextCdNo;
    }

    public static void setNextCdNo(int nextCdNo) {
        Cd.nextCdNo = nextCdNo;
    }
}
