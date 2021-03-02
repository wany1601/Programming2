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
package animal;

/**
 * A class of DomesticatedAnimal
 *
 * @author Yi Wang
 */
public class DomesticatedAnimal extends Animal {

    private int closeToHumanLevel;

    public DomesticatedAnimal() {
        // super means "Animal" here,
        // you can only call super constructor in the first line
        super();
        this.closeToHumanLevel = 0;
    }

    public DomesticatedAnimal(int closeToHumanLevel, String name,
            String type, int age, String gender) {
        super(name, type, age, gender);
        this.closeToHumanLevel = closeToHumanLevel;
    }

    public DomesticatedAnimal(DomesticatedAnimal domesticatedAnimal) {
        // polymorphism: DomesticatedAnimal extends Animal
        // DomesticatedAnimal is a special kind of Animal
        // if a method requires a parameter of class B, when you call the method
        // you can give an object of class B, or you can also give an object of
        // any subclass of class B.
        super(domesticatedAnimal);
        this.closeToHumanLevel = domesticatedAnimal.closeToHumanLevel;
    }

    @Override
    public boolean equals(Object obj) {
        // part 1
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        // part 2
        final DomesticatedAnimal other = (DomesticatedAnimal) obj;

        // part 3
        if (!super.equals(other))
            return false;
        if (this.closeToHumanLevel != other.closeToHumanLevel)
            return false;
        return true;
    }

    // overload
    public boolean equals(DomesticatedAnimal domesticatedAnimal) {
        return super.equals(domesticatedAnimal)
                && this.closeToHumanLevel == domesticatedAnimal.closeToHumanLevel;
    }

    @Override
    public String toString() {
        String str = "";

        str += super.toString();
        str += String.format("%-10s: %d\n", "CloseLevel", closeToHumanLevel);

        return str;
    }

    public int getCloseToHumanLevel() {
        return closeToHumanLevel;
    }

    public void setCloseToHumanLevel(int closeToHumanLevel) {
        this.closeToHumanLevel = closeToHumanLevel;
    }

}
