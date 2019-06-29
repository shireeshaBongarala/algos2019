package practice.dojo;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TwoPointerTest {

  @Test
  void shouldReturnTheResultantList() {
    int[] timestamp = {0, 30, 40, 50, 60, 100};
    int[] duration = {5, 10, 10, 10, 10, 10};
    int[] resultant = {30, 40, 50};
    int size = 20;

    ArrayList<Integer> resultantList = new ArrayList<>();

    for (int i = 0; i < timestamp.length; i++) {
      if (hasDuration(i, timestamp, duration, size)) {
        resultantList.add(timestamp[i]);
      }
    }

    assertEquals(resultantList.size(), 3);
    assertEquals(resultantList.get(0), 30, 0);
    assertEquals(resultantList.get(1), 40, 0);
    assertEquals(resultantList.get(2), 50, 0);
  }

  private boolean hasDuration(int i, int[] timestamp, int[] duration, int size) {
    if (duration[i] == size) {
      return true;
    }

    if(duration[i] > size) {
      return false;
    }

    int currentDuration = duration[i];

    for(int j = i+ 1; j< timestamp.length; j++) {
      if(timestamp[j-1] + duration[j-1] == timestamp[j]) {
        currentDuration += duration[j];
        if(currentDuration > size) return false;
        if(currentDuration == size) return true;
      } else {
        return false;
      }
    }

    return false;
  }

}