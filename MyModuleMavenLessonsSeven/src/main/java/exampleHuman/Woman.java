package exampleHuman;

import exampleFamily.Family;
import exampleFamily.Human;
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
        DomesticCat pet = new DomesticCat("Боня", 4, 5,
               new HashSet<>());
        System.out.println("Привіт мій любий котик " + pet.getNickname());
    }

    public void goToTheBeautySalon(Human human) {
        System.out.println("Любий я піду до " + human.getName() + " " + human.getSurname() + " зроблю собі зачіску.");
    }
}
