public class Solution {
    public static int jump(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    System.out.println(222);
                    break;
                }
            }
            System.out.println(111);
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 8, 0, 9 };
        int jump = jump(nums);
        System.out.println(jump);
    }
}
