package string;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class String_4 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int z = 0; z < n ; z++){
            String str = sc.next();
            System.out.println(reverseString(str));
        }
    }
    static String reverseString(String str) {
        char[] arr = str.toCharArray();
        int n = arr.length;
        for(int i = 0 ; i < n /2  ; i ++){
            char temp = arr[i];
            arr[i] = arr[n-1-i];
            arr[n-1-i] = temp;

        }
        return new String(arr);
    }
}
