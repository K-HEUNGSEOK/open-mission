package methodref;

import java.util.List;
import java.util.function.BiFunction;
import lambda.lambda5.mystream.MyStreamV3;

public class MethodRef6 {
    public static void main(String[] args) {
        Person person = new Person("Kim");
        BiFunction<Person,Integer,String> fum1 = (p, n) -> p.introduceWithNumber(n);
        System.out.println(fum1.apply(person, 1));
        BiFunction<Person,Integer,String> fum2 = Person::introduceWithNumber;
        System.out.println(fum2.apply(person, 1));
    }

}
