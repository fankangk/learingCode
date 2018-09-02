package sort;

/**
 * Author:  fankk
 * Date:    2018/8/30 15:05
 * Desc:
 */
public class Test {
    public static void main(String[] args){

       int[] arr = {2,4,5,8,1,11,12};
        int[] arr1 = null;
      //  BubbleSort b = new BubbleSort();
      //  b.bubbleSort1(arr);
        QuickSort ss = new QuickSort();
        ss.quickSort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+"  " );
        }
    }
}
