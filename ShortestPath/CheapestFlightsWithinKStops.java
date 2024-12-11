package ShortestPath;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightsWithinKStops {
    public static void main(String[] args) {
        int n = 4, src = 0, dst = 3, K = 1;
        int[][] flights={{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int ans = findCheapestPrice(n,flights,src,dst,K);
        System.out.print(ans);
        System.out.println();
    }
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Create the adjacency list to depict airports and flights in
        // the form of a graph.
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int m = flights.length;
        for (int i = 0; i < m; i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        //
        Queue<Flight> q = new LinkedList<>();
        q.add(new Flight(0, src, 0));
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = (int) (1e9);
        }
        dist[src] = 0;
        while (!q.isEmpty()) {
            Flight it = q.peek();
            q.remove();
            int stops = it.stops;
            int node = it.src;
            int cost = it.distance;
            if (stops >k) continue;
            for(Pair its: adj.get(node)){
              int adjNode=its.first;
              int edist=its.second;
              if(cost+edist<dist[adjNode] ){
                  dist[adjNode]=cost+edist;
                  q.add(new Flight(stops+1,adjNode,dist[adjNode]));
              }
            }
        }
        if(dist[dst] == (int)(1e9)) return -1;
        return dist[dst];
    }

}
class Flight{
    int stops;
    int src;
    int distance;

    public  Flight(int stops, int src, int distance) {
        this.stops = stops;
        this.src = src;
        this.distance = distance;
    }
}
