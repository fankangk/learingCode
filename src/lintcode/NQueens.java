package lintcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Auther: fankk
 * @Date: 2018/10/16 13:25
 * @Desc:    皇后问题是将n个皇后放置在n*n的棋盘上，皇后彼此之间不能相互攻击。给定一个整数n，返回所有不同的n皇后问题的解决方案。
 *
 *         ，即任意两个皇后都不能处于同一行、同一列或同一斜线上（指斜率为1或者-1）
 */
public class NQueens {

    class Node{
        int x;
        int y;
        public Node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    public static void main(String[] args){
        NQueens n =new NQueens();
        List<List<String>> re= n.solveNQueens(5);
        System.out.println(re);
    }
    public List<List<String>> solveNQueens(int n) {

        List<List<String>>  re= new ArrayList<List<String>>();

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
                re.add(convertNodeToString(list,n));
                row--;
                list.remove(list.size()-1);
            }

        }
        return re;

    }

    public boolean  isSlantLine(List<Node> list,Node node){
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

   public  List<String>  convertNodeToString(List<Node> nodeList,int n){

       List<String> list = new ArrayList<>();
        for(int i=0;i<nodeList.size();i++){
            StringBuilder  str=new StringBuilder();
            for(int j=0;j<n;j++){
                 if(j==nodeList.get(i).y){
                     str.append('Q');
                 }else{
                     str.append('.');
                 }
            }
            list.add(str.toString());
        }
        return list;

   }
}
