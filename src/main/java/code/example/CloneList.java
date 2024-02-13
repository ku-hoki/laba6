package code.example;

import java.util.ArrayList;
import java.util.List;

public class CloneList extends Human{

    public CloneList(String surname, String name, String middleName, int age) {
        super(surname, name, middleName, age);
    }

    //создание копии входного списка без заданного человека
    public List<Human> copyListWithoutOnePerson(List<Human> humanList, Human person){
        List<Human> copiedList = new ArrayList<>(humanList);
        copiedList.remove(person);
        return copiedList;
    }
}
