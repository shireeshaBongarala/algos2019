package practice.dojo.dp;

public class WaysToDecodeIterative {

  public int numDecodings(String A) {
    char[] arr = A.toCharArray();

    int size = arr.length;

    int[] decodings = new int[size + 1];

    decodings[size] = 1;
    countDecodings(arr, decodings);
    return decodings[0];

  }

  private void countDecodings(char[] arr, int[] decodings) {
    int size = arr.length;
    for (int i = size - 1; i >= 0; i--) {
      int val = Integer.valueOf(arr[i] + "");
      int count = 0;
      if (val >= 1 && val <= 9) {
        count += decodings[i + 1];
      }

      if (i < size - 1) {
        int doubleVal = Integer.valueOf(arr[i] + "" + arr[i + 1]);
        if (doubleVal >= 10 && doubleVal <= 26) {
          count += decodings[i + 2];
        }
      }

      decodings[i] = count;
    }
  }
}
