package lambda.lambda4;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class ExMain {
        public static void main (String[]args){
            List<Integer> numbers = List.of(1, 2, 3, 4);
            System.out.println("리스트: " + numbers);
            // 1. 합 구하기 (초깃값 0, 덧셈 로직)
            int sum = reduce(numbers, 0, (a,b) -> a+b);
            System.out.println(sum);

            // 2. 곱 구하기 (초깃값 1, 곱셈 로직, 람다로 작성)
            int muti = reduce(numbers, 1, (a,b) -> a * b);
            System.out.println(muti);

    }
    static int reduce(List<Integer> list, int start, BinaryOperator<Integer> binaryOperator){
            int sum = start;
        for (Integer i : list) {
            sum = binaryOperator.apply(sum ,i);
        }
        return sum;
    }
}