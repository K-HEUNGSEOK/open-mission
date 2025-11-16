import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = str.length();
        for(int i = 0 ; i < n ; i ++){

            if(i == str.indexOf(str.charAt(i))){
                System.out.println(str.charAt(i));
            }
        }
    }
}
