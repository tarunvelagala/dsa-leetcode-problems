//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
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

            int key = Integer.parseInt(in.readLine().trim());
            Solution ob = new Solution();
            out.println(ob.kthSmallest(arr, key));
            out.println("~");
        }
        out.flush();
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    // Time Complexity - O(n log k) 
    // Insertion/Deletion takes K elements O(logk)
    // n insertions with up to n - k removals → O(n log k)
    public static int kthSmallest(int[] arr, int k) {
        // Your code here
        // Using Max Heap so that the smallest element 
        // is at the top.
        PriorityQueue<Integer> p = 
            new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0;i<arr.length;i++) {
            p.add(arr[i]);
            
            // If heap size exceeds k, remove the largest element
            // So that the next smaller element will be the head. 
            if (p.size() > k) {
                p.poll();
            }
        }
        
        return p.peek();
    }
}
