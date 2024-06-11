public class Solution {

    // 双指针
    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        for (int right = 0; right < n; ++right) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }

    // 双指针优化
    public int removeElement2(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 2, 5, 8, 4, 6, 7, 7 };
        int val = 6;
        int removeElement = removeElement(nums, val);
        System.out.println(removeElement);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
