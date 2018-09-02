package shortest.path;

import java.util.Scanner;

/**
 * Author:  fankk
 * Date:    2018/8/15 15:12
 * Desc:   Djk算法（迪杰斯特拉算法 ）最短路径算法
 */
public class Djk {

    public static void main(String[] args){


        Scanner sc = new Scanner(System.in);
        String  str = sc.nextLine();
        String[] tar = str.split(" ");
        int n = Integer.parseInt(tar[0]);
        int m = Integer.parseInt(tar[1]);
        int[][] weight = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                    weight[i][j]=0;
                    continue;
                }
                weight[i][j]=Integer.MAX_VALUE;
            }
        }
        int t=1;
        for(int i=0;i<m;i++){
            String  str1 = sc.nextLine();
            String[] tar1 = str1.split(" ");
            int row = Integer.parseInt(tar1[0]);
            int column = Integer.parseInt(tar1[1]);
            weight[row][column]=t;
            t=t*2;
        }


        int startPosition=0;
        int max =Integer.MAX_VALUE;

        shortestPath(startPosition,weight);

        for(int i=1;i<weight[startPosition].length;i++){
            System.out.println(weight[startPosition][i]);
        }

    }
     /**
       *@desc:  Djk算法（迪杰斯特拉算法 ）最短路径算法 ,邻接矩阵存储图（二维数组），
      *         从指定的位置出发，到其余位置的最短路径
       *@author:  fankk
       *@date:   2018/8/15 15:26
       *@param:  startPosition   起点位置
       *@param:  weight          初始的邻接矩阵
       *@return:
     */
    public static void shortestPath(int startPosition,int[][] weight ){
        /*
        1 .求出weight[startPosition][]  找出最小值下标minIndex（之前遍历过的不算） ，第一次找出最小值表示startPosition-minIndex 的最短路径
           并不是说之后只要从weight[startPosition][]数组最小值就是找到最短的距离
        2 .找出以为出发点minIndex，到其余个点的距离即startPosition--minIndex（（中间可能经过其他的点）） --v 与startPosition--v比较
           如前者小更新weight[startPosition][]的距离 ，否则不做处理。
        3 ，重复步骤 1，，2
         */
        int len = weight.length;
        int[] flag = new int[len];  //标志位 ，表示数组下标对应的节点，有没有已经算出最短路径 1 表示已经求出，0表示没有
        flag[startPosition]=1;
        for(int count=0;count<len;count++){
            if(count==startPosition) {continue;}
            int node= findMinIndex(startPosition,weight,flag);
            int path =weight[startPosition][node];
            if(path==Integer.MAX_VALUE){continue;}  //说明无可到达点
            for(int i=0;i<len;i++){
                if(weight[node][i]==Integer.MAX_VALUE){continue;}
                if(weight[node][i]+path<weight[startPosition][i]){
                    weight[startPosition][i]=weight[node][i]+path;

                }
            }
        }

    }


     /**
       *@desc:   寻找 二维数组一行中的指定数据（并非一行中所有的数据）中最小值的下标
       *@author:  fankk
       *@date:   2018/8/17 9:55
       *@param:  int row 二维数组的行数
      *           int[][] weight
      *           int[] flag 对应二维数组行 ，标志查找最小值是否包含，  0包含，1 不包含
       *@return:
     */
    private static  int findMinIndex(int row,int[][] weight,int[] flag){
       int min =Integer.MAX_VALUE;
        int minIndex=0;
        for(int i=0;i<weight[row].length;i++){
            if(flag[i]==0&&weight[row][i]<min && i!=row){
                min=weight[row][i];
                minIndex=i;
            }
        }
        flag[minIndex]=1;
        return minIndex;
    }
}
