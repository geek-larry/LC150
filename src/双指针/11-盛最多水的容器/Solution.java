public class Solution {
    public static int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;

        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = new int[] { 1, 2, 3, 4, 5 };
        int maxArea = maxArea(height);
        System.out.println(maxArea);
    }
}