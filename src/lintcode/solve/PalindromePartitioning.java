package lintcode.solve;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: fankk
 * @Date: 2018/11/6 16:02
 * @Desc:  给定一个字符串s，将s分割成一些子串，使每个子串都是回文 返回s符合要求的的最少分割次数。
 */
public class PalindromePartitioning {


    public static void main(String[] args){
        String s = "efe";
        PalindromePartitioning p = new PalindromePartitioning();

     List re= p.partition(s);

     System.out.println(re.toString());

    }
    public int minCutNumber(String s) {
        if(isPalindrome(s)){
            return 0;
        }
       int min=s.length()-1;
       int maxCut = s.length()-1;
        for(int i=1;i<s.length();i++){
            if(isPalindrome(s.substring(0,i))){
                String  restString = s.substring(i,s.length());
                min= Math.min(minCutNumber(restString),min);
            }
        }

        return min+1;
    }


    public boolean isPalindrome(String s){
        if(s.length()<=1){
            return true;
        }
        int left=0;
        int right =s.length()-1;
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

     /**
      * @desc:
      * @date:   2018/11/6 17:19
      * @param:
      * @return: boolean[i][j] 表示S[i]到S[j]是否是回文串
      */
    public boolean[][] calcPalin(String s, int n) {
        boolean[][] isPalin = new boolean[n][n];

        int i, j, p;
        //初始化isPalin，
        for (i = 0; i < n; ++i) {
            for (j = 0; j < n; ++j) {
                isPalin[i][j] = false;
            }
        }
        /*
          从一个字符串为中心向两边扩展，判断是否为回文串，
           1.选择一个字符为中心向两边扩展 两种情况
              1.) 回文串的长度为奇数
              2.)  回文串的长度为偶数

         */

        //为奇数情况的
       for( p =0;p<s.length();p++){
           i=p;
           j=p;
           while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
               isPalin[i][j]=true;
               i--;
               j++;

           }
       }

        //为偶数情况的
        for( p =0;p<s.length()-1;p++){
            i=p;
            j=p+1;
            while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
                isPalin[i][j]=true;
                i--;
                j++;

            }
        }
         return isPalin;
    }

    public int minCut(String s) {
        int len = s.length();
        if (len== 0) {
            return 0;
        }
        int[] dp = new int[len+1];
        for(int i=0;i<len+1;i++){
            dp[i]=i;
        }
        boolean[][] isPalindrome = calcPalin(s,s.length());
        for (int i = 1; i <= s.length(); i++) {
            if (isPalindrome[0][i - 1]) {
                dp[i]=0;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (isPalindrome[j][i - 1]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[len];

    }
    /*******************************************************/
    public List<List<String>> partition(String s) {
        // write your code here
        boolean[][] isPalindrome =calcPalin(s,s.length());
        List<List<String>> re= partition(s,0,s.length(),isPalindrome);
        return re;
    }

     /**
      * @desc:   给定一个字符串s，将s分割成一些子串，使每个子串都是回文串。
      * @date:   2018/11/7 9:23
      * @param:  String s 目标字符串
      *          int start, 目标字符串的起始位置 包含start
      *          int end    目标字符串的结束始位置 不含end
      *          boolean[][] calcPalin  表示S[i]到S[j]是否是回文串
      * @return:
      */
    public List<List<String>> partition(String s,int start,int end,boolean[][] isPalindrome) {
        List<List<String>>  re= new ArrayList<List<String>>();
       if(start>=end){
           return re;
       }
        for(int i =start;i<end-1;i++){
                if(isPalindrome[start][i]){ //会丢失整个字符就是回文字符传的情况
                    List<List<String>> list=partition( s,i+1, end,isPalindrome);
                    if(list!=null && list.size()>0){
                        for(List<String> temp:list ){
                            temp.add(0,s.substring(start,i+1));
                            re.add(temp);
                        }
                    }
                }


        }
        if(isPalindrome[start][end-1]){
            List<String> var1= new ArrayList<String>();
            var1.add(s.substring(start,end));
            re.add(var1);
        }
        return re;
    }
}
