package practice.dojo.trees;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SortHeightsTest {

  private SortHeights sortHeights = new SortHeights();

  @Test
  void shouldSortByHeights() {
    int[] heights = {1, 2, 3, 4, 5, 6};
    int[] inFronts = {2, 2, 2, 1, 1, 0};
    List<Integer> sortedByHeights = sortHeights.sortByHeights(heights, inFronts);
    assertThat(sortedByHeights).containsExactly(6, 4, 1, 2, 3, 5);
  }
}