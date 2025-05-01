class Solution {

    public int reverse(int x) {
        int n = x;
        int r = 0;
        while(n >0) {
            int rem = n %10;
            n /= 10;
            r = r * 10 + rem;
        }
        return r;
    }

    public boolean isPalindrome(int x) {
        return reverse(x) == x;
    }
}