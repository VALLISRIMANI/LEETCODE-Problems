class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] minCoins = new int[amount + 1];
        Arrays.fill(minCoins, max);
        minCoins[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    minCoins[i] = Math.min(minCoins[i], minCoins[i - coin] + 1);
                }
            }
        }

        return minCoins[amount] > amount ? -1 : minCoins[amount];
    }
}