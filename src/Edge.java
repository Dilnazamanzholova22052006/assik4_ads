public class Edge <T> {
    private Vertex<T> from;
    private Vertex<T> to;
    private double weight;

    public Edge(Vertex<T> from, Vertex<T> to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public Vertex<T> getFrom() {
        return from;
    }

    public Vertex<T> getTo() {
        return to;
    }

    public double getWeight() {
        return weight;
    }
}
