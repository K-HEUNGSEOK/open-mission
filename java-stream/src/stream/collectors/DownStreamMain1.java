package stream.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DownStreamMain1 {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Kim", 1, 85),
                new Student("Park", 1, 70),
                new Student("Lee", 2, 70),
                new Student("Han", 2, 90),
                new Student("Hoon", 3, 90),
                new Student("Ha", 3, 89)
        );


        //1. 1단계 학년별로 학생들을 그룹화 하기
        Map<Integer, List<Student>> group1 = students.stream().collect(Collectors.groupingBy(Student::getGrade));
        System.out.println("group1 = " + group1);

        //2. 2단계 학년별로 학생들의 이름을 출력해라
        Map<Integer, List<String>> collect = students.stream().collect(
                Collectors.groupingBy(
                        Student::getGrade,
                        Collectors.mapping(Student::getName, Collectors.toList())
                )
        );
        System.out.println("collect = " + collect);

        //3. 3단계 학년별로 학생들의 수를 출력해라.
        Map<Integer, Long> collect1 = students.stream().collect(Collectors.groupingBy(
                Student::getGrade,
                Collectors.counting()
        ));
        System.out.println("collect1 = " + collect1);

        //4. 학년별로 학생들의 평균 성적을 출력해라.
        Map<Integer, Double> collect2 = students.stream().collect(Collectors.groupingBy(
                Student::getGrade,
                Collectors.averagingInt(Student::getScore)
        ));
        System.out.println("collect2 = " + collect2);
    }
}
