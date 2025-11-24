package string;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class String_1 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        String str = sc.next().toLowerCase();
        char target = Character.toLowerCase(sc.next().charAt(0));
        int ans = 0;

        for(int i = 0 ; i < str.length(); i ++){
            if (str.charAt(i) == target) ans ++;
        }
        System.out.println(ans);
    }
}
