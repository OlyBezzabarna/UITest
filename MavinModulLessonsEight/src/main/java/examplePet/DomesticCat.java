package examplePet;

import Enum.Species;
import exampleFamily.Pet;
import Pet.Interface.FoulOfInterface;

import java.util.Set;

public class DomesticCat extends Pet implements FoulOfInterface {

 //   public DomesticCat(String боня, int i, int i1, Set<String> habitsCat) {
//    }

    @Override
    public void respond() {
        System.out.println("Привіт, господарі. Я - Буба. Я дуже люблю коли ви мене пестите!");
    }

    @Override
    public void foul() {
        System.out.println("Піду тихенько подеру диван..");
    }

    public DomesticCat() {
   }

    public DomesticCat(Species species,String nickname) {
        super(species,nickname);
    }

    public DomesticCat(Species species, String nickname, int age, int trickLevel,Set habits) {
        super(species,nickname, age, trickLevel,habits);
    }

    public String getNickName() {

        return getNickname();
    }
}

