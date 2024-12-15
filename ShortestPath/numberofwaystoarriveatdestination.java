package ShortestPath;

import java.util.*;

public class numberofwaystoarriveatdestination {
    public static void main(String[] args) {
        int n = 7;
        List <List< Integer >> roads = new ArrayList< >() {
            {
                add(new ArrayList<Integer>(Arrays.asList(0, 6, 7)));
                add(new ArrayList<Integer>(Arrays.asList(0, 1, 2)));
                add(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
                add(new ArrayList<Integer>(Arrays.asList(1, 3, 3)));
                add(new ArrayList<Integer>(Arrays.asList(6, 3, 3)));
                add(new ArrayList<Integer>(Arrays.asList(3, 5, 1)));
                add(new ArrayList<Integer>(Arrays.asList(6, 5, 1)));
                add(new ArrayList<Integer>(Arrays.asList(2, 5, 1)));
                add(new ArrayList<Integer>(Arrays.asList(0, 4, 5)));
                add(new ArrayList<Integer>(Arrays.asList(4, 6, 2)));

            }
        };
        //Solution obj = new Solution();
        int ans = countPaths(n, roads);

        System.out.print(ans);
        System.out.println();
    }

    private static int countPaths(int n, List<List<Integer>> roads) {

        ArrayList < ArrayList < Pair >> adj = new ArrayList < > ();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList < > ());
        }
        int m = roads.size();
        for (int i = 0; i < m; i++) {
            adj.get(roads.get(i).get(0)).add(new Pair(roads.get(i).get(1), roads.get(i).get(2)));
            adj.get(roads.get(i).get(1)).add(new Pair(roads.get(i).get(0), roads.get(i).get(2)));
        }
        int dist[]=new int[n];
        int[] ways = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
            ways[i] = 0;
        }
        dist[0]=0;
        ways[0]=1;
        Queue<Pair> pq=new LinkedList<>();
        pq.add(new Pair(0,0));
        int mod = (int)(1e9 + 7);
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int src=p.first;
            int dis=p.second;
            for(Pair np: adj.get(src)){
                int newNode = np.first;
                int newD =np.second;
                if(dis+newD<dist[newNode]){
                    ways[newNode]= ways[src];
                    dist[newNode]=dis+newD;
                    pq.add(new Pair(newNode,dis+newD));
                }
                else if(dis+newD==dist[newNode]){
                    ways[newNode]=(ways[newNode]  + ways[src])%mod;
                    System.out.println("dis"+dis+newD);
                }
            }
        }
        return ways[n - 1] % mod;
    }

}
