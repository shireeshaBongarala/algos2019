package practice.dojo.binarysearch;

import java.util.Arrays;

class PaintersPartition {

  int getMinTimeRequired(int[] boards, int noOfPainters) {
    int minTime = Arrays.stream(boards).max().getAsInt();
    int maxTime = Arrays.stream(boards).sum();

    int midTime;
    while (minTime <= maxTime) {
      midTime = (maxTime + minTime) / 2;
      int noOfPaintersForMidTime = getPaintersRequired(boards, midTime);
      if (noOfPaintersForMidTime <= noOfPainters) {
        maxTime = midTime - 1;
      } else {
        minTime = midTime + 1;
      }
    }
    return minTime;
  }

  private int getPaintersRequired(int[] boards, int time) {
    int size = boards.length;
    int i = 0;
    int noOfPainters = 1;
    int cumulativeSum = 0;
    while (i < size) {
      if (cumulativeSum + boards[i] <= time) {
        cumulativeSum += boards[i];
      } else {
        cumulativeSum = boards[i];
        noOfPainters++;
      }
      i++;
    }
    return noOfPainters;
  }

}
