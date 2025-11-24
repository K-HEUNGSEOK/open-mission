package array;

import java.io.FileInputStream;
import java.util.Scanner;

public class Array_6 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < m ; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int ans = 0;
        for(int i = 1; i <= m; i ++){
            for(int j = 1; j <= m ; j ++){
                if(j == i) continue;
                boolean flag = true; //3번 다 통과했는지;
                int indexA = 0; //i의 위치
                int indexB = 0; //j의 위치
                //모든 경우에서 i가 j를 앞서야됨
                for(int k = 0 ; k < n ; k ++){
                    for(int l = 0 ; l< m ; l++){
                        if(arr[k][l] == i){
                            indexA = l;
                        }
                        if(arr[k][l] == j){
                            indexB= l;
                        }
                    }
                    if(indexA > indexB){
                        flag = false;
                    }
                    if(!flag) break;
                }
                if(flag) {
                    ans ++;
                }
            }
        }
        System.out.println(ans);

    }
}
