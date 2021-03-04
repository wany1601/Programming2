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

import java.util.Objects;

/**
 * A class of Animal
 *
 * @author Yi Wang
 */
public class Animal {

    String name;
    private String type;
    private int age;
    private String gender;

    public Animal() {
        this.name = "";
        this.type = "";
        this.age = -1;
        this.gender = "";
    }

    public Animal(String name, String type, int age, String gender) {
        this.name = name;
        this.type = type;
        this.age = age;
        this.gender = gender;
    }

    public Animal(Animal animal) {
        this.name = animal.name;
        this.type = animal.type;
        this.age = animal.age;
        this.gender = animal.gender;
    }

    @Override
    public boolean equals(Object obj) {
        // part 1
        if (this == obj)        // comparing address
            return true;
        if (obj == null)        // a.equals(xx)
            return false;
        if (getClass() != obj.getClass())
            return false;

        // part 2
        final Animal other = (Animal) obj;      // casting the data type

        // part 3
        if (this.age != other.age)
            return false;
        if (!Objects.equals(this.name, other.name))
            return false;
        if (!Objects.equals(this.type, other.type))
            return false;
        if (!Objects.equals(this.gender, other.gender))
            return false;
        return true;
    }

    // overload
    public boolean equals(Animal animal) {
        return this.name.equals(animal.name)
                && this.type.equals(animal.type)
                && this.age == animal.age
                && this.gender.equals(animal.gender);
    }

    @Override
    public String toString() {
        String str = "";

        str += String.format("%-10s: %s\n", "Name", name);
        str += String.format("%-10s: %s\n", "Type", type);
        str += String.format("%-10s: %d\n", "Age", age);
        str += String.format("%-10s: %s\n", "Gender", gender);

        return str;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
