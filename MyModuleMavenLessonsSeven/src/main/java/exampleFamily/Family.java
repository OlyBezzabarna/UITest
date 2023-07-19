package exampleFamily;

import examplePet.DomesticCat;

import java.util.*;

public class Family {

    private Human mother;
    private Human father;
    private List<Family> children;
    private Pet pet;

    public Family() {
        children = new ArrayList<>() {
        };
    }

    public Pet getPet() {
        return pet;
    }

    public Family(Human mother, Human father, List<Family> children, Pet pet) {
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
                new HashSet<>());
        System.out.println("Привіт " + pet.getNickname());
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void addChild(Human newChild) {
        children.add(newChild);
        newChild.setFamily(this);

    }

    private void setFamily(Family family) {
    }

    public List<Family> getChildren() {
        return children;
    }

    public void setChildren(List<Family> children) {
        this.children = children;
    }

    public void deleteChild(Human child) {
        if (children != null && children.contains(child)) {
            children.remove(child);
            System.out.println("New List after deleting element " + child + "such: " + children);
        }
    }

    public boolean deleteChild1(int index) {
        if (children == null || index >= children.size() || index < 0) {
            return false;
        }
        children.remove(index);
        return true;
    }

    public int countFamily() {
        return children.size() + 2;
    }

    @Override
    public String toString() {
        return "Family{" +
                "mother=" + mother.getName() + " " + mother.getSurname() + " " + mother.getYear() +
                ", father=" + father.getName() + " " + father.getSurname() + " " + father.getYear() +
                ", children=" + children +
                ", pet=" + pet +
                '}';
    }

}


