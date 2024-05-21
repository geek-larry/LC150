class Solution {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < gas.length; i++) {
            sum = sum + gas[i] - cost[i];
            if (sum < min && sum < 0) {
                min = sum;
                minIndex = i;
            }
        }
        if (sum < 0)
            return -1;
        return (minIndex + 1) % gas.length;
    }

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5}, cost = {3,4,5,1,2};
        int canCompleteCircuit = canCompleteCircuit(gas, cost);
        System.out.println(canCompleteCircuit);
    }
}