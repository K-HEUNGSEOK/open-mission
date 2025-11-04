package methodref;

import java.util.function.Function;

public class MethodRefEx3 {
    public static void main(String[] args) {
        //임의 메서드
        Person person1 = new Person("Kim");
        Person person2 = new Person("Park");
        Person person3 = new Person("Lee");

        Function<Person, String> fun1 = person -> person.introduce();
        System.out.println("person1.introduce() = " + fun1.apply(person1));
        System.out.println("person2.introduce() = " + fun1.apply(person2));
        System.out.println("person3.introduce() = " + fun1.apply(person3));

        //특정 타입의 동일한 인스턴스 메서드를 쓸 땐 메서드 참조가 가능하다.
        //클래스명::인스턴스명
        Function<Person,String> fun2 = Person::introduce;
        System.out.println("fun2.apply(person1) = " + fun2.apply(person1));
        System.out.println("fun2.apply(person1) = " + fun2.apply(person2));
        System.out.println("fun2.apply(person1) = " + fun2.apply(person3));
    }
}
