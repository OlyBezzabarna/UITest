package examplePet;

import Enum.Species;
import exampleFamily.Pet;
import Pet.Interface.FoulOfInterface;

import java.util.Set;

public class Dog extends Pet implements FoulOfInterface {

    public Dog() {
    }

    public Dog(Species species, String nickname) {
        super(species,nickname);
    }

    public Dog(Species species,String nickname, int age, int trickLevel,Set habits) {
        super(species,nickname, age, trickLevel, habits);
    }

    @Override
    public void respond() {
        System.out.println("Привіт, господарю. Я - Мопсік. Мені дуже подобається бігати!");
    }

    @Override
    public void foul() {
        System.out.println("Уух, я знову все розкидав.");
    }

//    @Override
//    public String toString() {
//        return "Dog{" +
//                "habits=" + habits +
//                '}';
//    }
}
