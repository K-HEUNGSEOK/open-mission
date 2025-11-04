package methodref;

import java.util.function.Supplier;

public class MethodRefMainEx1 {
    public static void main(String[] args) {
        //정적 메서드 참조
        Supplier<String> supplier = Person::greeting; //클래스::정적메서드
        System.out.println(supplier.get());

        //2. 특정 객체의 인스턴스 참조
        Person person = new Person("Kim");
        Supplier<String> instanceMethod1 = () -> person.introduce();
        System.out.println(instanceMethod1.get());
        Supplier<String> instanceMethod2 = person::introduce; //인스턴스::메서드
        System.out.println(instanceMethod2.get());

        //3. 생성자 참조
        Supplier<Person> newPerson1 = () -> new Person();
        System.out.println(newPerson1.get());
        Supplier<Person> newPerson2 = Person::new;
        System.out.println(newPerson1.get());
    }
}
