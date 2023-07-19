package myTest;

import java.util.*;

import exampleFamily.Human;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class HumanTest {
    @Test
    public void testToStringHuman() {
        Map<String, String> schedule = new HashMap<>();
        schedule.put("Sunday", "a walk in the forest");
        Human human1 = new Human("John", "Doe", 1990, 120, schedule);
        String expected1 = "Human{name='John', surname='Doe', year=1990, iq=120}";
        Assertions.assertEquals(expected1, human1.toString());
    }
}
