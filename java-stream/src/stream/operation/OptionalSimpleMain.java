package stream.operation;

import java.util.Optional;

public class OptionalSimpleMain {
    public static void main(String[] args) {
        Optional<Integer> optional = Optional.of(10);
        System.out.println("optional = " + optional);
        if (optional.isPresent()){ //값이 있는지 확인할 수 있는 메서드
            Integer i = optional.get();
            System.out.println("i = " + i);
        }
    }
}
