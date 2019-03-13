package practice.dojo.combinatorics;

import java.util.Arrays;

class Developers {

  int maxContributions(int[] frontEndContributions, int[] backEndContributions, int noOfFrontEnd) {

    return findMaxContributions(frontEndContributions,
        0, backEndContributions, noOfFrontEnd);

  }

  private int findMaxContributions(int[] frontEndContributions, int currentIndex, int[] backEndContributions, int noOfFrontEnd) {
    int size = frontEndContributions.length;
    if (currentIndex >= size) {
      return 0;
    }
    if (noOfFrontEnd == size) {
      return sum(frontEndContributions, currentIndex);
    }
    if (noOfFrontEnd == 0) {
      return sum(backEndContributions, currentIndex);
    }
    return Math.max(
        frontEndContributions[currentIndex] + findMaxContributions(frontEndContributions,
            currentIndex + 1, backEndContributions, noOfFrontEnd - 1),
        backEndContributions[currentIndex] + findMaxContributions(frontEndContributions,
            currentIndex + 1, backEndContributions, noOfFrontEnd)
    );
  }

  private int sum(int[] array, int index) {
    int sum = 0;
    for (int i = index; i < array.length; i++) {
      sum += array[i];
    }
    return sum;
  }

}
