package array;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jin Xiaofeng
 */
public class ArrayProblem {

    /**
     * 从排序数组中删除重复项
     * <p>
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * <p>
     * 示例 1:
     * <p>
     * 给定数组 nums = [1,1,2],
     * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     * 你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * 示例 2:
     * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
     * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
     * 你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * 说明:
     * 为什么返回数值是整数，但输出的答案是数组呢?
     * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
     * 你可以想象内部操作如下:
     * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
     * int len = removeDuplicates(nums);
     * // 在函数里修改输入数组对于调用者是可见的。
     * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
     * for (int i = 0; i < len; i++) {
     * print(nums[i]);
     * }
     *
     * @param nums 已排序的数组
     * @return 移除后数组的新长度
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int point = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[point]) {
                nums[++point] = nums[i];
            }
        }
        return point + 1;
    }

    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * <p>
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * <p>
     * 示例 1:
     * 输入: [7,1,5,3,6,4]
     * 输出: 7
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     * <p>
     * 示例 2:
     * 输入: [1,2,3,4,5]
     * 输出: 4
     * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     * 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     * 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     * <p>
     * 示例 3:
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     *
     * @param prices 股票价格
     * @return 最大利润
     */
    public int maxProfit(int[] prices) {
        int profit = 0;//利润
        int previous = 0;//前一天股价
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                previous = prices[0];
                continue;
            }
            if (prices[i] > previous) {
                //今天股价大于前一天
                profit += prices[i] - previous;
            }
            previous = prices[i];
        }
        return profit;
    }

    /**
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * <p>
     * 示例 1:
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     * <p>
     * 示例 2:
     * 输入: [-1,-100,3,99] 和 k = 2
     * 输出: [3,99,-1,-100]
     * 解释:
     * 向右旋转 1 步: [99,-1,-100,3]
     * 向右旋转 2 步: [3,99,-1,-100]
     * <p>
     * 说明:
     * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     * 要求使用空间复杂度为 O(1) 的原地算法。
     *
     * @param nums 待操作数组
     * @param k    右移数量
     */
    public void rorate(int[] nums, int k) {
        int length = nums.length;
        int[] newNums = new int[length];
        k = k % length;
        for (int i = 0; i < length; i++) {
            if (i + k >= length) {
                newNums[(i + k) % length] = nums[i];
            } else {
                newNums[i + k] = nums[i];
            }
        }
        for (int i = 0; i < length; i++) {
            nums[i] = newNums[i];
        }
    }

    /**
     * 给定一个整数数组，判断是否存在重复元素。
     * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
     * <p>
     * 示例 1:
     * 输入: [1,2,3,1]
     * 输出: true
     * <p>
     * 示例 2:
     * 输入: [1,2,3,4]
     * 输出: false
     * <p>
     * 示例 3:
     * 输入: [1,1,1,3,3,4,3,2,4,2]
     * 输出: true
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length-1; i++) {
//            if(nums[i]==nums[i+1]){
//                return true;
//            }
//        }
//        return false;

        if (nums.length < 2) {
            return false;
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            } else if (nums[i] == max) {
                return true;
            } else {
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[i] == nums[j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 只出现一次的数字
     * <p>
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * 说明：
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     * <p>
     * 示例 1:
     * 输入: [2,2,1]
     * 输出: 1
     * <p>
     * 示例 2:
     * 输入: [4,1,2,1,2]
     * 输出: 4
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        //TODO 学习理解位运算
        int res = 0;
        for (int num : nums)
            res ^= num;
        return res;
    }

    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     * <p>
     * 示例 1:
     * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出: [2,2]
     * <p>
     * 示例 2:
     * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出: [4,9]
     * <p>
     * 说明：
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
     * 我们可以不考虑输出结果的顺序。
     * <p>
     * 进阶:
     * 如果给定的数组已经排好序呢？你将如何优化你的算法？
     * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
     * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
     *
     * @param nums1
     * @param nums2
     * @return 两函数的交集
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            int[] t = new int[0];
            return t;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new LinkedList<>();

        int i = 0;
        int j = 0;
        int l1 = nums1.length;
        int l2 = nums2.length;
        while (i < l1 && j < l2) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] result = new int[list.size()];
        int k = 0;
        for (Integer temp : list) {
            result[k] = temp;
            k++;
        }
        return result;
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if(i==0){
                if(digits[0]==9){
                    int[] result = new int[digits.length+1];
                    result[0]=1;
                    result[1]=0;
                    for (int j = 1; j < digits.length; j++) {
                        result[j+1]=digits[j];
                    }
                    return result;
                }else{
                    digits[0]++;
                    return digits;
                }
            }
            if(digits[i]!=9){
                digits[i]++;
                break;
            }else{
                digits[i]=0;
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        ArrayProblem p = new ArrayProblem();
        int[] a = {6,1,4,5,3,9,0,1,9,5,1,8,6,7,0,5,5,4,3};
        int[] c = p.plusOne(a);
        System.out.println("返回的数字是：" + Arrays.toString(c));
    }
}
