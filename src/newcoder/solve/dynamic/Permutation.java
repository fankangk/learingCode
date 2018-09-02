package newcoder.solve.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Author:  fankk
 * Date:    2018/7/27 10:35
 * Desc:
 */
public class Permutation {


     /**
       *@desc:   确定某字符串的所有排列组合
       *@author:  fankk
       *@date:   2018/7/27 10:35
     */
    public ArrayList<String> getPermutation(String A) {
        // write code here
        ArrayList<String> reList = new ArrayList<String>();
        int len = A.length();
        if(len == 0){
            return reList;
        }
        char[] str = new char[len];
        for(int i=0;i<len;i++){
            str[i]=A.charAt(i);
        }
        Arrays.sort(str);
        ArrayList<String> re = new ArrayList<String>();
        re =getPermutation(str,str.length-1);
        Collections.sort(re);
        Collections.reverse(re);

        return re;

    }
    public ArrayList<String> getPermutation(char[] str ,int n) {
        ArrayList<String> reList = new ArrayList<String>();
        if(n==0){
            String s = new String() ;
            s = String.valueOf(str[0]);
            reList.add(s);
            return reList;
        }
        ArrayList<String> re = new ArrayList<String>();
        re = getPermutation(str,n-1);
        reList =  insertIntoString(re,str[n]);

        return reList;
    }

     public static void main(String[] args){
         Permutation p = new Permutation();
         String s="ABC";
         char c='a';
         ArrayList<String> re =p.getPermutation(s);
         System.out.println(re.toString());


     }


    public ArrayList<String> insertIntoString(ArrayList<String> strList,char c){
        ArrayList<String> reList = new ArrayList<String>();
        for(int i=0;i<strList.size();i++) {
            String str = strList.get(i);
            for (int index = 0; index <= str.length(); index++) {
                StringBuffer temp = new StringBuffer(str.substring(0, index));
                temp.append(c);
                temp.append(str.substring(index, str.length()));
                reList.add(temp.toString());
            }
        }
        return reList;
    }
}
