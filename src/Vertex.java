import java.util.Map;

public class Vertex<V>{
    private V data;
    private Map<Vertex<V>, Double> adjacentVertices; // with weights

    public Vertex(V data) {
        this.data = data;
        this.adjacentVertices = new HashMap<>();
    }

    public void addAdjacentVertex(Vertex<V> destination, double weight) {
        adjacentVertices.put(destination, weight);
    }

    // Getters and setters
    public V getData() { return data; }
    public Map<Vertex<V>, Double> getAdjacentVertices() { return adjacentVertices; }
}
