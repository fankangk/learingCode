package newcoder.solve.didi;

import java.util.Scanner;

/**
 * Author:  fankk
 * Date:    2018/7/19 15:20
 * Desc:
 */
public class EqualTarget {


    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        String str = sc.nextLine();
        String[] st = str.split(" ");
        int n=Integer.valueOf(st[0]);
        int target=Integer.valueOf(st[1]);

        String str2 = sc.nextLine();
        String[] st2 = str2.split(" ");
        int[] arr =new int[n];
        for(int i=0;i<n;i++){
          arr[i]=Integer.valueOf(st2[i]);
        }
        long re =countDifferentCircumstances( arr, target);
        System.out.println(re);

    }
    public static long countDifferentCircumstances(int[] arr,int target){
        /*
        dp[i][j]=dp[i-1][sum-arr[i]]
         */
        long count =0L;
        int len=arr.length;
        //数组的初始化0
        int[][] dp = new int[len+1][target+1];
       for(int i=0;i<=len;i++){
               dp[i][0]=1;
       }
        dp[0][0]=1;
       for(int i=1;i<=len;i++){
           for(int j=0;j<=target;j++){
               dp[i][j] +=dp[i-1][j];
               if(arr[i-1]<=j) {
                   dp[i][j] += dp[i-1][j-arr[i-1]];
               }
           }
       }



        return dp[len][target];
    }
}
