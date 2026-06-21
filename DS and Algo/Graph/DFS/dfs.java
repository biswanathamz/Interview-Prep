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

    public static void dfs(int node, boolean[] visited, List<List<Integer>>adj){
        visited[node] = true;

        System.out.println(node);

        for (int neighbour: adj.get(node)){
            if(!visited[neighbour]){
                dfs(neighbour, visited, adj);
            }
        }
    }

    public static void main(String[] args){
        List<List<Integer>> graph = createGraph();

        System.out.println("Graph : ");
        System.out.println(graph);

        boolean[] visited = new boolean[graph.size()];

        dfs(0, visited, graph);
    }
}