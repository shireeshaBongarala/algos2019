package practice.dojo.combinatorics;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class Developers2Test {
  @Test
  public void shouldReturnAllFrontEndContributionsWhenRequirementIsForFrontEnders() {
    Developers2 developers = new Developers2();
    assertEquals(11, developers.maxContributions(
        new int[] {1, 2, 8},
        new int[] {1,3, 4},
        3
    ));
  }

  @Test
  public void shouldReturnAllBackEndContributionsWhenRequirementIsForBackEnders() {
    Developers2 developers = new Developers2();
    assertEquals(8, developers.maxContributions(
        new int[] {1, 2, 8},
        new int[] {1,3, 4},
        0
    ));
  }

  @Test
  public void shouldMaxContributions() {
    Developers2 developers = new Developers2();
    assertEquals(11, developers.maxContributions(
        new int[] {4, 2, 3},
        new int[] {5, 2, 4},
        1
    ));
  }

  @Test
  public void shouldMaxContributions2() {
    Developers2 developers = new Developers2();
    assertEquals(21, developers.maxContributions(
        new int[] {2, 6, 7},
        new int[] {2, 2, 13},
        1
    ));
  }

  @Test
  public void shouldMaxContributions3() {
    Developers2 developers = new Developers2();
    assertEquals(235, developers.maxContributions(
        new int[] {108, 107, 10, 5},
        new int[] {110, 108, 13, 5},
        2
    ));
  }
}