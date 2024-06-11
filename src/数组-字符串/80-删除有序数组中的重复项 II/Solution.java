class Solution {
    // 双指针
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }


    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int removeDuplicates = removeDuplicates(nums);
        System.out.println(removeDuplicates);
    }
}
