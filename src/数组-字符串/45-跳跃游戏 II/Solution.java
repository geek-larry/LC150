public class Solution {
    // 反向查找出发位置
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

    // 正向查找可到达的最大位置
    public int jump2(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 8, 0, 9 };
        int jump = jump(nums);
        System.out.println(jump);
    }
}
