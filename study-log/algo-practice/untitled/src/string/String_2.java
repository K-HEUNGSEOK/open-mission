package string;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class String_2 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < str.length(); i++){
            if(Character.isLowerCase(str.charAt(i))){
                sb.append(Character.toUpperCase(str.charAt(i)));
            }else{
                sb.append(Character.toLowerCase(str.charAt(i)));
            }
        }
        System.out.println(sb.toString());
    }
}
