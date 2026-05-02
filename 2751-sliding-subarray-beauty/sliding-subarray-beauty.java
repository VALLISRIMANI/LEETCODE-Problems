class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int[] freq = new int[51]; 
        for (int i = 0; i < k; i++) {
            if (nums[i] < 0) freq[-nums[i]]++;
        }
        res[0] = getXthSmallestNegative(freq, x);
        for (int i = k; i < n; i++) {
            if (nums[i - k] < 0) freq[-nums[i - k]]--;
            if (nums[i] < 0) freq[-nums[i]]++;
            res[i - k + 1] = getXthSmallestNegative(freq, x);
        }
        return res;
    }
    private int getXthSmallestNegative(int[] freq, int x) {
        int count = 0;
        for (int val = 50; val >= 1; val--) { 
            count += freq[val];
            if (count >= x) {
                return -val;
            }
        }
        return 0;
    }
}

/*

class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            if (nums[i] < 0) {
                insertSorted(deque, nums[i]);
            }
        }

        res[0] = (deque.size() < x) ? 0 : deque.toArray(new Integer[0])[x - 1];

        for (int i = k; i < n; i++) {
            if (nums[i - k] < 0) {
                deque.remove(nums[i - k]);
            }

            if (nums[i] < 0) {
                insertSorted(deque, nums[i]);
            }

            res[i - k + 1] = (deque.size() < x) ? 0 : deque.toArray(new Integer[0])[x - 1];
        }

        return res;
    }

    private void insertSorted(Deque<Integer> deque, int val) { 
        ListIterator<Integer> it = ((LinkedList<Integer>) deque).listIterator(); 

        while (it.hasNext()) { 
            if (it.next() > val) { 
                it.previous(); 
                it.add(val); 
                return; 
            } 
        }
        
        deque.addLast(val); 
    }
}

*/