package newcoder.solve.tree;

/**
 * Author:  fankk
 * Date:    2018/7/24 15:06
 * Desc:
 */
public class LCA {


     /**
       *@desc:   有一棵无穷大的满二叉树，其结点按根结点一层一层地从左往右依次编号，根结点编号为1。现在有两个结点a，b。
      *           请设计一个算法，求出a和b点的最近公共祖先的编号。
       *@author:  fankk
       *@date:   2018/7/24 15:14
     */
    public int getLCA(int a, int b) {
        // write code here
        int parentA=a/2;
        int parentB=b/2;
        while(parentA!=parentB){
            if(parentA>parentB){
                parentA=parentA/2;
            }else{
                parentB=parentB/2;
            }
        }

        return parentA;
    }
}
