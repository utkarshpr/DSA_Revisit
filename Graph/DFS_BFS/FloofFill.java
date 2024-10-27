package Graph.DFS_BFS;
import  java.util.*;
/*
https://leetcode.com/problems/flood-fill/description/
 */
public class FloofFill {
    public static void main(String[] args) {
        int[][] image = {{0,1,0},{0,0,1}};
        int sr = 1;
        int sc = 1;
        int color = 1;
        int[][] ans=new int[image.length][image[0].length];

        floodFill(image,sr,sc,color,image[sr][sc],ans);
        for(int[] x :image){
            for(int j :x)
                System.out.print(j+" ");
            System.out.println();            ;
        }
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int color,int original,int [][] ans) {
        Queue<Pair> q=new LinkedList<>();
        ans[sr][sc]=1;
        q.add(new Pair(sr,sc));
        int dir[][]={{0,1},{1,0},{0,-1},{-1,0}};
        while(!q.isEmpty()){
            Pair p=q.poll();
            if(image[p.x][p.y]==original)
                image[p.x][p.y]=color;

            for(int[] i:dir)
            {
                int x1=p.x+i[0];
                int y1=p.y+i[1];
                if(x1<0 || y1<0 || x1>=image.length || y1 >=image[0].length)
                    continue;
                if (image[x1][y1]==original && ans[x1][y1]==0)
                {
                    ans[x1][y1]=1;
                    q.offer(new Pair(x1,y1));
                }
            }
        }
        return image;
    }
}
