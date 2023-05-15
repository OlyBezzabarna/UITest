package Enum;

public enum DayOfWeek {
    Sunday("a walk to the forest;"),
    Monday("buying products in a store;"),
    Tuesday("a trip on bicycles to the garden;"),
    Wednesday("language study;"),
    Thursday("house cleaning;"),
    Friday("reading a book.");

    private String schedule;

    DayOfWeek(String schedule) {
        this.schedule = schedule;
    }

    public String getSchedule() {
        return schedule;
    }

}