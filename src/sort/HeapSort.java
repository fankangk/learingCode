package sort;

/**
 * Author:  fankk
 * Date:    2018/8/30 16:40
 * Desc:
 */
public class HeapSort {


    public void heapSort(int[] arr){

        for (int i = arr.length / 2; i >= 0; i--) {
            heapAdjust(arr, arr.length - 1,i);
        }

        //交换元素，
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr,0,i);
            heapAdjust1(arr, i, 0);
        }



    }
    public void heapAdjust(int[] arr,int len,int index){
        /*
        构建最大堆
        left = 2*parent+1; right=  2*parent+2;
        parent =min（left ,right,parent）
         */
        int child = index*2+1;
        if(child<len){
            if(child+1<len && arr[child] < arr[child + 1]){child++;}
            if(arr[index]<arr[child]){
                swap(arr,index,child);
            }
        }

    }


    public void heapAdjust1(int[] arr,int len,int index){
        /*
        构建最大堆
        left = 2*parent+1; right=  2*parent+2;
        parent =min（left ,right,parent）
         */
        int child = index*2+1;
        while(child<len){
            if(child+1<len && arr[child] < arr[child + 1]){child++;}
            if(arr[index]<arr[child]){
                swap(arr,index,child);
            }
            index = child;
            child = child*2+1;
        }

    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[j];
        arr[j]=arr[i];
        arr[i]=temp;
    }
}
