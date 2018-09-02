package sort;

/**
 * Author:  fankk
 * Date:    2018/8/30 15:14
 * Desc:    冒泡排序
 */
public class BubbleSort {

    public int[] bubbleSort(int[] arr){
        if(arr==null||arr.length<=1){
            return arr;
        }

        for(int i=0;i<arr.length;i++){
          for(int j=arr.length-1;j>i;j--){
              if(arr[j]>arr[j-1]){
                  //交换数组
                 int temp=arr[j];
                  arr[j]=arr[j-1];
                  arr[j-1]=temp;
              }
          }
        }
        return arr;
    }








    public int[] bubbleSort1(int[] arr){
        if(arr==null||arr.length<=1){
            return arr;
        }

        for(int i=arr.length-1;i>0;i--){
            for(int j=0;j<i-1;j++){
                if(arr[j]>arr[j+1]){
                    //交换数组
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        return arr;
    }


}
