package practice.dojo.graphs;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

class UnionFindTest {

  @Test
  void shouldReturnNoOfConnectedComponents() {
    UnionFind unionFind = new UnionFind(10);
    unionFind.union(1, 2);
    unionFind.union(3, 2);
    unionFind.union(4, 5);
    unionFind.union(6, 7);
    unionFind.union(6, 9);
    assertThat(unionFind.find(1,3)).isTrue();
    assertThat(unionFind.getConnectedComponents()).isEqualTo(5);
  }


}