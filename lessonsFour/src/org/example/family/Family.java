package org.example.family;

import java.util.Arrays;

public class Family {

    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;

    public Family() {

    }

    public Pet getPet() {
        return pet;
    }

    public Family(Human mother, Human father, Human[] children, Pet pet) {
        this.mother = mother;
        this.father = father;
        this.children = children;
        this.pet = pet;
    }

    public void describePet() {
        System.out.println("У меня есть " + getPet().getSpecies() + ", ему " + getPet().getAge() + " года");
        System.out.println(getPet().getTrickLevel() <= 50 ? ", он почти не хитрый" : ", он очень хитрый");
    }

    public void greetPet() {
        System.out.println("Привет " + getPet().getNickname());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Arrays.equals(children, family.children);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(children);
    }

    public static void addChild() {
        Family family1 = new Family();
        Human[] children = new Human[4];
        children[0] = new Human("Tom", "Karleone", 1999, family1);
        children[1] = new Human("Anna", "Karleone", 2001, family1);
        children[2] = new Human("Etan", "Karleone", 2003, family1);
        children[3] = new Human("Jon", "Karleone", 2005, family1);
        System.out.println("Original Array is: " + Arrays.toString(children));

        Human[] children1 = new Human[5];
        for (int i = 0; i < children.length; i++) {
            children1[i] = children[i];
        }
        children1[4] = new Human("Diana", "Karleone", 2007, family1);
        System.out.println("A new array after adding an element" + Arrays.toString(children1));
    }

    public static void deleteChild() {
        Family family1 = new Family();
        Human[] children = new Human[4];
        children[0] = new Human("Tom", "Karleone", 1999, family1);
        children[1] = new Human("Anna", "Karleone", 2001, family1);
        children[2] = new Human("Etan", "Karleone", 2003, family1);
        children[3] = new Human("Jon", "Karleone", 2005, family1);

        Human[] newChildren = new Human[children.length - 1];
        Human deleteChild = children[3];

        System.out.println("Original Array is: " + Arrays.toString(children));
        int index = 0;
        for (int i = 0; i < children.length; i++) {
            if (children[i] != deleteChild) {
                newChildren[index] = children[i];
                index++;
            }
        }

        children = newChildren;
        System.out.println("New Array after deleting element = " + deleteChild + " and shifting: " + Arrays.toString(children));
    }

    public int countFamily() {
        return children.length + 2;
    }

}

