package Graph.DFS_BFS_Topo;
import java.util.*;

class BFS{
    public static void main(String[] args) {
        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);


       // ArrayList < Integer > ans = bfsOfGraph(5, adj);
        ArrayList < Integer > ans = dfsOfGraph(5, adj);
        int n = ans.size();
        for(int i = 0;i<n;i++) {
            System.out.print(ans.get(i)+" ");
        }

    }
    // Function to return Breadth First Traversal of given graph.
    public static ArrayList<Integer> bfsOfGraph(int V,
                                         ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q=new LinkedList<>();
        boolean visited[]=new boolean[V+1];
        ArrayList<Integer> bfs=new ArrayList<Integer>();
        q.add(0);
        visited[0]=true;
        while(!q.isEmpty()) {
            Integer node =q.poll();
            bfs.add(node);
            for (Integer it : adj.get(node)) {
                if (!visited[it]) {
                    visited[it]=true;
                    q.add(it);
                }
            }

        }
        return  bfs;
    }

    // Function to return a list containing the DFS traversal of the graph.
    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[]=new boolean[V+1];
        //visited[0]=true;
        ArrayList<Integer> ls = new ArrayList<>();
        dfs(0,visited,adj,ls);
        return ls;

    }
    public static void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj,
                           ArrayList<Integer> ls) {
        vis[node]=true;
        ls.add(node);
        for(Integer it :adj.get(node)){
            if (!vis[it]){
                dfs(it,vis,adj,ls);
            }
        }

    }
}