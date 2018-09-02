package sort;

/**
 * Author:  fankk
 * Date:    2018/8/30 14:46
 * Desc:  插入排序 从小到大排序
 */
public class InsertSort {

    public int[]  insertSort(int[] arr){
        if(arr==null||arr.length<=1){
            return arr;
        }

        for(int i=1;i<arr.length;i++){
            int temp=i-1;
            int tempValue = arr[i];
            //arr[0,,,i-1]已经排序好，
            while(temp>=0 &&tempValue<arr[temp]){
                arr[temp+1]=arr[temp];
                temp--;
            }
            arr[temp+1]=tempValue;
        }
        return arr;
    }
}
