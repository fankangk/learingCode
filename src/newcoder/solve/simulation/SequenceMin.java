package newcoder.solve.simulation;

import java.util.Scanner;

/**
 * Author:  fankk
 * Date:    2018/8/6 16:11
 * Desc:
 */
public class SequenceMin {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String s1 =sc.nextLine();
        String[] str = s1.split(" ");
        int  n=Integer.valueOf(str[0]);
        int  k=Integer.valueOf(str[1]);
        int[] number = new int[n];
        String s2 =sc.nextLine();
        String[] str2 = s2.split(" ");
        for(int i=0;i<n;i++){
            number[i]=Integer.valueOf(str2[i]);
        }
        SequenceMin m =new SequenceMin();
        int re =m.countNumber(number,k);
        System.out.println(re);
    }
    public int countNumber(int[] number,int k){
        if(number.length<=k){
            return 1;
        }
      int index =  getMinIndex(number);
      int beforeNumber = index;
      int afterNumber =number.length-1-index;
      int sum=0;
      sum+=beforeNumber/(k-1);
      sum+=afterNumber/(k-1);
      if (beforeNumber%(k-1)+afterNumber%(k-1)>k){
          sum+=2;
      }else{
          sum++;
      }
      return sum;
    }
    public int getMinIndex(int[] number){
        int min=number[0];
        int minNumberIndex=0;
        for(int i=1;i<number.length;i++){
            if(number[i]<min){
                min=number[i];
                minNumberIndex=i;
            }
        }
       return  minNumberIndex;
    }
}
