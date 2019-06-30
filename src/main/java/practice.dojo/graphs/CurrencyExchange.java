package practice.dojo.graphs;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;
import lombok.Value;

/*
Assumptions: Using a directed graph, and there's an implicit order in the order of the edges.
* */

public class CurrencyExchange {

  double convert(String fromUnit, String toUnit, Graph graph) {
    Node fromNode = graph.getNode(fromUnit);
    Node toNode = graph.getNode(toUnit);
    Node primary = graph.getPrimaryNode();

    double fromNodeToPrimary = fromNode.getEdgeFor(primary.getUnit()).getConversionRate();
    double toNodeToPrimary = toNode.getEdgeFor(primary.getUnit()).getConversionRate();

    return fromNodeToPrimary / toNodeToPrimary;
  }


  @Data
  class Graph {
    private Map<String, Node> nodeMap = new HashMap<>();
    Node primaryNode;

    void addNode(Node node) {
      String unit = node.getUnit();
      nodeMap.put(unit, node);
    }

    Node getNode(String unit) {
      return nodeMap.get(unit);
    }

    void addOrUpdateEdge(String from, String to, double conversionRate) {
      Node fromNode = nodeMap.getOrDefault(from, new Node(from));
      Node toNode = nodeMap.getOrDefault(to, new Node(to));


      fromNode.addOrUpdateEdge(new Edge(fromNode, toNode, conversionRate));
    }

    void updateParentPointers() {
      
    }
  }

  @Data
  private static class Node {
    private String unit;
    private Map<String, Edge> edgesMap = new HashMap<>();

    Node(String unit) {
      this.unit = unit;
    }

    Edge getEdgeFor(String unit) {
      return edgesMap.get(unit);
    }

    void addOrUpdateEdge(Edge edge) {
      edgesMap.put(edge.getEnd().getUnit(), edge);
    }

  }

  @Value
  private static class Edge {
    Node start;
    Node end;
    double conversionRate;
  }

}


