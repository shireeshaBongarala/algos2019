package practice.dojo.graphs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.Data;
import lombok.Value;

public class FindSynonyms {

  public static void main(String[] args) {
    FindSynonyms findSynonyms = new FindSynonyms();
    List<Name> names = new ArrayList<>();
    names.add(new Name("Shireesha", 1));
    names.add(new Name("Sirisha", 100));
    names.add(new Name("Sireesha", 90));
    names.add(new Name("Prashant", 20));
    names.add(new Name("Prasanth", 11));
    names.add(new Name("Prasanna", 11));
    names.add(new Name("Manohar", 20));


    Map<String, String> synonyms = new HashMap<>();
    synonyms.put("Shireesha", "Sirisha");
    synonyms.put("Sirisha", "Sireesha");
    synonyms.put("Prashant", "Prasanth");
    List<Name> uniqueNames = findSynonyms.countUniqueNames(names, synonyms);
    for (Name uniqueName : uniqueNames) {
      System.out.println(uniqueName);
    }
  }

  @Value
  static class Name {
    String name;
    int frequency;

    @Override
    public String toString() {
      return "Name{" +
          "name='" + name + '\'' +
          ", frequency=" + frequency +
          '}';
    }
  }

  @Data
  static class Node {
    boolean isReal = true;
    final String name;
    final int frequency;
    int cumulativeFrequency;
    List<Node> synonyms = new ArrayList<>();
    Node primary = this;

    public Node(String name, int frequency) {
      this.name = name;
      this.frequency = frequency;
      this.cumulativeFrequency = frequency;
    }

    void addSynonym(Node synonym) {
      synonyms.add(synonym);
      cumulativeFrequency += synonym.getCumulativeFrequency();
      synonym.markDuplicateOf(this);
    }

    void markDuplicateOf(Node primary) {
      this.setReal(false);
      this.setPrimary(primary);
    }

    void setPrimary(Node primary) {
      this.primary = primary;
    }
  }

  @Data
  static class Graph {
    Collection<Node> allNodes;
    Collection<Node> realNodes;

    Graph(Collection<Node> allNodes) {
      this.allNodes = allNodes;
      this.realNodes = new ArrayList<>(allNodes);
    }

    void addSynonyms(Node firstNode, Node secondNode) {
      if (firstNode == null || secondNode == null) {
        return;
      }
      Node[] nodePair = getOrder(firstNode, secondNode);
      Node realNode = nodePair[0];
      Node duplicateNode = nodePair[1];

      realNode.addSynonym(duplicateNode);
      realNodes.remove(duplicateNode);
    }

    private Node[] getOrder(Node firstNode, Node secondNode) {

      return new Node[] {firstNode.getPrimary(), secondNode.getPrimary()};
    }
  }

  List<Name> countUniqueNames(List<Name> allNames,
                              Map<String, String> synonymPairs) {

    Map<String, Node> allNodes = convertToNodes(allNames);
    Graph graph = new Graph(allNodes.values());
    synonymPairs.forEach((syn1, syn2) -> {
          graph.addSynonyms(
              allNodes.getOrDefault(syn1, null),
              allNodes.getOrDefault(syn2, null));
        }
    );

    return convertToNames(graph.getRealNodes());
  }

  private List<Name> convertToNames(Collection<Node> realNodes) {
    return realNodes
        .stream()
        .map(node -> new Name(node.getName(), node.getCumulativeFrequency()))
        .collect(Collectors.toList());
  }

  private Map<String, Node> convertToNodes(List<Name> allNames) {

    List<Node>
        nodes = allNames
        .stream()
        .map(name -> new Node(name.getName(), name.getFrequency()))
        .collect(Collectors.toList());

    Map<String, Node> nodeMap = new HashMap<>();
    for (Node node : nodes) {
      nodeMap.put(node.getName(), node);
    }

    return nodeMap;
  }


}
