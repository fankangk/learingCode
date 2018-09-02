package newcoder.solve.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:  fankk
 * Date:    2018/7/24 17:29
 * Desc:
 */
public class Robot {

     /**
       *@desc:  有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。请设计一个算法，计算机器人有多少种走法。
       *        给定两个正整数int x,int y，请返回机器人的走法数目。保证x＋y小于等于12。
       *@author:  fankk
       *@date:   2018/7/24 17:30
     */
    public int countWays(int x, int y) {
        //f(x,y)=f(x-1,y)+f(x,y-1)
       int re =0;
       int[][] number = new int[x+1][y+1];
       for(int i=1;i<=y;i++){
           number[1][i]=1;
       }
        for(int i=1;i<=x;i++){
            number[i][1]=1;
        }
        for(int i=2;i<=x;i++){
           for(int j=2;j<=y;j++){
               number[i][j]= number[i-1][j]+ number[i][j-1];
           }
        }
       return number[x][y];
    }

     /**
       *@desc:    有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。请设计一个算法，计算机器人有多少种走法。注意这次的网格中有些障碍点是不能走的。
                  给定一个int[][] map(C++ 中为vector >),表示网格图，若map[i][j]为1则说明该点不是障碍点，否则则为障碍。
                  另外给定int x,int y，表示网格的大小。请返回机器人从(0,0)走到(x - 1,y - 1)的走法数，为了防止溢出，请将结果Mod 1000000007。保证x和y均小于等于50
      *@author:  fankk
       *@date:   2018/7/25 8:34
     */
    public int countWays(int[][] map, int x, int y) {

        if(x<1||y<1) {return 0;}


        int[][] dp = new int[x][y];


        //map[0][i]为障碍点 则从[0][i]到[0][y-1] 对应的dp[][] 为0
        for(int i=0;i<y;i++){
            if(map[0][i]!=1){
                break;
            }
            dp[0][i]=1;
        }

        for(int i=0;i<x;i++){
            if(map[i][0]!=1){
                break;
            }
            dp[i][0]=1;
        }

        //如果[][]不为障碍点 dp[i][j]=dp[i-1][j]+dp[i][j-1]
        for(int i=1;i<x;i++){
            for(int j=1;j<y;j++){
                if(map[i][j]==1){  //非障碍点
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }else{
                    dp[i][j]=0;
                }
            }
        }


        return dp[x-1][y-1]%1000000007;






    }





    public static void main(String[] args){
        Map<String,Object> apiParamMap= new HashMap<String,Object>();

        apiParamMap.put("fan",1);
        System.out.println(apiParamMap.toString());
        apiParamMap.put("fan",3);
        System.out.println(apiParamMap.toString());
    }
}
