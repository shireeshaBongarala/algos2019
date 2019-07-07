package practice.dojo.dp;

import java.util.Arrays;

public class WaysToDecodeRecursive {

  public int numDecodings(String A) {
    char[] arr = A.toCharArray();
    int size = arr.length;

    int[] decodings = new int[size];

    Arrays.fill(decodings, -1);
    return countDecodings(arr, decodings, 0);
  }

  int countDecodings(char[] arr, int[] decodings, int index) {
    if (index == arr.length) {
      return 1;
    }
    if (index < 0 || index > arr.length) {
      return 0;
    }
    if (decodings[index] != -1) {
      return decodings[index];
    }


    int count = 0;
    Integer singleVal = Integer.valueOf(arr[index] + "");
    if (singleVal >= 1 && singleVal <= 9) {
      count += countDecodings(arr, decodings, index + 1);
    }
    if (index < arr.length - 1) {
      Integer doubleVal = Integer.valueOf(arr[index] + "" + arr[index + 1]);
      if (doubleVal >= 10 && doubleVal <= 26) {
        count += countDecodings(arr, decodings, index + 2);
      }
    }
    decodings[index] = count;
    return decodings[index];
  }
}
