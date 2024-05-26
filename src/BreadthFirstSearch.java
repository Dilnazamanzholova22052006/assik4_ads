import java.util.*;

public class BreadthFirstSearch <T> implements Search<T>{
        private Map<T, T> edgeTo;
        private Set<T> marked;
        private final T source;

        public BreadthFirstSearch(WeightedGraph<T> graph, T source) {
            this.source = source;
            edgeTo = new HashMap<>();
            marked = new HashSet<>();
            bfs(graph, source);
        }

        private void bfs(WeightedGraph<T> graph, T source) {
            Queue<T> queue = new LinkedList<>();
            queue.add(source);
            marked.add(source);
            while (!queue.isEmpty()) {
                T v = queue.poll();
                for (Edge<T> edge : graph.getVertex(v).getEdges()) {
                    T w = edge.getTo().getValue();
                    if (!marked.contains(w)) {
                        marked.add(w);
                        edgeTo.put(w, v);
                        queue.add(w);
                    }
                }
            }
        }

        @Override
        public boolean hasPathTo(T v) {
            return marked.contains(v);
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
