package ShortestPath;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ShortestDistanceInBinaryMaze {
    public static void main(String[] args) {
        int [][] mat={{0,0,0},{1,1,0},{1,1,0}};
        int x= shortestPathBinaryMatrix(mat);
        System.out.print(x);
    }
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]!=0 || grid[n-1][n-1]!=0){
            return -1;
        }
        if(n-1==0)return 1;
        PriorityQueue<Tuple> pq=new PriorityQueue<>((x,y)-> x.distance-y.distance);
        int dis[][] = new int[grid.length][grid[0].length];
        for (int[] row : dis) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dis[0][0]=0;
        int di=grid.length-1,dj=grid.length-1;
        pq.add(new Tuple(dis[0][0],0,0));
        int dr[] = {0, -1, -1, -1, 0, 1, 1, 1};
        int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};
        while(!pq.isEmpty()){
            Tuple node=pq.poll();
            int ui=node.row;
            int uj=node.col;
            int w=node.distance;
           // if(ui == grid.length-1 && uj == grid[0].length-1) return w;
            for(int i = 0;i<8;i++) {
                int newr = ui + dr[i];
                int newc = uj + dc[i];
                if(
                        newr>=0 && newc>=0 &&
                                newr<grid.length && newc< grid.length &&
                                1+w<dis[newr][newc]&&
                                grid[newr][newc]==0)
                {
                    dis[newr][newc]=w+1;
                    if(newr==grid.length-1 && newc==grid.length-1 )
                    {
                        return w+1;
                    }
                    pq.add(new Tuple(w+1,newr,newc));

                }
            }

        }
        return -1;
    }
}
class Tuple{
    int distance;
    int row;
    int col;
    public Tuple(int distance,int row, int col){
        this.row = row;
        this.distance = distance;
        this.col = col;
    }
}
