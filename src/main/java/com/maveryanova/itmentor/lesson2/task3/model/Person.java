package com.maveryanova.itmentor.lesson2.task3.model;

public class Person {
    public int age;
    public Sex sex;
    public String name;

    public Person(int age, Sex sex, String name) {
        this.age = age;
        this.sex = sex;
        this.name = name;
    }

    public static int compare(Person p1, Person p2) throws DuplicatedException {
        if (!p1.equals(p2) && p1.age == p2.age && p1.name.equals(p2.name) && p1.sex.equals(p2.sex)) {
            throw new DuplicatedException();
        }

        int sexCompareResult = p1.sex.compareTo(p2.sex);
        if (sexCompareResult > 0) return 1;
        if (sexCompareResult < 0) return -1;

        if (p1.age > p2.age) return -1;

        if (p1.age < p2.age) return 1;

        if (p1.name.compareToIgnoreCase(p2.name) < 0) {
            return  -1;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
            "age=" + age +
            ", sex=" + sex +
            ", name='" + name + '\'' +
            '}';
    }
}
