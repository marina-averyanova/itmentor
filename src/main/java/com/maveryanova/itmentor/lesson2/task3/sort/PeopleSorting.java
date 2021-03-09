package com.maveryanova.itmentor.lesson2.task3.sort;

import com.maveryanova.itmentor.lesson2.task3.model.Person;

public interface PeopleSorting {
    void sort(Person[] person) throws Exception;

    default void swap(Person[] arr, int one, int two) {
        Person temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }
}
