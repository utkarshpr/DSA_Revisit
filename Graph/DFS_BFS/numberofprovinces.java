package Graph.DFS_BFS;

import java.util.*;
/*
https://leetcode.com/problems/number-of-provinces/description/
 */
public class numberofprovinces {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 0},  // Room 0 has a key to room 1, but not room 2
                {0, 1, 0},  // Room 1 has a key to room 0, but not room 2
                {0, 0, 1}   // Room 2 is isolated, can only access itself
        };
       int x=  findCircleNum(matrix);
        System.out.println(x);
    }
    public static int findCircleNum(int[][] isConnected) {
        int count=0;
        ArrayList<ArrayList<Integer> > adj = new ArrayList<>();
        for(int i=0;i<isConnected.length;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<isConnected.length;i++)
        {
            for(int j=0;j<isConnected.length;j++)
            {
                if(isConnected[i][j]==1 && i!=j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }


      return   bfsOfGraph(adj,0);

    }
    public static int bfsOfGraph(ArrayList<ArrayList<Integer> > adjList,int node){
        boolean visited[]=new boolean[adjList.size()];
        int c=0;
       // visited[node]=true;
        for(int i=0;i< adjList.size();i++)
        {
            if (!visited[i]){
                dfs(i,adjList,visited);// i not node
                c++;
            }
        }

        return c;
    }

    private static void dfs(int i, ArrayList<ArrayList<Integer>> adj,boolean visited[]) {
        visited[i]=true;

        for(Integer x:adj.get(i)){
            if(visited[x]==false)
            { dfs(x, adj, visited);}
        }
    }

}
