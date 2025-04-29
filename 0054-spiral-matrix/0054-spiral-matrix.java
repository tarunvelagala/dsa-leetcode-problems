class Solution {

    public static List<Integer> spiralOrder(int[][] matrix) {
        // Initialize row and columns
        int row = matrix.length;
        int col = matrix[0].length;

        ArrayList<Integer> res = new ArrayList<>();

        // Initialize top, bottom, left, right
        int top = 0;
        int bottom = row - 1;
        int left = 0;
        int right = col - 1;

        // While top <= bottom and left <= right 
        while (left <= right && top <= bottom) {

            // Traverse from left -> right 
            // Increment the top 
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;

            // Traverse from top to bottom
            // Decrement the right
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;

            // Every time check on spiral check if 
            // top exceeds bottom and print right to left (reverse order)
            // and decrement bottom. 
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Every time check on spiral check if 
            // left exceeds right and print bottom to top (reverse order)
            // and increment left. 
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }
}
