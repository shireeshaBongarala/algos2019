package practice.dojo.arrays;

public class MaximumSubArray {

  public static void main(String[] args) {

    MaximumSubArray maximumSubArray = new MaximumSubArray();
    System.out.println(maximumSubArray.maxSubArray(new int[]{-1}));
  }


  public int maxSubArray(int[] nums) {
    int left = 0, right = 0;
    int maxSum = Integer.MIN_VALUE;

    int runningSum = 0;
    while (left <= right && right < nums.length) {
      runningSum += nums[right];
      if (runningSum > maxSum) {
        maxSum = runningSum;
      }
      while (runningSum <= 0 && left < nums.length && left <= right) {
        runningSum -= nums[left];
        left++;
      }
      if (left > right) {
        right = left;
      } else
      right++;
    }

    return maxSum;
  }
}
