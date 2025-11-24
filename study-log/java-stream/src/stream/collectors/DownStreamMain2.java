package stream.collectors;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class DownStreamMain2 {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Kim", 1, 85),
                new Student("Park", 1, 70),
                new Student("Lee", 2, 70),
                new Student("Han", 2, 90),
                new Student("Hoon", 3, 90),
                new Student("Ha", 3, 89)
        );

        //1. 학년별로 학생들을 그룹화 해라
        Map<Integer, List<Student>> collect = students.stream().collect(Collectors.groupingBy(Student::getGrade));
        System.out.println("collect = " + collect);
        //2. 학년별로 가장 점수가 높은 학생을 구해라. reducing 사용
        Map<Integer, Optional<Student>> collect1 = students.stream().collect(Collectors.groupingBy(
                Student::getGrade,
                Collectors.reducing((s1, s2) -> s1.getScore() > s2.getScore() ? s1 : s2)
        ));
        System.out.println("collect1 = " + collect1);
        //3.maxBy 사용
        Map<Integer, Optional<Student>> collect2 = students.stream().collect(Collectors.groupingBy(
                Student::getGrade,
                Collectors.maxBy(Comparator.comparing(Student::getScore))
        ));
        System.out.println("collect2 = " + collect2);
        //4. 학년별로 가장 점수가 높은 학생의 이름을 구해라 maxby랑 andthen 사용
        Map<Integer, String> collect3 = students.stream().collect(Collectors.groupingBy(
                Student::getGrade, // 그룹 나누는 기준
                Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparing(Student::getScore)), //다운스트림 컬렉션
                        opt -> opt.orElseThrow().getName() //여기가 옵셔널 처리하고 마지막 반환하는 곳
                )
        ));
        System.out.println("collect3 = " + collect3);

    }
}
