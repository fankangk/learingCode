package newcoder.solve.simulation;

import java.util.Scanner;

/**
 * Author:  fankk
 * Date:    2018/7/27 16:40
 * Desc:
 */
public class HardChoice {


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 =sc.nextLine();
       int  n=Integer.valueOf(s1);
        int[] m =new int[n];
        String str = sc.nextLine();
       String[] s = str.split(" ");
       for(int i=0;i<n;i++){
           m[i]=Integer.valueOf(s[i]);
       }
      int re=  hardChoice(m);
       System.out.println(re);
    }
    /*
         出一个含有n个数字的序列a1,a2,a3,...an，可以进行以下操作：
        一次操作定义为对这个序列的每个数字进行以下两种改变之一：
         1.ai ÷ 2
         2.ai × 3
        每一次的操作中，必须保证至少有一个数字是第1种改变；并且经过每次操作后，每一个数字都必须是整数。

    牛牛得知，每进行一次操作，他就可以得到一颗西瓜糖，，他最多可以得到多少颗西瓜糖。
     */
    public static int  hardChoice(int[] a){
        int count=0;
       int len =a.length;
       for(int i=0;i<len;i++){
           while(a[i]%2==0){
                 count++;
                 a[i]=a[i]/2;
           }
       }
        return count;
    }
}
