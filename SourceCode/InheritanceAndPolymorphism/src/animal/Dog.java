package animal;

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
import animal.DomesticatedAnimal;
import java.util.Scanner;

/**
 * A class of Dog
 *
 * @author Yi Wang
 */
public class Dog extends DomesticatedAnimal {

    private int sportHour;

    public Dog() {
        super();
        this.sportHour = 0;
    }

    public Dog(int sportHour, int closeToHumanLevel, String name, String type, int age, String gender) {
        super(closeToHumanLevel, name, type, age, gender);
        this.sportHour = sportHour;
    }

    public Dog(Dog dog) {
        super(dog);
        this.sportHour = dog.sportHour;
    }

    /**
     * Prints hello + the name of the dog
     */
    public void changeName() {
        System.out.println("Hello " + name);
        System.out.println("What name do you want to change to?");
        Scanner console = new Scanner(System.in);
        String newName = console.next();
        name = newName;
        System.out.println("Alright, you name has been changed to " + name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Dog other = (Dog) obj;
        if (!super.equals(other))
            return false;
        if (this.sportHour != other.sportHour)
            return false;
        return true;
    }

    public boolean equals(Dog dog) {
        return super.equals(dog) && this.sportHour == dog.sportHour;
    }

    @Override
    public String toString() {
        String str = "";

        str += super.toString();
        str += String.format("%-10s: %d\n", "SportHour", sportHour);

        return str;
    }

    public int getSportHour() {
        return sportHour;
    }

    public void setSportHour(int sportHour) {
        this.sportHour = sportHour;
    }

}
