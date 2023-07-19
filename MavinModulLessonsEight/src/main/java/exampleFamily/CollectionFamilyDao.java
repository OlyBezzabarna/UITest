package exampleFamily;

import Pet.Interface.FamilyDao;

import java.util.*;


public class CollectionFamilyDao implements FamilyDao {


    private List<Family> familyList;

    public CollectionFamilyDao() {
        familyList = new ArrayList<>();
    }
    @Override
    public List<Family> getAllFamilies() {
        return familyList;
    }
    //getAllFamilies - возвращает проиндексированный список всех семей (List).
    @Override
    public Family getFamilyByIndex(int index) {
        if (index >= 0 && index < familyList.size()) {
            return familyList.get(index);
        }
        return null;
    }
    //getFamilyByIndex (принимает индекс семьи из общего списка) - возвращает семью по указанному индексу.
    // В случае, если запросили элемент с несуществующим индексом - возвращайте null.

    @Override
    public boolean deleteFamily(int index) {
        if (index >= 0 && index < familyList.size()) {
            familyList.remove(index);
            return true;
        }
        return false;
    }
    //deleteFamily (принимает индекс) - удаляет семью с заданным индексом, если такой индекс существует;
    // возвращает true если удаление произошло, false - если нет.


    @Override
        public boolean deleteFamily1(Family family) {
            return familyList.remove(family);
    }
    //deleteFamily (принимает тип Family) - удаляет семью если такая существует в списке;
    // возвращает true если удаление произошло, false - если нет.
    @Override
    public void saveFamily(Family family) {
        if (familyList.contains(family)) {
        } else {
            familyList.add(family);
        }
    }

    @Override
    public List<Family> getAllFamilies(List<Family> familyList) {
        return null;
    }
    //saveFamily (принимает тип Family) - обновляет существующую семью в БД если такая уже существует,
    // сохраняет в конец списка - если нет.


    // вывести на экран все семьи (в индексированном списке) со всеми членами семьи
    @Override
    public  void displayAllFamilies(List<Family> familyList) {
        for (int i = 0; i < familyList.size(); i++) {
            Family family = familyList.get(i);
            System.out.println("Семья " + (i + 1));
            System.out.println(family.toString());
        }
    }

    // найти семьи с количеством людей больше чем (принимает количество человек и возвращает все семьи,
    // где количество людей больше чем указанное); выводит информацию на экран
    @Override
    public  List<Family> getFamiliesBiggerThan(List<Family> familyList, int numberOfPeople) {
        List<Family> result = new ArrayList<>();
        for (Family family : familyList) {
            if (family.countFamily() > numberOfPeople) {
                result.add(family);
            }
        }
        return result;
    }

    // найти семьи с количеством людей меньше чем (принимает количество человек и возвращает все
    // семьи, где количество людей меньше чем указанное); выводит информацию на экран
    @Override
    public List<Family> getFamiliesLessThan(List<Family> familyList, int numberOfPeople) {
        List<Family> result = new ArrayList<>();
        for (Family family : familyList) {
            if (family.countFamily() < numberOfPeople) {
                result.add(family);
            }
        }
        return result;
    }

    // подсчитать число семей с количеством людей равное переданному числу
    @Override
    public int countFamiliesWithMemberNumber(List<Family> familyList, int numberOfPeople) {
        int count = 0;
        for (Family family : familyList) {
            if (family.countFamily() == numberOfPeople) {
                count++;
            }
        }
        return count;
    }

    // создать новую семью (принимает 2 параметра типа Human) - создает новую семью, сохраняет в БД
    @Override
    public  void createNewFamily(List<Family> familyList, Human mother, Human father) {
        Family newFamily = new Family();
        newFamily.setMother(mother);
        newFamily.setFather(father);
        familyList.add(newFamily);
    }

    // удалить семью по индексу в списке - удаляет семью из БД
    @Override
    public void deleteFamilyByIndex(List<Family> familyList, int index) {
        if (index >= 0 && index < familyList.size()) {
            familyList.remove(index);
        }
    }

    // Родить семьей ребенка (принимает Family и 2 типа String: мужское и женское имя) - в данной
    // семье появляется новый ребенок с учетом данных родителей, информация о семье обновляется в БД;
    // метод возвращает обновленную семью. Если рожденный ребенок мальчик - ему присваивается мужское имя,
    // если девочка - женское.
    @Override
    public  Family bornChild(Family family, String maleName, String femaleName) {
        Human child;
        if (Math.random() < 0.5) {
            child = new Human(maleName, family.getFather().getSurname(), family.getFather().getYear(), family);
        } else {
            child = new Human(femaleName, family.getFather().getSurname(), family.getFather().getYear(), family);
        }
        family.addChild(child);
        return family;
    }

    // усыновить ребенка (принимает 2 параметра: Family, Human)- в данной семье сохраняется данный ребенок,
    // информация о семье обновляется в БД; метод возвращает обновленную семью.
    @Override
    public Family adoptChild(Family family, Human child) {
        family.addChild(child);
        return family;
    }

    // удалить детей старше чем (принимает int) - во всех семьях удаляются дети, которые старше указанного
    // возраста, информация обновляется в БД.
    @Override
    public void deleteAllChildrenOlderThen(List<Family> familyList, int age) {
        for (Family family : familyList) {
            family.deleteAllChildrenOlderThen(age);
        }
    }

    // возвращает количество семей в БД
    @Override
    public int count(List<Family> familyList) {
        return familyList.size();
    }

    @Override
    public Family getFamilyById(List<Family> familyList, int index) {
        return null;
    }

    // принимает индекс семьи, возвращает список домашних животных, которые живут в семье
    @Override
    public Set<Pet> getPets(List<Family> familyList, int familyIndex) {
        if (familyIndex >= 0 && familyIndex < familyList.size()) {
            Family family = familyList.get(familyIndex);
                          return family.getPets();
        }
        return null;
    }

    // принимает индекс семьи и параметр Pet - добавляет нового питомца в семью, обновляет данные в БД.
    @Override
    public void addPet(List<Family> familyList, int familyIndex, Pet pet) {
        if (familyIndex >= 0 && familyIndex < familyList.size()) {
            Family family = familyList.get(familyIndex);
            family.addPet(pet);
        }
    }
}
