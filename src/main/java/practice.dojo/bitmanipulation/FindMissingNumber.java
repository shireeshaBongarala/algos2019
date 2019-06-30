package practice.dojo.bitmanipulation;

public class FindMissingNumber {

  int findMissingNumber(int[] array) {
    //Size of the total array is one more than the given array.
    int sizeOfTheArray = array.length;

    int missingNumber = 0;

    int countZeros = 0;
    final int position = 0;
    for (int i = 0; i < array.length; i++) {
      countZeros += findBitAtAPosition(array[i], position) == 1 ? 0 : 1;
    }

    int countOnes = 0;
    for (int i = 0; i < array.length; i++) {
      countOnes += findBitAtAPosition(array[i], position);
    }

    if (isSizeEven(sizeOfTheArray)) {
      if (countZeros == countOnes) {
        missingNumber <<= 0;
      } else {
        missingNumber <<= 1;
      }
    } else {
      if (countOnes == countZeros) {
        missingNumber <<= 1;
      } else {
        missingNumber <<= 0;
      }
    }
    return 0;
  }

  private boolean isSizeEven(int sizeOfTheArray) {
    return sizeOfTheArray % 2 == 0;
  }


  int findBitAtAPosition(int num, int position) {
    return (num >> (position - 1)) & 1;
  }

}
