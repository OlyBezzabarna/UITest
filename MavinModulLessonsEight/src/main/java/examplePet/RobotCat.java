package examplePet;

import Enum.Species;
import exampleFamily.Pet;
import Pet.Interface.FoulOfInterface;

import java.util.Set;

public class RobotCat extends Pet implements FoulOfInterface {

    public RobotCat(Species species,String nickname) {
        super(species,nickname);
    }

    public RobotCat() {
    }

    public RobotCat(Species species, String nickname, int age, int trickLevel, Set habits) {
        super(species, nickname, age, trickLevel,habits);
    }

    @Override
    public void respond() {
        System.out.println("Привіт, господарю. Я - твій любий кіт Роббі. Після мене не потрібно прибирати!");
    }

    @Override
    public void foul() {
        System.out.println("Потрібно, як справжньому коту зробиту якусь шкоду.");
    }
}

