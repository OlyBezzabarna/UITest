package exampleFamily;

import Enum.Species;
import Pet.Interface.FamilyDao;
import exampleHuman.Woman;
import exampleHuman.Man;
import examplePet.Dog;
import examplePet.DomesticCat;
import examplePet.Fish;
import examplePet.RobotCat;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Set<String> habitsCat = new HashSet<>();
        habitsCat.add("любить спати цілий день,та гуляти всю ніч");
        Set<String> habitsDog = new HashSet<>();
        habitsDog.add("їсти, пити, спати");


        Pet cat = new DomesticCat(Species.DOMESTICCAT,"Боня", 4, 5, habitsCat);

        Pet dog = new Dog(Species.DOG,"Рокки", 5, 75, habitsDog);

        Set<Pet> pets = new HashSet<>();
        pets.add(cat);
        pets.add(dog);


//        Set<Pet> pets = new HashSet<>();
//        Pet pet = new Dog("Fil",10,35, new HashSet<String>(habits));
//        pets.add(pet);
//        family.setPet(pets);
//        familyController.addPet(1, dog);


        Map<String, String> schedule = new HashMap<>();
        schedule.put("Sunday", "a walk in the forest");
        schedule.put("Monday", "buying products in a store");
        schedule.put("Tuesday", "a trip on bicycles to the garden");


        Human human = new Human("Michael", "Karleone", 1977, 90, schedule);
        human.greetPet();
        //Family family = new Family();
        Family familyOne = new Family();
        Human motherOne = new Human("Jane", "Karleone", 1978, familyOne);
        Human fatherOne = new Human("Vito", "Karleone", 1978, familyOne);


        List<Family> childrenOne = new ArrayList<>();
        childrenOne.add(new Human("Tom", "Karleone", 1999, familyOne));
        childrenOne.add(new Human("Anna", "Karleone", 2001, familyOne));
        familyOne = new Family(motherOne, fatherOne, childrenOne,pets);
        familyOne.setPets (pets);

//        FamilyController.addPet(pets);

        Set<String> habitsDomesticCat = new HashSet<>();
        habitsDomesticCat.add("Мені дуже подобається бігати!");
        Set<String> habitsMyDog = new HashSet<>();
        habitsMyDog.add("Я дуже люблю коли ви мене пестите!");
        Set<String> habitsFish = new HashSet<>();
        habitsFish.add("Люблю спостерігати за людьми з акваріума!");
        Set<String> habitsRobotCat = new HashSet<>();
        habitsRobotCat.add("Після мене не потрібно прибирати!");

        Pet domesticCat = new DomesticCat(Species.DOMESTICCAT, "Буба",3 ,7, habitsDomesticCat);
        Pet myDog = new Dog(Species.DOG, "Мопс",2 , 4,habitsMyDog);
        Pet fish = new Fish(Species.FISH, "Буль",1,1,habitsFish);
        Pet robotCat = new RobotCat(Species.ROBOTCAT, "Роббі",5,0,habitsRobotCat);

        Set<Pet> pets1 = new HashSet<>();
        pets1.add(domesticCat);
        pets1.add(myDog);
        pets1.add(fish);
        pets1.add(robotCat);

        Family familyTwo = new Family();
        Human motherTwo = new Human("Olivia", "Jordan", 1979, familyTwo);
        Human fatherTwo = new Human("Aleks", "Jordan", 1980, familyTwo);

        List<Family> childrenTwo = new ArrayList<>();
        childrenTwo.add(new Human("Etan", "Jordan", 2003, familyTwo));
        childrenTwo.add(new Human("Jon", "Jordan", 2005, familyTwo));
        familyTwo = new Family(motherTwo,fatherTwo,childrenTwo,pets1);
        familyTwo.setPets(pets1);

        List<Family> familyList = new ArrayList<>();
        familyList.add(familyOne);
        familyList.add(familyTwo);


 //       familyOne.describePet();
        System.out.println(human + ", schedule= ");
        human.scheduleName();
        System.out.println(dog);

//        Human newChild = new Human("Elin", "Karleone", 2007, familyOne);
//        System.out.println(familyOne);
//        familyOne.addChild(newChild);
//        System.out.println(familyOne);
//        familyOne.deleteChild((new Human("Tom", "Karleone", 1999, familyOne)));
//        familyOne.deleteChild((new Human("Anna", "Karleone", 2001, familyOne)));
//        familyOne.deleteChild1(0);
//        System.out.println(familyOne);
//
//        System.out.println(familyOne.countFamily());



        domesticCat.eat();
        domesticCat.respond();
        domesticCat.foul();



        myDog.eat();
        myDog.respond();
        myDog.foul();


        fish.eat();
        fish.respond();



        robotCat.eat();
        robotCat.respond();
        robotCat.foul();

        Man man = new Man();
        Woman woman = new Woman();
        man.greetPet();
        woman.greetPet();
        man.feedTheFish();
        woman.goToTheBeautySalon(human);

        CollectionFamilyDao collectionFamilyDao = new CollectionFamilyDao();

        collectionFamilyDao.getAllFamilies(familyList);
        System.out.println(familyList);
        collectionFamilyDao.getFamilyByIndex(3);
        System.out.println(familyList);
        collectionFamilyDao.deleteFamily(0);
        System.out.println(familyList);
        collectionFamilyDao.deleteFamily1(familyOne);
        System.out.println(familyList);
        collectionFamilyDao.saveFamily(familyOne);
        System.out.println(familyList);

        collectionFamilyDao.displayAllFamilies(familyList);











    }
}


