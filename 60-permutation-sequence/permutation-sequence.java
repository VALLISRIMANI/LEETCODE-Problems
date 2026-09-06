class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        int factorial = 1;
        for (int i = 1; i < n; i++) {
            factorial *= i;
        }

        StringBuilder result = new StringBuilder();
        k--;
        
        while (n > 0) {
            int index = k / factorial;
            result.append(nums.get(index));
            nums.remove(index);

            k %= factorial;
            n--;

            if (n > 0) {
                factorial /= n;
            }
        }

        return result.toString();
    }
}