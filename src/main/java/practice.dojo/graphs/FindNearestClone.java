package practice.dojo.graphs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.Data;

public class FindNearestClone {

  @Data
  class Node {
    int color;
    List<Node> adjacencyList;
    Integer id;
    Set<Node> isVisitedBy;

    Node(Integer color, Integer id) {
      this.color = color;
      this.id = id;
    }
  }

  @Data
  class Graph {
    Map<Integer, Node> nodes;

    Graph(Map<Integer, Node> nodes) {
      this.nodes = nodes;
    }

    void addEdges(int[] gFrom, int[] gTo) {

    }
  }

  int findDistanceToNearestClone(int[] gFrom,
                                 int[] gTo,
                                 int nodes,
                                 int[] colors, int colorToMatch) {
    Map<Integer, Node> nodeMap =
        IntStream
            .rangeClosed(1, nodes)
            .boxed()
            .map(val -> new Node(val, colors[val - 1]))
            .collect(Collectors.toMap(Node::getId, Function.identity()));

    Graph graph = new Graph(nodeMap);
    graph.addEdges(gFrom, gTo);

    List<Node> nodesOfColor = fetchNodesWithColor(nodeMap.values(), colorToMatch);
    int shortestDistance = Integer.MAX_VALUE;
    if (nodesOfColor.size() <= 1) {
      return -1;
    }

    for(int i =0; i< nodesOfColor.size() -1; i++) {
        searchForFirstClone(nodesOfColor.get(i));
    }


    return 0;

  }

  private int searchForFirstClone(Node fromNode) {
    //Do BFS
    Queue<Node> queue = new LinkedList<>();
    ((LinkedList<Node>) queue).offerFirst(fromNode);


    return 0;
  }

  private ArrayList<Node> fetchNodesWithColor(Collection<Node> values, int colorToMatch) {
    return new ArrayList<>();
  }
}
