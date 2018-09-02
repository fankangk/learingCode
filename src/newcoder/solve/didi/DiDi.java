package newcoder.solve.didi;

import java.util.Arrays;
import java.util.Scanner;


/**
 * Author:  fankk
 * Date:    2018/7/19 8:57
 * Desc:
 */
public class DiDi {

    public static void main(String[] args){

//        Scanner sc =new Scanner(System.in);
//        String str = sc.nextLine();
//        String[] st = str.split(" ");
//        int n=Integer.valueOf(st[0]);
//        int m=Integer.valueOf(st[1]);
//        int[] capacity= new int[n];
//        int[] money= new int[m];
//        int[] people= new int[m];
//        String str1 = sc.nextLine();
//        String[] stCapacity = str1.split(" ");
//        for(int i=0;i<n;i++){
//            capacity[i]=Integer.valueOf(stCapacity[i]);
//        }
//        for(int i=0;i<m;i++){
//            String str2 = sc.nextLine();
//            String[] st2 = str2.split(" ");
//            people[i]=Integer.valueOf(st2[0]);
//            money[i]=Integer.valueOf(st2[1]);
//        }
        int[]  capacity={2,4,2};
        int[] money ={3,5,7,9,10};
        int[] people={1,3,3,5,1};

        int re =maxConsumptionAmount(capacity,money,people);
        System.out.println(re);

    }



    public static int maxConsumptionAmount(int[] capacity,int[]money,int[] people){

        int maxAmount=0;
        Arrays.sort(capacity);
        sortTwoArray(money,people);

        int len = money.length-1;
        int lenCapacity =capacity.length-1;

        int maxCapacityIndex=lenCapacity;

        while(maxCapacityIndex>=0 && len>=0 ){

            //所有的capacity都小于0，跳出
            if(capacity[maxCapacityIndex]<=0){
                break;
            }

            if(people[len]<=capacity[maxCapacityIndex]){
                int i=0;
                //找出大于等于人数的座位且要最接近的
                while(i<=maxCapacityIndex && capacity[i]<people[len] ){
                    i++;
                }
                capacity[i]=-1;
                if(i==maxCapacityIndex){
                    while(i>=0&&capacity[i]<=0){i--;}
                    maxCapacityIndex=i;
                }
                maxAmount+=money[len];

                lenCapacity--;
            }
            len--;
        }


        return maxAmount;
    }


     /**
       *@desc:  两个数组是小标是1对1,即一个对象有两个属性值，首先按照money从小到大，people从小到大
       *@author:  fankk
       *@date:   2018/7/19 14:02
       *@param:int[] ,int[]
     */
    public static void sortTwoArray(int[]money,int[] people){
        int len = money.length;
        for(int i=0;i<len-1;i++){
            int min=i;
            for(int j=i+1;j<len;j++){   //根据money 排序
                if(money[j]<money[min]){
                    min =j;
                }else if(money[j]==money[min]){ //根据money相等的时候，根据people排序
                   if(people[j]<people[min]){
                       min=j;
                   }
                }
            }
          if(min!=i){
              swap(money, i,min);
              swap(people,i,min);
          }
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[j];
        arr[j]=arr[i];
        arr[i]=temp;
    }








     /**
       *@desc:    一个数组有 N 个元素，求连续子数组的最大和
       *@author:  fankk
       *@date:   2018/7/19 9:00
       *@param:  int[]
       *@return:  int
     */
    public static int getSeriesMaxSum(int[] arr){
        /*
        以结尾的连续子数组的最大和为sum[i]
        sum[i]=max(sum[i-1]+arr[i],arr[i])
        sum[0]=arr[0];
         */
     int len = arr.length;
     int[] sum = new int[len];
     int maxSum=arr[0];
     sum[0]=arr[0];
     for(int i=1;i<len;i++){
         sum[i]=Math.max(sum[i-1],0)+arr[i];
         maxSum = Math.max(sum[i],maxSum);
     }
     return maxSum;
    }
}



class PeoleMoney implements Comparable<PeoleMoney> {
    public int money;
    public int people;
    //按照 money小到大，people小到大
    public int compareTo(PeoleMoney o) {
        int result =0;
        result =this.money-o.money;
        if(0==result){
            result=this.people-o.people;
        }
        return result;
    }
}