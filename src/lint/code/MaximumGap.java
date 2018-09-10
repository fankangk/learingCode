package lint.code;

/**
 * @Auther: fankk
 * @Date: 2018/9/7 15:53
 * @Desc:  给定一个未经排序的数组，请找出其排序表中连续两个要素的最大间距
 */
public class MaximumGap {

    public static void main(String[] args){


        MaximumGap m = new MaximumGap();
        int[] nums={3,2,1,4,3};
      int re =   m.maximumGap(nums);
      System.out.println(re);
    }

     /**
      * @desc:  给定一个未经排序的数组，请找出其排序表中连续两个要素的最大间距
      * @date:   2018/9/7 15:54
      * @param:    未排序的数组
      * @return:   排序表中连续两个要素的最大间距
      *
      * 思路：
      * (-)
      *   直接排序所用的数组
      * (二)
      *     1 首先找出最大值，最小值，计算出最大的差值
      *     2，划分区间，划分出nums.length+1 个区间，
      */
    public int maximumGap(int[] nums) {
        // write your code here
        int min=nums[0];
        int max=nums[0];
        for(int i=0;i<nums.length;i++){
            min=min>nums[i]?nums[i]:min;
            max=max<nums[i]?nums[i]:max;
        }
        if(max-min<1){
            return 0;
        }


        //[][0]在桶是否为空，[][0]  0 空，1非空
        //[][1] 在桶的最小值， //[][2] 在桶的最大值，

        //如何划分桶区间
         int section=(max-min)/nums.length+1;
        int bucket_nums = (max-min)/section + 1;
        int[][] bucket = new int[bucket_nums][3];

        for(int i=0;i<nums.length;i++){
            //桶的宽度d = len/ n,桶的个数为(nums[i]- min)/d  桶号：((A[i] - min) * n) / len
          int temp=  (nums[i]-min)/section;   //计算出nums[i]对应的区间
            if(bucket[temp][0]==0){
                bucket[temp][0]=1;
                bucket[temp][1]=nums[i];
                bucket[temp][2]=nums[i];
            }else{
               if(bucket[temp][1]>nums[i]){
                   bucket[temp][1]=nums[i] ;
               }else if(bucket[temp][2]<nums[i]){
                   bucket[temp][2]=nums[i];
               }
            }
        }
        //遍历桶bucket ，未空的
        int re =bucket[0][2]-bucket[0][1];
        int pre=0;
        for(int i=1;i<bucket_nums;i++){
            if(bucket[i][0]==0){
                while(bucket[i][0]==0){
                    i++;
                }
                if(bucket[i][1]-bucket[pre][2]>re){
                    re=bucket[i][1]-bucket[pre][2];
                }
            }else{  //因为区间为整数，所以可能所有的桶都不为空
              int temp1=bucket[i][1]-bucket[pre][2];
                int temp2=bucket[i][2]-bucket[i][1];
                if(temp1<temp2){
                    temp1=temp2;
                }
                re=Math.max(re,temp1);
            }
            pre=i;
        }
        return re;

    }

}
