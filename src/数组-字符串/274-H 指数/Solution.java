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

    // 计数排序
    public int hIndex2(int[] citations) {
        int n = citations.length, tot = 0;
        int[] counter = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n) {
                counter[n]++;
            } else {
                counter[citations[i]]++;
            }
        }
        for (int i = n; i >= 0; i--) {
            tot += counter[i];
            if (tot >= i) {
                return i;
            }
        }
        return 0;
    }

    // 二分搜索
    public int hIndex3(int[] citations) {
        int left = 0, right = citations.length;
        int mid = 0, cnt = 0;
        while (left < right) {
            // +1 防止死循环
            mid = (left + right + 1) >> 1;
            cnt = 0;
            for (int i = 0; i < citations.length; i++) {
                if (citations[i] >= mid) {
                    cnt++;
                }
            }
            if (cnt >= mid) {
                // 要找的答案在 [mid,right] 区间内
                left = mid;
            } else {
                // 要找的答案在 [0,mid) 区间内
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 0, 6, 1, 5 };
        int hIndex = hIndex(nums);
        System.out.println(hIndex);
    }
}
