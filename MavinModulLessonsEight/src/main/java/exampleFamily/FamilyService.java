package exampleFamily;

import Pet.Interface.FamilyDao;



import java.util.*;

public class FamilyService {

        private FamilyDao familyDao;

        public   FamilyService (){
            this.familyDao = familyDao;


        }
    // получить список всех семей

    public static List<Family> getAllFamilies(List<Family> familyList) {
        return familyList;
    }

    // вывести на экран все семьи (в индексированном списке) со всеми членами семьи
    public static void displayAllFamilies(List<Family> familyList) {
        for (int i = 0; i < familyList.size(); i++) {
            Family family = familyList.get(i);
            System.out.println("Семья " + (i + 1));
            System.out.println(family.toString());
        }
    }

    // найти семьи с количеством людей больше чем (принимает количество человек и возвращает все семьи где количество людей больше чем указанное); выводит информацию на экран
    public static List<Family> getFamiliesBiggerThan(List<Family> familyList, int numberOfPeople) {
        List<Family> result = new ArrayList<>();
        for (Family family : familyList) {
            if (family.countFamily() > numberOfPeople) {
                result.add(family);
            }
        }
        return result;
    }

    // найти семьи с количеством людей меньше чем (принимает количество человек и возвращает все семьи где количество людей меньше чем указанное); выводит информацию на экран
    public static List<Family> getFamiliesLessThan(List<Family> familyList, int numberOfPeople) {
        List<Family> result = new ArrayList<>();
        for (Family family : familyList) {
            if (family.countFamily() < numberOfPeople) {
                result.add(family);
            }
        }
        return result;
    }

    // подсчитать число семей с количеством людей равное переданному числу
    public static int countFamiliesWithMemberNumber(List<Family> familyList, int numberOfPeople) {
        int count = 0;
        for (Family family : familyList) {
            if (family.countFamily() == numberOfPeople) {
                count++;
            }
        }
        return count;
    }

    // создать новую семью (принимает 2 параметра типа Human) - создает новую семью, сохраняет в БД
    public static void createNewFamily(List<Family> familyList, Human mother, Human father) {
        Family newFamily = new Family();
        newFamily.setMother(mother);
        newFamily.setFather(father);
        familyList.add(newFamily);
    }

    // удалить семью по индексу в списке - удаляет семью из БД
    public static void deleteFamilyByIndex(List<Family> familyList, int index) {
        if (index >= 0 && index < familyList.size()) {
            familyList.remove(index);
        }
    }
    // родить семьей ребенка (принимает Family и 2 типа String: мужское и женское имя) - в данной семье появляется новый ребенок с учетом данных родителей, информация о семье обновляется в БД; метод возвращает обновленную семью. Если рожденный ребенок мальчик - ему присваивается мужское имя, если девочка - женское.
    public static Family bornChild(Family family, String maleName, String femaleName) {
        Human child;
        if (Math.random() < 0.5) {
            child = new Human(maleName, family.getFather(). getSurname(), family.getFather().getYear(), family);
        } else {
            child = new Human(femaleName, family.getFather(). getSurname(), family.getFather().getYear(), family);
        }
        family.addChild(child);
        return family;
    }

    // усыновить ребенка (принимает 2 параметра: Family, Human)- в данной семье сохраняется данный ребенок, информация о семье обновляется в БД; метод возвращает обновленную семью.
    public static Family adoptChild(Family family, Human child) {
        family.addChild(child);
        return family;
    }

    // удалить детей старше чем (принимает int) - во всех семьях удаляются дети, которые старше указанного возраста, информация обновляется в БД.
    public static void deleteAllChildrenOlderThen(List<Family> familyList, int age) {
        for (Family family : familyList) {
            family.deleteAllChildrenOlderThen(age);
        }
    }
//    public void deleteAllChildrenOlderThen(int age) {
//        int resultAge;
//        for (Family family : familyDao.getAllFamilies()) {
//            Iterator iterator = family.getChildren().iterator();
//            while (iterator.hasNext()) {
//                Human child = (Human) iterator.next();
//                resultAge = 2019 - child.getBirthDate();
//                if (!(child.getBirthDate() == 0)) {
//                    if (resultAge > age) {
//                        iterator.remove();
//                        familyDao.saveFamily(family);
//                    }
//                }
//            }
//        }
//    }

    // возвращает количество семей в БД
    public static int count(List<Family> familyList) {
        return familyList.size();
    }

    // принимает индекс семьи, возвращает Family по указанному индексу
    public static Family getFamilyById(List<Family> familyList, int index) {
        if (index >= 0 && index < familyList.size()) {
            return familyList.get(index);
        }
        return null;
    }

    // принимает индекс семьи, возвращает список домашних животных, которые живут в семье.
    // изменила List<Pet> на  Set<Pet>
    public static Set<Pet> getPets(List<Family> familyList, int familyIndex) {
        if (familyIndex >= 0 && familyIndex < familyList.size()) {
            Family family = familyList.get(familyIndex);
            return family.getPets();
        }
        return null;
    }

    // принимает индекс семьи и параметр Pet - добавляет нового питомца в семью, обновляет данные в БД.
    public static void addPet(List<Family> familyList, int familyIndex, Pet pet) {
        if (familyIndex >= 0 && familyIndex < familyList.size()) {
            Family family = familyList.get(familyIndex);
            family.addPet(pet);

        }
    }
//            familyDao.getAllFamilies(List<Family> familyList);
//            familyDao.getFamilyByIndex(int index);
//            familyDao.deleteFamily(index);
//            familyDao.deleteFamily1();
//            familyDao.saveFamily();



}

