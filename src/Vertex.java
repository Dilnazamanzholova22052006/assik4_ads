import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


    class Vertex<T> {
        private T value;
        private List<Edge<T>> edges;

        public Vertex(T value) {
            this.value = value;
            this.edges = new ArrayList<>();
        }

        public T getValue() {
            return value;
        }

        public List<Edge<T>> getEdges() {
            return edges;
        }

        public void addEdge(Edge<T> edge) {
            edges.add(edge);
        }
    }


