package practice.dojo.graphs;

import java.util.Arrays;

public class UnionFind {

  private int[] ancestors;

  public UnionFind(int size) {
    int size1 = size;
    this.ancestors = new int[size];
    for (int i = 0; i < ancestors.length; i++) {
      ancestors[i] = i;
    }
  }

  public void union(int a, int b) {
    int minAncestor = Math.min(ancestors[a], ancestors[b]);
    int maxAncestor = Math.max(ancestors[a], ancestors[b]);

    for (int i = 0; i < ancestors.length; i++) {
      if (ancestors[i] == maxAncestor) {
        ancestors[i] = minAncestor;
      }
    }
  }

  public boolean find(int a, int b) {
    return ancestors[a] == ancestors[b];
  }

  public long getConnectedComponents() {
    return Arrays.stream(ancestors).distinct().count();
  }
}
