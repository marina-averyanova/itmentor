package com.maveryanova.itmentor.lesson4.model;

import java.util.Objects;

//  У каждого животного есть уникальный идентификационный номер, кличка, хозяин (объект класс Person с полями – имя, возраст, пол), вес.
public class Pet implements Comparable<Pet> {
    private final int id;

    private String name;
    private Person owner;
    private int weight;

    public Pet(int id, String name, Person owner, int weight) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.weight = weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet)) return false;
        Pet pet = (Pet) o;
        return id == pet.id && weight == pet.weight && name.equals(pet.name) && owner.equals(pet.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, owner, weight);
    }

    @Override
    public int compareTo(Pet o) {
        return compare(this, o);
    }

    private static int compare(Pet pet1, Pet pet2) {
        if (pet1.owner.compareTo(pet2.owner) == 0) {
            int nameCompareResult = pet1.name.compareTo(pet2.name);
            if (nameCompareResult == 0) {
                return pet1.weight > pet2.weight ? -1 : 1;
            } else return nameCompareResult;
        }
        if (pet1.owner.compareTo(pet2.owner) > 0) {
            return 1;
        } else return -1;
    }
}
