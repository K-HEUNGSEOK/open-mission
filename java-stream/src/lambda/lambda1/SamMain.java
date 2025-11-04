package lambda.lambda1;

public class SamMain {
    public static void main(String[] args) {
        SamInterface samInterface = () -> System.out.println("출력");
        samInterface.run();
    }
}
