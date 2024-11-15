package Graph.DFS_BFS_Topo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class khan_TOPOSORT {
    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        int[] ans = StopoSort(V, adj);
        for (int node : ans) {
            System.out.print(node + " ");
        }
        System.out.println("");
    }

    private static int[] StopoSort(int v, ArrayList<ArrayList<Integer>> adj) {
        int ind[]=new int[v];
        for(int i=0;i<v;i++){
            for(int it:adj.get(i)){
                ind[it]++;
            }
        }
        Stack<Integer> st=new Stack<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<v;i++)
        {
            if (ind[i]==0)
                q.add(i);
        }
        int top[]=new int[v];
        int x=0;
        while (!q.isEmpty()){
            int node = q.peek();
            q.remove();

            top[x++]=node;
            for (int it : adj.get(node)) {
                ind[it]--;
                if (ind[it] == 0)
                    q.add(it);

            }
        }
    return top;
    }
}
