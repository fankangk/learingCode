package lintcode;

/**
 * @Auther: fankk
 * @Date: 2018/10/9 14:45
 * @Desc:   计算数字k在0到n中的出现的次数，k可能是0~9的一个值
 */
public class DigitCounts {

    public int digitCounts(int k, int n) {

        int re=0;
        for(int i=0;i<=n;i++){
            re+=count(k,i);
        }
        return re;
    }
     /**
      * @desc:   计算number 中k的个数
      * @date:   2018/10/9 14:50
      * @param:
      * @return:
      */
    public int count(int k,int number){

        int count=0;
        do{
            if(k==number%10){
                count++;
            }
            number=number/10;
        }while(number!=0);

        return count;
    }
}
