package exampleFamily;

import examplePet.DomesticCat;

import java.util.Arrays;

public class Family {

    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;

    public Family() {
        children = new Human[0];
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
        System.out.println("В мене є " + getPet().getNickname() + ", йму " + getPet().getAge() + " рочки");
        System.out.println(getPet().getTrickLevel() <= 50 ? ", він майже не хитрий" : ", він дуже хитрий");
    }

    public void greetPet() {
        DomesticCat pet = new DomesticCat("Боня", 4, 5,
                new String[]{"любить спати цілий день", "та гуляти всю ніч"});
        System.out.println("Привіт " + pet.getNickname());
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
        if (children != null && children.length > 0 && Arrays.asList(children).contains(child)) {
            Human[] children1 = new Human[children.length - 1];
            int j = 0;
            for (int i = 0; i < children.length; i++) {
                if (!children[i].equals(child)) {
                    children1[j] = children[i];
                    j++;
                }
            }
            children = children1;
            System.out.println("New Array after deleting element " + child + " and shifting: " + Arrays.toString(children));
        }
    }

    public boolean deleteChild1(int index) {
        if (index > children.length - 1 || index < 0) return false;
        Human[] childrenResult = new Human[children.length - 1];
        int j = 0;
        for (int i = 0; i < children.length; i++) {
            if (i != index) {
                childrenResult[j++] = children[i];
            }
        }
        children = childrenResult;
        return true;
    }

    public Human[] getChildren() {
        return children;
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


