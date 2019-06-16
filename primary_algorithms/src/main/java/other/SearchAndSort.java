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

    public static void main(String[] args) {
        SearchAndSort ss = new SearchAndSort();
        int[] nums1={1,2,3,0,0,0};
        int[] nums2={2,5,6};
        ss.merge(nums1,3,nums2,3);
        System.out.println(Arrays.toString(nums1));
    }
}
