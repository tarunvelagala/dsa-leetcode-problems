class Solution {

    public static List<Integer> spiralOrder(int[][] matrix) {
	    int row = matrix.length;
	    int col = matrix[0].length;
	    
	    ArrayList<Integer> res = new ArrayList<>();
	    int top = 0;
	    int bottom = row - 1;
	    int left = 0;
	    int right = col - 1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom;i++) {
                res.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left;i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top;i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }
}
