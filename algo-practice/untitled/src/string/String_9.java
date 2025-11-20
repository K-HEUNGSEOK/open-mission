package string;

import java.io.FileInputStream;
import java.util.Scanner;

public class String_9 {
    public static void main(String args[]) throws Exception{
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < str.length(); i++) {
            if(Character.isDigit(str.charAt(i))) {
                sb.append(str.charAt(i));
            }
        }
        System.out.println(Integer.parseInt(sb.toString()));
    }
}
