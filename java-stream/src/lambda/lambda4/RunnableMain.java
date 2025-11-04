package lambda.lambda4;

public class RunnableMain {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("하이");
            }
        };
        runnable.run();

        Runnable runnable1 = () -> System.out.println("하이");
        runnable1.run();
    }
}
