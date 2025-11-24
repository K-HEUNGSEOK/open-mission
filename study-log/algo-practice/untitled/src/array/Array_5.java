package array;

import java.io.FileInputStream;
import java.util.Scanner;

public class Array_5 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][5];
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < 5 ; j ++){
                arr[i][j] = sc.nextInt();
            }
        }
        int max =0;
        int index =0;

        for(int i = 0 ; i < n ; i ++){
            int cnt = 0;
            boolean[] ch = new boolean[n];
            for(int k = 0 ; k < n ; k ++){
                for(int l = 0 ; l < 5; l++){
                    if(i == k) continue;
                    if(arr[i][l] == arr[k][l] && !ch[k]){
                        ch[k] = true;
                        cnt ++;
                    }
                }
            }
            if(cnt > max){
                max = cnt;
                index = i+1;
            }
        }
        if(index == 0) {
            System.out.println(1);
        }else{
            System.out.println(index);
        }
    }
}
