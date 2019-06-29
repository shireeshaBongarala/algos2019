package practice.dojo.bruteforce;

public class LHS {

  public int findLHS(int[] nums) {
    int max = 0;
    int current = 0;
    for(int i = 0; i< nums.length; i++) {
      for(int j=i; j < nums.length; j++) {
        if(nums[i] == nums[j] || (nums[i] == nums[j] + 1)) {
          current++;
        }
      }
      if(current > max) max = current;
      current = 0;

      for(int j=i; j < nums.length; j++) {
        if(nums[i] == nums[j] || (nums[i] == nums[j] - 1)) {
          current++;
        }
      }
      if(current > max) max = current;
      current = 0;
    }

    return max;
  }

  public static void main(String[] args) {
    LHS lhs = new LHS();
    System.out.println(lhs.findLHS(new int[] {1,1,1,1}));

  }
}
