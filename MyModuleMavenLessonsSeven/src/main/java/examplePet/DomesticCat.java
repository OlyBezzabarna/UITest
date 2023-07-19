package examplePet;

import Enum.Species;
import exampleFamily.Pet;
import Pet.Interface.FoulOfInterface;

import java.util.Set;

public class DomesticCat extends Pet implements FoulOfInterface {

    @Override
    public void respond() {
        System.out.println("Привіт, господарі. Я - Боня. Я дуже люблю коли ви мене пестите!");
    }

    @Override
    public void foul() {
        System.out.println("Піду тихенько подеру диван..");
    }

    public DomesticCat(Species species, String боня, int i, int i1, Set habits) {

    }

    public DomesticCat(Species species) {
    }

    public DomesticCat(String nickname, int age, int trickLevel, Set habits) {
        super(nickname, age, trickLevel, habits);
    }

    public String getNickName() {

        return getNickname();
    }
}

