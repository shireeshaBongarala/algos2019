package practice.dojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSortWithBFS {
  class Node {
    int value;
    int degree = 0;
    List<Node> adjacencyList = new ArrayList();
    boolean visited = false;

    Node(int value) {
      this.value = value;
    }
  }

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    ArrayList<Node> nodes = new ArrayList();

    HashMap<Integer, Node> nodeMap = new HashMap();

    for (int i = 0; i < numCourses; i++) {
      Node node = new Node(i);
      nodeMap.put(i, node);
    }

    for (int i = 0; i < prerequisites.length; i++) {
      Node firstNode = nodeMap.get(prerequisites[i][1]);
      Node dependentNode = nodeMap.get(prerequisites[i][0]);
      firstNode.adjacencyList.add(dependentNode);
      dependentNode.degree += 1;
    }

    Queue<Node> queue = new LinkedList();

    for (int i = 0; i < numCourses; i++) {
      Node node = nodeMap.get(i);
      if (node.degree == 0) {
        queue.add(node);
      }
    }

    if (queue.isEmpty()) {
      return false;
    }

    int count = 0;
    while (!queue.isEmpty()) {
      Node currNode = queue.poll();
      currNode.visited = true;
      count++;
      for (Node dependency : currNode.adjacencyList) {
        dependency.degree -= 1;
        if (dependency.degree == 0 && !dependency.visited) {
          queue.add(dependency);
        }
      }
    }

    return count == numCourses;

  }

}
