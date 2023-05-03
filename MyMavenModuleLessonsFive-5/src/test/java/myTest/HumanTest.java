package myTest;

import org.example.family.Human;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HumanTest {
    @Test
    public void testToStringHuman() {
        Human human1 = new Human("John", "Doe", 1990, 120, new String[][]{{"task1", "14:00"}, {"task2", "15:00"}});
        String expected1 = "Human{name='John', surname='Doe', year=1990, iq=120}";
        Assertions.assertEquals(expected1, human1.toString());
    }
}
