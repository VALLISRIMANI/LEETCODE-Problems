class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!dfs(i, 0, color, graph)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean dfs(int node, int c, int[] color, int[][] graph) {
        color[node] = c;

        for (int neigh : graph[node]) {
            if (color[neigh] == -1) {
                if (!dfs(neigh, 1 - c, color, graph)) {
                    return false;
                }
            } else if (color[neigh] == color[node]) {
                return false;
            }
        }

        return true;
    }
}