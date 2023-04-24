package org.example;

import org.example.family.Family;
import org.example.family.Human;
import org.example.family.Pet;


public class Main {
    public static void main(String[] args) {

        Pet pet = new Pet("кот", "Боня", 4, 5,
                new String[]{"любит спать целый день", "и гулять всю ночь"});
        pet.eat();
        pet.respond();
        pet.foul();

        String[][] schedule = new String[][]{{"день-воскресенье"}, {"задание-прогулка"}};
        Human human = new Human("Michael", "Karleone", 1977, 90, schedule);

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

        family1.greetPet();
        family1.describePet();
        System.out.println(human);

        Pet dog = new Pet();
        dog.setNickName("Rock");
        dog.setAge(5);
        dog.setTrickLevel(75);
        dog.setHabits(new String[]{"eat", "drink", "sleep"});
        System.out.println(dog);

        Human children1 = new Human("Elin", "Karleone", 2007,family1);

        family1.addChild(children1);
        System.out.println(family1);
        family1.deleteChild(children[0]);
        family1.deleteChild(children[1]);

        System.out.println(family1.countFamily());


    }


}