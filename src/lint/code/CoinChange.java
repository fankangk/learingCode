package lint.code;

/**
 * @Auther: fankk
 * @Date: 2018/9/8 15:56
 * @Desc:
 */
public class CoinChange {


    public static void main(String[] args){


     
        int[] nums={1,2,4};
        CoinChange c = new CoinChange();
        int re =  c.coinChange(nums,32000);
        System.out.println(re);
    }

    
    
     /**
      * @desc:  给出不同面额的硬币以及一个总金额.
      *         写一个方法来计算给出的总金额可以换取的最少的硬币数量.
      *         如果已有硬币的任意组合均无法与总金额面额相等, 那么返回 -1.
      * @date:   2018/9/8 15:57
      * @param:  int[] coins 不同面额的硬币
      *          amount     一个总金额.
      * @return:
      *
      * @remarks  当amount较大时，时间比较长，应该考虑其他的问题
      */
    public int coinChange(int[] coins, int amount) {
        // write your code here
        int row=coins.length;
        //注意数组的初始化
        int[][] dp = new int[row][amount+1];
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0){
                dp[0][i]=i/coins[0];
            }else{
                dp[0][i]=-1;
            }
        }

       for(int i=1;i<row;i++){
            for(int j=0;j<=amount;j++){
                int kLen=j/coins[i];
                dp[i][j] = -1;
                for(int k=0;k<=kLen;k++){
                   // dp[i][j]=min(dp[i-1][j-k*coins[i]],dp[i][j])
                    if(dp[i-1][j-k*coins[i]]==-1) {
                        continue;
                    }else{
                        if(dp[i][j]==-1){
                            dp[i][j]=dp[i-1][j-k*coins[i]]+k;
                        }else{
                            dp[i][j]=Math.min(dp[i-1][j-k*coins[i]]+k,dp[i][j]);
                        }
                    }
                }
            }
       }

       return dp[row-1][amount];

    }
}
