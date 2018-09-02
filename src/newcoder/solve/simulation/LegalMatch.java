package newcoder.solve.simulation;

import java.util.Scanner;
import java.util.Stack;

/**
 * Author:  fankk
 * Date:    2018/8/6 15:02
 * Desc:一般的括号匹配问题是这样的：给出一个字符串，判断这个括号匹配是不是合法的括号匹配。
        如"((" 和 "())"都不是合法的括号匹配，但是"()()()"，"(()())()"等就是合法的括号匹配。
        现在给出一个加强版的括号匹配问题： 给出n个由括号 '(' 和 ‘)’ 组成的字符串，
        请计算出这些字符串中有多少对字符串满足si + sj是合法的括号匹配。如果si + sj和sj + si都是合法的括号匹配(i ≠ j)，
        那么这两种搭配都需要计入答案；如果对于si，si + si是合法的括号匹配，那么也需要计入答案。
 */

public class LegalMatch {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String s1 =sc.nextLine();
        int  n=Integer.valueOf(s1);
        String[] str =new String[n];
        for(int i=0;i<n;i++){
            str[i] = sc.nextLine();
        }
        int re =countLegal(str);
        System.out.println(re);
    }

    public static int countLegal(String[] targetStr){
        int sum=0;
        int isSignalLegal=0;    //单个合法
        int isSignalIllegal=0;  //非合法
        String[] dealAfterTargetStr = new String[targetStr.length];
        for(int i=0;i<targetStr.length;i++){
            String target =targetStr[i];
           String re = isLegal(target);
            if(re==null||re.length()==0){
                isSignalLegal++;
            }else{
                dealAfterTargetStr[isSignalIllegal]=re;
                isSignalIllegal++;
            }
        }
        sum +=isSignalLegal;
        sum +=isSignalLegal*(isSignalLegal-1);
        for(int i=0;i<isSignalIllegal;i++){
            for(int j=i+1;j<isSignalIllegal;j++){
                String mergeString1 =   dealAfterTargetStr[i]+dealAfterTargetStr[j];
                if(isLegalString(mergeString1)){
                    sum++;
                }
                String mergeString2 =   dealAfterTargetStr[j]+dealAfterTargetStr[i];
                if(isLegalString(mergeString2)){
                    sum++;
                }
            }
        }


        return sum;
    }

    public static String   isLegal (String str){
        String re="";
        Stack<Character> stack = new  Stack<Character>();
        int i=0;
        while(i<str.length()){
            Character c = str.charAt(i);
            i++;
            if(stack.isEmpty()){  //判断栈是否为空
                stack.push(c);
                continue;
            }
            char targetMatch = stack.peek();
            if( targetMatch=='('  && c==')'){//如果符合匹配，移除
                stack.pop();
            }else{
                stack.push(c);
            }

        }
        if(stack.isEmpty()){ return re;}
        while(!stack.isEmpty()){
            re=stack.pop()+re;
        }
        return re;

    }

    public   static boolean   isLegalString (String str){
        if(str.startsWith(")")){ return false;}
        Stack<Character> stack = new  Stack<Character>();
        int i=0;
        while(i<str.length()){
            Character c = str.charAt(i);
            i++;
            if(stack.isEmpty()){  //判断栈是否为空
                stack.push(c);
                continue;
            }
            char targetMatch = stack.peek();
            if( targetMatch=='('  && c==')'){//如果符合匹配，移除
                stack.pop();
            }else{
                stack.push(c);
            }

        }
        if(stack.isEmpty()){ return true;}
        return false;

    }
}
