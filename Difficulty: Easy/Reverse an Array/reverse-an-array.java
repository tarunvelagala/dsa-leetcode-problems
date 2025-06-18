class Solution {
    public void reverseArray(int arr[]) {
        // code here
        int lp = 0;
        int rp = arr.length - 1;
        while(lp < rp) {
            int temp = arr[lp];
            arr[lp] = arr[rp];
            arr[rp] = temp;
            lp++;
            rp--;
        }
    }
}