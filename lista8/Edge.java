import java.util.*;

public class Edge {
  // reprezentacja krawędzi jako
  // para wierzchołków
  Vertex v1;
  Vertex v2;
  int weight;

  public Edge(Vertex v1, Vertex v2) {
    this.v1 = v1;
    this.v2 = v2;
    Random r = new Random();
    this.weight = r.nextInt(10);
  }

  public Edge(Vertex v1, Vertex v2, int weight) {
    this.v1 = v1;
    this.v2 = v2;
    this.weight = weight;
  }
}
