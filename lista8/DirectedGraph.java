import java.util.*;

public class DirectedGraph {

  Vertex[] vertexes;
  Edge[] edges;

  public DirectedGraph(Vertex[] vertexes, Edge[] edges) {
    this.vertexes = vertexes;
    this.edges = edges;
  }

  public int[][] asAdjacencyMatrix() {
    int[][] matrix = new int[this.vertexes.length][this.vertexes.length];
    for (int i=0; i<this.vertexes.length; i++) {
      for (int k=0; k<this.vertexes.length; k++) {
        for (Edge e: this.edges) {
          if ((e.v1.number == this.vertexes[i].number || e.v1.number == this.vertexes[k].number)
              && (e.v2.number == this.vertexes[i].number || e.v2.number == this.vertexes[k].number)) {
            if (e.v1.number == this.vertexes[i].number) {
              matrix[i][k] = 1;
            } else {
              matrix[i][k] = -1;
            }
          } else {
            if (matrix[i][k] != 0) {
              continue;
            }
            matrix[i][k] = 0;
          }
        }
      }
    }
    return matrix;
  }

  public LinkedList<Vertex>[] asAdjacencyList() {
    LinkedList<Vertex>[] array = new LinkedList[this.vertexes.length];
    int i = 0;
    for (Vertex v: this.vertexes) {
      LinkedList<Vertex> l = new LinkedList<Vertex>();
      array[i] = l;
      l.add(v);
      i++;
      for (Edge e: this.edges) {
        if (e.v1.number == v.number) {
          l.add(e.v2);
        }
      }
    }
    return array;
  }

  public int[][] asIncidenceMatrix() {
    int[][] matrix = new int[this.edges.length][this.vertexes.length];
    for (int i=0; i<this.edges.length; i++) {
      for (int k=0; k<this.vertexes.length; k++) {
        if (this.edges[i].v1.number == this.vertexes[k].number) {
          matrix[i][k] = 1;
        } else if(this.edges[i].v2.number == this.vertexes[k].number) {
          matrix[i][k] = -1;
        }
        else {
          matrix[i][k] = 0;
        }
      }
    }
    return matrix;
  }
}
