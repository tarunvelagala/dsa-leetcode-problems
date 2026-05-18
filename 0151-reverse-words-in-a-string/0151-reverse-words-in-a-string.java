import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

class Solution {
    public String reverseWords(String s) {
        if(s == null) return "";
        final String[] reverseStringsList = s.trim().split("\\s+");
        if(reverseStringsList == null && reverseStringsList.length < 1) {
            return "";
        }
        Collections.reverse(Arrays.asList(reverseStringsList));
        return String.join(" ", reverseStringsList);
    }
}