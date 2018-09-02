package newcoder.solve.w163;

import java.util.Scanner;

/**
 * Author:  fankk
 * Date:    2018/8/14 11:05
 * Desc:
 */
public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] var = str.split(" ");
        int a = Integer.parseInt(var[0]);
        int b = Integer.parseInt(var[1]);
        int c = Integer.parseInt(var[2]);
        int m = a+b>a*b?(a+b):a*b;
        int m1 =m+c>m*c?m+c:m*c;
        int t = c+b>c*b?(c+b):c*b;
        int t1 =t+a>t*a?t+a:t*a;
        if(m1>t1)  System.out.println(m1);
        else  System.out.println(t1);
    }
}
