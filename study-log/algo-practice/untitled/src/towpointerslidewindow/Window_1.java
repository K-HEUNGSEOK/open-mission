package towpointerslidewindow;

import java.io.FileInputStream;
import java.util.Scanner;

public class Window_1 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i ++)arr[i] = sc.nextInt();

        int total = 0;
        for(int i = 0 ; i < m-1; i ++){
            total += arr[i];
        }
        int ans = 0 ;
        for(int i = m-1; i < n ; i ++){
            total += arr[i];
            ans = Math.max(ans,total);
            total -= arr[i-m+1];
        }
        System.out.println(ans);
    }
}
