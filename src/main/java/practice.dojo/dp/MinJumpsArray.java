package practice.dojo.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class MinJumpsArray {

  public int jump(ArrayList<Integer> A) {
    int size = A.size();
    int[] noj = new int[size];
    Arrays.fill(noj, Integer.MAX_VALUE);
    noj[size - 1] = 0;

    for (int i = size - 2; i >= 0; i--) {
      int jumps = A.get(i);
      if (i + jumps == size - 1) {
        noj[i] = 1;
        continue;
      }

      for (int j = i + 1; j <= i + jumps && j < size; j++) {
        if (noj[j] != Integer.MAX_VALUE) {
          noj[i] = Math.min(noj[i], 1 + noj[j]);
        }
      }
    }
    return noj[0] == Integer.MAX_VALUE ? -1 : noj[0];
  }
}
