package com.maveryanova.itmentor.lesson2.task3.sort;

import com.maveryanova.itmentor.lesson2.task3.model.DuplicatedException;
import com.maveryanova.itmentor.lesson2.task3.model.Person;

public class HeapSortPeopleSorting implements PeopleSorting {

    @Override
    public void sort(Person[] array) throws DuplicatedException {
        // build start heap
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, i, array.length);
        }

        for (int i = array.length - 1; i >= 0; i--) {
            swap(array, 0, i);
            heapify(array, 0, i);
        }
    }

    private void heapify(Person[] array, int rootIndex, int heapSize) throws DuplicatedException {
        // max element goes to root
        int leftChildIndex = 2 * rootIndex + 1;
        int rightChildIndex = leftChildIndex + 1;

        int tempIndex = rootIndex;

        if (leftChildIndex < heapSize && Person.compare(array[tempIndex], array[leftChildIndex]) < 0)
            tempIndex = leftChildIndex;
        if (rightChildIndex < heapSize && Person.compare(array[tempIndex], array[rightChildIndex]) < 0)
            tempIndex = rightChildIndex;

        if (rootIndex == tempIndex)
            return;

        swap(array, tempIndex, rootIndex);

        heapify(array, tempIndex, heapSize);
    }
}
