package practice.dojo.combinatorics;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DevelopersTest {

  @Test
  public void shouldReturnAllFrontEndContributionsWhenRequirementIsForFrontEnders() {
    Developers developers = new Developers();
    assertEquals(11, developers.maxContributions(
        new int[] {1, 2, 8},
        new int[] {1,3, 4},
        3
    ));
  }

  @Test
  public void shouldReturnAllBackEndContributionsWhenRequirementIsForBackEnders() {
    Developers developers = new Developers();
    assertEquals(8, developers.maxContributions(
        new int[] {1, 2, 8},
        new int[] {1,3, 4},
        0
    ));
  }

  @Test
  public void shouldMaxContributions() {
    Developers developers = new Developers();
    assertEquals(11, developers.maxContributions(
        new int[] {4, 2, 3},
        new int[] {5, 2, 4},
        1
    ));
  }
}