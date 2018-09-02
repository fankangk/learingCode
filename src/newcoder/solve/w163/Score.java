package newcoder.solve.w163;

import java.util.Scanner;

/**
 * Author:  fankk
 * Date:    2018/8/14 9:23
 * Desc:
 */
public class Score {

     /**
       *@desc:   荧幕上一共有 n 列，每次都会有一个 1 x 1 的方块随机落下，
      * 在同一列中，后落下的方块会叠在先前的方块之上，当一整行方块都被占满时，这一行会被消去，并得到1分。
      * 当玩到第 m 个方块落下时他觉得太无聊就关掉了，小易希望你告诉他这局游戏他获得的分数
      * 第一行两个数 n, m
      * 第二行 m 个数，c1, c2, ... , cm ， ci 表示第 i 个方块落在第几列
      * 其中 1 <= n, m <= 1000, 1 <= ci <= n
      *
       *@author:  fankk
       *@date:   2018/8/14 9:25
     */
     private static int count =0;
     public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
         String str = sc.nextLine();
         String[] tar = str.split(" ");
         int len = Integer.parseInt(tar[0]);
         int[] row = new int[len];
         int num = Integer.parseInt(tar[1]);
         String str1 = sc.nextLine();
         String[] tar1 = str1.split(" ");
         for(int i=0;i<num;i++){
             int lie =  Integer.parseInt(tar1[i])-1;
             row[lie]++;
         }
      int re =   findMin(row,len);
      System.out.println(re);
    }
    public static int findMin(int[] heigh,int len){
         int min = heigh[0];
        for(int i=1;i<len;i++){
            if(heigh[i]<min) {
                min= heigh[i];
            }
        }
        return min;
    }

}
