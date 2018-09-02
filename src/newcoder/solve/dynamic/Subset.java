package newcoder.solve.dynamic;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Author:  fankk
 * Date:    2018/7/27 9:05
 * Desc:
 */
public class Subset {

    public static void main(String[] args){

        Subset s = new Subset();
        int[] A={123,456,789};
        Arrays.sort(A);
        ArrayList<ArrayList<Integer>> relist =  s.getSubsets1(A,2);
        System.out.println(relist.toString());
    }
    /**
      *@desc:    返回某集合的所有非空子集
     *            各子集内部从大到小排序,子集之间字典逆序排序
      *@author:  fankk
      *@date:   2018/7/27 9:05
    */
    public ArrayList<ArrayList<Integer>> getSubsets1(int[] A, int n) {
        // ArrayList  [i]=getSubsets(A.N-1)+getSubsets(A.N-1).add(A[i])+A[i]
        ArrayList<ArrayList<Integer>> relist = new ArrayList<ArrayList<Integer>>();
        if(n==0){
            ArrayList<Integer> tempList1 = new  ArrayList<Integer>();
            tempList1.add(A[0]);
            relist.add(tempList1);
             return relist;
        }
        ArrayList<ArrayList<Integer>> re = getSubsets1(A,n-1);

        for(int i=0 ;i<re.size();i++){
            ArrayList<Integer> tempList = new ArrayList<Integer>();
            tempList.addAll(re.get(i));
            tempList.add(0,A[n]);

            relist.add(tempList);
        }
        ArrayList<Integer> temp = new  ArrayList<Integer>();
        temp.add(A[n]);
        relist.add(temp);
        relist.addAll(re);


        return relist;
    }
}
