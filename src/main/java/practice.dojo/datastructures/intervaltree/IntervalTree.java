package practice.dojo.datastructures.intervaltree;


import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class IntervalTree {
  private Node root;


  void insert(Interval interval) {
    Node newVal = new Node(interval);
    if(root == null) {
      root = newVal;
      return;
    }




  }

  List<Interval> getAllExistingIntervals() {
    return Collections.emptyList();
  }
}
