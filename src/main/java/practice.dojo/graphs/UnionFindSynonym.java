package practice.dojo.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import lombok.Data;

public class UnionFindSynonym {

  @Data
  class Graph {

    HashMap<String, Graph.Node> nodeHashMap = new HashMap<>();

    @Data
    class Node {
      boolean isPrimary = true;
      List<Node> synonyms = new ArrayList<>();
      String name;
      Node parent = this;

      public Node(String name) {
        this.name = name;
      }
    }

    void addSynonym(String a, String b) {
      Graph.Node node1 = nodeHashMap.getOrDefault(a, new Node(a));
      if (!nodeHashMap.containsKey(a)) {
        nodeHashMap.put(a, node1);
      }

      Graph.Node node2 = nodeHashMap.getOrDefault(b, new Node(b));
      if (!nodeHashMap.containsKey(b)) {
        nodeHashMap.put(b, node2);
      }

      Graph.Node primary = node1.isPrimary ? node1 : node2;
    }


  }


}
