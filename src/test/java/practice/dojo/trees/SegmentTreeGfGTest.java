package practice.dojo.trees;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class SegmentTreeGfGTest {


  SegmentTreeGfG segmentTreeGfG;

  @Test
  void test1() {
    segmentTreeGfG = new SegmentTreeGfG(new int[] {2, 1, 4, 2, 6, 7, 2});
    System.out.println(segmentTreeGfG.range(0, 7));
    segmentTreeGfG.updateAt(0, 22);
    System.out.println(segmentTreeGfG.range(0, 7));
    System.out.println();
    segmentTreeGfG.range(0, 7);
  }

}