package code.example;

import java.util.*;


public class ExclusionSets {

    public List<Set<Integer>> findSetsWithoutCrossing(List<Set<Integer>> firstSet, List<Set<Integer>> secondSet){

        List<Set<Integer>> resultSets = new ArrayList<>();
        for (Set<Integer> set: firstSet){
            List<Set<Integer>> intersectionSets = new ArrayList<>(Collections.singletonList(new HashSet<>(set)));
            intersectionSets.retainAll(secondSet);//нахождение пересечений множеств first и second

            if (intersectionSets.isEmpty()){//если результат пересечения пустой, то они не пересекаются
                resultSets.add(set);
            }
        }
        return resultSets;
    }
}
