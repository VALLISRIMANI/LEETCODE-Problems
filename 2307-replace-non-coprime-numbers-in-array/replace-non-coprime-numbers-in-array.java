class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> stack = new ArrayList<>();

        for(int num : nums) {
            while(!stack.isEmpty() && gcd(stack.get(stack.size() - 1), num) > 1) {
                num = lcm(stack.remove(stack.size() -1), num);
            }
            stack.add(num);
        }

        return stack;
    }

    public int lcm(int m, int n) {
        return m / gcd(m, n) * n;
    }

    public int gcd(int m, int n) {
        return n == 0 ? m : gcd(n, m % n);
    }
}