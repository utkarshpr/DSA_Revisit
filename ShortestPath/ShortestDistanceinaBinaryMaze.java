package ShortestPath;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceinaBinaryMaze {
    public static void main(String[] args) {
        int grid[][] = {{1, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
                {1, 0, 0, 1}};
       int[] source = {0, 1} ,destination = {2,2};
    int x= shortestPathBinaryMatrix(grid,source,destination);
    System.out.print(x);
    }
    public static int shortestPathBinaryMatrix(int[][] grid,int [] source, int [] dest) {
        if(source[0]==dest[0] && source[1]==dest[1])return 0;
        Queue<Tuple> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int[][] dist = new int[n][m];
        for(int i = 0;i<n;i++) {
            for(int j =0;j<m;j++) {
                dist[i][j] = (int)(1e9);
            }
        }
        dist[source[0]][source[1]] = 0;
        q.add(new Tuple(0,source[0],source[1]));
        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, 1, 0, -1};
        while(!q.isEmpty()){
            Tuple it = q.peek();
            q.remove();
            int dis = it.distance;
            int r = it.row;
            int c = it.col;
            for(int i = 0;i<4;i++) {
                int newr = r + dr[i];
                int newc = c + dc[i];
                if(newr >=0 && newr<n && newc >=0 && newc<m && grid[newr][newc]==1 && 1+dis<dist[newr][newc]){
                    dist[newr][newc] = 1 + dis;
                    if(newr == dest[0] &&
                            newc == dest[1])
                        return dis + 1;
                    q.add(new Tuple(1+dis,newr,newc));

                }
            }
        }
        return -1;
    }
}

