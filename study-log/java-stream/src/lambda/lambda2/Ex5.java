package lambda.lambda2;
import java.util.*;
public class Ex5 {
    public static void main(String[] args){
        List<Integer> list = List.of(1,2,3,4);
        int sum = getReduce(list, 0, (a,b) -> a + b);
        System.out.println(sum);
        int muti = getReduce(list,1,(a,b) -> a * b);
        System.out.println(muti);
    }
    static int getReduce(List<Integer> list , int initial, MyReduce myReduce){
        int total = initial;
        for (Integer i : list) {
            total = myReduce.reduce(total, i);
        }
        return total;
    }

    interface MyReduce{
        int reduce(int a , int b);
    }
}
