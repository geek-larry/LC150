import java.util.PriorityQueue;
import java.util.TreeMap;

// 优先队列
class MedianFinder {
    PriorityQueue<Integer> queMin;
    PriorityQueue<Integer> queMax;

    public MedianFinder() {
        queMin = new PriorityQueue<Integer>((a, b) -> (b - a));
        queMax = new PriorityQueue<Integer>((a, b) -> (a - b));
    }

    public void addNum(int num) {
        if (queMin.isEmpty() || num <= queMin.peek()) {
            queMin.offer(num);
            if (queMax.size() + 1 < queMin.size()) {
                queMax.offer(queMin.poll());
            }
        } else {
            queMax.offer(num);
            if (queMax.size() > queMin.size()) {
                queMin.offer(queMax.poll());
            }
        }
    }

    public double findMedian() {
        if (queMin.size() > queMax.size()) {
            return queMin.peek();
        }
        return (queMin.peek() + queMax.peek()) / 2.0;
    }
}

// 有序集合 + 双指针
class MedianFinder2 {
    TreeMap<Integer, Integer> nums;
    int n;
    int[] left;
    int[] right;

    public void MedianFinder() {
        nums = new TreeMap<Integer, Integer>();
        n = 0;
        left = new int[2];
        right = new int[2];
    }

    public void addNum(int num) {
        nums.put(num, nums.getOrDefault(num, 0) + 1);
        if (n == 0) {
            left[0] = right[0] = num;
            left[1] = right[1] = 1;
        } else if ((n & 1) != 0) {
            if (num < left[0]) {
                decrease(left);
            } else {
                increase(right);
            }
        } else {
            if (num > left[0] && num < right[0]) {
                increase(left);
                decrease(right);
            } else if (num >= right[0]) {
                increase(left);
            } else {
                decrease(right);
                System.arraycopy(right, 0, left, 0, 2);
            }
        }
        n++;
    }

    public double findMedian() {
        return (left[0] + right[0]) / 2.0;
    }

    private void increase(int[] iterator) {
        iterator[1]++;
        if (iterator[1] > nums.get(iterator[0])) {
            iterator[0] = nums.ceilingKey(iterator[0] + 1);
            iterator[1] = 1;
        }
    }

    private void decrease(int[] iterator) {
        iterator[1]--;
        if (iterator[1] == 0) {
            iterator[0] = nums.floorKey(iterator[0] - 1);
            iterator[1] = nums.get(iterator[0]);
        }
    }
}
