package string;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class String_6 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        //그냥 str의 길이로 하면 줄어들기 때문에  안된다.
        //str 요소를 삭제하면 길이도 줄어든다
        //중복되는 부분은 ch 배열을 통해 체크해두고 나머지를 조합해서 문자를 만들면?
        boolean[] ch = new boolean[str.length()];

        int n = str.length();
        for(int i = 0 ; i < n ; i ++){
            for(int j = i + 1; j < n ; j ++){
                if(str.charAt(i) == str.charAt(j)){
                    ch[j] = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i ++){
            if(!ch[i]){
                sb.append(str.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }
}
