package examplePetSix;

import Enum.Species;
import exampleFamilySix.Pet;
import Pet.Interface.FoulOfInterface;

public class Dog extends Pet implements FoulOfInterface {

    public Dog(Species species, String rock, int i, int i1, String[] strings) {
    }

    public Dog(Species species) {
    }

    public Dog(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
    }

    @Override
    public void respond() {
        System.out.println("Привіт, господарю. Я - Мопсік. Мені дуже подобається бігати!");
    }

    @Override
    public void foul() {
        System.out.println("Уух, я знову все розкидав.");
    }
}
