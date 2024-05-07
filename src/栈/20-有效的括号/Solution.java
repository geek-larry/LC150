import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {
            {
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }
        };

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        int sum = 0;
        int index = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            sum = nums[i] + nums[i + 1] + nums[i + 2];
            System.out.println(sum);
            if (sum >= target) {
                index = i;
                break;
            }
        }
        if (index == 0) {
            return nums[length - 1] + nums[length - 2] + nums[length - 3];
        }
        int sum1 = sum;
        System.out.println(index);
        int sum2 = nums[index - 1] + nums[index] + nums[index + 1];
        return (sum1 - target) > (target - sum2) ? sum2 : sum1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int target = 19;
        int threeSumClosest = threeSumClosest(arr, target);
        System.out.println(threeSumClosest);
    }
}