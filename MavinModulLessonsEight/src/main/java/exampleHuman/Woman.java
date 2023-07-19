package exampleHuman;

import exampleFamily.Family;
import exampleFamily.Human;
import Enum.Species;
import examplePet.DomesticCat;

import java.util.HashSet;

public class Woman extends Human {

    public Woman() {

    }

    public Woman(String name, String surname, int year, Family family) {
        super(name, surname, year, family);
    }

    @Override
    public void greetPet() {
     //   Dog pet = new Dog(Species.DOG,"Боня");
        DomesticCat pet = new DomesticCat(Species.DOMESTICCAT,"Боня");
 //              new HashSet<>());
        System.out.println("Привіт мій рижик " + pet.getNickname());
    }

    public void goToTheBeautySalon(Human human) {
        System.out.println("Любий я пішла до перукаря " + human.getName() + " " + human.getSurname() + " зроблю собі зачіску.");
    }
}
