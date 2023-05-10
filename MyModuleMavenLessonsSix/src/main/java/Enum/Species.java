package Enum;

public enum Species {

    DOMESTICCAT("Cat"),
    DOG("Dog"),
    FISH("Fish"),
    ROBOTCAT("RobotCat"),
    UNKNOWN("UNKNOWN");
    private String species;

    Species(String species) {
        this.species = species;
    }

    public String getSpecies() {
        return species;
    }

}
