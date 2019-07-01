package practice.dojo.combinatorics;

import java.util.ArrayList;

public class AtMostNGivenDigitSet {

  public int atMostNGivenDigitSet(int N, int[] D) {
    char[] digits = getNoOfDigits(N);


    int vocab = D.length;

    int result = 0;

    for (int i = 0; i < digits.length; i++) {
      result += Math.pow(vocab, i);
    }


    return 0;
  }


  public int removeDuplicates(ArrayList<Integer> a) {
    int index = 0;
    int duplicates = 0;
    while (index < a.size() - 1) {
      if (a.get(index).equals(a.get(index + 1))) {
        duplicates += 1;
        if (index + 2 < a.size()) {
          a.set(index + 1, a.get(index + 2));
        }
        index++;
      }
    }

    for (int i = 0; i < duplicates; i++) {
      a.remove(a.size() - 1);
    }
    return a.size();
  }



  private char[] getNoOfDigits(int n) {
    return String.valueOf(n).toCharArray();
  }

}
