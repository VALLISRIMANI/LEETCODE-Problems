class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        boolean[] visited = new boolean[n];
        
        if (!visited[source]) {
            dfs(graph, source, visited);
        }
        
        return visited[destination];
    }
    
    private void dfs(List<List<Integer>> graph, int source, boolean[] visited) {
        visited[source] = true;
        
        for (int neigh : graph.get(source)) {
            if (!visited[neigh]) {
                dfs(graph, neigh, visited);
            }
        }
    }
}