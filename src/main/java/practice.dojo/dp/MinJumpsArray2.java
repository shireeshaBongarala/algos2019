package practice.dojo.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class MinJumpsArray2 {

  public static void main(String[] args) {
    MinJumpsArray2 jumpsArray2 = new MinJumpsArray2();
    ArrayList<Integer> array = new ArrayList<>(Arrays.asList(2, 3, 1, 1, 4));
    jumpsArray2.jump(array);
  }

  public int jump(ArrayList<Integer> A) {
    if (A.size() == 1) {
      return 0;
    }
    int jumps = 1;
    int lastReach = A.get(0);
    int maxReach = A.get(0);
    for (int i = 1; i < A.size(); i++) {
      if (maxReach < i) {
        return -1;
      }
      if (lastReach < i) {
        jumps++;
        lastReach = maxReach;
      }
      maxReach = Math.max(maxReach, i + A.get(i));
    }
    return jumps;
  }

}
