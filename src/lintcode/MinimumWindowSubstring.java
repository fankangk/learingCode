package lintcode;

/**
 * @Auther: fankk
 * @Date: 2018/10/15 16:05
 * @Desc:   给定一个字符串source和一个目标字符串target，
 *          在字符串source中找到包括所有目标字符串字母的子串（可以不按顺序）
 */
public class MinimumWindowSubstring {

         public String minWindow(String S, String T) {

             //统计目标字符串中各字符的数量
            int[] tarHash = new int[255];
            for(int i = 0; i < T.length(); i++){
                tarHash[T.charAt(i)]++;
            }
            int start =0,i= 0;
            // 用于记录窗口内每个字母出现次数
            int[] destHash = new int[255];

           // 记录滑窗中的出现目标字符串的数量
            int found = 0;


            //初始化 ，滑窗的起始，结束，和滑窗的大小
            int begin = -1, end = S.length(), minLength = S.length();

            for(start = i = 0; i < S.length(); i++){

                destHash[S.charAt(i)]++;
                if(destHash[S.charAt(i)] <= tarHash[S.charAt(i)]) {
                    found++;
                }
                if(found == T.length()){
                    while(start < i && destHash[S.charAt(start)] > tarHash[S.charAt(start)]){
                        destHash[S.charAt(start)]--;
                        start++;
                    }
                }

                if(i - start < minLength){
                    minLength = i - start;
                    begin = start;
                    end = i;
                }
                destHash[S.charAt(start)]--;
                found--;
                start++;
            }
            return begin == -1 ? "" : S.substring(begin,end + 1);
        }
 }
