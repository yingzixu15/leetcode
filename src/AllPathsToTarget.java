import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>>[] record = new List[n];
        List<Integer> goalRecord = new ArrayList<>();
        goalRecord.add(n-1);
        record[n-1] = new ArrayList<>();
        record[n-1].add(goalRecord);
        boolean[] visited = new boolean[n];
        dfs(record, visited, n, graph, 0);
        
        if (record[0] == null) return new ArrayList<List<Integer>>();
        else return record[0];
    }

    private void dfs(List<List<Integer>>[] record, boolean[] visited, int n, int[][] graph, int start) {
        // base case
        if (visited[start]) return;
        visited[start] = true;
        if (graph[start].length == 0) return;
        if (start == n-1) return;
        
        // recursive case
        for (int child: graph[start]) {
            dfs(record, visited, n, graph, child);
            if (record[child] != null) {
                for (List<Integer> path: record[child]) {
                    List<Integer> copyOfPath = new ArrayList<>(path);
                    copyOfPath.add(0, start);
                    if (record[start] == null) 
                        record[start] = new ArrayList<>();
                    record[start].add(copyOfPath);
                }
            }
        }
    }
}