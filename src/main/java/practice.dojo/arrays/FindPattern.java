package practice.dojo.arrays;


/* Find smallest repeating pattern in the given string */
/* Does not work! */
public class FindPattern {

  public static void main(String[] args) {
    System.out.println(findPattern("ABABAB"));
  }

  static int findPattern(String input) {

    if (input.isEmpty()) {
      return -1;
    }
    if (isOdd(input)) {
      return -1;
    }
    int size = input.length();
    String firstSubArray = input.substring(0, size / 2);
    String secondHalf = input.substring(size / 2, size);

    if (firstSubArray.equals(secondHalf)) {
      int smallerPattern = findPattern(firstSubArray);
      if(smallerPattern == -1) return firstSubArray.length();
      else return smallerPattern;
    } else {
      return -1;
    }

  }

  static private boolean isOdd(String input) {
    return input.length() % 2 != 0;
  }
}
