package practice.dojo.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

class Powerset {
  ArrayList<ArrayList<Integer>> generateFor(ArrayList<Integer> input) {
    if (input.isEmpty()) {
      return new ArrayList<>();
    }
    Integer first = input.get(0);
    input.remove(0);
    ArrayList<ArrayList<Integer>> subResult = generateFor(input);
    if (subResult.isEmpty()) {
      return new ArrayList<>(
          Arrays.asList(
              new ArrayList<>(Arrays.asList(first)),
              new ArrayList<>()));
    }
    ArrayList<ArrayList<Integer>> result = (ArrayList<ArrayList<Integer>>) subResult.clone();
    for (ArrayList<Integer> list : subResult) {
      list.add(first);
      result.add(list);
    }

    return subResult;
  }
}
