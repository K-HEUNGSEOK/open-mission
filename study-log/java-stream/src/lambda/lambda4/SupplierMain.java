package lambda.lambda4;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierMain {
    public static void main(String[] args) {
        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return new Random().nextInt(10);
            }
        };
        System.out.println(supplier.get());

        Supplier<Integer> supplier1 = () -> new Random().nextInt(10);
        System.out.println(supplier1.get());
    }
}
