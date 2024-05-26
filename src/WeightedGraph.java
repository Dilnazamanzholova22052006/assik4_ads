import java.util.HashMap;
import java.util.Map;

class WeightedGraph<T> {
    Map<T, Vertex<T>> vertices;
    private boolean directed;

    public WeightedGraph(boolean directed) {
        this.vertices = new HashMap<>();
        this.directed = directed;
    }

    public void addEdge(T from, T to, double weight) {
        Vertex<T> fromVertex = vertices.computeIfAbsent(from, Vertex::new);
        Vertex<T> toVertex = vertices.computeIfAbsent(to, Vertex::new);
        fromVertex.addEdge(new Edge<>(fromVertex, toVertex, weight));
        if (!directed) {
            toVertex.addEdge(new Edge<>(toVertex, fromVertex, weight));
        }
    }

    public Vertex<T> getVertex(T value) {
        return vertices.get(value);
    }
}