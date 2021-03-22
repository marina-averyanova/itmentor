package com.maveryanova.itmentor.lesson4.model;

import java.util.Objects;

// объект класс Person с полями – имя, возраст, пол)
public class Person implements Comparable<Person> {
    String name;
    int age;
    Sex sex;

    public Person(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && sex == person.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex);
    }

    @Override
    public int compareTo(Person o) {
        return compare(this, o);
    }

    private static int compare(Person p1, Person p2) {
        return p1.name.compareToIgnoreCase(p2.name);
    }
}
