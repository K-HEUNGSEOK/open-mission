package string;

import java.io.FileInputStream;
import java.util.Scanner;

public class String_11 {
    public static void main(String args[]) throws Exception{
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = str.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i ++){
            char temp = str.charAt(i);
            int cnt = 1;
            int index = 0;
            for(int j = i + 1; j < n ; j ++){
                if(temp != str.charAt(j)) break;
                else{
                    cnt ++;
                    index = j;
                }
            }
            if(cnt > 1){
                sb.append(temp).append(cnt);
                i = index;
            }else{
                sb.append(temp);
            }
        }
        System.out.println(sb);
    }
}
