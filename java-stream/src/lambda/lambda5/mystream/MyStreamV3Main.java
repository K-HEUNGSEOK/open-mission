package lambda.lambda5.mystream;

import java.util.List;

public class MyStreamV3Main {
    public static void main(String[] args) {
        List<Student> list = List.of(
                new Student("Apple",100),
                new Student("Banana",80),
                new Student("Berry",50),
                new Student("Tomato",40)
        );

        //점수가 80 이상인 학생의 이름 추출
        List<String> list1 = MyStreamV3.of(list).filter(n -> n.getScore() >= 80).map(n -> n.getName()).toList();
        System.out.println("list1 = " + list1);

        List<String> list2 = MyStreamV3.of(list).filter(n -> n.getName().length() == 5 && n.getScore() >= 80)
                .map(n -> n.getName().toUpperCase())
                .toList();

        System.out.println("list2 = " + list2);
    }
}
