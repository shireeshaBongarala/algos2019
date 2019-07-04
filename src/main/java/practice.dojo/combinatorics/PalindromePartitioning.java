package practice.dojo.combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PalindromePartitioning {


  public static void main(String[] args) {
    PalindromePartitioning p = new PalindromePartitioning();
    System.out.println( p.partition("efe"));
  }

  public ArrayList<ArrayList<String>> partition(String a) {

    ArrayList<ArrayList<String>> solution = new ArrayList<>();
    if (isPalindrome(a)) {
      final ArrayList<String> withWholeString = new ArrayList<>();
      withWholeString.add(a);
      solution.add(withWholeString);
    }

    for (int i = 1; i < a.length(); i++) {
      String firstPart = a.substring(0, i);
      if (!isPalindrome(firstPart)) {
        continue;
      }
      String lastPart = a.substring(i);
      if (!isPalindrome(lastPart)) {
        continue;
      }

      ArrayList<ArrayList<String>> firstPartPermutations = partition(firstPart);
      ArrayList<ArrayList<String>> lastPartPermutations = partition(lastPart);



      for (ArrayList<String> firstPartPermutation : firstPartPermutations) {
        for(ArrayList<String> last : lastPartPermutations) {
          ArrayList<String> list = new ArrayList<>();
          list.addAll(firstPartPermutation);
          list.addAll(last);
          solution.add(list);
        }
      }
    }

    return solution;

  }


  //TODO: Implement
  boolean isPalindrome(String str) {
    StringBuilder builder = new StringBuilder(str);
    return str.equals(builder.reverse().toString());
  }


}
