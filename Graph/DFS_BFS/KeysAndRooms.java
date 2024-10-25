package Graph.DFS_BFS;

import java.util.*;
public class KeysAndRooms {
    /*
    https://leetcode.com/problems/keys-and-rooms/description/
     */
    public static void main(String[] args) {
        List<List<Integer>> ar=new ArrayList<>();
        ar.add(new ArrayList<>(List.of(1,3)));
        ar.add(new ArrayList<>(List.of(3,0,1)));
        ar.add(new ArrayList<>(List.of(2)));
        ar.add(new ArrayList<>(List.of(0)));
         canVisitAllRooms(ar);
    }
    public static  boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int i = 0; i < rooms.size(); i++) {
            adjList.put(i, rooms.get(i));  // For each room, store the list of rooms it has keys to
        }
        boolean visited[]=new boolean[adjList.size()];
        bfsOfGraph(visited,adjList,0);

        for(int i=0;i<visited.length;i++)
           if(!visited[i])
               return false;
        return true;
    }
    public static  void bfsOfGraph(boolean visited[],Map<Integer, List<Integer>> adjList, int node){
        visited[node]=true;
        Queue<Integer> q=new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){


            Integer data=q.poll();
           // visited[data]=true;
           // System.out.println(data);
            for(Integer it : adjList.get(data)){
                if (!visited[it]){
                    visited[it]=true;
                    q.add(it);
                }
            }

        }
    }
}

