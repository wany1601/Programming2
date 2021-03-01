/*
 * The MIT License
 *
 * Copyright 2021 George Aziz.
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
import java.util.List;

/**
 * A simple class of zoo, that contains many different animals
 *
 * @author George Aziz
 */
public class Zoo {

    private ArrayList<Animal> animals;

    public Zoo() {
        animals = new ArrayList<>();
    }

    public Zoo(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public Zoo(Zoo zoo) {
        this.animals = new ArrayList<>(zoo.animals);
    }

    /**
     * Counts how many animals are in the zoo that have the same type
     *
     * @param type the specific type of the animals
     * @return the number of animals that share a specific type
     */
    public int countAnimals(String type) {
        int count = 0;

        for (Animal animal : animals)
            if (animal.getType().equalsIgnoreCase(type))
                count++;

        return count;
    }

    /**
     * Updates the valid types in the zoo
     */
    public void updateValidType() {
        Animal.getLegalTypes().removeAll(Animal.getLegalTypes());

        for (Animal animal : animals)
            if (!Animal.getLegalTypes().contains(animal.getType()))
                Animal.getLegalTypes().add(animal.getType());
    }

    /**
     * Checks if the gender in the zoo is balanced or not in a specific type of
     * animals
     *
     * @param type the specific type of animals
     * @return whether the gender is balanced or not
     */
    public boolean isGenderBalanced(String type) {
        int countMale = 0;
        int countFemale = 0;

        for (Animal animal : animals) {
            while (animal.getType().equalsIgnoreCase(type))
                if (animal.getGender().equalsIgnoreCase("male"))
                    countMale++;
                else
                    countFemale++;
        }
        double difference = Math.abs(countFemale - countMale);
        if (difference / countAnimals(type) < 0.2)
            return false;

        return true;
    }

    /**
     * Removes the oldest animal in the zoo in a specific type and updates the
     * valid types in the zoo at the end
     *
     * @param type the specific type
     */
    public void removeOldest(String type) {
        int max = 0;

        for (Animal animal : animals) {
            if (animal.getType().equalsIgnoreCase(type))
                max = Math.max(max, animal.getAge());
        }
        for (int i = 0; i < animals.size(); i++)
            if (animals.get(i).getType().equalsIgnoreCase(type))
                if (animals.get(i).getAge() == max) {
                    animals.remove(i);
                    i--;
                }

        updateValidType();
    }

    public boolean equals(Zoo zoo) {
        return this.animals.equals(zoo.animals);
    }

    @Override
    public String toString() {
        String str = "";
        int countMale = 0;
        int countFemale = 0;

        //header
        str += String.format("%s: %d\n", "Total Number of Animals", animals.size());
        for (Animal animal : animals)
            if (animal.getGender().equalsIgnoreCase("male"))
                countMale++;
            else
                countFemale++;
        str += String.format("%s: %d\n", "Male", countMale);
        str += String.format("%s: %d\n\n", "Female", countFemale);

//body
        for (int i = 0; i < Animal.getLegalTypes().size(); i++) {
            str += String.format("%s\n", Animal.getLegalTypes().get(i));
            str += String.format("%s: %d\n", "Number",
                    calcStatistic(Animal.getLegalTypes().get(i))[0]
                    + calcStatistic(Animal.getLegalTypes().get(i))[1]);
            str += String.format("%s: %d\n", "Female",
                    calcStatistic(Animal.getLegalTypes().get(i))[1]);
            str += String.format("%s: %d\n", "Male",
                    calcStatistic(Animal.getLegalTypes().get(i))[0]);
            str += String.format("%s: %s\n", "Balanced",
                    (isGenderBalanced(Animal.getLegalTypes().get(i)) ? "Yes" : "No"));
            str += String.format("%s: %d\n", "Oldes",
                    calcStatistic(Animal.getLegalTypes().get(i))[2]);
        }

        return str;
    }

    /**
     * Calculates all the statistics of a specific type of an animal
     *
     * @param type specific type of an animal
     * @return the array with all the statistics
     */
    public int[] calcStatistic(String type) {
        int[] calcStatistics = new int[3];

        for (Animal animal : animals) {
            if (type.equalsIgnoreCase(animal.getType())) {
                if (animal.getGender().equalsIgnoreCase("male"))
                    calcStatistics[0]++;
                if (animal.getGender().equalsIgnoreCase("male"))
                    calcStatistics[1]++;
                calcStatistics[2] = Math.max(calcStatistics[2], animal.getAge());
            }
        }

        return calcStatistics;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public static void main(String[] args) {
        Animal a1 = new Animal("Copain", "male", 5, "Dog");
        Animal a2 = new Animal("Copain", "female", 5, "Dog");
        Animal a3 = new Animal("Copain", "male", 5, "Cat");
        Animal a4 = new Animal("Copain", "male", 5, "Monkey");

        ArrayList<Animal> animals = new ArrayList<>(Arrays.asList(new Animal[]{a1, a2, a3, a4}));
        Zoo zoo = new Zoo(animals);

        System.out.println(zoo);
    }
}
