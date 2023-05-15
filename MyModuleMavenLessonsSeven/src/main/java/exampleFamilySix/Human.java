package exampleFamilySix;

import Enum.DayOfWeek;

import java.util.Map;
import java.util.Objects;

public class Human extends Family {

    private String name;
    private String surname;
    private int year;
    private int iq;
    private Map schedule;
    private Family family;

    public Human() {

    }

    public Human(String name, String surname, int year, Family family) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.family = family;
    }

    public Human(String name, String surname, int year, int iq, Map schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.schedule = schedule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(name, human.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getYear() {
        return year;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public Map getSchedule() {
        return schedule;
    }

    public void scheduleName() {
        for (DayOfWeek day : DayOfWeek.values()) {
            System.out.println(day.name() + ": " + day.getSchedule());
        }
    }

    @Override
    public String toString() { //
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + year +
                ", iq=" + iq +
                "}";
    }


}
