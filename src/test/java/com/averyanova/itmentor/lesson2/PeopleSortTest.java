package com.averyanova.itmentor.lesson2;

import com.maveryanova.itmentor.lesson2.task3.sort.HeapSortPeopleSorting;
import com.maveryanova.itmentor.lesson2.task3.sort.SelectionSortPeopleSorting;
import com.maveryanova.itmentor.lesson2.task3.Task3;
import com.maveryanova.itmentor.lesson2.task3.model.DuplicatedException;
import com.maveryanova.itmentor.lesson2.task3.model.Person;
import com.maveryanova.itmentor.lesson2.task3.model.Sex;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PeopleSortTest {

    @Test
    public void selectionSortTest() throws Exception {
        Person[] arr = new Person[] {
            new Person(20, Sex.MAN, "Аркадий"),
            new Person(30, Sex.WOMAN, "Анна"),
            new Person(20, Sex.MAN, "Александр"),
            new Person(42, Sex.WOMAN, "Антонина"),
            new Person(35, Sex.MAN, "Антон"),
            new Person(42, Sex.WOMAN, "Александра"),
            new Person(18, Sex.MAN, "Алексей"),
            new Person(7, Sex.WOMAN, "Алёна"),
            new Person(28, Sex.MAN, "Арсений"),
            new Person(34, Sex.WOMAN, "Алиса"),
            new Person(20, Sex.MAN, "Мишель"),
            new Person(20, Sex.WOMAN, "Мишель")
        };

        Person[] expected = new Person[] {
            new Person(35, Sex.MAN, "Антон"),
            new Person(28, Sex.MAN, "Арсений"),
            new Person(20, Sex.MAN, "Александр"),
            new Person(20, Sex.MAN, "Аркадий"),
            new Person(20, Sex.MAN, "Мишель"),
            new Person(18, Sex.MAN, "Алексей"),
            new Person(42, Sex.WOMAN, "Александра"),
            new Person(42, Sex.WOMAN, "Антонина"),
            new Person(34, Sex.WOMAN, "Алиса"),
            new Person(30, Sex.WOMAN, "Анна"),
            new Person(20, Sex.WOMAN, "Мишель"),
            new Person(7, Sex.WOMAN, "Алёна")
        };

        SelectionSortPeopleSorting sorting = new SelectionSortPeopleSorting();
        sorting.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            assertEquals(expected[i].age, arr[i].age);
            assertEquals(expected[i].sex, arr[i].sex);
            assertEquals(expected[i].name, arr[i].name);
        }
    }

    @Test
    public void selectionSortExceptionTest() {
        Person[] arr = new Person[] {
            new Person(20, Sex.MAN, "Аркадий"),
            new Person(20, Sex.MAN, "Аркадий")
        };

        SelectionSortPeopleSorting sorting = new SelectionSortPeopleSorting();

        try {
            sorting.sort(arr);
        } catch (DuplicatedException e) {
            assertEquals("two equal people!", e.getMessage());
        }
    }

    @Test
    public void heapSortTest() throws Exception {
        Person[] arr = new Person[] {
            new Person(20, Sex.MAN, "Аркадий"),
            new Person(30, Sex.WOMAN, "Анна"),
            new Person(20, Sex.MAN, "Александр"),
            new Person(42, Sex.WOMAN, "Антонина"),
            new Person(35, Sex.MAN, "Антон"),
            new Person(42, Sex.WOMAN, "Александра"),
            new Person(18, Sex.MAN, "Алексей"),
            new Person(7, Sex.WOMAN, "Алёна"),
            new Person(28, Sex.MAN, "Арсений"),
            new Person(34, Sex.WOMAN, "Алиса"),
            new Person(20, Sex.MAN, "Мишель"),
            new Person(20, Sex.WOMAN, "Мишель")
        };

        Person[] expected = new Person[] {
            new Person(35, Sex.MAN, "Антон"),
            new Person(28, Sex.MAN, "Арсений"),
            new Person(20, Sex.MAN, "Александр"),
            new Person(20, Sex.MAN, "Аркадий"),
            new Person(20, Sex.MAN, "Мишель"),
            new Person(18, Sex.MAN, "Алексей"),
            new Person(42, Sex.WOMAN, "Александра"),
            new Person(42, Sex.WOMAN, "Антонина"),
            new Person(34, Sex.WOMAN, "Алиса"),
            new Person(30, Sex.WOMAN, "Анна"),
            new Person(20, Sex.WOMAN, "Мишель"),
            new Person(7, Sex.WOMAN, "Алёна")
        };

        HeapSortPeopleSorting sorting = new HeapSortPeopleSorting();
        sorting.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            assertEquals(expected[i].age, arr[i].age);
            assertEquals(expected[i].sex, arr[i].sex);
            assertEquals(expected[i].name, arr[i].name);
        }
    }

    @Test
    public void heapSortExceptionTest() {
        Person[] arr = new Person[] {
            new Person(20, Sex.MAN, "Аркадий"),
            new Person(20, Sex.MAN, "Аркадий")
        };

        HeapSortPeopleSorting sorting = new HeapSortPeopleSorting();

        try {
            sorting.sort(arr);
        } catch (DuplicatedException e) {
            assertEquals("two equal people!", e.getMessage());
        }
    }

    @Test
    public void mainMethodTest() throws Exception {
        Task3 task3 = new Task3();
        task3.sortPeople(30);
    }
}
