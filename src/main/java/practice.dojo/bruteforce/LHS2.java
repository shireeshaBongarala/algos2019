package practice.dojo.bruteforce;

import java.util.HashMap;

public class LHS2 {


  public int findLHS(int[] nums) {
    int max = 0;
    HashMap<Integer, Integer> freqCounter = new HashMap();
    for(int i = 0; i < nums.length; i++) {
      if(freqCounter.containsKey(nums[i])) {
        freqCounter.put(nums[i], freqCounter.get(nums[i]) + 1);
      } else {
        freqCounter.put(nums[i], 1);
      }
    }

    for(int i = 0; i< nums.length; i++) {
      if(freqCounter.containsKey(nums[i] + 1)) {
        int current = freqCounter.get(nums[i]) + freqCounter.get(nums[i] +1);
        max = Math.max(max, current);
      }

      if(freqCounter.containsKey(nums[i] -1)) {
        int current = freqCounter.get(nums[i]) + freqCounter.get(nums[i] -1);
        max = Math.max(max, current);
      }
    }
    return max;

  }
  public static void main(String[] args) {
    LHS lhs = new LHS();
    System.out.println(lhs.findLHS(new int[] {1,1,1,1}));

  }
}
