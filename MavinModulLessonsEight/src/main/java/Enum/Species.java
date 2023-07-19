package Enum;
import java.util.*;

public enum Species {
    DOMESTICCAT("Cat", "Я дуже люблю коли ви мене пестите!"),
    DOG("Dog", "Мені дуже подобається бігати!"),
    FISH("Fish","Люблю спостерігати за людьми з акваріума!"),
    ROBOTCAT("RobotCat","Після мене не потрібно прибирати!"),
    UNKNOWN("UNKNOWN","Мабуть щось зроблю...");

    @Override
    public String toString() {
        return "Species{}";
    }

    private String species;
    private Set <String> habits;

    Species(String species,String habits) {
        this.species = species;
        this.habits = Collections.singleton(habits);
    }

    public String getSpecies() {
        return species;
    }

    public String getHabits() {
        return habits.toString();
    }
}
