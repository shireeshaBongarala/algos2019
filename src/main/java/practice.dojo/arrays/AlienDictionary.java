package practice.dojo.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AlienDictionary {

  HashMap<Character, Node> nodeMap = new HashMap<>();

  class Node {
    Character value;
    int rank;
    List<Node> nextCharacters = new ArrayList<>();

    public List<Node> getNextCharacters() {
      return nextCharacters;
    }

    public Character getValue() {
      return value;
    }

    public void setValue(Character value) {
      this.value = value;
    }

    public int getRank() {
      return rank;
    }
  }

  public String alienOrder(String[] words) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < words.length - 1; i++) {
      String w1 = words[i];
      String w2 = words[i + 1];

      for (int j = 0; j < w1.length(); j++) {
        if (j >= w2.length()) {
          break;
        }
        if (w1.charAt(j) == w2.charAt(j)) {
          continue;
        } else {
          Node nodeForW1 = new Node();
          Node nodeForW2 = new Node();
        }
      }
    }


    return "";
  }


}
