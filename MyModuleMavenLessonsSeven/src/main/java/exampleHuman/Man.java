package exampleHuman;

import Enum.Species;
import exampleFamily.Family;
import exampleFamily.Human;
import examplePet.DomesticCat;

import java.util.HashSet;


public class Man extends Human {

    public Man() {
    }

    public Man(String name, String surname, int year, Family family) {
        super(name, surname, year, family);
    }

    @Override
    public void greetPet() {
        DomesticCat pet = new DomesticCat("Боня", 4, 5,
                new HashSet());
        System.out.println("Привіт мій рижик " + pet.getNickName());
    }

    public void feedTheFish() {
        System.out.println("Піду нагодую свою золотеньку " + Species.FISH.getSpecies());
    }
}
