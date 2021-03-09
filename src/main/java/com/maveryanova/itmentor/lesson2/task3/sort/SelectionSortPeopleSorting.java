package com.maveryanova.itmentor.lesson2.task3.sort;

import com.maveryanova.itmentor.lesson2.task3.model.DuplicatedException;
import com.maveryanova.itmentor.lesson2.task3.model.Person;

public class SelectionSortPeopleSorting implements PeopleSorting {

    @Override
    public void sort(Person[] array) throws DuplicatedException {

        int outerCounter;
        int innerCounter;
        int indexMin;

        for (outerCounter = 0; outerCounter < array.length - 1; outerCounter++) {
            indexMin = outerCounter;
            for (innerCounter = outerCounter + 1; innerCounter < array.length; innerCounter++) {
                if (Person.compare(array[innerCounter], array[indexMin]) < 0) {
                    indexMin = innerCounter;
                }
            }
            swap(array, outerCounter, indexMin);
        }
    }
}
