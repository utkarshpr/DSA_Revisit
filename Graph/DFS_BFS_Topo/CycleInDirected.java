package Graph.DFS_BFS_Topo;

import java.util.ArrayList;

public class CycleInDirected {
    public static void main(String[] args) {
        int V = 11;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(7);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(7).add(5);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);

        //Solution obj = new Solution();
        boolean ans = isCyclic(V, adj);
        if (ans)
            System.out.println("True");
        else
            System.out.println("False");

    }

    private static boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[]=new boolean[v];
        boolean pathVisited[]=new boolean[v];
        for(int i = 0;i<v;i++) {
            if (!visited[i]) {
                if (dfsCheck(i, adj, visited, pathVisited) == true) return true;
            }
        }
        return false;
    }

    private static boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adj,
                                    boolean[] visited, boolean[] pathVisited) {
        visited[node]=true;
        pathVisited[node]=true;
        for(int it : adj.get(node)) {
            // when the node is not visited
            if(!visited[it]) {
                if(dfsCheck(it, adj, visited, pathVisited))
                    return true;
            }
            // if the node has been previously visited
            // but it has to be visited on the same path
            else if(pathVisited[it]) {
                return true;
            }
        }
        pathVisited[node]=false;
        return false;
    }
}
