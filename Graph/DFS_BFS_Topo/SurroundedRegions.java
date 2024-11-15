package Graph.DFS_BFS_Topo;

import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/surrounded-regions/
 */
public class SurroundedRegions {
    public static void main(String[] args) {
        char x[][]={{'X','O','X'},{'X','O','X'},{'X','O','X'}};
        solve(x);
    }
    public static void solve(char[][] board) {
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<board.length;i++)
        {
           if(board[i][0]=='O')
               q.add(new Pair(i,0));
           if(board[i][board[0].length-1]=='O')
               q.add(new Pair(i,board[0].length-1));
        }
        for(int j=0;j<board[0].length;j++)
        {
            if(board[0][j]=='O')
                q.add(new Pair(0,j));
            if(board[board.length-1][j]=='O')
                q.add(new Pair(board.length-1,j));
        }
        boolean visited[][]=new boolean[board.length][board[0].length];
        int direction[][]={{1,0},{0,1},{-1,0},{0,-1}};
        int row=board.length;
        int col=board[0].length;
        while(!q.isEmpty())
        {
            Pair p=q.poll();
            int x=p.x;
            int y=p.y;
            visited[x][y]=true;
            for(int i=0;i<direction.length;i++){
                int nx=x+direction[i][0];
                int ny= y+ direction[i][1];
                if(nx<0 || nx>=row )
                    continue;
                if(ny <0 || ny>=col)
                    continue;
                if(!visited[nx][ny] && board[nx][ny]=='O'){
                    q.add(new Pair(nx,ny));
                }
            }

        }
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]=='O' && !visited[i][j])
                {
                    board[i][j]='X';
                }
            }
        }
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
               System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}
