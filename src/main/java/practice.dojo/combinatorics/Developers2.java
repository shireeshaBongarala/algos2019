package practice.dojo.combinatorics;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparingInt;
import lombok.Value;

public class Developers2 {

  @Value
  private static class Tuple {
    int frontEndContributions;
    int backEndContributions;

  }

  int maxContributions(int[] frontEndContributions, int[] backEndContributions, int noOfFrontEnd) {
    List<Tuple> developers = new ArrayList<>();
    for (int i = 0; i < frontEndContributions.length; i++) {
      developers.add(new Tuple(frontEndContributions[i], backEndContributions[i]));
    }
    final int noOfDevs = developers.size();
    final int noOfBackEnd = noOfDevs - noOfFrontEnd;

    final int i = noOfDevs - 1;
    developers.sort(comparingInt(Tuple::getFrontEndContributions));
    int maxContributions1 = getMaxContributions(developers, i, noOfBackEnd, noOfFrontEnd);

    developers.sort(comparingInt(Tuple::getBackEndContributions));
    int maxContributions2 = getMaxContributions(developers, i, noOfBackEnd, noOfFrontEnd);

    return Math.max(maxContributions1, maxContributions2);
  }

  private int getMaxContributions(List<Tuple> developers, int index, int backEnd, int frontEnd) {
    int maxContributions = 0;
    while (index >= 0) {
      Tuple current = developers.get(index);
      if (current.getFrontEndContributions() > current.getBackEndContributions() && frontEnd > 0) {
        maxContributions += current.getFrontEndContributions();
        frontEnd--;
      } else if (current.getFrontEndContributions() > current.getBackEndContributions() && frontEnd <= 0) {
        maxContributions += current.getBackEndContributions();
        backEnd--;
      } else if (backEnd > 0) {
        maxContributions += current.getBackEndContributions();
        backEnd--;
      } else {
        maxContributions += current.getFrontEndContributions();
        frontEnd--;
      }
      index--;
    }
    return maxContributions;
  }
}

