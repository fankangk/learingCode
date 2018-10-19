package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: fankk
 * @Date: 2018/10/18 08:37
 * @Desc:
 */
public class NQueensII {


    class Node{
        int x;
        int y;
        public Node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    public int totalNQueens(int n) {

       int re=0;
        Node[][]  node= new Node[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                node[i][j] = new Node(i,j) ;
            }
        }
        int[] visted = new int[n];
        for(int i=0;i<n;i++){
            visted[i]=-1;
        }

        List<Node>  list = new ArrayList<Node>();
        int row=0;
        while(row>=0 && row<n ){
            int flag=0;     //标志位 ，0 表示位找到符合条件的， 1 表示找到符合条件的
            for(int j=visted[row]+1;j<n;j++){
                if(isSlantLine(list,node[row][j])){
                    list.add(node[row][j]);
                    visted[row]=j;
                    flag=1;
                    break;
                }

            }
            if(flag ==1){
                row++;
            }else{
                if(!list.isEmpty()) {
                    list.remove(list.size() - 1);
                }
                visted[row]=-1;
                row--;
            }
            if(list.size()==n){
               re++;
                row--;
                list.remove(list.size()-1);
            }

        }
        return re;
    }

     /**
      * @desc:    判断是否符合要求 即任意两个皇后都不能处于同一行、同一列或同一斜线上（指斜率为1或者-1）
      * @date:   2018/10/19 8:35
      */
    public boolean  isSlantLine(List<Node> list, Node node){
        for(int i=0;i<list.size();i++){
            Node tempNode = list.get(i);
            if(tempNode.y==node.y){
                return false;
            }
            double k = Math.abs( (tempNode.y-node.y)*1.0/(tempNode.x-node.x))-1;
            if(k==0){
                return false;
            }
        }
        return true;
    }
}
