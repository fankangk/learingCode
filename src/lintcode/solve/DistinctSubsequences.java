package lintcode.solve;

/**
 * @Auther: fankk
 * @Date: 2018/11/8 14:42
 * @Desc: 给出字符串S和字符串T，计算S的不同的子序列中T出现的个数
 */
public class DistinctSubsequences {

    public static void main(String[] args){
        DistinctSubsequences d =new DistinctSubsequences();
       int re= d.numDistinct("asblasdbladjbadjab","asb");
       System.out.print(re);

    }
    public int numDistinct(String S, String T) {

        int sLen=S.length();
        int tLen=T.length();
        if(tLen==0){
            return 1;
        }
        if(sLen<tLen){
            return 0;
        }
       int [][] dp = new int[sLen+1][tLen+1];
      for(int i=0;i<sLen;i++){
          dp[i][0]=1;
      }
      //dp[i][j]=dp[i-1][j]+dp[i-1][j-1]
      for(int i=1;i<=tLen;i++){
          for(int j=1;j<=sLen;j++){
              if(S.charAt(j-1)==T.charAt(i-1)){
                  dp[j][i]=dp[j-1][i]+dp[j-1][i-1];
              }else{
                  dp[j][i]=dp[j-1][i];
              }
          }
      }
      int re=0;
      for(int i=0;i<=sLen;i++){
          re+=dp[i][tLen] ;
      }

      return dp[sLen][tLen];
    }

}
