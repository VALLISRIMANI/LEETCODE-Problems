class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];

        dfs(0, visited, rooms);

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }

    void dfs(int start, boolean[] visited, List<List<Integer>> rooms) {
        visited[start] = true;
        for (int x : rooms.get(start)) {
            if (!visited[x]) {
                dfs(x, visited, rooms);
            }
        }
    }
}