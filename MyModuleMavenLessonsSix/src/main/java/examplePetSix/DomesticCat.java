package examplePetSix;

import Enum.Species;
import exampleFamilySix.Pet;
import Pet.Interface.FoulOfInterface;

public class DomesticCat extends Pet implements FoulOfInterface {

    @Override
    public void respond() {
        System.out.println("Привіт, господарі. Я - Боня. Я дуже люблю коли ви мене пестите!");
    }

    @Override
    public void foul() {
        System.out.println("Піду тихенько подеру диван..");
    }

    public DomesticCat(Species species, String боня, int i, int i1, String[] strings) {

    }

    public DomesticCat(Species species) {
    }

    public DomesticCat(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
    }

    public String getNickName() {

        return getNickname();
    }
}

