package code.example;

import java.util.ArrayList;
import java.util.List;

public class ListDemo extends Human{
    public ListDemo(String surname, String name, String middleName, int age) {
        super(surname, name, middleName, age);
    }

    public List<Human> findPeopleWithSameSurname(List<Human> humanList, Human person){
        List<Human> result = new ArrayList<>();
        String surName = person.getSurname();
        for (Human human: humanList){
            if (human.getSurname().equals(surName) && !human.equals(person)){
                result.add(human);

            }
        }

        return result;
    }
}
