package lintcode;

import java.util.Stack;

/**
 * @Auther: fankk
 * @Date: 2018/10/15 15:12
 * @Desc:
 */
public class MinStack {

    Stack<Integer> numberStack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();
    public MinStack() {

    }


    public void push(int number) {
        numberStack.push(number);
        if(minStack.isEmpty()||minStack.peek()>=number){
            minStack.push(number);
        }
    }


    public int pop() {
         int re=numberStack.pop();
         if(re==minStack.peek()){
             minStack.pop();
         }
         return re;
    }


    public int min() {
      return minStack.peek();
    }
}
