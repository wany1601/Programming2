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
 * A simple class of Magazine
 *
 * @author Yi Wang
 */
public class Magazine extends Publication {

    private double publicationFrequency;

    public Magazine() {
        super();
        this.publicationFrequency = 1;
    }

    public Magazine(double publicationFrequency, String title, double price) {
        super(title, price);
        this.publicationFrequency = publicationFrequency;
    }

    public Magazine(Magazine magazine) {
        super(magazine);
        this.publicationFrequency = magazine.publicationFrequency;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + super.hashCode();
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.publicationFrequency)
                ^ (Double.doubleToLongBits(this.publicationFrequency) >>> 32));
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
        final Magazine other = (Magazine) obj;
        if (!super.equals(other))
            return false;
        if (Double.doubleToLongBits(this.publicationFrequency)
                != Double.doubleToLongBits(other.publicationFrequency))
            return false;
        return true;
    }

    @Override
    public String toString() {
        String str = "";

        str += super.toString();
        str += String.format("%-10s:%.1f\n", "Publication Frequency", publicationFrequency);

        return str;
    }

    public double getPublicationFrequency() {
        return publicationFrequency;
    }

    public void setPublicationFrequency(double publicationFrequency) {
        this.publicationFrequency = publicationFrequency;
    }

}
