package ShortestPath;
import java.util.*;
public class ShortestPathIOnUndirectedGraph {
    public static void main(String[] args) {

        int n=9, m=10;
        int[][] edge = {{0,1},{0,3},{3,4},{4,5},{5,6},{1,2},{2,6},{6,7},{7,8},{6,8}};

        int res[] = objshortestPath(edge,n,m,2);
        for(int i=0;i<n;i++){
            System.out.print(res[i]+" ");
        }
        System.out.println();
    }

    private static int[] objshortestPath(int[][] edge, int n, int m, int src) {
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            adj.get(edge[i][0]).add(edge[i][1]);
            adj.get(edge[i][1]).add(edge[i][0]);
        }
        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            Integer temp=q.poll();
            for(Integer it : adj.get(temp)){
                if(dist[temp]+1<dist[it]){
                    dist[it]=1+dist[temp];
                    q.add(it);
                }
            }
        }
        for(int i = 0;i<n;i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }
        return dist;
    }
}
