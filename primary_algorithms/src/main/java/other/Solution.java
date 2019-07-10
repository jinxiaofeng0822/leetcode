package other;

import java.util.Random;

/**
 * @author Jin Xiaofeng
 */
public class Solution {

    private int[] array;
    private int[] original;

    private Random random=new Random();

    private int randRange(int min,int max){
        return random.nextInt(max-min)+min;
    }

    public Solution(int[] nums) {
        array=nums;
        original=nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array=original;
        original=original.clone();
        return array;
    }

    private void swap(int i,int j){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swap(i,randRange(i,array.length));
        }
        return array;
    }
}
