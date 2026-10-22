class Solution {
    private int timer = 0;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(List<Integer> connection : connections) {
            int u = connection.get(0);
            int v = connection.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] disc = new int[n];
        int[] low = new int[n];

        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0, -1, adj, disc, low, bridges);

        return bridges;
    }

    private void dfs(int u, int p, List<List<Integer>> adj, int[] disc, int[] low, List<List<Integer>>  bridges) {
        disc[u] = low[u] = ++timer;

        for (int v : adj.get(u)) {
            if (v == p) {
                continue;
            }

            if (disc[v] == 0) {
                dfs(v, u, adj, disc, low, bridges);

                low[u] = Math.min(low[u], low[v]);

                if (low[v] > disc[u]) {
                    bridges.add(Arrays.asList(u, v));
                }
            } else {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}