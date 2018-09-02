package sort;

/**
 * Author:  fankk
 * Date:    2018/8/30 15:39
 * Desc:   选择排序
 */
public class SelectSort {

    public int[] selectSort(int[] arr){

        if(arr==null||arr.length<=1){
            return arr;
        }

       for(int i=0;i<arr.length-1;i++){
            int maxIndex=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[maxIndex]<arr[j]){
                    maxIndex=j;
                }
            }
            int temp = arr[maxIndex];
            arr[maxIndex] =arr[i];
            arr[i]=temp;
       }
        return arr;
    }
}
