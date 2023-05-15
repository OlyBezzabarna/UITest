package myTest;

import java.util.*;

import exampleFamilySix.Family;
import exampleFamilySix.Human;
import exampleFamilySix.Pet;
import examplePetSix.DomesticCat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


public class FamilyTest {

    private Family family1;


    @BeforeEach
    public void setFamily1() {
        family1 = new Family();
        Human mother = new Human("Jane", "Karleone", 1978, family1);
        Human father = new Human("Vito", "Karleone", 1978, family1);

        List<Family> children = new ArrayList<>();
        children.add(new Human("Tom", "Karleone", 1999, family1));
        children.add(new Human("Anna", "Karleone", 2001, family1));
        Set<String> habitsCat = new HashSet<>();
        Pet cat = new DomesticCat("Боня", 4, 5, habitsCat);
        family1 = new Family(mother, father, children, cat);

    }

    @Test
    public void testToStringOne() {
        String result = family1.toString();
        Assertions.assertNotNull(result);
        Assertions.assertFalse(result.contains("null"));
    }


    @Test
    public void testToStringTwo() {
        String expected = "Family{" +
                "mother=Jane Karleone 1978" +
                ", father=Vito Karleone 1978" +
                ", children=[Human{name='Tom', surname='Karleone', year=1999, iq=0}, Human{name='Anna', surname='Karleone', year=2001, iq=0}]" +
                ", pet=Pet{nickname='Боня', age=4, trickLevel=5, habits=[]}" +
                '}';
        String actual = family1.toString();
        Assertions.assertEquals(expected, actual);
        System.out.println(actual);
    }

    @Test
    public void testCountFamily() {
        Assertions.assertEquals(4, family1.countFamily());

    }

}







