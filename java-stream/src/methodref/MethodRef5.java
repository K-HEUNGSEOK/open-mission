package methodref;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import lambda.lambda5.mystream.MyStreamV3;

public class MethodRef5 {
    public static void main(String[] args) {
        List<Person> personList = List.of(new Person("Kim"), new Person("Park"), new Person("Lee"));

        List<String> list = MyStreamV3.of(personList)
                .map(Person::introduce)
                .map(String::toUpperCase)
                .toList();
        System.out.println("list = " + list);
    }

}
