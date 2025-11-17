import java.util.*;

public class bfs {
    
    private Map<Integer, List<Integer>> graph;
    private Set<Integer> visited;

    public static void main(String[] args) {
        bfs s = new bfs();
        s.addEdge(0, 1);
        s.addEdge(0, 2);
        s.addEdge(1, 3);
        s.addEdge(2, 4);
        s.addEdge(3, 5);
        
        s.BFS(0);
    }
    
    public bfs() {
        this.graph = new HashMap<>();
        this.visited = new HashSet<>();
    }
    
    public void addEdge(int start, int end) {
        graph.computeIfAbsent(start, k -> new ArrayList<>()).add(end);
    }
    
    public void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(start);
        visited.add(start);
        
        while(!queue.isEmpty()) {
            int node = queue.poll();
            
            System.out.println(node);
            
            for(int neigbor : graph.getOrDefoult(node, Collections.emptyList())) {
                if(!visited.contains(neigbor)) {
                    visited.add(neigbor);
                    queue.add(neigbor);
                }
            }
        }
    }
}
