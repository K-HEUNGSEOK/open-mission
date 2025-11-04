package stream.basic;

import java.util.List;

public class ImmutubleMain {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4);
        System.out.println("list = " + list);

        List<Integer> list1 = list.stream().filter(n -> n % 2 == 0)
                .toList();
        System.out.println("list1 = " + list1);
        System.out.println("list = " + list);
    }
}
