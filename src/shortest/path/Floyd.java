package shortest.path;

/**
 * Author:  fankk
 * Date:    2018/8/17 10:34
 * Desc:
 */
public class Floyd {

  public static void main(String[] args){

  int i,j,k;
  int n =100;
  int[][] e = new int[n][n];

      for(k=1;k<=n;k++){
          for(i=1;i<=n;i++) {

              for (j = 1; j <= n; j++) {
                  if (e[i][j] > e[i][k] + e[k][j]){
                      e[i][j] = e[i][k] + e[k][j];
                  }


              }
          }
      }




  }
}
