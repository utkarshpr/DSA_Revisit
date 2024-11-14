package Graph.DFS_BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class topoSort {
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

        int[] ans =  topoSortn(V, adj);
        for (int node : ans) {
            System.out.print(node + " ");
        }
        System.out.println("");
    }

    public static int[] topoSortn(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[]=new boolean[v];
       Stack<Integer> st=new Stack<>();
       for(int i=0;i<v;i++) {

        if(!visited[i])
           dfs_(i, st, visited, adj);
       }
        int ans[] = new int[v];
        int i = 0;
        while (!st.isEmpty()){
            ans[i++]=st.pop();
        }
        return ans;



    }

    public static void dfs_(int i, Stack<Integer> st, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[i]=true;
        for(int x: adj.get(i)){
            if(!visited[x])
                dfs_(x,st,visited,adj);
        }
        st.push(i);
    }
}
