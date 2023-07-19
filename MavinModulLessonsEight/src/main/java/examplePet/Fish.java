package examplePet;

import Enum.Species;
import exampleFamily.Pet;

import java.util.Set;

public class Fish extends Pet {


    @Override
    public void respond() {
        System.out.println("Привіт, я рибка. Моє ім'я Буль. Люблю спостерігати за людьми з акваріума!");
    }

    public Fish(Species species,String nickname) {
        super(species,nickname);
    }

    public Fish() {
    }
    public Fish(Species species, String nickname, int age, int trickLevel,Set habits) {
        super(species,nickname, age, trickLevel,habits);
    }
}
