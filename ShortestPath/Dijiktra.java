package ShortestPath;

import java.util.*;

public class Dijiktra {
    public static void main(String[] args) {
        int V = 5;

        // Initialize adjacency list
        ArrayList<ArrayList<iPair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges (u, v, w) -> u connects to v with weight w
        adj.get(0).add(new iPair(1, 2));
        adj.get(0).add(new iPair(4, 1));
        adj.get(1).add(new iPair(2, 3));
        adj.get(2).add(new iPair(3, 6));
        adj.get(4).add(new iPair(1, 2));
        adj.get(4).add(new iPair(3, 4));
        int src=0;
        ArrayList<Integer> distances = dijkstra(adj, src);

        // Print shortest distances from source
        System.out.println("Shortest distances from vertex " + src + ":");
        for (int i = 0; i < distances.size(); i++) {
            System.out.println("Vertex " + i + " -> " + distances.get(i));
        }

    }
    public  static  ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        int V = adj.size();

        PriorityQueue<iPair> pq=new PriorityQueue<>((a, b) -> a.second - b.second);

        ArrayList<Integer> dist = new ArrayList<>();

        for(int i=0;i<V;i++) dist.add(Integer.MAX_VALUE);

        dist.set(src,0);

        for (int i = 0; i < adj.size(); i++) {
      //      if (i == src)
                pq.add(new iPair(src, 0));
//            else
//                pq.add(new iPair(i, Integer.MAX_VALUE));
        }

        while(!pq.isEmpty()){
            iPair node=pq.poll();
            int u=node.first;
            int w=node.second;
            for(iPair it : adj.get(u)){
                int v=it.first;
                int wt=it.second;
                if(dist.get(v)>w+wt){
                    dist.set(v, w + wt);
                    pq.add(new iPair(v, dist.get(v)));
                }
            }
        }
        return dist;


    }


}
class iPair {
    int first, second;

    iPair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
