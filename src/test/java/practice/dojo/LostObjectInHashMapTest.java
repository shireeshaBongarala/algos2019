package practice.dojo;

import java.util.HashSet;
import java.util.Objects;


import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

class LostObjectInHashMapTest {

  class MyKey {
    int val1;
    int val2;

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      MyKey myKey = (MyKey) o;
      return val1 == myKey.val1 &&
          val2 == myKey.val2;
    }

    @Override
    public int hashCode() {
      return Objects.hash(val1, val2);
    }
  }


  @Test
  void should() {
    HashSet<MyKey> keys = new HashSet<>();
    MyKey oneOnlyKey = new MyKey();
    oneOnlyKey.val1 = 12;
    oneOnlyKey.val2 = 23;

    keys.add(oneOnlyKey);
    assertThat(keys.contains(oneOnlyKey)).isTrue();
    oneOnlyKey.val2 = 24;
    assertThat(keys.contains(oneOnlyKey)).isFalse();

  }
}