import java.util.*;

public class DijkstraSearch <T> implements Search<T>{
    private Map<T, T> edgeTo;
    private Map<T, Double> distTo;
    private PriorityQueue<VertexDistance<T>> pq;
    private final T source;

    public DijkstraSearch(WeightedGraph<T> graph, T source) {
        this.source = source;
        edgeTo = new HashMap<>();
        distTo = new HashMap<>();
        pq = new PriorityQueue<>(Comparator.comparingDouble(VertexDistance::getDistance));
        for (T vertex : graph.vertices.keySet()) {
            distTo.put(vertex, Double.POSITIVE_INFINITY);
        }
        distTo.put(source, 0.0);
        pq.add(new VertexDistance<>(graph.getVertex(source), 0.0));
        dijkstra(graph);
    }

    private void dijkstra(WeightedGraph<T> graph) {
        while (!pq.isEmpty()) {
            VertexDistance<T> vd = pq.poll();
            Vertex<T> v = vd.getVertex();
            for (Edge<T> edge : v.getEdges()) {
                relax(edge);
            }
        }
    }

    private void relax(Edge<T> edge) {
        Vertex<T> v = edge.getFrom();
        Vertex<T> w = edge.getTo();
        double weight = edge.getWeight();
        if (distTo.get(w.getValue()) > distTo.get(v.getValue()) + weight) {
            distTo.put(w.getValue(), distTo.get(v.getValue()) + weight);
            edgeTo.put(w.getValue(), v.getValue());
            pq.add(new VertexDistance<>(w, distTo.get(w.getValue())));
        }
    }

    @Override
    public boolean hasPathTo(T v) {
        return distTo.get(v) < Double.POSITIVE_INFINITY;
    }

    @Override
    public Iterable<T> pathTo(T v) {
        if (!hasPathTo(v)) return null;
        LinkedList<T> path = new LinkedList<>();
        for (T x = v; !x.equals(source); x = edgeTo.get(x)) {
            path.addFirst(x);
        }
        path.addFirst(source);
        return path;
    }
}