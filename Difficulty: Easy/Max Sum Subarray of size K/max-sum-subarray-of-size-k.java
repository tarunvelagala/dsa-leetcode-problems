//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());

            Solution ob = new Solution();
            int ans = ob.maximumSumSubarray(arr, k);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    public int maximumSumSubarray(int[] arr, int k) {
        
        int n = arr.length;
        if(n < k) return -1;
        
        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;
        
        for(int i = 0;i<k;i++) {
            windowSum += arr[i];
        }
        
        maxSum = windowSum;
        
        for(int i = k;i<n;i++) {
            windowSum += arr[i] - arr[i-k];
            maxSum = Math.max(maxSum, windowSum);
        }
        
        return maxSum;
    }
    
    public int maximumSumSubarrayBF(int[] arr, int k) {
        // Code here
        // Repeat the question to the interviewer 
        // Ask for examples 
        // Start with the intution 
        // Bruteforce
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length-k+1;i++) {
            int currSum = 0;
            for(int j = 0;j<k;j++) {
                currSum += arr[i+j];
            }
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}