package practice.dojo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;


class NMaxPairCombinations {

  ArrayList<Integer> findMaxNElementSums(ArrayList<Integer> A, ArrayList<Integer> B) {
    A.sort(Comparator.reverseOrder());
    B.sort(Comparator.reverseOrder());

    PriorityQueue<Tuple> heap = new PriorityQueue<>(Comparator.comparingInt(Tuple::getVal).reversed());
    heap.add(new Tuple(A.get(0) + B.get(0), 0, 0));

    ArrayList<Integer> solution = new ArrayList<>();
    int i = A.size() - 1;
    while (i >= 0) {
      Tuple current = heap.poll();
      if (current != null) {
        solution.add(current.val);
        int a_index = current.a_index;
        int b_index = current.b_index;
        if (b_index < A.size() - 1) {
          int val = A.get(a_index) + B.get(b_index + 1);
          final Tuple e = new Tuple(val, a_index, b_index + 1);
          if (!heap.contains(e)) {
            heap.add(e);
          }
        }

        if (a_index < A.size() - 1) {
          int val = A.get(a_index + 1) + B.get(b_index);
          final Tuple e = new Tuple(val, a_index + 1, b_index);
          if (!heap.contains(e)) {
            heap.add(e);
          }
        }
      }
      i--;
    }


    return solution;

  }


  private class Tuple {
    int val;
    int a_index;
    int b_index;

    Tuple(int val, int a_index, int b_index) {
      this.val = val;
      this.a_index = a_index;
      this.b_index = b_index;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Tuple tuple = (Tuple) o;
      return a_index == tuple.a_index &&
          b_index == tuple.b_index;
    }

    @Override
    public int hashCode() {
      return Objects.hash(a_index, b_index);
    }

    int getVal() {
      return val;
    }
  }
}
