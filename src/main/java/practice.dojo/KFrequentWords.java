package practice.dojo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class KFrequentWords {

  class Node {
    int freq;
    String word;

    Node(String word) {
      this.word = word;
      this.freq = 0;
    }
  }

  public List<String> topKFrequent(String[] words, int k) {
    HashMap<String, Node> wordMap = new HashMap();

    for (String word : words) {
      Node node = wordMap.getOrDefault(word, new Node(word));
      node.freq += 1;

      wordMap.putIfAbsent(word, node);
    }

    PriorityQueue<Node> maxHeap = new PriorityQueue<>((o1, o2) -> o1.freq == o2.freq ? o1.word.compareTo(o2.word) : o1.freq - o2.freq);
    maxHeap.addAll(wordMap.values());

    List<String> result = new ArrayList();
    for (int i = 0; i < k && !maxHeap.isEmpty(); i++) {
      result.add(maxHeap.poll().word);
    }

    return result;
  }

}
