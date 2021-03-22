package com.averyanova.itmentor.lesson5;

import com.maveryanova.itmentor.lesson5.PetServiceStream;
import com.maveryanova.itmentor.lesson4.model.Person;
import com.maveryanova.itmentor.lesson4.model.Pet;
import com.maveryanova.itmentor.lesson4.model.Sex;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PetServiceStreamTest {
    private static final Person person1 = new Person("John", 30, Sex.MALE);
    private static final Person person2 = new Person("Anna", 20, Sex.FEMALE);
    private static final Person person3 = new Person("Nick", 40, Sex.MALE);

    @Test
    public void addPetTest() throws Exception {
        PetServiceStream petService = new PetServiceStream();
        Pet tom = new Pet(1, "Tom", person1, 5);
        Pet jerry = new Pet(2, "Jerry", person2, 1);

        petService.addPet(1, "Tom", person1, 5);
        petService.addPet(2, "Jerry", person2, 1);

        assertEquals(List.of(tom, jerry), petService.getPets());
        assertEquals(List.of(tom), petService.findPet("Tom"));
        assertEquals(List.of(jerry), petService.findPet("Jerry"));
    }

    @Test
    public void addPetErrorTest() {
        PetServiceStream petService = new PetServiceStream();
        try {
            petService.addPet(1, "Tom", person1, 5);
            petService.addPet(1, "Tom", person1, 5);
        } catch (Exception e) {
            assertEquals("pet already exists", e.getMessage());
        }
    }

    @Test
    public void changePetTest() throws Exception {
        PetServiceStream petService = new PetServiceStream();
        Pet tom = new Pet(1, "Tom", person1, 5);
        Pet jerry = new Pet(2, "Jerry", person2, 1);

        petService.addPet(1, "Tom", person1, 5);
        petService.addPet(2, "Jerry", person2, 1);

        assertEquals(List.of(tom, jerry), petService.getPets());
        assertEquals(List.of(tom), petService.findPet("Tom"));
        assertEquals(List.of(jerry), petService.findPet("Jerry"));

        petService.changePet(1, "Tom", person1, 7);
        petService.changePet(2, "Jerry", person1, 1);

        Pet tomGotFat = new Pet(1, "Tom", person1, 7);
        Pet jerryChangedOwner = new Pet(2, "Jerry", person1, 1);

        assertEquals(List.of(tomGotFat, jerryChangedOwner), petService.getPets());
        assertEquals(List.of(tomGotFat), petService.findPet("Tom"));
        assertEquals(List.of(jerryChangedOwner), petService.findPet("Jerry"));
    }

    @Test
    public void sortingPetsTest() throws Exception {
        PetServiceStream petService = new PetServiceStream();
        Pet tom = new Pet(1, "Tom", person1, 5);
        Pet jerry = new Pet(2, "Jerry", person2, 1);
        Pet july = new Pet(3, "July", person2, 2);
        Pet jessy = new Pet(4, "Jessy", person3, 4);
        Pet jessy2 = new Pet(5, "Jessy", person3, 5);

        petService.addPet(1, "Tom", person1, 5);
        petService.addPet(2, "Jerry", person2, 1);
        petService.addPet(3, "July", person2, 2);
        petService.addPet(4, "Jessy", person3, 4);
        petService.addPet(5, "Jessy", person3, 5);


        List<Pet> expectedSortedPets = List.of(jerry, july, tom, jessy2, jessy);
        List<Pet> expectedPets = List.of(tom, jerry, july, jessy, jessy2);

        List<Pet> sortedPets = petService.getSortedPets();
        List<Pet> pets = petService.getPets();

        for (int i = 0; i < 5; i++) {
            assertEquals(sortedPets.get(i), expectedSortedPets.get(i));
            assertEquals(pets.get(i), expectedPets.get(i));
        }
    }
}
