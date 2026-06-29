class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                result++;
                DFS_recursion(i, visited, n, isConnected);
            }
        }

        return result;
    }

    void DFS_recursion(int startVertex, boolean[] visited, int n, int[][] isConnected) {
        visited[startVertex] = true;

        for (int i = 0; i < n; i++) {
            if (isConnected[startVertex][i] == 1 && !visited[i]) {
                DFS_recursion(i, visited, n, isConnected);
            }
        }
    }
}