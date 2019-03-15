package practice.dojo.combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import lombok.Value;

public class Developers3 {


  @Value
  static class Tuple {
    int frontEndContributions;
    int backEndContributions;
  }

  int maxContributions(int[] frontEndContributions, int[] backEndContributions, int noOfFrontEnd) {
    List<Tuple> developers = new ArrayList<>();
    for (int i = 0; i < frontEndContributions.length; i++) {
      developers.add(new Tuple(frontEndContributions[i], backEndContributions[i]));
    }

    developers.sort(Comparator.comparingInt(x -> x.getBackEndContributions() - x.getFrontEndContributions()));
    int maxContributions = 0;
    for (int i = 0; i < noOfFrontEnd; i++) {
      maxContributions += developers.get(i).getFrontEndContributions();
    }
    for (int i = noOfFrontEnd; i < developers.size(); i++) {
      maxContributions += developers.get(i).getBackEndContributions();
    }

    return maxContributions;
  }
}
