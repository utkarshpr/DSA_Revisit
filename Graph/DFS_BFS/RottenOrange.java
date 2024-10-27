package Graph.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOrange {
    public static void main(String[] args) {
        int[][] adjList = {
                {2, 1, 1},  // Node 0 can access nodes 2, 1, and 1 (repeated)
                {1, 1, 0},  // Node 1 can access nodes 1, and 0
                {0, 1, 1}   // Node 2 can access nodes 0, 1, and 1 (repeated)
        };
        int fresh_orange=0;
        Queue<Pair> q= new LinkedList<>();
        for(int i=0;i<adjList.length;i++){
            for(int j=0;j<adjList[i].length;j++)
            {
               if(adjList[i][j]==1)
                   fresh_orange++;
               if (adjList[i][j]==2)
                   q.add(new Pair(i,j));
            }
        }
        if (fresh_orange == 0)
            return;

      int x=  bfs(adjList,q,fresh_orange);
      System.out.print(x);


    }

    private static int bfs(int[][] adjList, Queue<Pair> q, int freshOrange) {
        int direction[][]={{1,0},{0,1},{-1,0},{0,-1}};
        int row=adjList.length;
        int col=adjList[0].length;
        int count=0;

        while (!q.isEmpty()){
            count++;
            int size = q.size();
            for(int i=0;i<size;i++) {
                Pair p=q.poll();
                for(int[] dir:direction){
                    int x1=p.x+dir[0];
                    int y1=p.y+dir[1];
                    if (x1 < 0 || y1 < 0
                            || x1 >= row || y1 >= col
                            || adjList[x1][y1] == 0 || adjList[x1][y1] == 2) {
                        continue;
                    }
                    adjList[x1][y1]=2;
                    q.offer(new Pair(x1,y1));
                    freshOrange--;
                }
            }

        }
    return freshOrange==0?count-1:-1;
    }
}
class  Pair{
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
