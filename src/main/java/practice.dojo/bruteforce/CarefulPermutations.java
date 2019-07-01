package practice.dojo.bruteforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarefulPermutations {

  public static void main(String[] args) {
    CarefulPermutations carefulPermutations = new CarefulPermutations();
    carefulPermutations.firstValidPermutation(5);
  }


  public class Permutation {
    private int[] array;

    public Permutation(int n) {
      this.array = new int[2*n];
      Arrays.fill(array, 0);
    }

    public Permutation(int[] array) {
      this.array = Arrays.copyOf(array, array.length);
    }

    int findElementAt(int index) {
      return array[index];
    }

    void setElementAt(int index, int value) {
      array[index] = value;
    }

    public void print() {
      for (int i : array) {
        System.out.print(i + " ");
      }
      System.out.println();
    }

    int[] getArray() {
      return array;
    }

  }

  void firstValidPermutation(int n) {
    int[] array = new int[2*n];
    Arrays.fill(array, 0);

    List<Permutation> initialPermutation = findAllValidPermutations(array, n);

    for(int i = n-1; i > 0; i--) {
      initialPermutation = findValidOnes(initialPermutation, i);
    }

    for (Permutation permutation : initialPermutation) {
      permutation.print();
    }

  }

  List<Permutation> findAllValidPermutations(int[] input, int currentIndex) {
    int size = input.length;
    List<Permutation> permutations = new ArrayList<>();
    for (int i = 0; i < (size - currentIndex); i++) {
      if (input[i] == 0 && input[i + currentIndex] == 0) {
        Permutation permutation = new Permutation(input);
        permutation.setElementAt(i, currentIndex);
        permutation.setElementAt(i + currentIndex, currentIndex);
        permutations.add(permutation);
      }
    }
    return permutations;
  }

  List<Permutation> findValidOnes(List<Permutation> inputPermutations, int currentIndex) {
    List<Permutation> permutations = new ArrayList<>();
    for (Permutation permutation : inputPermutations) {
      int[] input = permutation.getArray();
      permutations.addAll(findAllValidPermutations(input, currentIndex));
    }
    return permutations;
  }
}
