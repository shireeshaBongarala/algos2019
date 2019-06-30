package practice.dojo;

public class ShuffleMe {
  static int randNumber(int lower, int higher) {
    return lower + (int) (Math.random() * (higher - lower + 1));
  }

  static int[] shuffleArray(int[] array) {
    for (int i = array.length - 1; i >= 0; i--) {
      int randPos = randNumber(0, i);
      int temp = array[randPos];
      array[randPos] = array[i];
      array[i] = temp;
    }

    return array;
  }

  public static void main(String[] args) {
    int[] array = new int[10];

    for (int i = 0; i < array.length; i++) {
      array[i] = i;
    }
    int[] shuffled = shuffleArray(array);
    for (int i : shuffled) {
      System.out.println(i);
    }
  }
}
