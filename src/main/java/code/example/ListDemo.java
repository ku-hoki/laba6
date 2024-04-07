package code.example;

import java.util.*;

public class ListDemo {

    //Метод для поиска челиков с одной фамилией
    public List<Human> findPeopleWithSameSurname(List<Human> humanList, Human person) {
        List<Human> result = new ArrayList<>();
        for (Human human : humanList) {
            if (human.getSurname().equals(person.getSurname()) && !human.equals(person)) {
                result.add(human);
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
    public Set<Human> findMaxAgePeople(List<Human> peopleList) {
        int maxAge = 0;
        Set<Human> veryOldPeople = new HashSet<>();

        for (Human person : peopleList) {
            if (person.getAge() > maxAge) {
                maxAge = person.getAge();
                veryOldPeople.add(person);

            }
        }
        return veryOldPeople;
    }

    public Set<Human> findPeopleByIndex(Map<Integer, Human> idHumanList, Set<Integer> ids){

        Set<Human> result = new HashSet<>();
        for (int id: ids){
            Human person = idHumanList.get(id);
            if (person != null){
                result.add(person);
            }
        }
        return result;
    }
}

