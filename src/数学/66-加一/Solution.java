/**
 * 
 * 链接：https://leetcode.cn/problems/plus-one/solutions/4481/java-shu-xue-jie-ti-by-yhhzw/
 * 
 * @author Larry
 * @since 2024-06-11 17:23:41
 */
class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            digits[i] = (digits[i] + 1) % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }
}