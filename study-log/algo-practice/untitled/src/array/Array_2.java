package array;

import java.io.FileInputStream;
import java.util.Scanner;

public class Array_2 {
    static boolean[] prime;
    public static void main(String args[]) throws Exception{
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int max = 100000;
        for(int i = 0 ; i < n ; i ++){
            arr[i] = sc.nextInt();
            max = Math.max(max,arr[i]);
        }
        prime = new boolean[max + 1];
        prime[0] = true;
        prime[1] = true;
        for(int i = 2; i <= max; i ++){
            for(int j = i + i ; j <= max; j +=i){
                if(!prime[j]) prime[j] = true;
            }
        }

        for(int i = 0 ; i < n ; i++){
            isCheck(arr[i]);
        }
    }
    static void isCheck(int n){
        StringBuilder sb = new StringBuilder();
        sb.append(n);
        StringBuilder temp = sb.reverse();
        int ans = Integer.parseInt(temp.toString());
        if(!prime[ans]){
            System.out.print(ans +" ");
        }
    }
}
