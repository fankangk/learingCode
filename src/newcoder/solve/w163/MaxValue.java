package newcoder.solve.w163;

import java.util.Scanner;

/**
 * Author:  fankk
 * Date:    2018/8/14 9:46
 * Desc:
 */
public class MaxValue {

     /**
       *@desc: 你知道了小易对一堂课每分钟知识点的感兴趣程度，并以分数量化，
        *以及他在这堂课上每分钟是否会睡着，你可以叫醒他一次，这会使得他在接下来的k分钟内保持清醒。
        * 你需要选择一种方案最大化小易这堂课听到的知识点分值。
      *
      * 第一行 n, k (1 <= n, k <= 105) ，表示这堂课持续多少分钟，以及叫醒小易一次使他能够保持清醒的时间。
      * 第二行 n 个数，a1, a2, ... , an(1 <= ai <= 104) 表示小易对每分钟知识点的感兴趣评分。
      * 第三行 n 个数，t1, t2, ... , tn 表示每分钟小易是否清醒, 1表示清醒。
      *
       *@author:  fankk
       *@date:   2018/8/14 9:47
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] tar = str.split(" ");
        int n = Integer.parseInt(tar[0]);
        int k = Integer.parseInt(tar[1]);
        String str1 = sc.nextLine();
        String[] tar1 = str1.split(" ");

        String str2 = sc.nextLine();
        String[] tar2 = str2.split(" ");

        int[] value = new int[n];
        int[] minute = new int[n];
        for(int i=0;i<n;i++){
            value[i]=Integer.parseInt(tar1[i]);
        }
        for(int i=0;i<n;i++){
            minute[i]=Integer.parseInt(tar2[i]);
        }
        int re =countScor( value,minute, k);
        System.out.println(re);
    }
     /**
       *@desc:
       *@author:  fankk
       *@date:   2018/8/14 9:53
       *@param:    int[] value  每分钟获取的知识点的价值
      *            int[] minute  每分钟是否清醒 1表示清醒
      *            int k          叫醒一次，持续清醒的时间 分钟
       *@return:
     */
    public static int  countScor(int[] value,int[] minute,int k){
      int  lenMinute = minute.length;
      int  wakeValue = 0;
      int maxSleepValue = 0;
      for(int i=0;i<lenMinute;i++){
         if(minute[i]==1) {
             wakeValue+=value[i];     //清醒时获取的 知识点
         }else{
             int currValue=0;        //此时刻叫醒 额外获取的知识点
             for(int j=i;j<lenMinute&&j<i+k;j++){
                 if(minute[j]!=1){
                     currValue+=value[j];
                 }
             }
             if(currValue>maxSleepValue){
                 maxSleepValue=currValue;
             }
         }
      }

      return wakeValue+maxSleepValue;
    }
}
