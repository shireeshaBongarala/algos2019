package practice.dojo.graphs;

import java.util.HashMap;
import java.util.Map;

public class UnionFindByRank {

  public static void main(String[] args) {
    UnionFindByRank unionFindByRank = new UnionFindByRank();
    unionFindByRank.makeSet(1);
    unionFindByRank.makeSet(2);
    unionFindByRank.makeSet(3);
    unionFindByRank.makeSet(4);
    unionFindByRank.makeSet(5);
    unionFindByRank.makeSet(6);
    unionFindByRank.union(5, 6);
    unionFindByRank.union(4, 5);
    System.out.println(unionFindByRank.findSet(4));
    System.out.println(unionFindByRank.findSet(5));
    System.out.println(unionFindByRank.findSet(6));
    System.out.println(unionFindByRank.findSet(1));
  }
  private Map<Integer, Node> nodeMap = new HashMap<>();

  class Node {
    Node parent;
    int data;
    int rank;

    Node(int data) {
      this.data = data;
      this.rank = 0;
      this.parent = this;
    }
  }


  void makeSet(int data) {
    Node node = new Node(data);
    nodeMap.put(data, node);
  }

  void union(int x, int y) {
    Node xNode = nodeMap.get(x);
    Node yNode = nodeMap.get(y);

   Node xParent = findSet(xNode);
   Node yParent = findSet(yNode);

   if(xParent == yParent) return;

   if(xParent.rank > yParent.rank) {
     yParent.parent = xParent;
   } else if(xParent.rank < yParent.rank) {
     xParent.parent = yParent;
   }else  {
     xParent.rank += 1;
     yParent.parent = xParent;
   }

  }

  int findSet(int data) {
    return findSet(nodeMap.get(data)).data;
  }

  Node findSet(Node node) {
    Node parent = node.parent;
    if (parent == node) {
      return node;
    }

    node.parent = findSet(node.parent);
    return node.parent;
  }

}
