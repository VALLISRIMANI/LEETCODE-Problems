class Solution {
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[] height = new int[columns];
        int maxArea = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '0') {
                    height[j] = 0;
                } else {
                    height[j] += 1;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(height));
        }
        
        return maxArea;
    }
    
    static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int[] extended = Arrays.copyOf(heights, heights.length + 1);

        for (int i = 0; i < extended.length; i++) {
            while (!stack.isEmpty() && extended[i] < extended[stack.peek()]) {
                int height = extended[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }
}