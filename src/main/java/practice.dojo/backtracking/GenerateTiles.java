package practice.dojo.backtracking;


public class GenerateTiles {
  private static int count = 0;

  public static void main(String[] args) {
    GenerateTiles gn = new GenerateTiles();
    int[] freq = new int[26];

    StringBuilder stringBuilder = new StringBuilder();
    for (Character c : "ABDCE".toCharArray()) {
      freq[c - 'A'] += 1;
    }
    System.out.println(gn.generateTiles(freq));
  }

  int generateTiles(int[] table) {
    for (int i = 0; i < table.length; i++) {
      if (table[i] > 0) {
        table[i]--;
        generateTiles(table);
        table[i]++;
        printThe(table);
        count++;
      }
    }
    return count;
  }

  private void printThe(int[] table) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < table.length; i++) {
      int count = table[i];
      while(count > 0) {
        stringBuilder.append((((char) (i+ 'A'))));
        count--;
      }

    }

    System.out.println(stringBuilder.toString());
  }
}
