package exampleFamily;

import Enum.Species;
import exampleHuman.Woman;
import exampleHuman.Man;
import examplePet.Dog;
import examplePet.DomesticCat;
import examplePet.Fish;
import examplePet.RobotCat;

public class Main {
    public static void main(String[] args) {


        Pet pet = new DomesticCat("Боня", 4, 5,
                new String[]{"любит спать целый день", "и гулять всю ночь"});

        Pet dog = new Dog("Rock", 5, 75, new String[]{"eat", "drink", "sleep"});

        String[][] schedule = new String[][]{{"Sunday"}, {"a walk in the forest"},
                {"Monday"}, {"buying products in a store"},
                {"Tuesday"}, {"a trip on bicycles to the garden"}};

        Human human = new Human("Michael", "Karleone", 1977, 90, schedule);
        human.greetPet();

        Family family1 = new Family();
        Human mother = new Human("Jane", "Karleone", 1978, family1);
        Human father = new Human("Vito", "Karleone", 1978, family1);

        Human[] children = new Human[4];
        children[0] = new Human("Tom", "Karleone", 1999, family1);
        children[1] = new Human("Anna", "Karleone", 2001, family1);
        children[2] = new Human("Etan", "Karleone", 2003, family1);
        children[3] = new Human("Jon", "Karleone", 2005, family1);
        children[3].setFamily(family1);

        family1 = new Family(mother, father, children, pet);

        family1.describePet();
        System.out.println(human + ", schedule= ");
        human.scheduleName();
        System.out.println(dog);

        Human children1 = new Human("Elin", "Karleone", 2007, family1);

        family1.addChild(children1);
        System.out.println(family1);
        family1.deleteChild(children[0]);
        family1.deleteChild(children[1]);
        family1.deleteChild1(2);
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


