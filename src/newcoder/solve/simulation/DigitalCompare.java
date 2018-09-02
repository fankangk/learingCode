package newcoder.solve.simulation;

import java.util.Scanner;
import java.util.Stack;

/**
 * Author:  fankk
 * Date:    2018/7/27 16:59
 * Desc:
 */
public class DigitalCompare {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new  Stack<Character>();
        stack.peek();
    }
    /*
    请你比较xy和yx的大小，如果前者大于后者，输出">"，小于则输出"<"，等于则输出"="。
     */
    public static void compare(int x,int y){

    }



//    public static int matchNumber(String[] str,int n){
//
//    }
    public static String matchNumber(String str){
        Stack<Character> stack = new  Stack<Character>();
        for(int i=0;i<str.length();i++){
            if('('==str.charAt(i)){
                stack.push('(');
            }else{

                if(!stack.isEmpty()){
                    if(stack.peek()=='('){
                        stack.pop();
                    }else{
                        stack.push(')');
                    }
                }else{
                    stack.push(')');
                }

            }
        }
        if(stack.isEmpty()){
            return "";
        }
        StringBuffer s = new StringBuffer();

        return "";
    }

}
/*
一般的括号匹配问题是这样的：

给出一个字符串，判断这个括号匹配是不是合法的括号匹配。

如"((" 和 "())"都不是合法的括号匹配，但是"()()()"，"(()())()"等就是合法的括号匹配。

这个问题解决起来非常简单，相信大家都知道怎么解决。

现在给出一个加强版的括号匹配问题： 给出n个由括号 '(' 和 ‘)’ 组成的字符串，
请计算出这些字符串中有多少对字符串满足si + sj是合法的括号匹配。如果si + sj和sj + si都是合法的括号匹配(i ≠ j)，
那么这两种搭配都需要计入答案；如果对于si，si + si是合法的括号匹配，那么也需要计入答案。

 */