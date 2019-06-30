package practice.dojo.tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class WordLadder {

  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    List<List<String>> solution = new ArrayList<>();

    Map<String, GraphNode> graph = new HashMap<>();
    for (String word : wordList) {
      graph.put(word, new GraphNode(word, Integer.MAX_VALUE,
          getAdjList(word, wordList)));
    }

    if (!graph.containsKey(endWord)) {
      return solution;
    }

    graph.put(beginWord, new GraphNode(beginWord, 0,
        getAdjList(beginWord, wordList)));

    Queue<GraphNode> queue = new LinkedList<>();
    queue.add(graph.get(beginWord));

    Set<String> used = new HashSet<>();

    while (!queue.isEmpty()) {
      GraphNode currNode = queue.poll();

      if (currNode.word.equals(endWord)) {
        break;
      }

      used.add(currNode.word);

      for (String adjWord : currNode.adjList) {
        if (used.contains(adjWord)) {
          continue;
        }

        GraphNode adjNode = graph.get(adjWord);

        int newDis = currNode.dis + 1;

        if (adjNode.dis > newDis) {
          adjNode.parent.add(currNode);
          adjNode.dis = currNode.dis + 1;

          queue.add(adjNode);
        } else if (adjNode.dis == newDis) {
          adjNode.parent.add(currNode);
        }
      }
    }

    GraphNode endNode = graph.get(endWord);

    if (!endNode.parent.isEmpty()) {
      int len = endNode.dis + 1;
      dfs(endNode, len - 1, new String[len], solution);
    }

    return solution;
  }

  private void dfs(GraphNode node, int i, String[] list, List<List<String>> solution) {
    list[i] = node.word;

    if (i == 0) {
      solution.add(Arrays.stream(list)
          .collect(Collectors.toList()));

      return;
    }

    for (GraphNode adj : node.parent) {
      dfs(adj, i - 1, list, solution);
    }
  }

  private List<String> getAdjList(String word, List<String> wordList) {
    List<String> adjList = new ArrayList<>();

    for (String adjWord : wordList) {
      int i = 0, diff = 0;

      while (i < word.length() && diff <= 1) {
        if (word.charAt(i) != adjWord.charAt(i)) {
          ++diff;
        }

        i++;
      }

      if (diff == 1) {
        adjList.add(adjWord);
      }
    }

    return adjList;
  }

  private static class GraphNode {
    String word;
    int dis;
    List<GraphNode> parent = new ArrayList<>();
    List<String> adjList;

    GraphNode(String word, int dis, List<String> adjList) {
      this.word = word;
      this.dis = dis;
      this.adjList = adjList;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      GraphNode graphNode = (GraphNode) o;
      return Objects.equals(word, graphNode.word);
    }

    @Override
    public int hashCode() {
      return Objects.hash(word);
    }
  }
}
