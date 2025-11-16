package string;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class String_3 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] split = str.split(" ");

        int index = 0;
        int max = 0;
        for(int i = 0 ; i < split.length; i ++){
            if(split[i].length() > max){
                max = split[i].length();
                index = i;
            }
        }
        System.out.println(split[index]);
    }
}
