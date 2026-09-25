class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<>();
        for (int student : students) {
            q.offer(student);
        }

        int idx = 0;
        int rejected = 0;

        while (!q.isEmpty() && rejected < q.size()) {
            if (q.peek() == sandwiches[idx]) {
                q.poll();
                idx++;
                rejected = 0;
            } else {
                q.offer(q.poll());
                rejected++;
            }
        }

        return q.size();
    }
}