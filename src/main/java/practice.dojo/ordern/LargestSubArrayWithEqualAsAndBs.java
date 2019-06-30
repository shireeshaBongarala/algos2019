package practice.dojo.ordern;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Value;

public class LargestSubArrayWithEqualAsAndBs {

  public static void main(String[] args) {
    LargestSubArrayWithEqualAsAndBs asAndBs = new LargestSubArrayWithEqualAsAndBs();
    SubArray array = asAndBs.getLargestSubArrayWithEqual("BA");
    System.out.println(array.getStart() + " " + array.getEnd());
  }

  @Value
  class SubArray {
    int start;
    int end;
  }

  @Value
  class Table {
    int aCount;
    int bCount;

    @Getter
    public int difference;
  }

  SubArray getLargestSubArrayWithEqual(String input) {
    char[] inputArray = input.toCharArray();
    final int length = inputArray.length;
    Table[] tables = new Table[length];
    int aCount = 0, bCount = 0;
    for (int i = 0; i < length; i++) {
      if (inputArray[i] == 'A') {
        aCount++;
      } else {
        bCount++;
      }

      tables[i] = new Table(aCount, bCount, aCount - bCount);
    }

    Map<Integer, Integer> firstOccurence = new HashMap<>();
    firstOccurence.put(0, -1); //Super important line
    SubArray maxSubArray = new SubArray(-1, -1);
    int maxDiff = 0;
    for (int i = 0; i < tables.length; i++) {
      if (firstOccurence.containsKey(tables[i].getDifference())) {
        int firstValue = firstOccurence.get(tables[i].getDifference());
        int currentSubArray = i - firstValue;
        if (currentSubArray >= maxDiff) {
          maxDiff = currentSubArray;
          maxSubArray = new SubArray(firstValue + 1, i);
        }

      } else {
        firstOccurence.put(tables[i].getDifference(), i);
      }
    }


    return maxSubArray;
  }
}
