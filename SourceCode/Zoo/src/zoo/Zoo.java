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
import java.util.HashSet;

/**
 * A simple class of Zoo
 *
 * @author Yi Wang
 */
public class Zoo {

    private ArrayList<Animal> animals;

    public Zoo() {
        this.animals = new ArrayList<>();
    }

    public Zoo(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public Zoo(Zoo zoo) {
        this.animals = new ArrayList<>(zoo.animals);
    }

    /**
     * Counts the number of a specific type of animal in the zoo
     *
     * @param type the specific type of animal you want to count
     * @return the number of a specific type of animal in the zoo
     */
    public int countAnimals(String type) {
        int count = 0;

        for (Animal animal : animals)
            if (animal.getType().equalsIgnoreCase(type))
                count++;

        return count;
    }

    /**
     * Goes through VALID_TYPES and check if in the zoo there are animals belong
     * to each of the type, if not then remove that type from the VALID_TYPES
     */
    public void updateValidTypes() {
        ArrayList<String> validTypes = Animal.getVALID_TYPES();
        boolean valid;
        for (int i = 0; i < validTypes.size(); i++) {
            valid = false;          // assume the type is not valid

            for (Animal animal : animals)
                if (animal.getType().equalsIgnoreCase(validTypes.get(i))) {
                    valid = true;       // if one animal belong to the type, set valid to true
                    break;
                }

            if (!valid) // remove if valid is still false
                validTypes.remove(i--);
        }
    }

    /**
     * Goes through VALID_TYPES and check if in the zoo there are animals belong
     * to each of the type, if not then remove that type from the VALID_TYPES
     */
    public void updateValidTypes2() {
        HashSet<String> existTypes = new HashSet<>();

        for (Animal animal : animals)
            existTypes.add(animal.getType());

        ArrayList<String> validTypes = Animal.getVALID_TYPES();
        for (int i = 0; i < validTypes.size(); i++) {
            if (!existTypes.contains(validTypes.get(i)))
                validTypes.remove(i--);
        }
    }

    /**
     * Checks if the difference between the amount of female and the amount of
     * male of a type is less than a specific threshold
     *
     * @param type the specific type you want to check
     * @return if the difference between the amount of female and the amount of
     * male of a type is less than a specific threshold
     */
    public boolean isGenderBalanced(String type) {
        int[] nums = calcGenderDistribution(type);
        double threshold = 0.2;

        return Math.abs(nums[0] - nums[1]) < (nums[0] + nums[1]) * threshold;
    }

    /**
     * Checks the number of male and the number of female of a type
     *
     * @param type the type you want to check
     * @return the number of male and the number of female of a type
     */
    public int[] calcGenderDistribution(String type) {
        int[] nums = new int[2];

        for (Animal animal : animals)
            if (animal.getType().equalsIgnoreCase(type))
                if (animal.getGender().equalsIgnoreCase("male"))
                    nums[0]++;
                else
                    nums[1]++;

        return nums;
    }

    /**
     * Checks the number of male and the number of female in the zoo
     *
     * @return the number of male and the number of female of a type
     */
    public int[] calcGenderDistribution() {
        int[] nums = new int[2];

        for (Animal animal : animals)
            if (animal.getGender().equalsIgnoreCase("male"))
                nums[0]++;
            else
                nums[1]++;

        return nums;
    }

    /**
     * Finds the oldest age of a specific type
     *
     * @param type the type you want to check
     * @return the oldest age of a specific type
     */
    public int calcOldest(String type) {
        int age = -1;

        for (Animal animal : animals)
            if (animal.getType().equalsIgnoreCase(type))
                age = Math.max(age, animal.getAge());

        return age;
    }

    /**
     * Removes the oldest animal of a specific type
     *
     * @param type the type of animal you want to remove
     */
    public void removeOldest(String type) {
        int age = calcOldest(type);

        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getType().equalsIgnoreCase(type))
                if (animals.get(i).getAge() == age)
                    animals.remove(i--);
        }
    }

    @Override
    public String toString() {
        String str = "";

        str += String.format("Total Number of Animals: %d\n", animals.size());
        str += String.format("Male: %d\n", calcGenderDistribution()[0]);
        str += String.format("Female: %d\n\n", calcGenderDistribution()[1]);

        for (String type : Animal.getVALID_TYPES()) {
            str += type + ":";
            int[] nums = calcGenderDistribution();

            str += String.format("%-10s: %d\n", "Number", nums[0] + nums[1]);
            str += String.format("%-10s: %d\n", "Male", nums[0]);
            str += String.format("%-10s: %d\n", "Female", nums[1]);
            str += String.format("%-10s: %s\n", "Balanced",
                    isGenderBalanced(type) ? "Yes" : "No");
            str += String.format("%-10s: %d\n", "Oldset age", calcOldest(type));
        }

        return str;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }
}
