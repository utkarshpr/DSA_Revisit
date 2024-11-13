package Graph.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/number-of-enclaves/description/
 */
public class NumberOfEnclave {
    public static void main(String[] args) {
    int grid[][]={{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}};
    System.out.print(numEnclaves(grid));
    }
    public static int numEnclaves(int[][] grid) {
        Queue<Pair> q=new LinkedList<>();
        boolean visited[][]=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
        {
            if(grid[i][0]==1)
            {
                q.add(new Pair(i,0));
            }
            if(grid[i][grid[0].length-1]==1){
                q.add(new Pair(i,grid[0].length-1));
            }
        }
        for(int j=0;j<grid[0].length;j++)
        {
            if(grid[0][j]==1)
                q.add(new Pair(0,j));
            if(grid[grid.length-1][j]==1)
                q.add(new Pair(grid.length-1,j));
        }

        int direction[][]={{1,0},{0,1},{-1,0},{0,-1}};
        int row=grid.length;
        int col=grid[0].length;
        while(!q.isEmpty()){
            Pair p= q.poll();
            int x=p.x;
            int y=p.y;
            visited[x][y]=true;
            for(int i=0;i<direction.length;i++){
                int nx=x+direction[i][0];
                int ny=y+direction[i][1];
                if(nx<0 || nx>=row){
                    continue;
                }
                if(ny<0 || ny>=col){
                    continue;
                }
                if(!visited[nx][ny] && grid[nx][ny]==1){
                    q.add(new Pair(nx,ny));
                }
            }
        }
        int count=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j] && grid[i][j]==1){
                    count++;
                }
            }
        }
    return count;
    }
}
