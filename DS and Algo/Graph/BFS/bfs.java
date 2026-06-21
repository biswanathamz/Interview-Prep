import java.util.*;

class main{

    public static List<List<Integer>> createGraph(){
        int vertices = 8;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i=0; i<vertices; i++){
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(0).add(2);

        adj.get(1).add(0);
        adj.get(1).add(3);
        adj.get(1).add(4);

        adj.get(2).add(0);
        adj.get(2).add(5);
        adj.get(2).add(6);

        adj.get(3).add(1);
        adj.get(3).add(7);

        adj.get(4).add(1);

        adj.get(5).add(2);

        adj.get(6).add(2);

        adj.get(7).add(3);

        return adj;
    }

    public static void bfs(int start, List<List<Integer>>adj){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[adj.size()];

        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();

            System.out.println(node+" ");

            for (int neighbour:adj.get(node)){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }
    }

    public static void main(String[] args){
        List<List<Integer>> graph = createGraph();

        System.out.println("Graph : ");
        System.out.println(graph);

        bfs(0, graph);
    }
}