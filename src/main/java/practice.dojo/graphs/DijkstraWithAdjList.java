package practice.dojo.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.Data;

public class DijkstraWithAdjList {

  public static void main(String[] args) {
    DijkstraWithAdjList withAdjList = new DijkstraWithAdjList();
    int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {1, 5}};


    ArrayList<Integer> output = withAdjList.getShortestReach(6, edges, 6, 1);
    for (Integer integer : output) {
      System.out.print(integer + " ");
    }
  }

  @Data
  class Node {
    int id;
    List<Edge> edges = new ArrayList<>();
    boolean isVisited;
    Integer distanceFromStart;

    public Node(int id) {
      this.id = id;
    }

    Edge addEdge(Node toNode, int weight) {
      final Edge edge = new Edge(toNode, weight);
      edges.add(edge);
      return edge;
    }

    @Data
    class Edge {
      Node toNode;
      int weight;

      Edge(Node toNode, int weight) {
        this.toNode = toNode;
        this.weight = weight;
      }
    }
  }


  ArrayList<Integer> getShortestReach(int nodeCount, int[][] edges, int distance, int startNode) {
    Map<Integer, Node> nodeMap = generateNodes(nodeCount);
    addEdgesToNodes(nodeMap, edges, distance);

    final Node startNode1 = nodeMap.get(startNode);
    startNode1.setDistanceFromStart(0);
    doBFS(startNode1);
    return getDistancesFor(nodeMap, startNode);
  }


  private ArrayList<Integer> getDistancesFor(Map<Integer, Node> nodeMap, int startNode) {
    return (ArrayList<Integer>) IntStream.rangeClosed(1, nodeMap.size()).boxed()
        .filter(x -> !x.equals(startNode))
        .map(x -> nodeMap.get(x).getDistanceFromStart() == null? -1 : nodeMap.get(x).getDistanceFromStart())
        .collect(Collectors.toList());
  }

  private void doBFS(Node startNode) {
    LinkedList<Node> queue = new LinkedList<>();
    queue.addFirst(startNode);

    while (!queue.isEmpty()) {
      Node currentNode = queue.poll();
      currentNode.setVisited(true);
      currentNode
          .getEdges()
          .stream()
          .filter(edge -> !edge.getToNode().isVisited())
          .forEach(edge -> {
            Node toNode = edge.getToNode();
            queue.add(toNode);
            toNode.setVisited(true);
            toNode.setDistanceFromStart(
                currentNode.getDistanceFromStart() + edge.getWeight()
            );
          });
    }
  }

  private void addEdgesToNodes(Map<Integer, Node> nodeMap, int[][] edges, int distance) {
    Arrays.stream(edges).forEach(edge -> {
      Node fromNode = nodeMap.get(edge[0]);
      Node toNode = nodeMap.get(edge[1]);
      fromNode.addEdge(toNode, distance);
    });
  }

  private Map<Integer, Node> generateNodes(int nodeCount) {
    return IntStream
        .rangeClosed(1, nodeCount)
        .boxed()
        .map(Node::new)
        .collect(
            Collectors.toMap(Node::getId, Function.identity()));
  }

}
