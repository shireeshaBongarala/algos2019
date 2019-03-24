package practice.dojo.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

class SortHeights {
  List<Integer> sortByHeights(int[] heights, int[] inFronts) {
    TreeMap<Integer, Integer> mapOfHeights = new TreeMap<>();

    for (int i =0; i < heights.length; i++) {
      mapOfHeights.put(heights[i], inFronts[i]);
    }

    List<Integer> sortedHeights = new LinkedList<>();
    while (!mapOfHeights.isEmpty()) {
      int height = mapOfHeights.lastKey();
      int inFront = mapOfHeights.get(height);
      mapOfHeights.remove(height);
      if(sortedHeights.isEmpty()) {
        sortedHeights.add(height);
      } else {
        sortedHeights.add(inFront, height);
      }
    }
    return sortedHeights;
  }
}
