package practice.dojo.trees;

import lombok.Data;

public class InorderMorris {

  @Data
  static class TreeNode {
    int value;
    TreeNode leftNode;
    TreeNode rightNode;
    TreeNode next;
    boolean isVisited;
  }


  // Next points to the inorder successor it's the root for the left node, etc.,?
// Two traversals ?

  private void inorderTraversal(TreeNode root) {
    if (root == null) {
      return;
    }

    while (root.leftNode != null && !root.leftNode.isVisited) {
      root.leftNode.next = root.leftNode;
      root = root.leftNode;
    }

    root.isVisited = true;

    root = root.rightNode;

    while(root.rightNode != null && !root.rightNode.isVisited) {
//      root.rightNode.
    }


//    if (treeNode.leftNode != null) {
//      inorderTraversal(treeNode.leftNode, treeNode);
//    }
//
//
//
////    System.out.println(treeNode);
////    if (treeNode.rightNode != null) {
////      inorderTraversal(treeNode.rightNode);
////    }

  }

}
