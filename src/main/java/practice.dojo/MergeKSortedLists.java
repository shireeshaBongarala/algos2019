package practice.dojo;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import lombok.Getter;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * public int val;
 * public ListNode next;
 * ListNode(int x) { val = x; next = null; }
 * }
 */
public class MergeKSortedLists {

  static class ListNode {
    @Getter
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public ListNode mergeKLists(ArrayList<ListNode> a) {
    ListNode head = null;
    ListNode tail = null;
    PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

    for (ListNode listNode : a) {
      if (listNode != null) {
        queue.add(listNode);
      }
    }

    while(!queue.isEmpty()) {
      ListNode currentMinNode = queue.poll();
      if(tail == null) {
        head = currentMinNode;
        tail = currentMinNode;
      } else {
        tail.next = currentMinNode;
        tail = currentMinNode;
      }
      if(currentMinNode.next != null) {
        queue.add(currentMinNode.next);
      }
    }

    return head;
  }

}
