class Solution {
    public void reverseString(char[] s) {
        int leftPointer = 0;
        int rightPointer = s.length - 1;
        while(leftPointer < rightPointer) {
            char temp = s[rightPointer];
            s[rightPointer] = s[leftPointer];
            s[leftPointer] = temp;
            leftPointer++;
            rightPointer--;
        }
    }
}