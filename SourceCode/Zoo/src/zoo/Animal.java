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
package zoo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A simple class of Animal
 *
 * @author Yi Wang
 */
public class Animal {

    private String name;
    private String gender;
    private int age;
    private String type;
    private static final ArrayList<String> VALID_TYPES
            = new ArrayList<>(Arrays.asList(new String[]{"Cat", "Dog", "Monkey"}));

    public Animal() {
        this.name = "";
        this.gender = "";
        this.age = -1;
        this.type = "";
    }

    public Animal(String name, String gender, int age, String type) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.type = isTypeValid(type) ? type : "";
    }

    public Animal(Animal animal) {
        this.name = animal.name;
        this.gender = animal.gender;
        this.age = animal.age;
        this.type = animal.type;
    }

    /**
     * Checks if the type is valid, in the other word, belongs to the
     * VALID_TYPES
     *
     * @param type the type you want to check
     * @return if the type is valid, in the other word, belongs to the
     * VALID_TYPES
     */
    public boolean isTypeValid(String type) {
        for (String validType : VALID_TYPES)
            if (validType.equalsIgnoreCase(type))
                return true;

        return false;
    }

    public boolean equals(Animal animal) {
        return this.name.equals(animal.name)
                && this.gender.equals(animal.gender)
                && this.age == animal.age
                && this.type.equals(animal.type);
    }

    @Override
    public String toString() {
        String str = "";

        str += String.format("%-10s: %s\n", "Name", name);
        str += String.format("%-10s: %s\n", "Gender", gender);
        str += String.format("%-10s: %d\n", "Age", age);
        str += String.format("%-10s: %s\n", "Type", type);

        return str;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (isTypeValid(type))
            this.type = type;
    }

    public static ArrayList<String> getVALID_TYPES() {
        return VALID_TYPES;
    }

}
