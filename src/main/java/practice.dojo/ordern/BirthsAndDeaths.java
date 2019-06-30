package practice.dojo.ordern;

import java.util.Map;
import java.util.TreeMap;

public class BirthsAndDeaths {

  static int getMaxPopulousYear(int[][] birthAndDeath) {
    int runningCount = 0;
    int maxCount = 0;
    Map<Integer, Integer> freqCounter = new TreeMap<>();
    for (int[] ints : birthAndDeath) {
      int birthYear = ints[0];
      int deathYear = ints[1];

      int existingBirthValue = freqCounter.getOrDefault(birthYear, 0);
      freqCounter.put(birthYear, existingBirthValue + 1);

      int existingDeathValue = freqCounter.getOrDefault(deathYear, 0);
      freqCounter.put(deathYear, existingDeathValue - 1);
    }

    for (Map.Entry<Integer, Integer> yearFreq : freqCounter.entrySet()) {
      runningCount+= yearFreq.getValue();
      if(runningCount > maxCount) maxCount = runningCount;
    }

    return maxCount;
  }

  public static void main(String[] args) {
    BirthsAndDeaths birthsAndDeaths = new BirthsAndDeaths();
    int[][] birthAndDeath = new int[4][2];
    birthAndDeath[0][0] = 1810;
    birthAndDeath[0][1] = 1840;
    birthAndDeath[1][0] = 1821;
    birthAndDeath[1][1] = 1831;
    birthAndDeath[2][0] = 1871;
    birthAndDeath[2][1] = 1888;
    birthAndDeath[3][0] = 1876;
    birthAndDeath[3][1] = 1891;

    System.out.println(getMaxPopulousYear(birthAndDeath));

  }
}
