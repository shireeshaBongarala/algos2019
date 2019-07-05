package practice.dojo.trees;

/*
Assumes the array size is fixed.
Update and range queries take O(log n)
* */
public class SegmentTree {

  private int[] array;
  int[] segmentTree;

  public SegmentTree(int[] array) {
    this.array = array;
    constructSegmentTree(array);
  }

  public int range(int start, int end) {
    return 0;
  }

  public void updateAt(int value, int index) {

  }

  private void constructSegmentTree(int[] array) {


    int size = array.length;
    for (int i = size - 1; i >= 0; i--) {
      segmentTree[i] = array[i] + findLeftChild(array, i) + findRightChild(array, i);
    }

  }


  private int findLeftChild(int[] array, int i) {
    int leftIndex = 2 * (i) + 1;
    return leftIndex > array.length - 1 ? 0 : array[leftIndex];
  }

  private int findRightChild(int[] array, int i) {
    int rightIndex = 2 * (i) + 2;
    return rightIndex > array.length - 1 ? 0 : array[rightIndex];
  }


}
