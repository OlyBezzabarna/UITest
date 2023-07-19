package exampleFamily;

import Pet.Interface.FoulOfInterface;

import java.util.Set;
import Enum.Species;


public abstract class Pet implements FoulOfInterface {
    private String nickname;
    private int age;
    private int trickLevel;
    protected Set habits;
    private Species species;

    public Pet() {

    }

    public Pet(Species species,String nickname, int age, int trickLevel) {

        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.species = species;

    }
    public Pet(Species species, String nickname, int age, int trickLevel, Set habits) {

        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
        this.species = species;

    }

    public Pet(Species species,String nickname) {
        this.species = species;
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickName(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(int trickLevel) {
        this.trickLevel = trickLevel;
    }

    public void setHabits(Set habits) {
        this.habits = habits;
    }

    public void eat() {
        System.out.println("Я їм!");
    }

    public abstract void respond();

    public void foul() {
        System.out.println("Нужно хорошо замести следы...");
    }

    @Override
    public String toString() {
        return "Pet{" +
                "species=" + species.getSpecies()+
                ", nickname='" + nickname + '\'' +
                ", age=" + age +
                ", trickLevel=" + trickLevel +
                ", habits=" + habits +
                '}';
    }


//    @Override
//    public String toString() {
//        return "Pet{" +
//                "nickname='" + nickname + '\'' +
//                ", age=" + age +
//                ", trickLevel=" + trickLevel +
//                ", habits=" + habits +
//                '}';
//    }

    public Set getHabits() {
        return habits;
    }
}


