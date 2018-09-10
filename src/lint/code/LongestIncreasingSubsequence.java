package lint.code;

/**
 * @Auther: fankk
 * @Date: 2018/9/10 08:43
 * @Desc:   给定一个整数序列，找到最长上升子序列（LIS），返回LIS的长度
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args){
        LongestIncreasingSubsequence l = new LongestIncreasingSubsequence();
        int[] nums={-2,-1};
      //  int re =l.longestIncreasingSubsequence(nums);
        int re =l.longestIncreasingSubsequence1(nums);
        System.out.println(re);
    }


     /**
      * @desc:  n*n
      * @date:   2018/9/10 9:01
      */
    public int longestIncreasingSubsequence(int[] nums) {

        if(nums==null||nums.length==0){
            return 0;
        }

        /*
          dp[i] 表示以nums[0，，，i]的最长递增字串  结尾元素在i左边且比nums[i]小的LIS的最大值
          dp[i]=max(dp[j])+1    nums[j]<nums[i]&&j<i
         */
       int len = nums.length;
       int[] dp = new int[len];

       dp[0]=1;
        int maxLongest=dp[0];       //初始最大的长度
       for(int i=1;i<len;i++){
           for(int j=i-1;j>=0;j--){
               if(nums[j]<nums[i]){
                   dp[i]=Math.max(dp[i],dp[j]);
               }
           }
           dp[i]+=1;
           maxLongest=Math.max(dp[i],maxLongest);
       }
        return maxLongest;
    }







    public int longestIncreasingSubsequence1(int[] nums) {

        if(nums==null||nums.length==0){
            return 0;
        }
          /*
          dp[i] 表示以nums[0，，，i]的最长递增字串  结尾元素在i左边且比nums[i]小的LIS的最大值
          dp[i]=max(dp[j])+1    nums[j]<nums[i]&&j<i

          help[i] 表示的递增字串长度为i+1的结尾的的最小值
         */
        int len = nums.length;
        int[] dp = new int[len];
        int[] help= new int[len];
        dp[0]=1;
        help[0]=nums[0];
        int max=1;

        for(int i=1;i<len;i++){
           int temp= binarySearch(help,0,max,nums[i]);
           if(temp!=-1){
               help[temp]=nums[i];
               dp[i]=temp+1;
           }else{
               help[max]=nums[i];
               max++;
               dp[i]=max;
           }
        }
        return max;
    }

     /**
      * @desc:  查找出第一个比target 大的数 ，如果找不到返回-1
      * @date:   2018/9/10 9:17
      */
    public int binarySearch(int[] nums,int start,int end,int target){

      while(start<=end){
          if(end-start<=1){  //此时的区间长度为1或者2
              if(nums[start]>=target) return start;
              if(nums[end]>=target) return end;
              return -1;
          }

          int mid = (start+end)/2;
          if(nums[mid]>target){
              end=mid;
          }else if(nums[mid]<target){
              start=mid+1;
          }else{
              return mid;
          }
      }

      return -1;
    }
}
