package code.example;

import java.util.*;


public class ExclusionSets {

    //поиск множества, которое не пересекается с заданным множеством
    public static List<Set<Integer>> findSetsWithoutCrossing(List<Set<Integer>> firstSet, Set<Integer> secondSet){

        List<Set<Integer>> interimSet = new ArrayList<>(firstSet);
        for (Set<Integer> set: firstSet){
            set.removeAll(secondSet);
        }
        interimSet.removeIf(Set::isEmpty);

        if (firstSet.isEmpty()){
            throw new IllegalArgumentException("error");
        }
        return interimSet;

    }
}
