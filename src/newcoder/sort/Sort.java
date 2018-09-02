package newcoder.sort;
/**
 * Author:  fankk
 * Date:    2018/7/16 9:27
 * Desc:    排序算法
 */
public class Sort {


    /*
    *@Desc:  冒泡排序
    *@Author  fankk
    *@Date    2018/7/16
    */
    public int[] bubbleSort(int[] arr){
        int len=arr.length;
        for(int i=0;i<len;i++){  //外层循环
           for(int j=0;j<len-i-1;j++){
                if(arr[j]>arr[j+1]){  //交换数组
                    swap(arr,j,j+1);
                }
           }
        }
        return arr;
    }

     /*
     *@Desc:    选择排序
     *@Author  fankk
     *@Date    2018/7/16
     */
    public int[] selectSort(int[] arr){

        int len=arr.length;
        for(int i=0;i<len;i++){
            int min=i;
            for(int j=i+1;j<len;j++){
                if(arr[min]>arr[j]){
                    min=j;
                }
            }
            if(min!=i){
                swap(arr,i,min);
            }
        }
        return arr;
    }

     /*
     *@Desc:   插入排序
     *@Author  fankk
     *@Date    2018/7/16
     */
    public int[] insertSort(int[] arr){

        int len =arr.length;
        for(int i=1;i<len;i++){
            if(arr[i]<arr[i-1]){
                int temp=arr[i];
                int j;
                for( j=i-1;j>=0&&temp<arr[j];j--){
                    arr[j+1]=arr[j];
                }
                arr[j+1]=temp;
            }
        }
        return arr;
    }


     /*
     *@Desc:    堆排序
     *@Author  fankk
     *@Date    2018/7/16
     */
   public int[] heapSort(int[] arr){

       //构建最大堆
       for (int i = arr.length / 2; i >= 0; i--) {
           heapAdjust(arr, i, arr.length - 1);
       }

       //交换元素，
       for (int i = arr.length - 1; i > 0; i--) {
           swap(arr,0,i);
           heapAdjust(arr, 0, i);
       }

       return arr;
   }

     /*
     *@Desc:   堆调整
     *@Author  fankk
     *@Date    2018/7/16
     */
    public void heapAdjust(int[] arr,int parent,int len){

      int child = parent*2+1;
      while(child<len){
          if(child+1<len && arr[child] < arr[child + 1]){child++;}
          if(arr[parent]<arr[child]){
             swap(arr,parent,child);
          }
          parent = child;
          child = child*2+1;
      }

    }


    public void  shellSort(int[] arr){
        int len=0;
        int gap=len/2;
        while(gap>0) {
            shellSort1(arr, gap);
            gap=gap/2;
        }
    }
 /*
 *@Desc:  希尔排序
 *@Author  fankk
 *@Date    2018/7/16
 */
    public void  shellSort1(int[] arr,int gap){

        int len =arr.length;
        for(int i=0;i<gap;i=i+1){
                int index = i+gap;
                while(index<len){

                }
            }

    }


    public static void swap(int[] arr,int i,int j){
        int temp = arr[j];
        arr[j]=arr[i];
        arr[i]=temp;
    }




}
