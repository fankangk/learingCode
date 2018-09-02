package newcoder.solve.w163;

import java.util.Scanner;

/**
 * Author:  fankk
 * Date:    2018/8/13 16:12
 * Desc:
 */
public class MinChange {

    public static void main(String[] args){
        MinChange m =new MinChange();

        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        int num = Integer.parseInt(n);
        for(int i=0;i<num;i++){
            String s= sc.nextLine();
            String[] tar = s.split(":");
            String re =isBoolean(tar[0],tar[1],tar[2]);
            System.out.println(re);
        }
    }
    public static String  isBoolean(String hour,String minute,String second){
      int hour1=Integer.parseInt(hour);
        if(hour1<0||hour1>23){  //时间不满足要求
            int c1 =  hour.charAt(0)-48;

            if(c1>2){
                hour="0"+hour.charAt(1);
            }
            if(Integer.parseInt(hour)>23){
                hour=hour.charAt(0)+"0";
            }
        }

        int minute1=Integer.parseInt(minute);
        if(minute1<0||minute1>60){  //时间不满足要求
            int c1 =  minute.charAt(0)-48;

            if(c1>5){
                minute="0"+minute.charAt(1);
            }
            if(Integer.parseInt(minute)>59){
                minute=minute.charAt(0)+"0";
            }
        }

        int second1=Integer.parseInt(second);
        if(second1<0||second1>60){  //时间不满足要求
            int c1 =  second.charAt(0)-48;

            if(c1>5){
                second="0"+second.charAt(1);
            }
            if(Integer.parseInt(second)>59){
                second=second.charAt(0)+"0";
            }
        }
  String re =hour+":"+minute+":"+second;
  return re;

    }
}
/*

小云正在参与开发一个即时聊天工具，他负责其中的会话列表部分。

会话列表为显示为一个从上到下的多行控件，其中每一行表示一个会话，每一个会话都可以以一个唯一正整数id表示。

当用户在一个会话中发送或接收信息时，如果该会话已经在会话列表中，则会从原来的位置移到列表的最上方；如果没有在会话列表中，则在会话列表最上方插入该会话。

小云在现在要做的工作是测试，他会先把会话列表清空等待接收信息。当接收完大量来自不同会话的信息后，就输出当前的会话列表，以检查其中是否有bug。
 */