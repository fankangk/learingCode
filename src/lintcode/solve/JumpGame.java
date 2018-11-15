package lintcode.solve;

/**
 * @Auther: fankk
 * @Date: 2018/11/8 14:15
 * @Desc:
 */
public class JumpGame {
    public int jump(int[] A) {
        if(A==null||A.length==1){
            return 0;
        }
     int count=0;
     int left=0;
     int right=0;
     int  maxIndex=0;
    while(right<A.length-1){
        for(int i=left;i<=right;i++){
            maxIndex=Math.max(maxIndex,i+A[i]);
        }
        if(maxIndex==right){
            return -1;
        }
        count ++;
        left=right+1;
        right=maxIndex;

    }
    return count;
    }
}
