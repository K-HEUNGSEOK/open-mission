package array;

import java.io.FileInputStream;
import java.util.Scanner;

public class Array_1 {
    public static void main(String args[]) throws Exception{
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i ++) arr[i] = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]).append(" ");

        for(int i = 1; i < n ; i ++){
            if(arr[i] > arr[i-1]) sb.append(arr[i]).append(" ");
        }
        System.out.println(sb.toString());

    }
}
