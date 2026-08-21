class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        
        int j = 0, result = 0;
        for (int house : houses) {
            while (j < heaters.length - 1 && Math.abs(house - heaters[j]) >= Math.abs(house - heaters[j + 1])) {
                j++;
            }

            result = Math.max(result, Math.abs(house - heaters[j]));
        }

        return result;
    }
}