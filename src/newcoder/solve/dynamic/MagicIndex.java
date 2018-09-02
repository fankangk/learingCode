package newcoder.solve.dynamic;

/**
 * Author:  fankk
 * Date:    2018/7/27 8:49
 * Desc:
 */
public class MagicIndex {

      /**
        *@desc:  在数组A[0..n-1]中，有所谓的魔术索引，满足条件A[i]=i。给定一个升序数组，元素值各不相同，
       *          编写一个方法，判断在数组A中是否存在魔术索引。
        *@author:  fankk
        *@date:   2018/7/27 8:50
      */
    public boolean findMagicIndex(int[] A, int n) {
        // write code here
        for(int i=0;i<n;){
            if(i>=n){
                break;
            }
            int temp =A[i];
            if(i==temp){
                return true;
            }
            i=Math.max(temp+1,i+1);
        }
        return false;
    }


     /**
       *@desc:    在数组A[0..n-1]中，有所谓的魔术索引，满足条件A[i]=i。给定一个不下降序列，元素值可能相同
       *@author:  fankk
       *@date:   2018/7/27 9:00
     */
    public boolean findMagicIndex1(int[] A, int n) {
        // write code here
        for(int i=0;i<n;){
            if(i>=n){
                break;
            }
            int temp =A[i];
            if(i==temp){
                return true;
            }
            i=Math.max(temp,i+1);
        }
        return false;
    }

}
