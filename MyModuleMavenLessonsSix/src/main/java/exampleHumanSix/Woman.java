package exampleHumanSix;

import exampleFamilySix.Pet;
import exampleFamilySix.Family;
import exampleFamilySix.Human;
import examplePetSix.DomesticCat;

public final class Woman extends Human {

    public Woman() {

    }

    public Woman(String name, String surname, int year, Family family) {
        super(name, surname, year, family);
    }

    @Override
    public void greetPet() {
        DomesticCat pet = new DomesticCat("Боня", 4, 5,
                new String[]{"любит спать целый день", "и гулять всю ночь"});
        System.out.println("Привіт мій любий котик " + pet.getNickname());
    }

    public void goToTheBeautySalon(Human human) {
        System.out.println("Любий я піду до " + human.getName() + " " + human.getSurname() + " зроблю собі зачіску.");
    }
}
