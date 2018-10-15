package lintcode;

/**
 * @Auther: fankk
 * @Date: 2018/10/12 14:55
 * @Desc:  在数组中找到第k大的元素
 */
public class KthLargestElement {

    /*
      1 .用堆排序
      2. 快速排序
     */
    public static void main(String[] args){
        KthLargestElement k = new KthLargestElement();
        int[] arr={9,3,2,4,8};
      int re =  k.kthLargestElement(3,arr);
      System.out.println(re);
    }
    public int kthLargestElement(int n, int[] nums) {

        creatMaxHeap(nums);
        for(int i=0;i<n;i++){
            adjustHeap(nums,0,nums.length-1-i);
        }
        return nums[nums.length-n];
    }


     /**
      * @desc:   构建最大堆
      * @date:   2018/10/12 14:59
      * @param:
      * @return:
      */
    public void creatMaxHeap(int[] arr){
        int len = arr.length;
        for(int i=(len+1)/2;i>=0;i--){
            int children = i*2+1;
            if(children<len && children+1<len && arr[children]<arr[children+1]){
                children++;
            }
            if(children<len && arr[i]<arr[children]){
                swap(arr,i,children );
            }
        }
    }

     /**
      * @desc:   堆调整
      * @date:   2018/10/15 8:43
      * @param:
      * @return:
      */
    public void adjustHeap(int[] arr,int start,int end){

        if(start>=end){
            return ;
        }
        swap(arr,start,end);
        int parent =start;
        int children =parent*2+1;
        while(parent<end){
            if(children<end && children+1<end && arr[children]<arr[children+1]){
                children++;
            }
            if(children<end && arr[parent]<arr[children]){
                swap(arr,parent,children );
            }
            parent=children;
            children=parent*2+1;
        }


    }



    public  int partition(int[] arr,int start,int end,int k){
        if (start >= end) {
            return arr[k];
        }
        int left = start, right = end;
        int pivot = arr[(start + end) / 2];
        while (left <= right) {
            while (left <= right && arr[left] < pivot) {
                left++;
            }
            while (left <= right && arr[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }

        if (k <= right) {
            return partition(arr, start, right, k);
        }
        if (k >= left) {
            return partition(arr, left, end, k);
        }
        return arr[k];

    }

     public void swap(int[] arr,int m1,int m2 ){
        int temp= arr[m1];
         arr[m1]=arr[m2];
         arr[m2]=temp;
     }

}