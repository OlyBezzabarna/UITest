package Pet.Interface;

import java.util.*;
import exampleFamily.Family;
import exampleFamily.Human;
import exampleFamily.Pet;

public interface FamilyDao {

    List<Family> getAllFamilies();

    //getAllFamilies - возвращает проиндексированный список всех семей (List).
    Family getFamilyByIndex(int index);

    //getFamilyByIndex (принимает индекс семьи из общего списка) - возвращает семью по указанному индексу. В случае, если запросили элемент с несуществующим индексом - возвращайте null.
    boolean deleteFamily(int index);

    //deleteFamily (принимает индекс) - удаляет семью с заданным индексом, если такой индекс существует; возвращает true если удаление произошло, false - если нет.
     boolean deleteFamily1(Family family);

    //deleteFamily (принимает тип Family) - удаляет семью если такая существует в списке; возвращает true если удаление произошло, false - если нет.
    void saveFamily(Family family);

//saveFamily (принимает тип Family) - обновляет существующую семью в БД если такая уже существует,
// сохраняет в конец списка - если нет.


 //   List<Family> getAllFamilies();

    // получить список всех семей
    List<Family> getAllFamilies(List<Family> familyList);

    // вывести на экран все семьи (в индексированном списке) со всеми членами семьи
    void displayAllFamilies(List<Family> familyList);

    // найти семьи с количеством людей больше чем (принимает количество человек и возвращает все семьи где количество людей больше чем указанное); выводит информацию на экран
    List<Family> getFamiliesBiggerThan(List<Family> familyList, int numberOfPeople);

    // найти семьи с количеством людей меньше чем (принимает количество человек и возвращает все семьи где количество людей меньше чем указанное); выводит информацию на экран
    List<Family> getFamiliesLessThan(List<Family> familyList, int numberOfPeople);


    // подсчитать число семей с количеством людей равное переданному числу
    int countFamiliesWithMemberNumber(List<Family> familyList, int numberOfPeople);


    // создать новую семью (принимает 2 параметра типа Human) - создает новую семью, сохраняет в БД
    void createNewFamily(List<Family> familyList, Human mother, Human father);


    // удалить семью по индексу в списке - удаляет семью из БД
    void deleteFamilyByIndex(List<Family> familyList, int index);

    // родить семьей ребенка (принимает Family и 2 типа String: мужское и женское имя) - в данной семье появляется новый ребенок с учетом данных родителей, информация о семье обновляется в БД; метод возвращает обновленную семью. Если рожденный ребенок мальчик - ему присваивается мужское имя, если девочка - женское.
    Family bornChild(Family family, String maleName, String femaleName);


    // усыновить ребенка (принимает 2 параметра: Family, Human)- в данной семье сохраняется данный ребенок, информация о семье обновляется в БД; метод возвращает обновленную семью.
    Family adoptChild(Family family, Human child);


    // удалить детей старше чем (принимает int) - во всех семьях удаляются дети, которые старше указанного возраста, информация обновляется в БД.
    void deleteAllChildrenOlderThen(List<Family> familyList, int age);
//    void deleteAllChildrenOlderThen(int age);


    // возвращает количество семей в БД
    int count(List<Family> familyList);


    // принимает индекс семьи, возвращает Family по указанному индексу
    Family getFamilyById(List<Family> familyList, int index);

    // принимает индекс семьи, возвращает список домашних животных, которые живут в семье.
    // изменила List<Pet> на  Set<Pet>
    Set<Pet> getPets(List<Family> familyList, int familyIndex);

    // принимает индекс семьи и параметр Pet - добавляет нового питомца в семью, обновляет данные в БД.
    void addPet(List<Family> familyList, int familyIndex, Pet pet);

}



