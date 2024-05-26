import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public interface Search<V> {
    void search(V start);


    public class BreadthFirstSearch<V> implements Search<V> {
        private WeightedGraph<V> graph;

        public BreadthFirstSearch(WeightedGraph<V> graph) {
            this.graph = graph;
        }

        @Override
        public void search(V start) {
            Set<V> visited = new HashSet<>();
            Queue<Vertex<V>> queue = new LinkedList<>();
            Vertex<V> startVertex = graph.getVertex(start);

            if (startVertex != null) {
                queue.add(startVertex);
                visited.add(start);

                while (!queue.isEmpty()) {
                    Vertex<V> current = queue.poll();
                    System.out.println(current.getData()); // Process the current vertex

                    for (Vertex<V> neighbor : current.getAdjacentVertices().keySet()) {
                        if (!visited.contains(neighbor.getData())) {
                            visited.add(neighbor.getData());
                            queue.add(neighbor);
                        }
                    }
                }
            }
        }
    }
}
