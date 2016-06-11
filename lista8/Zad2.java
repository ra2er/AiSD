import java.util.*;

public class Zad2 {
  public static void main(String[] args) {
    Vertex v1 = new Vertex(1);
    Vertex v2 = new Vertex(2);
    Vertex v3 = new Vertex(3);
    Vertex v4 = new Vertex(4);
    Vertex v5 = new Vertex(5);

    Edge e1 = new Edge(v1, v2, 1);
    Edge e2 = new Edge(v1, v3, 5);
    Edge e3 = new Edge(v2, v4, 9);
    Edge e4 = new Edge(v4, v5, 7);
    Edge e5 = new Edge(v3, v5, 2);
    Edge e6 = new Edge(v5, v1, 3);

    System.out.println("Graf nieskierowany");
    Graph g = new Graph(new Vertex[]{v1, v2, v3, v4, v5}, new Edge[]{e1, e2, e3, e4, e5, e6});
    System.out.println("Macierz sąsiedztwa");
    int[][] m = g.asAdjacencyMatrix();
    for (int i=0; i<5; i++) {
      for (int k=0; k<5; k++) {
        System.out.print(String.format("%d ", m[i][k]));
      }
      System.out.print("\n");
    }

    System.out.println("Lista sąsiedztwa");
    LinkedList<Vertex>[] array = g.asAdjacencyList();
    for (LinkedList l: array) {
      ListIterator<Vertex> iter = l.listIterator();
      while(iter.hasNext()) {
        System.out.print(String.format("%d -> ", iter.next().number));
      }
      System.out.print("\\\n");
    }
    System.out.println("Macierz incydencji");
    m = g.asIncidenceMatrix();
    for (int i=0; i<6; i++) {
      for (int k=0; k<5; k++) {
        System.out.print(String.format("%d ", m[i][k]));
      }
      System.out.print("\n");
    }

    System.out.println("Graf skierowany");
    DirectedGraph dg = new DirectedGraph(new Vertex[]{v1, v2, v3, v4, v5}, new Edge[]{e1, e2, e3, e4, e5, e6});
    System.out.println("Macierz sąsiedztwa");
    m = dg.asAdjacencyMatrix();
    for (int i=0; i<5; i++) {
      for (int k=0; k<5; k++) {
        System.out.print(String.format("%d ", m[i][k]));
      }
      System.out.print("\n");
    }
    System.out.println("Lista sąsiedztwa");
    array = dg.asAdjacencyList();
    for (LinkedList l: array) {
      ListIterator<Vertex> iter = l.listIterator();
      while(iter.hasNext()) {
        System.out.print(String.format("%d -> ", iter.next().number));
      }
      System.out.print("\\\n");
    }
    System.out.println("Macierz incydencji");
    m = dg.asIncidenceMatrix();
    for (int i=0; i<6; i++) {
      for (int k=0; k<5; k++) {
        System.out.print(String.format("%d ", m[i][k]));
      }
      System.out.print("\n");
    }
  }
}
