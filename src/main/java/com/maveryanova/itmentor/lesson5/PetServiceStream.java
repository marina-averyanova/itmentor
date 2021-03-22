package com.maveryanova.itmentor.lesson5;

import com.maveryanova.itmentor.lesson4.PetService;
import com.maveryanova.itmentor.lesson4.model.Pet;
import java.util.List;
import java.util.stream.Collectors;

// Переписать домашнюю работу из темы Java Collections используя Stream Api везде, где это представляется возможным
public class PetServiceStream extends PetService {

    @Override
    public List<Pet> getSortedPets() {
        return pets.values().stream().sorted().collect(Collectors.toList());
    }

    @Override
    public List<Pet> getPets() {
        // NOTE unnecessary, just to show stream api knowledge
        return pets.values().stream().collect(Collectors.toList());
    }
}
