package code.example;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class CollectionsDemoTest {

    @Test
    void testCountStringStartWith(){

        List<String> stroki = new ArrayList<>();
        stroki.add("pina-colada");
        stroki.add("banana");
        stroki.add("pineapple");

        assertEquals(2, CollectionsDemo.countStringStartWith(stroki, 'p'));
    }

    @Test
    void testCountStringStartNull(){

        List<String> stroki = new ArrayList<>();
        stroki.add("pina-colada");
        stroki.add("banana");
        stroki.add("pineapple");

        try {
            CollectionsDemo.countStringStartWith(stroki, 'z');
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("No strings start with the specified character", e.getMessage());
        }

    }


    @Test
    void testFindPeopleWithSameSurname(){//тест на поиск однофамильцев
        Human person1 = new Human("Brown", "Tom", "Andreevich", 20);
        Human person2 = new Human("Brown", "Tim", "Vladimir", 21);
        Human person3 = new Human("Will", "Smit", "Anton", 25);

        List<Human> people = new ArrayList<>();
        people.add(person1);
        people.add(person2);
        people.add(person3);

        List<Human> expected = new ArrayList<>();
        expected.add(person1);
        expected.add(person2);

        assertEquals(expected, ListDemo.findPeopleWithSameSurname(people, person1));
    }

    @Test
    void testNotFindPeopleWithSameSurname(){
        Human person1 = new Human("Brown", "Tom", "Andreevich", 20);
        Human person2 = new Human("Will", "Smit", "Anton", 25);

        List<Human> people = new ArrayList<>();
        people.add(person1);
        people.add(person2);

        try {
            ListDemo.findPeopleWithSameSurname(people, person1);
            fail("There are no people with the same last name");
        } catch (IllegalArgumentException e) {
        assertEquals("There are no people with the same last name", e.getMessage());
        }
    }

    @Test
    void testFindExclusionSets(){
        Set<Integer> set2 = new HashSet<>(Arrays.asList(4, 5, 6));
        Set<Integer> set3 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));

        Set<Integer> targetSet = new HashSet<>(Arrays.asList(4, 5, 6));

        List<Set<Integer>> firstSets = Arrays.asList(set1, set2, set3);
        List<Set<Integer>> expected = Arrays.asList(set1, set3);

        assertEquals(expected, ExclusionSets.findSetsWithoutCrossing(firstSets, targetSet));
    }
    @Test
    void testFindExclusionSetsNull(){

        List<Set<Integer>> inputSets = List.of();

        Set<Integer> targetSet = new HashSet<>();
        targetSet.add(2);
        targetSet.add(4);

        try {
            ExclusionSets.findSetsWithoutCrossing(inputSets, targetSet);
            fail("the input list is empty");
        }catch (IllegalArgumentException e) {
            assertEquals("error", e.getMessage());
        };

    }
    @Test
    void testCopyListWithoutOnePerson(){
        Human person1 = new Human("Brown", "Tom", "Andreevich", 20);
        Human person2 = new Human("Brown", "Tim", "Vladimir", 21);
        Human person3 = new Human("Will", "Smit", "Anton", 25);

        List<Human> people = new ArrayList<>(Arrays.asList(person1, person2, person3));
        List<Human> expected = new ArrayList<>(Arrays.asList(person1, person2));

        assertEquals(expected, CloneList.copyListWithoutOnePerson(people, person3));
    }

    @Test
    void testDriveOldPeopleFind(){

        List<Human> people = new ArrayList<>();
        people.add(new Human("Will", "Vlas", "karat", 29));
        people.add(new Human("Smit", "Alen", "marat", 30));
        people.add(new Student("Larion", "Ivan", "Alesha", 30, "Computer society"));

        assertEquals(2, ListDemo.findMaxAgePeople(people).size());
    }

    @Test
    void testFindPeopleByIndexMap(){
        Human person1 = new Human("Brown", "Tom", "Andreevich", 20);
        Human person2 = new Human("Haruki", "Murakami", "Da", 51);
        Human person3 = new Human("Will", "Smit", "Anton", 38);

        Map<Integer, Human> idHumanMap = new HashMap<>();
        idHumanMap.put(1, person1);
        idHumanMap.put(2, person2);
        idHumanMap.put(3, person3);

        Set<Integer> ids = new HashSet<>(Arrays.asList(1, 2));

        Set<Human> expected = new HashSet<>();
        expected.add(person1);
        expected.add(person2);

        assertEquals(expected, ListDemo.findPeopleByIndex(idHumanMap, ids));
    }

    @Test
    void testFindPeopleOlder18(){
        Human person1 = new Human("Brown", "Tom", "Andreevich", 2);
        Human person2 = new Human("Haruki", "Murakami", "Da", 51);
        Human person3 = new Human("Will", "Sat", "Anton", 38);

        Map<Integer, Human> idHumanMap = new HashMap<>();
        idHumanMap.put(1, person1);
        idHumanMap.put(2, person2);
        idHumanMap.put(3, person3);


        List<Integer> expected = Arrays.asList(2, 3);

        assertEquals(expected, ListDemo.findPeopleOlder18(idHumanMap));
    }

    @Test
    void testmapBuildIdToAge(){
        Human person1 = new Human("Brown", "Tom", "Andreevich", 2);
        Human person2 = new Human("Haruki", "Murakami", "Da", 51);
        Human person3 = new Human("Will", "Sat", "Anton", 38);

        Map<Integer, Human> idHumanMap = new HashMap<>();
        idHumanMap.put(1, person1);
        idHumanMap.put(2, person2);
        idHumanMap.put(3, person3);

        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(1, 2);
        expected.put(2, 51);
        expected.put(3, 38);

        assertEquals(expected, ListDemo.BuildMapIdAgeToPeople(idHumanMap));
    }

    @Test
    void testBuildAgeToPeopleMap(){
        Human person1 = new Human("Brown", "Tom", "Andreevich", 2);
        Human person2 = new Human("Haruki", "Murakami", "Da", 51);
        Human person3 = new Human("Will", "Sat", "Anton", 38);
        Human person4 = new Human("Osaki", "Nana", "Ara", 38);
        Human person5 = new Human("KArat", "Takumi", "Net", 51);
        Human person6 = new Human("Crazy", "Salt", "Yep", 38);

        Set<Human> people = new HashSet<>(Arrays.asList(person1, person2, person3, person4, person5, person6));

        Map<Integer, List<Human>> expected = new HashMap<>();

        expected.put(2, Collections.singletonList(person1));
        expected.put(51, Arrays.asList(person2, person5));
        expected.put(38, Arrays.asList(person6, person4, person3));

        assertEquals(expected, ListDemo.IdAgeToPeoples(people));
    }
}