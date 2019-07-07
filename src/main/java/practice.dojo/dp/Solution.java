package practice.dojo.dp;

import java.util.Arrays;
import java.util.List;

public class Solution {
  // DO NOT MODIFY THE LIST. IT IS READ ONLY

  public static void main(String[] args) {
    Solution solution = new Solution();
    int a = solution.longestSubsequenceLength(Arrays.asList(1, 11, 2, 10, 4, 5, 2, 1));
    System.out.println(a);
  }

  public int longestSubsequenceLength(final List<Integer> A) {
    int size = A.size();
    int[] iss = new int[size];
    Arrays.fill(iss, -1);
    int[] dss = new int[size];
    Arrays.fill(dss, -1);

    int[] arr = new int[size];
    for (int i = 0; i < size; i++) {
      arr[i] = A.get(i);
    }


    cds(dss, arr, 0);
    cis(iss, arr, size - 1);

    int max = 0;
    for (int i = 1; i < size; i++) {
      max = Math.max(max, iss[i] + dss[i] - 1);
    }

    return max;

  }

  int cds(int[] dss, int[] arr, int index) {
    if (index >= arr.length) {
      return 0;
    }
    if (dss[index] != -1) {
      return dss[index];
    }

    int maxVal = 1;
    for (int i = index + 1; i < arr.length; i++) {
      if (arr[i] < arr[index]) {
        maxVal = Math.max(1 + cds(dss, arr, i), maxVal);
      }
    }

    dss[index] = maxVal;
    return maxVal;
  }


  int cis(int[] iss, int[] arr, int index) {
    if (index < 0) {
      return 0;
    }
    if (iss[index] != -1) {
      return iss[index];
    }

    int maxVal = 1;
    for (int i = index - 1; i >= 0; i--) {
      if (arr[i] > arr[index]) {
        maxVal = Math.max(1 + cis(iss, arr, i), maxVal);
      }
    }

    iss[index] = maxVal;
    return maxVal;
  }


}

