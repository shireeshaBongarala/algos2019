package practice.dojo.arrays;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Find K Closest elements
* */
public class KClosest {

  List<Integer> findKClosest(int[] array, int K, int element) {
    int left = 0, right = array.length - K;
    int mid = (right + left) / 2;
    while (left < right) {
      if ((element - array[mid]) > (array[mid + K] - element)) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }

    return Arrays.stream(array, left, left + K).boxed().collect(Collectors.toList());
  }
}
