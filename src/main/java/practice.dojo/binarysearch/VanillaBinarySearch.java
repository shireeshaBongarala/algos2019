package practice.dojo.binarysearch;


public class VanillaBinarySearch {

  public static void main(String[] args) {
  }

  static  int search(int[] array, int element) {
    int position = binarySearch(array, 0, array.length, element);
    return position;
  }

  static private int binarySearch(int[] array, int start, int end, int element) {
    if (start < 0) {
      return -1;
    }
    int mid = (start + end) / 2;
    if (array[mid] == element) {
      return mid;
    } else if (array[mid] > element) {
      return binarySearch(array, start, mid - 1, element);
    } else {
      return binarySearch(array, mid + 1, end, element);
    }
  }
}
