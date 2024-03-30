public class Solution {
    public boolean isSubsequence(String s, String t) {
        int length1 = s.length();
        int length2 = t.length();
        int i = 0;
        int j = 0;
        while (i < length1 && j < length2) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }

        }
        return i == length1;
    }
}
