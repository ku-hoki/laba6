package code.example;

import java.util.*;

public class ListDemo {

    //Метод для поиска челиков с одной фамилией
    public static List<Human> findPeopleWithSameSurname(List<Human> humanList, Human person) {
        List<Human> result = new ArrayList<>();
        for (Human human : humanList) {
            if (human.getSurname().equals(person.getSurname())) {
                result.add(human);
            }
            if (result.isEmpty()){
                throw new IllegalArgumentException("There are no people with the same last name");
            }
        }
        return result;
    }

    //Метод удаления выбранного человечка
    public List<Human> removeSelectedPerson(List<Human> humanList, Human targetPerson) {
        List<Human> copyList = new ArrayList<>(humanList);
        copyList.remove(humanList);
        return copyList;

    }

    //Метод нахождения стариков
    public static Set<Human> findMaxAgePeople(List<Human> peopleList) {
        int maxAge = 0;
        Set<Human> veryOldPeople = new HashSet<>();

        for (Human person : peopleList) {
            if (person.getAge() > maxAge) {
                maxAge = person.getAge();
                veryOldPeople.add(person);
                veryOldPeople.clear();
            }
            if (person.getAge() == maxAge){
                veryOldPeople.add(person);
            }
        }
        return veryOldPeople;
    }

    //нахождение айди которое есть в исходном листе
    public static Set<Human> findPeopleByIndex(Map<Integer, Human> idHumanList, Set<Integer> ids){

        Set<Human> result = new HashSet<>();
        for (int id: ids){
            Human person = idHumanList.get(id);
            if (person != null){
                result.add(person);
            }
        }
        return result;
    }

    public static List<Integer> findPeopleOlder18(Map<Integer, Human> idHumanList){
        List<Integer> adultsControl = new ArrayList<>();
        for (Map.Entry<Integer, Human> entry : idHumanList.entrySet()){
            if (entry.getValue().getAge()>=18){
                adultsControl.add(entry.getKey());
            }
        }
        return adultsControl;
    }

    public  static Map<Integer, Integer> BuildMapIdAgeToPeople(Map<Integer,Human> idHumanMap){
        Map<Integer, Integer> idMapToAge = new HashMap<>();
        for(Map.Entry<Integer, Human> entry: idHumanMap.entrySet()){
            Human person = entry.getValue();
           int id = entry.getKey();
           int age = person.getAge();
           idMapToAge.put(id, age);
        }
        return idMapToAge;
    }

    public static Map<Integer, List<Human>> IdAgeToPeoples(Set<Human> peoples){
         Map<Integer, List<Human>> ageIdToPeoples = new HashMap<>();
         for (Human person: peoples){
             int age = person.getAge();
             if (!ageIdToPeoples.containsKey(age)){
                 ageIdToPeoples.put(age, new ArrayList<>());
             }
             ageIdToPeoples.get(age).add(person);

         }
         return ageIdToPeoples;
    }
}

