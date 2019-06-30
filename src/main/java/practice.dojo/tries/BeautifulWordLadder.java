package practice.dojo.tries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.Setter;

public class BeautifulWordLadder {
  @Getter
  private static class Node {
    private String word;

    @Setter
    private Integer distance;

    @Setter
    private List<Node> adjacencyList;

    @Setter
    private List<Node> parents;

    void addParent(Node parent) {
      parents.add(parent);
    }

    Node(String word) {
      this.word = word;
    }
  }


  public List<List<String>> findLadders(String beginWord,
                                        String endWord,
                                        List<String> wordList) {
    List<List<String>> solution = new ArrayList<>();
    if (!wordList.contains(endWord)) {
      return solution;
    }

    Map<String, Node> graph = createNodesForDict(wordList);

    Node beginNode = graph.get(beginWord);
    beginNode.setAdjacencyList(getAdjacentNodes(beginNode, graph));


    LinkedList<Node> queue = new LinkedList<>();
    queue.add(beginNode);

    while (!queue.isEmpty()) {
      Node currentNode = queue.poll();
      if (currentNode.getWord().equals(endWord)) {
        //Found path with distance that is the shortest
        break;
      }
      Set<String> visited = new HashSet<>();
      visited.add(currentNode.getWord());
      currentNode.adjacencyList
          .stream()
          .filter(n -> !visited.contains(n.getWord()))
          .filter(n -> (currentNode.getDistance() + 1) < n.getDistance())
          .peek(adjNode -> {
            adjNode.setDistance(currentNode.getDistance() + 1);
            adjNode.addParent(currentNode);
          }).forEach(queue::add);
    }

    Node endNode = graph.get(endWord);

//    solution = endNode.parents
//        .stream()
//        .map(parent -> backTrack(parent, beginNode))
//        .collect(Collectors.toList());


    return solution;
  }

//  private List<List<String>> backTrack(Node parent, Node beginNode) {
//    if (parent.getWord().equals(beginNode.getWord())) {
//      return Collections.emptyList();
//    }
//
//    return parent.getParents()
//        .stream()
//        .map(grandParent -> backTrack(grandParent, beginNode))
//        .map(list -> {
//          list.add(parent.getWord());
//          return list;
//        })
//        .collect(Collectors.toList());
//
//
//    return new LinkedList<>();
//  }

  private List<Node> getAdjacentNodes(Node beginNode, Map<String, Node> graph) {
    return graph.values()
        .stream()
        .filter(node -> isAdjacent(node, beginNode))
        .collect(Collectors.toList());
  }

  private boolean isAdjacent(Node node, Node beginNode) {
    String wordOne = beginNode.getWord();
    String wordTwo = node.getWord();
    //TODO: Implement me!!!
    return true;
  }

  private Map<String, Node> createNodesForDict(List<String> wordList) {
    Map<String, Node> graph = new HashMap<>();
    for (String word : wordList) {
      graph.put(word, createNode(word));
    }

    return graph;
  }

  private Node createNode(String word) {
    return new Node(word);
  }

}
