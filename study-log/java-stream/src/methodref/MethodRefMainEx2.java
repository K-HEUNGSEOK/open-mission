package methodref;

import java.util.function.Function;
import java.util.function.Supplier;

public class MethodRefMainEx2 {
    public static void main(String[] args) {
        //정적 메서드 참조
        Function<String ,String> staticMethod1 = name -> Person.greeting(name);
        Function<String ,String> staticMethod2 = Person::greeting;
        System.out.println(staticMethod1.apply("시발"));
        System.out.println(staticMethod2.apply("하이"));

        //인스턴스
        Person person = new Person("Kim");
        Function<Integer,String> method1 = n -> person.introduceWithNumber(n);
        Function<Integer,String> method2 = person::introduceWithNumber;
        System.out.println(method1.apply(123));
        System.out.println(method2.apply(12313));

        Function<String,Person> newPerson = n -> new Person(n);
        Function<String,Person> newPerson1 = Person::new;
        System.out.println(newPerson.apply("kom"));
        System.out.println(newPerson1.apply("ㅏㄱㄷㅈㅂ"));
    }
}
