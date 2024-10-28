package Graph.DFS_BFS;
import java.util.*;
public class CyclicDetectionBFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);


        boolean ans = isCycle(4, adj);
        if (ans)
            System.out.println("1");
        else
            System.out.println("0");

    }
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj){
        int visited[]=new int[V];
        int parents[]=new int[V];
        Arrays.fill(parents,-1);
        for(int i=0;i<V;i++)
        {
            if(visited[i]==0)
            {
                if (checkForCycle(visited,adj,parents,i))
                    return true;
            }
        }
        return false;
    }

    private static boolean checkForCycle(int[] visited, ArrayList<ArrayList<Integer>> adj, int[] parents,int node) {
        Queue<Pair> q =  new LinkedList<>(); //BFS
        q.add(new Pair(node, -1));
        visited[node]=1;
        while(!q.isEmpty()) {
            Pair p=q.poll();
            int par=p.y;
            int temp=p.x;
            for (Integer it : adj.get(node)) {
                if(visited[it]==0){
                    q.offer(new Pair(it,temp));
                }
                if(it!=par)
                    return true;
            }
        }
        return  false;
    }
}
