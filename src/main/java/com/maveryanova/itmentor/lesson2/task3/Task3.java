package com.maveryanova.itmentor.lesson2.task3;

import com.google.gson.Gson;
import com.maveryanova.itmentor.lesson2.task3.model.Name;
import com.maveryanova.itmentor.lesson2.task3.model.Person;
import com.maveryanova.itmentor.lesson2.task3.model.Sex;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Task3 {
    // 3. Дан массив объектов Person.
    // Класс Person характеризуется полями
    // age (возраст, целое число 0-100),
    // sex (пол – объект класса Sex со строковыми константами внутри MAN, WOMAN),
    // name (имя - строка).
    // Создать два класса, методы которых будут реализовывать сортировку объектов.
    // Предусмотреть единый интерфейс для классов сортировки. Реализовать два различных метода сортировки этого массива по правилам:
    // первые идут мужчины
    // выше в списке тот, кто более старший
    // имена сортируются по алфавиту
    // Программа должна вывести на экран отсортированный список и время работы каждого алгоритма сортировки.
    // Предусмотреть генерацию исходного массива (10000 элементов и более).
    // Если имена людей и возраст совпадают, выбрасывать в программе пользовательское исключение.

    private Name[] maleNames;
    private Name[] femaleNames;

    private static final String MALE_NAMES_FILE = "male_names.json";
    private static final String FEMALE_NAMES_FILE = "female_names.json";

     {
         try {
             maleNames = read(MALE_NAMES_FILE);
             femaleNames = read(FEMALE_NAMES_FILE);
         } catch (IOException e) {
             e.printStackTrace();
         }
    }

    public void sortPeople(int n) throws Exception {
        System.out.println("generate people array of " + n + " elements");
        Person[] array1 = new Person[n];

        for (int i = 0; i < n; i++) {
            array1[i] = generatePerson();
        }

        Person[] array2 = Arrays.copyOf(array1, array1.length);

        SelectionSortPeopleSorting sort1 = new SelectionSortPeopleSorting();
        HeapSortPeopleSorting sort2 = new HeapSortPeopleSorting();

        System.out.println("start to sort with selection sort");
        Instant start1 = Instant.now();
        sort1.sort(array1);
        Instant end1 = Instant.now();

        System.out.println("selection sort duration=" + (end1.toEpochMilli() - start1.toEpochMilli()));

        System.out.println("start to sort with heap sort");
        Instant start2 = Instant.now();
        sort2.sort(array2);
        Instant end2 = Instant.now();

        System.out.println("heap  duration=" + (end2.toEpochMilli() - start2.toEpochMilli()));
        System.out.println(Arrays.toString(array2));
    }

    private Person generatePerson() {
        int age = generateAge();
        Sex sex = generateSex() == 1 ? Sex.WOMAN : Sex.MAN;
        String name = generateName(sex);
        return new Person(age, sex, name);
    }

    private int generateAge() {
        return ThreadLocalRandom.current().nextInt(1, 100 + 1);
    }

    private int generateSex() {
        return ThreadLocalRandom.current().nextInt(1, 2 + 1);
    }

    public String generateName(Sex sex) {
        int id;
        if (sex.equals(Sex.WOMAN)) {
            id = ThreadLocalRandom.current().nextInt(1, femaleNames.length + 1);
            return femaleNames[id].name;
        } else {
            id = ThreadLocalRandom.current().nextInt(1, maleNames.length + 1);
            return maleNames[id].name;
        }
    }

    private Name[] read(String fileName) throws IOException {
        File file = new File(getClass().getClassLoader().getResource(fileName).getFile());
        String content = new String(Files.readAllBytes(file.toPath()));

        Gson gson = new Gson();
        return gson.fromJson(content, Name[].class);
    }

    public void write(String fileName, String str) throws IOException {
        Path path = Paths.get(fileName);
        byte[] strToBytes = str.getBytes();

        Files.write(path, strToBytes);
    }
}
