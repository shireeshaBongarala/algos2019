package practice.dojo.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumber {

  public static void main(String[] args) {
    PhoneNumber phoneNumber = new PhoneNumber();
    phoneNumber.letterCombinations("23");

  }

  public List<String> letterCombinations(String digits) {
    String[] map = new String[10];
    map[2] = "abc";
    map[3] = "def";
    map[4] = "ghi";
    map[5] = "jkl";
    map[6] = "mno";
    map[7] = "pqrs";
    map[8] = "tuv";
    map[9] = "wxyz";
    char[] cdigits = digits.toCharArray();
    if(digits.isEmpty()) return new ArrayList();
    return getCombinations(cdigits, map, new StringBuilder(), 0);
  }

  List<String> getCombinations(char[] digits, String[] map, StringBuilder sb, int index) {
    List<String> result = new ArrayList();
    if (index >= digits.length && sb.length() == digits.length) {
      result.add(sb.toString());
      return result;
    }

    for (int i = index; i < digits.length; i++) {
      int val = digits[i] - '0';
      if (val >= 2 && val <= 9) {
        for (Character c : map[val].toCharArray()) {
          sb.append(c);
          result.addAll(getCombinations(digits, map, sb, i + 1));
          sb.delete(sb.length() - 1, sb.length());
        }
      }
    }
    return result;
  }

}
