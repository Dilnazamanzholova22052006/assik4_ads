public class VertexDistance <T>{
    private Vertex<T> vertex;
    private double distance;

    public VertexDistance(Vertex<T> vertex, double distance) {
        this.vertex = vertex;
        this.distance = distance;
    }

    public Vertex<T> getVertex() {
        return vertex;
    }

    public double getDistance() {
        return distance;
    }
}
