package lintcode.solve;

/**
 * @Auther: fankk
 * @Date: 2018/11/9 09:46
 * @Desc:
 */
public class EditDistance {
    public static void main(String[] args){

        EditDistance  es = new EditDistance();

     int re=   es.minDistance("mart","karma");
     System.out.println(re);
    }
    public int minDistance(String word1, String word2) {
       int len1 =word1.length();
       int len2=word2.length();

       int[][] dp =new int[len1+1][len2+1];
       for(int i=0;i<=len1;i++){
           dp[i][0]=i;
       }
       for(int i=0;i<=len2;i++){
            dp[0][i]=i;
       }

       /*
       dp[i][j]=  dp[i-1][j]+1  删除word1 的i
                = dp[i][j-1]+1  增加
                = dp[i-1][j-1]+1; 更改
        */
       for(int i=1;i<=len1;i++){
           for(int j=1;j<=len2;j++){
               int min = Math.min(dp[i][j-1],dp[i-1][j])+1;
               if(word1.charAt(i-1)==word2.charAt(j-1)){
                   dp[i][j]=Math.min(dp[i-1][j-1],min);
               }else{
                   dp[i][j]=Math.min(dp[i-1][j-1]+1,min);
               }
           }
       }
   return dp[len1][len2];
    }
}
