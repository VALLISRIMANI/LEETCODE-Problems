class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }
        
        int count = 0;
        
        while (!q.isEmpty()) {
            int current = q.poll();
            count++;
            
            for (int[] prequisite : prerequisites) {
                if (prequisite[1] == current) {
                    inDegree[prequisite[0]]--;
                    if (inDegree[prequisite[0]] == 0) {
                        q.offer(prequisite[0]);
                    }
                }
            }
        }
        
        return count == numCourses;
    }
}