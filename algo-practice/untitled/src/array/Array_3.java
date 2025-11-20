package array;

import java.io.FileInputStream;
import java.util.Scanner;

public class Array_3 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < n ; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int max = 0;
        for(int i = 0 ; i < n ;  i++){
            int ans1 = 0;
            int ans2 = 0;
            for(int j = 0; j < n ; j++){
                ans1 += arr[i][j];
                ans2 += arr[j][i];
            }
            int ans = Math.max(ans1,ans2);
            max = Math.max(max,ans);
        }
        int ans1= 0;
        int ans2= 0;
        for(int i = 0 ; i < n ; i ++){
            ans1 += arr[i][i];
            ans2 += arr[i][n-1-i];
        }
        int ans = Math.max(ans1,ans2);
        max = Math.max(max,ans);
        System.out.println(max);
    }
}
