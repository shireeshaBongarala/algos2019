package practice.dojo.trees;


import java.util.stream.IntStream;

/*
https://www.geeksforgeeks.org/segment-tree-efficient-implementation/
* */
public class SegmentTreeGfG {

  private int[] segTree;
  private int len;

  public SegmentTreeGfG(int[] inputArray) {
    this.len = inputArray.length;
    this.segTree = fillValues(inputArray);
  }

  private int[] fillValues(int[] inp) {
    segTree = new int[2 * len];

    IntStream.range(0, len).boxed().forEach(i -> segTree[len + i] = inp[i]);

    for (int i = len - 1; i >= 0; i--) {
      segTree[i] = segTree[i << 1] + segTree[i << 1 | 1];
    }
    return segTree;
  }

  public void updateAt(int index, int value) {
    segTree[index + len] = value;

    for (int i = index + len; i > 1; i >>= 1) {
      segTree[i >> 1] = segTree[i] + segTree[i ^ 1]; // TODO: Understand why XOR is used
    }
  }

  public int range(int l, int r) {
    int res = 0;

    for (l += len, r += len; l < r;
         l >>= 1, r >>= 1) {
      if ((l & 1) > 0) {
        res += segTree[l++];
      }

      if ((r & 1) > 0) {
        res += segTree[--r];
      }
    }

    return res;
  }

}
