package ShortestPath;

import java.util.*;

public class PrintpathDijiktra {
    public static void main(String[] args) {
        int  n = 5, m= 6;
        int [][]edges = {{1, 2, 2}, {2, 5, 5}, {2, 3, 4}, {1, 4, 1}, {4, 3, 3}, {3, 5, 1}};
        ArrayList<ArrayList<iPair>> adj = new ArrayList<>();
        for (int i = 0; i <=n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            adj.get(edges[i][0]).add(new iPair(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new iPair(edges[i][0],edges[i][2]));

        }
        int des=n;
        List<Integer> ar= dijikitra(des,adj);
        System.out.print(ar);
    }

    private static List<Integer> dijikitra(int des, ArrayList<ArrayList<iPair>> adj) {
        List<Integer> ans=new ArrayList<>();
        PriorityQueue<iPair> pq=new PriorityQueue<>((x,y)-> x.second-y.second);
        int dist[]=new int[adj.size()];
        Arrays.fill(dist,Integer.MAX_VALUE);
        int parent[]=new int[adj.size()];
        for(int i=0;i<adj.size();i++)
            parent[i]=i;
        dist[1]=0;
        pq.add(new iPair(1,0));
        while(!pq.isEmpty()){
            iPair p=pq.poll();
            int u=p.first;
            int w=p.second;
            for(iPair it : adj.get(u)){
                int v= it.first;
                int wt=it.second;
                if(wt+w<dist[v]){
                    dist[v]=wt+w;
                    pq.add(new iPair(v,dist[v]));
                    parent[v]=u;
                }

            }

        }
        if(dist[des]==Integer.MAX_VALUE)
        {
            ans.add(-1);
            return ans;
        }
        int node=des;
        while(parent[node]!=node){
            ans.add(node);
            node=parent[node];
        }
        ans.add(1);
        Collections.reverse(ans);
         return ans;
    }
}
