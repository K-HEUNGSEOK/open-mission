package lambda.lambda1;

public class InstanceMain {
    public static void main(String[] args) {
        Produce produce = new Produce() {
            @Override
            public void run() {
                System.out.println("hello lambda");
            }
        };
        System.out.println(produce.getClass());
        System.out.println(produce);

        Produce produce2 = () -> System.out.println("하이");
        System.out.println(produce2.getClass());
        System.out.println(produce2);

        MyFunction myFunction = (a,b) -> a + b;
        System.out.println(myFunction.apply(1, 2));
    }
}
