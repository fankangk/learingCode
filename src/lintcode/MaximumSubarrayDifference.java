package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: fankk
 * @Date: 2018/10/18 10:29
 * @Desc:  给定一个整数数组，找出两个不重叠的子数组A和B，使两个子数组和的差的绝对值|SUM(A) - SUM(B)|最大。

返回这个最大的差值。
 */
public class MaximumSubarrayDifference {


    public static void main(String[] args){

        MaximumSubarrayDifference m =new  MaximumSubarrayDifference();
       int[] arr = {-5,-4};
        int re =m.maxDiffSubArrays(arr);
        System.out.println(re);
    }

    public int maxDiffSubArrays(int[] nums) {

        int len = nums.length;
        int[][]  arr = new int[len][2];
        int[][]  arrReseerve = new int[len][2];
        int lastMaxValue = nums[0];
        int lastMinValue = nums[0];
        arr[0][0]=  nums[0];;
        arr[0][1]=  nums[0];;
        for(int i=1;i<len;i++){
            int tempMAX = nums[i]+Math.max(lastMaxValue,0);
            int tempMin = nums[i]+Math.min(lastMinValue,0);
            arr[i][0] = Math.max(tempMAX,arr[i-1][0]);
            arr[i][1] = Math.min(tempMin,arr[i-1][1]);
            lastMaxValue=tempMAX;
            lastMinValue=tempMin;

        }
         lastMaxValue = nums[len-1];
         lastMinValue = nums[len-1];
        arrReseerve[len-1][0]= nums[len-1];
        arrReseerve[len-1][1]=nums[len-1];
        for(int i=len-2;i>=0;i--){

            int tempMAX = nums[i]+Math.max(lastMaxValue,0);
            int tempMin = nums[i]+Math.min(lastMinValue,0);
            arrReseerve[i][0] = Math.max(tempMAX,arrReseerve[i+1][0]);
            arrReseerve[i][1] = Math.min(tempMin,arrReseerve[i+1][1]);
            lastMaxValue=tempMAX;
            lastMinValue=tempMin;
        }

        int re=Integer.MIN_VALUE;
        for(int i=0;i<len-1;i++){
            int number= Math.max(Math.abs(arr[i][0]-arrReseerve[i+1][1]),Math.abs(arrReseerve[i+1][0]-arr[i][1]));
            re=Math.max(re,number);
        }
        return re;
    }
}
