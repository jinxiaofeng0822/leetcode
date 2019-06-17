package other;

import java.util.Arrays;

/**
 * @author Jin Xiaofeng
 */
public class SearchAndSort {
    /**
     * 合并两个有序数组
     *
     * 给定两个有序整数数组 nums1 和 nums2，
     * 将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
     *
     * 说明:
     *
     *     初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
     *     你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m+n];
        int tm=0;
        int tn=0;
        int tt=0;
        while (tm < m && tn < n) {
            if(nums1[tm]<nums2[tn]){
                temp[tt]=nums1[tm];
                tm++;
            }else{
                temp[tt]=nums2[tn];
                tn++;
            }
            tt++;
        }
        while (tm<m){
            temp[tt]=nums1[tm];
            tm++;
            tt++;
        }
        while (tn<n){
            temp[tt]=nums2[tn];
            tn++;
            tt++;
        }
        for (int i = 0; i < temp.length; i++) {
            nums1[i]=temp[i];
        }
    }

    /**
     * 第一个错误的版本
     * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，
     * 你的产品的最新版本没有通过质量检测。由于每个版本都是基于
     * 之前的版本开发的，所以错误的版本之后的所有版本都是错的。
     * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有
     * 版本出错的第一个错误的版本。
     * 你可以通过调用 bool isBadVersion(version) 接口来判断
     * 版本号 version 是否在单元测试中出错。实现一个函数来查找
     * 第一个错误的版本。你应该尽量减少对调用 API 的次数。
     *
     * 示例:
     *
     * 给定 n = 5，并且 version = 4 是第一个错误的版本。
     *
     * 调用 isBadVersion(3) -> false
     * 调用 isBadVersion(5) -> true
     * 调用 isBadVersion(4) -> true
     *
     * 所以，4 是第一个错误的版本。
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        return fbv(0,n);
    }

    public int fbv(int start,int end){
        if (end-start<=1) {
            if(isBadVersion(start)){
                return start;
            }else{
                return end;
            }
        }

        int m=(end-start)/2+start;
        if(isBadVersion(m)){
            return fbv(start,m);
        }else{
            return fbv(m,end);
        }
    }

    public boolean isBadVersion(int n){
        return n>=1702766719;
    }
    public static void main(String[] args) {
        SearchAndSort ss = new SearchAndSort();
        System.out.println(ss.firstBadVersion(2126753390));
    }
}
