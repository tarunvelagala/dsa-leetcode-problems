class Solution {

    // Sort the array -> naive solution
    public void sortColorsBruteForce(int[] nums) {
        Arrays.sort(nums);
    }

    // Better solution using count variables and loops.
    public void sortColorsBetter(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) count0++; else if (nums[i] == 1) count1++; else count2++;
        }

        for (int i = 0; i < count0; i++) nums[i] = 0;
        for (int i = count0; i < count0 + count1; i++) nums[i] = 1;
        for (int i = count0 + count1; i < nums.length; i++) nums[i] = 2;
    }

    // Using Dutch National Flag Algorithm
    // https://github.com/tarunvelagala/dsa-leetcode-problems/blob/main/_patterns/algorithms/DutchNationalFlag.md
    public void sortColorsOptimal(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) mid++; else {
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }
    }

    public void sortColors(int[] nums) {
        // Causes TLE
        //  sortColorsBruteForce(nums);
        // sortColorsBetter(nums);

        // Dutch National Flag Algorithm
        sortColorsOptimal(nums);
    }
}
