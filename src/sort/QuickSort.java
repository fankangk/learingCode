package sort;

/**
 * Author:  fankk
 * Date:    2018/8/30 15:53
 * Desc:    快速排序  //非递归？
 */
public class QuickSort {

    public void quickSort(int[] arr,int start,int end){
      /*
      *  首先选择基数 ，
      *  从后往前寻找比基数小的数据（一定要首先开始），从前往后找比基数大的数
      *  递归的调用
      * */
      if(start>=end) {       //退出的条件
          return;
      }

      int start1=start;
      int end1=end;
      int  baseValue = arr[start1];
      while(start1<=end1){

          while(start1<end1 && arr[end1]>baseValue){
              end1--;
          }
          if(start1==end1){
              arr[end1]=baseValue;
              break;
          }
          arr[start1++]=arr[end1];

          while(start1<end1 && arr[start1]<baseValue){
              start1++;
          }
          if(start1==end1){
              arr[start1]=baseValue;
              break;
          }
          arr[end1--]=arr[start1];
      }
        quickSort(arr,start,end1-1);
        quickSort(arr,end1+1,end);
    }
}
