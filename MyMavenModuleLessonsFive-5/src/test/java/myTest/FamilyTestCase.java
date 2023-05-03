package myTest;


import org.example.family.Family;
import org.example.family.Human;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class FamilyTestCase {

    private Family family1;
    private Human child1;
    private Human child2;

    @BeforeEach
    public void setUp() {
        family1 = new Family();
        child1 = new Human("Oliver", "Karleone", 2009, family1);
        child2 = new Human("Diana", "Karleone", 2011, family1);
        family1.addChild(child1);
        family1.addChild(child2);
    }

    @Test
    public void testDeleteChild1() {
        family1.deleteChild(child1);
        Assertions.assertEquals(1, family1.getChildren().length);
        Assertions.assertEquals(child2, family1.getChildren()[0]);
    }

    @Test
    public void testDeleteChildNotInArray2() {
        // Создаем объект childNotInArray, который не эквивалентен ни одному элементу массива children
        Human childNotInArray = new Human("Max", "Karleone", 2015, family1);
        // Создаем копию исходного массива children
        Human[] originalChildren = family1.getChildren().clone();
        // Удаляем объект childNotInArray из массива children
        family1.deleteChild(childNotInArray);
        // Проверяем, что массив children остался неизменным
        Assertions.assertArrayEquals(originalChildren, family1.getChildren());
    }

    @Test
    public void testDeleteChildValidIndex3() {
        boolean result = family1.deleteChild1(0);
        Assertions.assertEquals(1, family1.getChildren().length);
        Assertions.assertEquals(child2, family1.getChildren()[0]);
        Assertions.assertTrue(result);
    }

    @Test
    void testDeleteChildInvalidIndex4() {
        boolean result = family1.deleteChild1(2);
        Assertions.assertFalse(result);
        Assertions.assertEquals(2, family1.getChildren().length);
        Assertions.assertEquals(child1, family1.getChildren()[0]);
        Assertions.assertEquals(child2, family1.getChildren()[1]);
    }

    @Test
    public void testAddChild() {
        Assertions.assertEquals(2, family1.getChildren().length);
        Assertions.assertSame(child1, family1.getChildren()[0]);
        Assertions.assertSame(child2, family1.getChildren()[1]);
    }
}
