package myTest;

import java.util.*;

import exampleFamily.Family;
import exampleFamily.Human;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FamilyTestCase {

    private Family family;
    private List<Family> children;
    private Human newChild;

    @BeforeEach
    public void setUp() {
        family = new Family();
        children = new ArrayList<>();
        children.add(new Human("Tom", "Karleone", 1999, family));
        children.add(new Human("Anna", "Karleone", 2001, family));
        family.setChildren(children);
        newChild = new Human("Etan", "Karleone", 2003, family);
    }

    @Test
    public void addChild() {
        // Добавляем нового ребенка
        family.addChild(newChild);
        // Проверяем, что количество детей увеличилось на 1
        Assertions.assertEquals(3, family.getChildren().size());
        // Проверяем, что добавленный ребенок есть в списке детей
        Assertions.assertTrue(family.getChildren().contains(newChild));
        System.out.println(children);
    }

    @Test
    public void testDeleteChild() {
        family.addChild(newChild);
        family.deleteChild(newChild);
        Assertions.assertFalse(family.getChildren().contains(newChild));

    }

    @Test
    public void testDeleteChildWithNonexistentChild() {
        // создаем объект child, который не эквивалентен ни одному элементу массива children
        Human nonExistentChild = new Human("John", "Doe", 2005, family);
        // сохраняем копию списка children для сравнения
        List<Family> originalChildren = new ArrayList<>(children);
        // удаляем несуществующего ребенка
        family.deleteChild(nonExistentChild);
        // проверяем, что список children остался неизменным
        Assertions.assertEquals(originalChildren, children);
    }

    @Test
    public void testDeleteChild1Index() {
        System.out.println(children);
        int resultBefore = family.getChildren().size();
        family.deleteChild1(1);
        Assertions.assertEquals(family.getChildren().size(), resultBefore - 1);
        System.out.println(children);
    }

    @Test
    public void testDeleteChild1ReturnsFalseWhenIndexIsOutOfRange() {
        int index = 5;
        boolean result = family.deleteChild1(index);
        Assertions.assertFalse(result);
        Assertions.assertEquals(children, family.getChildren());
    }
}



