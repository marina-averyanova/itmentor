package com.maveryanova.itmentor.lesson4;

import com.maveryanova.itmentor.lesson4.model.Person;
import com.maveryanova.itmentor.lesson4.model.Pet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// Разработать программу – картотеку домашних животных.
// У каждого животного есть уникальный идентификационный номер, кличка, хозяин (объект класс Person с полями – имя, возраст, пол), вес.
//Реализовать:
//• метод добавления животного в общий список (учесть, что добавление дубликатов должно приводить к исключительной ситуации)
//• поиск животного по его кличке (поиск должен быть эффективным)
//• изменение данных животного по его идентификатору
//• вывод на экран списка животных в отсортированном порядке.
// Поля для сортировки – хозяин(имя, по возрастанию), если имена хозяев одинаковые - кличка животного.
// Если и имя хозяина и кличка животного одинаковые - раньше вывести животное, у которого больше вес
public class PetService {
    private final Map<Integer, Pet> pets = new HashMap<>();
    private final Map<String, LinkedList<Pet>> petsByNames = new HashMap<>();

    public void addPet(int id, String name, Person owner, int weight) throws Exception {
        if (pets.get(id) != null) {
            throw new Exception("pet already exists");
        }
        Pet pet = new Pet(id, name, owner, weight);
        pets.put(id, pet);

        if (petsByNames.containsKey(name)) {
            petsByNames.get(name).add(pet);
        } else {
            LinkedList<Pet> pets = new LinkedList<>();
            pets.add(pet);
            petsByNames.put(name, pets);
        }
    }

    public void changePet(int id, String name, Person owner, int weight) {
        if (pets.containsKey(id)) {
            Pet pet = pets.get(id);
            pet.setName(name);
            pet.setOwner(owner);
            pet.setWeight(weight);
        }
    }

    public List<Pet> findPet(String name) {
        return petsByNames.get(name);
    }

    public List<Pet> getSortedPets() {
        Pet[] arr = pets.values().toArray(new Pet[0]);
        Arrays.sort(arr);
        return Arrays.asList(arr);
    }

    public List<Pet> getPets() {
        return new ArrayList<>(pets.values());
    }
}
