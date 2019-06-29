package practice.dojo.datastructures.intervaltree;

public class Interval implements Comparable<Interval> {
  private final int start;
  private final int end;

  public Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }

  public int getStart() {
    return start;
  }

  public int getEnd() {
    return end;
  }

  @Override
  public int compareTo(Interval other) {
    if (getStart() < other.getStart()) {
      return -1;
    }
    if (getStart() > other.getStart()) {
      return 1;
    }
    return Integer.compare(getEnd(), other.getEnd());
  }
}
