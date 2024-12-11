package ShortestPath;

import java.util.*;

public class NetworkDellayTime {
    public static void main(String[] args) {
        int times[][] = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4, k = 2;
        int x = networkDelayTime(times, n, k);
        System.out.print(x);
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] time : times) {
            adj.get(time[0]).add(new Pair(time[1], time[2]));
        }

        int[] minDis = new int[n + 1];
        Arrays.fill(minDis, Integer.MAX_VALUE);
        minDis[k] = 0;

        //PriorityQueue<Tuple2> pq = new PriorityQueue<>(Comparator.comparingInt(t -> t.distance));
        Queue<Tuple2> pq=new LinkedList<>();
        pq.add(new Tuple2(0, k));

        while (!pq.isEmpty()) {
            Tuple2 t = pq.poll();
            int src = t.row, dis = t.distance;

            if (dis > minDis[src]) continue;

            for (Pair p : adj.get(src)) {
                int adjNode = p.first, distance = p.second;
                if (dis + distance < minDis[adjNode]) {
                    minDis[adjNode] = dis + distance;
                    pq.add(new Tuple2(minDis[adjNode], adjNode));
                }
            }
        }

        int max = Arrays.stream(minDis).skip(1).max().getAsInt();
        return max == Integer.MAX_VALUE ? -1 : max;
    }


}
class Tuple2 {
    int distance, row;

    Tuple2(int distance, int row) {
        this.distance = distance;
        this.row = row;
    }
}