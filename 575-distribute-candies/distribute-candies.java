class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();

        for (int num : candyType) {
            set.add(num);
        }

        int half = candyType.length / 2;

        return set.size() >= half ? half : set.size();
    }
}