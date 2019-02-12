package practice.dojo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MagicianAndChocolates {
  public int nchoc(int A, ArrayList<Integer> B) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    long chocolates = 0;
    maxHeap.addAll(B);
    for (int i = 0; i < A; i++) {
      if(maxHeap.size() > 0) {
            int current = maxHeap.poll();
        chocolates+= current;
        current = (int) Math.floor(current >> 1);
        if(current > 0) maxHeap.add(current);
        chocolates = (int) (chocolates % (Math.pow(10, 9) + 7));
      }
    }
    return (int) chocolates;
  }
}
