package other;

/**
 * @author Jin Xiaofeng
 */
public class DivideAndConquer {
    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * <p>
     * 注意：给定 n 是一个正整数。
     * 示例 1：
     * 输入： 2
     * 输出： 2
     * 解释： 有两种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶
     * 2.  2 阶
     * <p>
     * 示例 2：
     * 输入： 3
     * 输出： 3
     * 解释： 有三种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶 + 1 阶
     * 2.  1 阶 + 2 阶
     * 3.  2 阶 + 1 阶
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
//        不难发现，这个问题可以被分解为一些包含最优子结构的子问题，
//        即它的最优解可以从其子问题的最优解来有效地构建，我们可以使用动态规划来解决这一问题。
//        第 i 阶可以由以下两种方法得到：
//        在第 (i−1)(i-1)(i−1) 阶后向上爬一阶。
//        在第 (i−2)(i-2)(i−2) 阶后向上爬 222 阶。
//        所以到达第 iii 阶的方法总数就是到第 (i−1) 阶和第 (i−2) 阶的方法数之和。
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    /**
     * 最大子序和
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组
     * （子数组最少包含一个元素），返回其最大和。
     * 示例:
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     * 进阶:
     * 如果你已经实现复杂度为 O(n) 的解法，
     * 尝试使用更为精妙的分治法求解。
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        //时间复杂度O(n^2),不好的算法
        int max = Integer.MIN_VALUE;
        int maxTemp;
        for (int i = 0; i < nums.length; i++) {
            maxTemp = nums[i];
            int tempj=nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                tempj=tempj+nums[j];
                if(tempj>maxTemp){
                    maxTemp=tempj;
                }
            }
            if (maxTemp > max) {
                max = maxTemp;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a={-2,1,-3,4,-1,2,1,-5,4};
        DivideAndConquer d= new DivideAndConquer();
        int max = d.maxSubArray(a);
        System.out.println(max);
    }
}
