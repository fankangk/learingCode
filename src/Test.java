import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author:  fankk
 * Date:    2018/8/16 9:44
 * Desc:
 */
public class Test {

    public static void main(String[] args){
        Date d=new Date();

        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       try {
          //Date d= df.parse("2018-08-30 23:46:35");
           System.out.println("今天的日期：" + df.format(d));
           System.out.println("两天前的日期：" + df.format(new Date(d.getTime() -2 * 24 * 60 * 60 * 1000)));
           System.out.println("40分钟后的日期：" + df.format(new Date(d.getTime() + 40 * 60 * 1000)));
       }catch (Exception e){

       }
    }
}
