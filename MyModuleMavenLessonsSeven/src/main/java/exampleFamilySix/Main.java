package exampleFamilySix;

import Enum.Species;
import exampleHumanSix.Woman;
import exampleHumanSix.Man;
import examplePetSix.Dog;
import examplePetSix.DomesticCat;
import examplePetSix.Fish;
import examplePetSix.RobotCat;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Set<String> habitsCat = new HashSet<>();
        habitsCat.add("любить спати цілий день,та гуляти всю ніч");
        Set<String> habitsDog = new HashSet<>();
        habitsDog.add("eat, drink, sleep");

        Pet cat = new DomesticCat("Боня", 4, 5, habitsCat);

        Pet dog = new Dog("Rock", 5, 75, habitsDog);

        Set<Pet> setPet = new HashSet<>();
        setPet.add(cat);
        setPet.add(dog);


        Map<String, String> schedule = new HashMap<>();
        schedule.put("Sunday", "a walk in the forest");
        schedule.put("Monday", "buying products in a store");
        schedule.put("Tuesday", "a trip on bicycles to the garden");


        Human human = new Human("Michael", "Karleone", 1977, 90, schedule);
        human.greetPet();

        Family family1 = new Family();
        Human mother = new Human("Jane", "Karleone", 1978, family1);
        Human father = new Human("Vito", "Karleone", 1978, family1);

        List<Family> children = new ArrayList<>();
        children.add(new Human("Tom", "Karleone", 1999, family1));
        children.add(new Human("Anna", "Karleone", 2001, family1));
        children.add(new Human("Etan", "Karleone", 2003, family1));
        children.add(new Human("Jon", "Karleone", 2005, family1));


        family1 = new Family(mother, father, children, cat);

        family1.describePet();
        System.out.println(human + ", schedule= ");
        human.scheduleName();
        System.out.println(dog);

        Human newChild = new Human("Elin", "Karleone", 2007, family1);
        System.out.println(family1);
        family1.addChild(newChild);
        System.out.println(family1);
        family1.deleteChild((new Human("Tom", "Karleone", 1999, family1)));
        family1.deleteChild((new Human("Anna", "Karleone", 2001, family1)));
        family1.deleteChild1(0);
        System.out.println(family1);

        System.out.println(family1.countFamily());

        Dog myDog = new Dog(Species.DOG);
        myDog.eat();
        myDog.respond();
        myDog.foul();

        DomesticCat domesticCat = new DomesticCat(Species.DOMESTICCAT);
        domesticCat.eat();
        domesticCat.respond();
        domesticCat.foul();

        Fish fish = new Fish(Species.FISH);
        fish.eat();
        fish.respond();

        RobotCat robotCat = new RobotCat(Species.ROBOTCAT);
        robotCat.eat();
        robotCat.respond();
        robotCat.foul();

        Man man = new Man();
        Woman woman = new Woman();
        man.greetPet();
        woman.greetPet();
        man.feedTheFish();
        woman.goToTheBeautySalon(human);

    }
}


