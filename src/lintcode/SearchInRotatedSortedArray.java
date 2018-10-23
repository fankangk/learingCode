package lintcode;

/**
 * @Auther: fankk
 * @Date: 2018/10/22 08:47
 * @Desc:
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args){

        SearchInRotatedSortedArray s =new SearchInRotatedSortedArray();
       int[] arr={2,2,2,3,1};
       boolean re = s.search(arr,1);
       System.out.println(re);
    }
     /**
      * @desc:  设有一个排序的按未知的旋转轴旋转的数组。给定一个目标值进行搜索，如果在数组中找到目标值返回数组中的索引位置，否则返回-1。
      * @date:   2018/10/22 8:56
      * @param:
      * @return:
      */
    public boolean search(int[] A, int target) {
        // write your code here
        int len =A.length;
        int left=0;
        int right=len-1;

        while(left<=right) {
            int mid= (left+right+1)/2;
            if(A[mid]==target){
                return true;
            }
            while(A[mid] ==A[left]){
                left++;

            }
            while(A[mid] ==A[right]){
                right--;

            }
            if (A[mid] >=A[left]) {     //left --mid 递增区间

                if (A[left] <= target && target <A[mid]) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            }else{        //mid --right 递增区间
                if (A[mid] < target && target <= A[right]) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
        }
        return false;
    }
}
