package myTest;

import java.util.*;

import exampleFamily.Pet;
import examplePet.Dog;
import examplePet.DomesticCat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import Enum.Species;

public class PetTest {

    @Test
    public void testToStringCat() {
        Set<String> habitsCat = new HashSet<>();
        habitsCat.add("любить спати цілий день,та гуляти всю ніч");
        Pet cat = new DomesticCat(Species.DOMESTICCAT,"Боня", 4, 5, habitsCat);
        String petExpectedToString = "Pet{species=Cat, nickname='Боня', age=4, trickLevel=5, habits=[любить спати цілий день,та гуляти всю ніч]}";
        Assertions.assertEquals(petExpectedToString, cat.toString());

    }

    @Test
    public void testToStringDog() {
        Set<String> habitsDog = new HashSet<>();
        habitsDog.add("eat, drink, sleep");
        Pet dog = new Dog(Species.DOG, "Мопс",2 , 4,habitsDog);
        String dogExpectedToString = "Pet{species=Dog, nickname='Мопс', age=2, trickLevel=4, habits=[eat, drink, sleep]}";
        Assertions.assertEquals(dogExpectedToString, dog.toString());
    }

}




