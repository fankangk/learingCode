package newcoder.sort;

import java.util.Scanner;

/**
 * Author:  fankk
 * Date:    2018/7/13 13:29
 * Desc:
 */
public class maxArea {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] heighs = new int[n];
        for(int i=0;i<n;i++){
            heighs[i]=   scan.nextInt();
        }


        int re=0;
        int len= heighs.length;
        int[] area = new int[len];

        area[0]=heighs[0];
        re =  area[0];

        for(int i=1;i<len;i++){
            if(heighs[i]>=heighs[i-1]){
                area[i]=area[i-1]+heighs[i];
            }else{
                area[i]=heighs[i];
            }
            if(re<area[i]){
                re = area[i];
            }
        }



        System.out.println(re);






    }
    public int getMaxArea(int[] heighs){
        int re=0;
        int len= heighs.length;
        int[] area = new int[len];
        //初始化为0
        for(int i=0;i<len;i++){
            area[i]=0;
        }
        area[0]=heighs[0];
        re =  area[0];
        for(int i=1;i<len;i++){
           if(heighs[i]>=heighs[i-1]){
               area[i]=area[i-1]+heighs[i];
           }else{
               area[i]=heighs[i];
           }
           if(re<area[i]){
               re = area[i];
           }
        }
        return re;
    }
}
