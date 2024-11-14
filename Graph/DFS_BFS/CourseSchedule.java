package Graph.DFS_BFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static Graph.DFS_BFS.topoSort.topoSortn;

public class CourseSchedule {
    public static void main(String[] args) {
        int numCourses = 4;
        int [][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
//        int numCourses = 4;
//        int[][] prerequisites = {{1, 0}, {2, 1}, {3, 2}, {1, 3}};

       int ar[]= findOrder(numCourses,prerequisites);
       for(int i:ar)
           System.out.print(i+" ");
    }
    // cycle -> topogit
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean isCycle=cycleDectectionInCyclic(numCourses,prerequisites);
        if (isCycle)
            return new int[]{};
        else{
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                graph.add(new ArrayList<>());
            }

            for (int[] prereq : prerequisites) {
                graph.get(prereq[1]).add(prereq[0]); // Directed edge from prereq[1] to prereq[0]
            }
            int ar[]=topoSortn1(numCourses,graph);
            return ar;
        }
    }
    public static int[] topoSortn1(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[]=new boolean[v];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<v;i++) {

            if(!visited[i])
                dfs_1(i, st, visited, adj);
        }
        int ans[] = new int[v];
        int i = 0;
        while (!st.isEmpty()){
            ans[i++]=st.pop();
        }
        return ans;



    }

    public static void dfs_1(int i, Stack<Integer> st, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[i]=true;
        for(int x: adj.get(i)){
            if(!visited[x])
                dfs_1(x,st,visited,adj);
        }
        st.push(i);
    }

    private static boolean cycleDectectionInCyclic(int numCourses, int[][] prerequisites) {
        boolean visited[]=new boolean[numCourses];
        boolean pathVisited[]=new boolean[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            graph.get(prereq[1]).add(prereq[0]); // Directed edge from prereq[1] to prereq[0]
        }



        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(dfs__(i,visited,pathVisited,graph))
                    return  true;
            }
        }
        return  false;


    }

    private static boolean dfs__(int node, boolean[] visited, boolean[] pathVisited, List<List<Integer>> prereqList) {
        visited[node]=true;
        pathVisited[node]=true;
        for(int i :prereqList.get(node)){
            if(!visited[i]){
                if(dfs__(i,visited,pathVisited,prereqList))
                    return true;

            }
            if(pathVisited[i])
                return true;
        }
        pathVisited[node]=false;
        return  false;
    }
}
