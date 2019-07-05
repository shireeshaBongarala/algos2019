package practice.dojo.arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPoints {

  static class Point {
    int x;
    int y;
    int shortestDistFromOrigin;

    Point(int x, int y) {
      this.x = x;
      this.y = y;
      this.shortestDistFromOrigin = (int) (Math.pow(x, 2) + Math.pow(y, 2));
    }

    int[] toArray() {
      return new int[] {x, y};
    }

    public int getShortestDistFromOrigin() {
      return shortestDistFromOrigin;
    }

    public void setShortestDistFromOrigin(int shortestDistFromOrigin) {
      this.shortestDistFromOrigin = shortestDistFromOrigin;
    }
  }

  public int[][] kClosest(int[][] points, int K) {
    PriorityQueue<Point> queue = new PriorityQueue<>(
        Comparator.comparingInt(Point::getShortestDistFromOrigin));
    for (int i = 0; i < points.length; i++) {
      queue.add(new Point(points[i][0], points[i][1]));
    }

    int[][] result = new int[K][2];
    for (int i = 0; i < K; i++) {
      result[i] = queue.poll().toArray();
    }

    return result;
  }


}
