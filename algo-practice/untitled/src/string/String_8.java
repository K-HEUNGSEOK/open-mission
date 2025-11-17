package string;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class String_8 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toLowerCase();
        str = str.replaceAll("[^a-z]" ,"");
        if (isCheck(str)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
    static boolean isCheck(String str){
        for(int i = 0 ; i < str.length(); i++){
            if(str.charAt(i) != str.charAt(str.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
