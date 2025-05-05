class Solution {

    public int[] productExceptSelfBruteForce(int[] nums) {
        int[] productArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                product *= nums[j];
            }
            productArray[i] = product;
        }
        return productArray;
    }

    // We could make 4 observsations here
    // 1. All the numbers are +ve.
    // 2. Odd -ve's -> product subarray is -ve
    // 3. Even -ve's -> product subarray is +ve
    // 4. Zero's -> product subarray is zero's
    // https://leetcode.com/problems/product-of-array-except-self/solutions/1342916/3-minute-read-mimicking-an-interview
    public int[] productExceptSelf(int[] nums) {
        int[] prefixSubArrayProduct = new int[nums.length];
        int[] suffixSubArrayProduct = new int[nums.length];

        // Important
        prefixSubArrayProduct[0] = 1;
        suffixSubArrayProduct[nums.length - 1] = 1;

        // Calculate the prefixSubArray -> 1 -> n
        for (int i = 1; i < nums.length; i++) prefixSubArrayProduct[i] = prefixSubArrayProduct[i - 1] * nums[i - 1];

        // Calculate the prefixSubArray -> n - 2 -> =0
        for (int i = nums.length - 2; i >= 0; i--) suffixSubArrayProduct[i] = suffixSubArrayProduct[i + 1] * nums[i + 1];

        // Finally we multiply both the arrays.
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = suffixSubArrayProduct[i] * prefixSubArrayProduct[i];
        }
        return res;
    }
}
