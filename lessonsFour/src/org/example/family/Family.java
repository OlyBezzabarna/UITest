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

    public void addChild(Human child) {
        Human[] children1 = new Human[children.length + 1];
        for (int i = 0; i < children.length; i++) {
            children1[i] = children[i];
        }
        children1[children.length] = child;
        children = children1;
        System.out.println("New Array after adding an element: " + Arrays.toString(children));
    }

    public void deleteChild(Human child) {
        Human[] children1 = new Human[children.length - 1];
        int index = 0;
        for (int i = 0; i < children.length; i++) {
            if (!children[i].equals(child)) {
                children1[index] = children[i];
                index++;
            }
        }
        children = children1;
        System.out.println("New Array after deleting element " + child + " and shifting: " + Arrays.toString(children));
    }

    public int countFamily() {
        return children.length + 2;
    }

    @Override
    public String toString() {
        return "Family{" +
                "mother=" + mother.getName() + " " + mother.getSurname() + " " + mother.getYear() +
                ", father=" + father.getName() + " " + father.getSurname() + " " + father.getYear() +
                ", children=" + Arrays.deepToString(children) +
                ", pet=" + pet +
                '}';
    }

}


