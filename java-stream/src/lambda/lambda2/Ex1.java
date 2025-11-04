package lambda.lambda2;

import java.util.Arrays;
import lambda.lambda1.Produce;

public class Ex1 {
    public static void main(String[] args) {
        measure(() -> {
            int n = 10;
            int total = 0;
            for(int i = 1; i <= n ; i ++){
                total += i;
            }
            System.out.println(total);
        });

        measure(() -> {
            int[] arr = {4,3,2,1};
            Arrays.stream(arr).sorted().forEach(num -> System.out.print(num + " "));
        });
    }

    static void measure(Produce p){
        long startTime = System.nanoTime();
        System.out.println("시작 시간 : " + startTime);
        p.run();
        long endTime = System.nanoTime();
        System.out.println("종료 시간 : " + endTime);
        System.out.println(endTime - startTime);
    }
}
