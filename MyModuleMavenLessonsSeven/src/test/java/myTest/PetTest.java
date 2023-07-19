package myTest;

import java.util.*;

import exampleFamily.Pet;
import examplePet.Dog;
import examplePet.DomesticCat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PetTest {

    @Test
    public void testToStringCat() {
        Set<String> habitsCat = new HashSet<>();
        habitsCat.add("любить спати цілий день,та гуляти всю ніч");
        Pet cat = new DomesticCat("Боня", 4, 5, habitsCat);
        String petExpectedToString = "Pet{nickname='Боня', age=4, trickLevel=5, habits=[любить спати цілий день,та гуляти всю ніч]}";
        Assertions.assertEquals(petExpectedToString, cat.toString());

    }

    @Test
    public void testToStringDog() {
        Set<String> habitsDog = new HashSet<>();
        habitsDog.add("eat, drink, sleep");
        Pet dog = new Dog("Rock", 5, 75, habitsDog);
        String dogExpectedToString = "Pet{nickname='Rock', age=5, trickLevel=75, habits=[eat, drink, sleep]}";
        Assertions.assertEquals(dogExpectedToString, dog.toString());
    }

}




