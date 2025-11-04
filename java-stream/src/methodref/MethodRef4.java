package methodref;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MethodRef4 {
    public static void main(String[] args) {
        List<Person> personList = List.of(new Person("Kim"), new Person("Park"), new Person("Lee"));
        List<String> strings = mapPersonToString(personList, Person::introduce);
        System.out.println("strings = " + strings);

        List<String> strings1 = mapStringToString(strings, String::toUpperCase);
        System.out.println("strings1 = " + strings1);
    }
    static List<String> mapPersonToString(List<Person> personList, Function<Person,String> function){
        List<String> result = new ArrayList<>();
        for (Person person : personList) {
            result.add(function.apply(person));
        }
        return result;
    }
    static List<String> mapStringToString(List<String> strings, Function<String,String> function){
        List<String> result = new ArrayList<>();
        for (String s : strings) {
            result.add(function.apply(s));
        }
        return result;
    }
}
