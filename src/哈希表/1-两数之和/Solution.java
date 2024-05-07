import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                Integer c = map.get(target - nums[i]);
                return new int[] { c, i };
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
