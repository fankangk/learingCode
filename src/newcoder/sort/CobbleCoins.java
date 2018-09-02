package newcoder.sort;

import java.util.Scanner;

/**
 * Author:  fankk
 * Date:    2018/7/13 10:39
 * Desc:
 */
public class CobbleCoins {

    public static void main(String[] args){
//dp[i][j] = sum(dp[i-1][j - k*coins[i-1]])


 Scanner scan = new Scanner(System.in);

 int sum = scan.nextInt();


 int[]   coins={1,5,10,20,50,100 };

 int coinLength = coins.length;

 int[][] dp = new int [coinLength+1][sum+1];

 for(int i=0;i<=coinLength;i++){
        dp[i][0]=1;

 }
    for(int i=1;i<=coinLength;i++){   //coins数组
        for(int j=1;j<=sum;j++){
            dp[i][j]=0;
            for(int k=0;k<=j/coins[i-1];++k){
                dp[i][j]+=dp[i-1][j-k*coins[i-1]];
            }
        }
    }

        Long re =0L;
        for(int i=0;i<=coinLength;i++){
           re+=dp[coinLength][sum] ;

        }

        System.out.println(dp[coinLength][sum]);
    }

    /**
     * Author:  fankk
     * Date:    2018/7/13 13:54
     * Desc:
     */
    public static class LongestSubstring {


        public int getLongestCommonString(String str1, String str2) {

           /*
           动态规划：若str1的第i个字符与str2的第j字符相同 则
                    dp[i][j]=dp[i-1][j-1]+1;
            */
           int re=0;
           int len1 = str1.length();
           int len2 = str2.length();
           int[][] dp = new int[len1][len2];
           //初始化dp
            for(int i=0;i<len1;i++){
                for(int j=0;j<len2;j++){
                    dp[i][j]=0;
                }
            }

           for(int i=0;i<len1;i++){
               for(int j=0;j<len2;j++){
                   if(str1.charAt(i)==str2.charAt(j)){
                      if(i>0 && j>0){
                          dp[i][j]=dp[i-1][j-1]+1;
                      }else{
                          dp[i][j]=1;
                      }
                   }
                   if(re<dp[i][j]) {
                       re=dp[i][j];
                   }
               }
           }

           return re;
        }
    }
}
