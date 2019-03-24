package practice.dojo.binarysearch;

import static org.assertj.core.api.Java6Assertions.assertThat;
import org.junit.jupiter.api.Test;

class PaintersPartitionTest {

  private PaintersPartition paintersPartition = new PaintersPartition();


  @Test
  void shouldGiveTheMinTimeRequiredByNPainters1() {
    int[] boards = {5, 2, 5, 2, 5, 2};
    int noOfPainters = 3;

    assertThat(paintersPartition.getMinTimeRequired(boards, noOfPainters)).isEqualTo(7);
  }

  @Test
  void shouldGiveTheMinTimeRequiredByNPainters2() {
    int[] boards = {5, 3, 5, 2, 5, 2};
    int noOfPainters = 3;

    assertThat(paintersPartition.getMinTimeRequired(boards, noOfPainters)).isEqualTo(8);
  }

  @Test
  void shouldGiveTheMinTimeRequiredByNPainters3() {
    int[] boards = {5, 3, 5, 2, 5, 2};
    int noOfPainters = 6;

    assertThat(paintersPartition.getMinTimeRequired(boards, noOfPainters)).isEqualTo(5);
  }

  @Test
  void shouldGiveTheMinTimeRequiredByNPainters4() {
    int[] boards = {5, 3, 5, 2, 5, 2};
    int noOfPainters = 1;

    assertThat(paintersPartition.getMinTimeRequired(boards, noOfPainters)).isEqualTo(22);
  }
}