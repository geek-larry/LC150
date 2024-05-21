import java.util.Arrays;

class Solution {
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0, i = citations.length - 1; 
        while (i >= 0 && citations[i] > h) {
            h++; 
            i--;
        }
        return h;
    }

    public static void main(String[] args) {
        int[] nums = {3,0,6,1,5};
        int hIndex = hIndex(nums);
        System.out.println(hIndex);
    }
}
