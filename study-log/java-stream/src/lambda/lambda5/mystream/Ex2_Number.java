package lambda.lambda5.mystream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lambda.lambda5.filter.GenericFilter;
import lambda.lambda5.map.GenericMap;

public class Ex2_Number {
    //점수가 80 이상인애들만 출력
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Apple",100),
                new Student("Banana", 80),
                new Student("Berry", 50),
                new Student("Tomato", 40)
        );
        List<String> directList = dircet(students);
        System.out.println("directList = " + directList);
        List<String> lambdaList = lambda(students);
        System.out.println("lambdaList = " + lambdaList);
    }
    static List<String> dircet(List<Student> students){
        List<String> list = new ArrayList<>();
        for (Student student : students) {
            if (student.getScore() >= 80){
                list.add(student.getName());
            }
        }
        return list;
    }
    static List<String> lambda(List<Student> students){
       return students.stream().filter(n -> n.getScore() >= 80).map(name -> name.getName())
               .collect(Collectors.toUnmodifiableList());
    }
}
