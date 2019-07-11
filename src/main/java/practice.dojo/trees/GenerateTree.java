package practice.dojo.trees;

public class GenerateTree {


  public static void main(String[] args) {
    int[] nums = new int[] {1,2,3,4 ,5};
    int n = nums.length;
    int tree[] = new int[2*n];
    for(int i = 0; i < n; i++) {
      tree[n+i] = nums[i];
    }

    for(int i = n-1; i > 0; i--) {
      tree[i] = tree[2*i] + tree[2*i + 1];
    }

    for (int i : tree) {
      System.out.println(i);
    }
  }
}
