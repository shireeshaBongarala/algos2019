package practice.dojo.datastructures.intervaltree;

public class Node implements Comparable<Node> {
  private Interval interval;
  private Node left;
  private Node right;

  public Node(Interval interval) {
    this.interval = interval;
  }

  void add(Interval interval) {
    Node toAddNode = new Node(interval);

    if(this.equals(toAddNode)) return;

    if(this.compareTo(toAddNode) > 0) {
    }


  }

  public Node getLeft() {
    return left;
  }

  public void setLeft(Node left) {
    this.left = left;
  }

  public Node getRight() {
    return right;
  }

  public void setRight(Node right) {
    this.right = right;
  }

  public Interval getInterval() {
    return interval;
  }

  @Override
  public int compareTo(Node o) {
    return this.getInterval().compareTo(o.getInterval());
  }
}
