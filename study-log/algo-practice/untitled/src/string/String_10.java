package string;

import java.io.FileInputStream;
import java.util.Scanner;

public class String_10 {
    public static void main(String args[]) throws Exception{
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char t = sc.next().charAt(0);
        int n = str.length();
        int[] list = new int[n];
        for(int i = 0 ; i < n ; i ++) {
            list[i] = Integer.MAX_VALUE;
        }
        for(int i = 0 ; i <n ; i ++) {
            char temp = str.charAt(i);
            if(temp == t) {
                list[i] = 0;
            }else {
                for(int j = i + 1; j < n ; j ++) {
                    if(str.charAt(j) == t) {
                        list[i] = j-i;
                        break;
                    }
                }
            }
        }

        for(int i = n-1 ; i >= 0 ; i --) {
            char temp = str.charAt(i);
            if(temp == t) {
                list[i] = 0;
            }else {
                for(int j = i -1 ; j >= 0 ; j --) {
                    if(str.charAt(j) == t) {
                        if(i - j > list[i]) {
                            break;
                        }else {
                            list[i] = i - j;
                            break;
                        }
                    }
                }
            }
        }
        for(int i : list) {
            System.out.print(i + " ");
        }
    }
}
