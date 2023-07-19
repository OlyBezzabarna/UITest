package exampleFamily;

import Pet.Interface.FamilyDao;
import examplePet.Dog;
import examplePet.DomesticCat;
import Enum.Species;
import examplePet.Fish;
import examplePet.RobotCat;

import java.util.*;

public class Family {

    private Human mother;
    private Human father;
    private List<Family> children;
    private Species species;
    private Pet pet;
    private Set<Pet> pets;
    private Set<Pet> pets1;

    public Set<Pet> getPets1() {
        return pets1;
    }

    public void setPets1(Set<Pet> pets1) {
        this.pets1 = pets1;
    }

    public Family(){

       }
//    {
//        children = new ArrayList<>() {
//        };
//        pet = new HashSet<>();
//    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Pet getPet() {
        return pet;
    }


    public Family(Human mother, Human father, List<Family> children, Set <Pet> pets ) {
        this.mother = mother;
        this.father = father;
        this.children = children;
        this.pets = pets;

        }


    public void describePet() {
        System.out.println("В мене є " + getPet().getNickname() + ", йму " + getPet().getAge() + " рочки");
        System.out.println(getPet().getTrickLevel() <= 50 ? ", він майже не хитрий" : ", він дуже хитрий");
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public void greetPet() {

        DomesticCat pet = new DomesticCat(Species.DOMESTICCAT,"Боня");
    //            new HashSet<>());
        System.out.println("Привіт " + pet.getNickname());
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    private void setFamily(Family family) {
    }

    public List<Family> getChildren() {
        return children;
    }

    public void setChildren(List<Family> children) {
        this.children = children;
    }


    public void addChild(Human newChild) {
        children.add(newChild);
        newChild.setFamily(this);
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
                ", pet=" + pets +
                '}';
    }

    public void deleteAllChildrenOlderThen(int age) {
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public void addPet(Pet pet) {
    }

    public Set<Pet> getPets() {
        return this.getPets();
    }

}


