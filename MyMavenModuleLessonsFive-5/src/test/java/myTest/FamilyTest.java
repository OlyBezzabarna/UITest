package myTest;

import org.example.Species;
import org.example.family.Family;
import org.example.family.Human;
import org.example.family.Pet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class FamilyTest {

    private Family family1;
    private Human child1;
    private Human child2;
    private Human mother;
    private Human father;
    private Pet pet;


    @BeforeEach
    public void setFamily1() {
        family1 = new Family();
        Human mother = new Human("Jane", "Karleone", 1978, family1);
        Human father = new Human("Vito", "Karleone", 1978, family1);
        child1 = new Human("Oliver", "Karleone", 2009, family1);
        child2 = new Human("Diana", "Karleone", 2011, family1);
        Pet pet = new Pet(Species.CAT, "Боня", 4, 5,
                new String[]{"любит спать целый день", "и гулять всю ночь"});
        family1 = new Family(mother, father, new Human[]{child1, child2}, pet);

    }

    @Test
    public void testToString() {
        String expected = "Family{mother=Jane Karleone 1978, father=Vito Karleone 1978, " +
                "children=[Human{name='Oliver', surname='Karleone', year=2009, iq=0}, " +
                "Human{name='Diana', surname='Karleone', year=2011, iq=0}], " +
                "pet=Pet{species=CAT, nickname='Боня', age=4, trickLevel=5, habits=[любит спать целый день, и гулять всю ночь]}}";

        Assertions.assertEquals(expected, family1.toString());
    }

    @Test
    public void testCountFamily() {
        Assertions.assertEquals(4, family1.countFamily());

    }

    }







