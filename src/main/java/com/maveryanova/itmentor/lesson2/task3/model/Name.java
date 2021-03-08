package com.maveryanova.itmentor.lesson2.task3.model;

public class Name {
    public int id;
    public String name;
    public Sex sex;

    public Name(int id, String name, Sex sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Name{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", sex=" + sex +
            '}';
    }
}
