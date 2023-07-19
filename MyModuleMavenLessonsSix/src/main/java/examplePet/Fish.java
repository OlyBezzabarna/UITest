package examplePet;

import Enum.Species;
import exampleFamily.Pet;

public class Fish extends Pet {


    @Override
    public void respond() {
        System.out.println("Привіт, я рибка. Моє ім'я Буль. Люблю спостерігати за людьми з акваріума!");
    }

    public Fish(Species species) {
    }

    public Fish() {
    }

    public Fish(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
    }
}
