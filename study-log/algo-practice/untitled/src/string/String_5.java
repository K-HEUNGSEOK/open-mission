package string;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class String_5 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(reverseString(str));
    }
    //1.처음과 끝이 알파벳인지 확인한다.
    //2.하나가 알파벳이면 고정시켜두고
    //3.start 나 end 를 높이거나 줄여가면서 알파벳을 찾으면 교환한다. 반복
    static String reverseString(String str) {
        char[] arr = str.toCharArray();
        int start = 0;
        int end = arr.length-1;
        char temp = '0';
        while(start < end){
            if(Character.isAlphabetic(arr[start]) && Character.isAlphabetic(arr[end])){
                temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start ++;
                end --;
            }else if(!Character.isAlphabetic(arr[start])) {
                start ++;
            }else{
                end --;
            }
        }
        return new String(arr);
    }
}
//kdj#@kdjg%$#kdjgk@kd$dk

//kdd#@kkgj%$#dkgjd@kj$dk
