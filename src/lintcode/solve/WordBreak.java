package lintcode.solve;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

/**
 * @Auther: fankk
 * @Date: 2018/11/5 09:45
 * @Desc:  给定字符串 s 和单词字典 dict，确定 s 是否可以分成一个或多个以空格分隔的子串
 *       ，并且这些子串都在字典中存在
 */
public class WordBreak {

    private  int minLength=Integer.MAX_VALUE;
    private   int maxLength=Integer.MIN_VALUE;

    class  StartEnd{
        int start;
        int end;
        public StartEnd(int start,int end){
            this.start=start;
            this.end=end;
        }
    }

    private void  length(Set<String> dict){

        Iterator<String>  iterator= dict.iterator();
        while(iterator.hasNext()){

            String temp = iterator.next();
            minLength = Math.min(temp.length(),minLength) ;
            maxLength=Math.max(temp.length(),maxLength);
        }
    }

    public boolean wordBreak(String s, Set<String> dict) {

        if(s==null||s.length()==0){
            return true;
        }
        if(dict==null||dict.size()==0){
            return false;
        }
        length(dict);
        if(s.length()<minLength){
            return false;
        }
        //StartEnd 包括start ,不含end
        Stack<StartEnd> stack = new Stack<StartEnd>();
        for(int i=minLength;i<=maxLength;i++){
            String temp=s.substring(0,i);
            if(dict.contains(temp)){
                stack.push(new StartEnd(0,i));
                break;
            }
        }


        while(!stack.isEmpty()){
            StartEnd popStartEnd=  stack.peek();
            if(popStartEnd.end ==s.length()){
                return true;
            }


            boolean flagContian=false;
            for(int i = popStartEnd.end+minLength; i<=popStartEnd.end+maxLength;i++){
                if(i>s.length()){
                    break;
                }
                String temp=s.substring(popStartEnd.end,i);
                if(dict.contains(temp)){
                    stack.push(new StartEnd(popStartEnd.end,i));
                    flagContian=true;
                    break;
                }
            }

            while(!flagContian&&!stack.isEmpty()){
                StartEnd popStartEnd1= stack.pop();
                for(int i=popStartEnd1.end+1;i<=popStartEnd1.start+maxLength;i++){
                    if(i>s.length()){
                        break;
                    }
                    String temp=s.substring(popStartEnd1.start,i);
                    if(dict.contains(temp)){
                        stack.push(new StartEnd(popStartEnd1.start,i));
                        flagContian=true;
                    }
                }
            }

        }
         return false;
    }

    public static void main(String[] args){
        WordBreak w=  new WordBreak();
        String s="aaaaaaa";
        Set<String> dict= new HashSet<>();
        dict.add("aaaa");
        dict.add("aa");
      boolean f=  w.wordBreak(s,dict);
      System.out.print(f);
    }



}
