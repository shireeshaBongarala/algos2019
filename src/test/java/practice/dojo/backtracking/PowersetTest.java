package practice.dojo.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class PowersetTest {

  @Test
  void shouldGenerateAllTheSubsets1(){
    Powerset powerset = new Powerset();
    assertThat(powerset.generateFor(new ArrayList<>(Arrays.asList(12, 13))))
        .isEqualTo(new ArrayList<ArrayList<Integer>>(
            Arrays.asList(
                new ArrayList<>(Collections.singletonList(12)),
                new ArrayList<>(Collections.singletonList(13)),
                new ArrayList<>(Arrays.asList(12, 13)),
                new ArrayList<>()
    )));
  }

}