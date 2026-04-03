import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class p812 {

  static class Edge {

    int from, to;;

    public Edge(int from, int node) {
      this.from = from;
      this.to = node;
    }

  }

  static class Graph {

    HashMap<Integer, LinkedList<Edge>> adyacentList;
    int size;

    public Graph(int size) {

      this.size = size;
      adyacentList = new HashMap<>();

      for (int i = 1; i <= this.size; i++) {
        adyacentList.put(i, new LinkedList<Edge>());
      }

    }

    public void addEdge(int A, int B) {
      this.adyacentList.get(A).add(new Edge(A, B));
      this.adyacentList.get(B).add(new Edge(B, A));
    }

    public void clear(int to) {
      for (int i = 1; i <= to; i++) {
        this.adyacentList.get(i).clear();
      }
    }

    public int[] getMetadata(int size) {
      LinkedList<Integer> q = new LinkedList<>();
      boolean[] visited = new boolean[size + 1];

      int withoutEdges = 0;
      int totalTrees = 0;
      int totalCicles = 0;

      for (int i = 1; i <= size; i++) {
        if (visited[i])
          continue;

        int totalNodes = 0;
        int totalEdges = 0;
        q.add(i);

        while (!q.isEmpty()) {
          int current = q.pop();
          if (visited[current])
            continue;
          visited[current] = true;

          totalNodes++;

          for (Edge edge : this.adyacentList.get(current)) {
            totalEdges++;
            if (!visited[edge.to]) {
              q.add(edge.to);
            }
          }
        }

        totalEdges /= 2;
        if (totalNodes == 1 && totalEdges == 0)
          withoutEdges++;
        else if (totalEdges == totalNodes - 1)
          totalTrees++;
        else
          totalCicles++;
      }

      return new int[] { withoutEdges, totalTrees, totalCicles };
    }
  }

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    Graph graph = new Graph(100);

    while (s.hasNext()) {
      int nodes = s.nextInt();
      int N = s.nextInt();

      for (int i = 0; i < N; i++) {
        graph.addEdge(s.nextInt(), s.nextInt());
      }

      int[] metadata = graph.getMetadata(nodes);
      System.out.printf("%d %d %d\n", metadata[0], metadata[1], metadata[2]);

      graph.clear(nodes);
    }

    s.close();

  }

}
