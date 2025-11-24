package string;

import java.io.FileInputStream;
import java.util.Scanner;

public class String_12 {
    public static void main(String args[]) throws Exception{
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        StringBuilder ans = new StringBuilder();
        for(int i = 0 ; i < str.length(); i +=7){
            String temp = str.substring(i, i + 7);
            ans.append((char)parse(temp));
        }
        System.out.println(ans);
    }
    static int parse(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < str.length(); i++){
            if(str.charAt(i) == '#'){
                sb.append(1);
            }else{
                sb.append(0);
            }
        }
        return Integer.parseInt(sb.toString(), 2);
    }
}
