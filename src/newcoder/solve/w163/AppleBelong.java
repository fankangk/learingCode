package newcoder.solve.w163;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Author:  fankk
 * Date:    2018/8/14 10:21
 * Desc:
 */
public class AppleBelong {
    
     /**
       *@desc:  在果园里有N堆苹果，每堆苹果的数量为ai，小易希望知道从左往右数第x个苹果是属于哪一堆的
      *
      * 第一行一个数n(1 <= n <= 105)。
        第二行n个数ai(1 <= ai <= 1000)，表示从左往右数第i堆有多少苹果
        第三行一个数m(1 <= m <= 105)，表示有m次询问。
        第四行m个数qi，表示小易希望知道第qi个苹果属于哪一堆
      *
       *@author:  fankk
       *@date:   2018/8/14 10:21
       *@param:  
       *@return: 
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = Integer.parseInt(str);
        int[] appleNum = new int[n];
        String str1 = sc.nextLine();
        String[] var1=str1.split(" ");
        for(int i=0;i<n;i++){
            appleNum[i] =Integer.parseInt(var1[i]);
        }
        String str2 = sc.nextLine();
        int m = Integer.parseInt(str2);
        int[] target  =new int[m];
        int[] target1  =new int[m];
        String str3 = sc.nextLine();
        String[] var3= str3.split(" ");
        for(int i=0;i<m;i++){
            target[i] =Integer.parseInt(var3[i]);
            target1[i] =Integer.parseInt(var3[i]);
        }
        Arrays.sort(target);
       Map map =  belong(target,appleNum);
       for(int i=0;i<m;i++){
           Integer temp = target1[i];
           System.out.println(map.get(temp));
       }
    }
     /**
       *@author:  fankk
       *@date:   2018/8/14 10:25
       *@param:  int[] taget 询问的目标 数值是按照从小到大排序的
      *         int[] appleNum  每堆对应的苹果数量
       *@return:
     */
    public static Map<Integer,Integer> belong(int[] taget,int[] appleNum){

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int currSum=0;
        int appleLen =appleNum.length;
        int tagetLen = taget.length;
        int targetIndex=0;   //表示当前的target 遍历
        for(int i=0;i<appleLen;i++){
            currSum+=appleNum[i];
            while(targetIndex<tagetLen&&taget[targetIndex]<=currSum ){
                map.put(taget[targetIndex],i+1);
                targetIndex++;
            }
            if(targetIndex>=tagetLen) {break;}
        }
        return map;
    }
}
