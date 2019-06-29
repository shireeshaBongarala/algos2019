package practice.dojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class JewelsToStone {

  public int numJewelsInStones(String J, String S) {
    Set<Character> jewels = new HashSet<>();

    final char[] chars = J.toCharArray();
    for (char aChar : chars) {
      jewels.add(aChar);
    }
    int count = 0;
    for(int i =0; i< S.length(); i++) {
      if(jewels.contains(S.charAt(i))) count++;
    }

    return count;
  }

  public static void main(String[] args) {
    JewelsToStone jewelsToStone = new JewelsToStone();
    jewelsToStone.numJewelsInStones("abc", "Shireesha");
  }
}
