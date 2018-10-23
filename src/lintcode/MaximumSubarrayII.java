package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: fankk
 * @Date: 2018/10/18 08:51
 * @Desc:    给定一个整数数组，找出两个 不重叠 子数组使得它们的和最大。每个子数组的数字在数组中的位置应该是连续的。返回最大的和
 */
public class MaximumSubarrayII {

    public static void main(String[] args){

        MaximumSubarrayII m =new  MaximumSubarrayII();
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(3);
        nums.add(-1);
        nums.add(2);
        nums.add(-1);
        nums.add(2);
     int re =m.maxTwoSubArrays(nums);
      System.out.println(re);
    }

    public int maxTwoSubArrays(List<Integer> nums) {

        int size=nums.size();
        int[] max= new  int[size];
        int[] maxReverse= new  int[size];

        int lastValue = nums.get(0);
        max[0]= lastValue;
        for(int i=1;i<size;i++){
            int temp = nums.get(i)+Math.max(lastValue,0);
            max[i] = Math.max(temp,max[i-1]);
            lastValue=temp;
        }

        lastValue =nums.get(size-1);
        maxReverse[size-1]=lastValue;
        for(int i=size-2;i>=0;i--){
            int temp = nums.get(i)+Math.max(lastValue,0);
            maxReverse[i] = Math.max(temp,maxReverse[i+1]);
            lastValue=temp;
        }

        int re=Integer.MIN_VALUE;
        for(int i=0;i<size-1;i++){
            int number= max[i]+ maxReverse[i+1];
            re=Math.max(re,number);
        }

        return  re;


//        for(int i=0;i<size-1;i++){
//            int number1 = maxSumSubArrays(nums,0,i);
//            int number2 = maxSumSubArrays(nums,i+1,size-1);
//            max=Math.max(max,number1+number2);
//        }
//        return max;
    }


    public int maxSumSubArrays(List<Integer> arr,int start,int end) {


        if(start>end || start<0||end>=arr.size()){
            throw  new RuntimeException("error  输入不合法");
        }
        if(start==end){
            return arr.get(start);
        }
        //表示以num[i]结尾的最大子数组
        int[] num = new int[end-start+1];
        num[0]=arr.get(start);
        int re= num[0];
        for(int i=start+1 ;i<=end;i++){
            num[i-start] = arr.get(i)+Math.max(num[i-1-start],0);
            re= Math.max(re, num[i-start]);
        }
        return re;
    }
}
