package Graph.DFS_BFS_Topo;
import java.util.*;

/*
https://leetcode.com/problems/evaluate-division/
 */
public class EvaluateDivision_399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries)
    {
        HashMap<String,HashMap<String,Double>> gp=buildGraph(equations,values);
        double[] finalAns = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String dividend = queries.get(i).get(0);
            String divisor = queries.get(i).get(1);

            if( !gp.containsKey(dividend) || !gp.containsKey(divisor)){
                finalAns[i]=-1.0;
            }
            else{
                HashSet<String> vis = new HashSet<>();
                double[] ans = {-1.0};
                double temp = 1.0;
                dfs(dividend, divisor, gp, vis, ans, temp);
                finalAns[i] = ans[0];
            }
        }
        return finalAns;


    }
    public void dfs(String node, String dest, HashMap<String, HashMap<String, Double>> gr, HashSet<String> vis, double[] ans, double temp) {
        if (vis.contains(node))
            return;
        vis.add(node);
        if (node.equals(dest))
        {
            ans[0]=temp;
            return;
        }
        for (Map.Entry<String, Double> entry : gr.get(node).entrySet()) {
            String ne = entry.getKey();
            double val = entry.getValue();
            dfs(ne, dest, gr, vis, ans, temp * val);
        }

    }


    public HashMap<String, HashMap<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        HashMap<String, HashMap<String, Double>> gr = new HashMap<>();

        for(int i=0;i<equations.size();i++)
        {
            String x=equations.get(i).get(0);
            String y=equations.get(i).get(1);
            double weight=values[i];

            gr.putIfAbsent(x,new HashMap<>());
            gr.putIfAbsent(y,new HashMap<>());

            gr.get(x).put(y,weight);
            gr.get(y).put(x,1.0/weight);


        }

        return gr;
    }
}
