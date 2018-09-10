package lint.code;

import java.util.Arrays;

public class Sort {

    public static void main(String[] args){
        Sort sort = new Sort();
        int[] arr={0,4,3,0};
        sort.twoSum(arr,0);
    }

    /**
     * @desc: 56. 两数之和  给一个整数数组，找到两个数使得他们的和等于一个给定的数 target
     *          返回这两个数的下标, 并且第一个下标小于第二个下标
     * @date:
     * @param:  
     * @return:
     *思路：
     * （一）
     *      1.首先对数组排序
     *      2. l数组的最值（初始为0），r初始为len-1
     *      arr[l]+arr[r]<target l++
     *       arr[l]+arr[r]>target r--
     * （二）
     *      1.利用与目标值的差值作为hasmap 的key ,值为list(放数组的下标，考虑到数组有重复值)
     *      2.判断 map的可以与number[i] 是否相等
     *
     */
    public int[] twoSum(int[] numbers, int target) {

        if(numbers==null||numbers.length<2){
            throw new RuntimeException("输入不合法，numbers数组长度最小为2");
        }
        int len = numbers.length;
        int[] arr= new int[len];
        for(int i=0;i<len;i++){
            arr[i]=numbers[i];
        }
        Arrays.sort(arr);
        int[] re =new int[2];
        int l=0;
        int r=numbers.length-1;
        while(l<r){
            int temp=arr[l]+arr[r];
            if(temp<target){
                l++;
            }
            else if(temp>target){
                r--;
            }
            else {

                return findIndex(numbers,arr[l],arr[r]);
            }
        }
        return re;
    }
     /**
      * @desc: 找出目标数值中值为lTarget，rTarget的下标
      */
    public int[] findIndex(int[] arr,int lTarget,int rTarget){
        int[] re = new int[2];
        int r=-1;
        int l=-1;
        for(int i=0;i<arr.length;i++){
            if(l==-1&&arr[i]==lTarget){
                l=i;
            }else if(r==-1&&arr[i]==rTarget){
                r=i;
            }
            if(l!=-1&&r!=-1){
                re[0]=l;
                re[1]=r;
                Arrays.sort(re);
                break;
            }
        }
        return re;
    }
}
