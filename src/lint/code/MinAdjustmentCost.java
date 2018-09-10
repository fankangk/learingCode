package lint.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: fankk
 * @Date: 2018/9/8 15:21
 * @Desc:
 */
public class MinAdjustmentCost {


    public static void main(String[] args){
        MinAdjustmentCost m= new MinAdjustmentCost();
        List<Integer> A =new ArrayList<Integer>();
        A.add(1);
        A.add(4);
        A.add(2);
        A.add(3);
      int re =  m.MinAdjustmentCost(A,1);
      System.out.println(re);
    }


     /**
      * @desc:   给一个整数数组，调整每个数的大小，使得相邻的两个数的差不大于一个给定的整数target
      *          ，调整每个数的代价为调整前后的差的绝对值，求调整代价之和最小是多少。
      * @date:   2018/9/8 15:21
      * @param:
      * @return:
      *
      * dp[i][j]=dp[i-1][j]+abs(A[i-1]-j)
      */
    public int MinAdjustmentCost(List<Integer> A, int target) {
        // write your code here
        int len= A.size();
        //dp[i][j]  表示A[i-1]调整为j 的代价
        int lie=101;
        int[][]  dp = new int[len+1][lie];
        //初始化dp，dp[0][] 为0 ，其余的为大于100的值（应为调整的最大代价99）
        for(int i=0;i<lie;i++){
            dp[0][i]=0;
        }
        for(int row=1;row<=len;row++){
            for(int column=0;column<lie;column++){
                dp[row][column]=Integer.MAX_VALUE;
            }
        }

        for(int i=1;i<=len;i++){
            for(int j=0;j<lie;j++){
                for(int k=0;k<=100;k++){
                    if(Math.abs(j-k)<=target){
                        dp[i][j]=Math.min(dp[i-1][k]+Math.abs(A.get(i-1)-j),dp[i][j]);
                    }
                }
            }
        }

        int cost=dp[len][0];
        for(int i=0;i<=100;i++)
        {
            cost=Math.min(cost,dp[len][i]);
        }
        return cost;
    }
}
