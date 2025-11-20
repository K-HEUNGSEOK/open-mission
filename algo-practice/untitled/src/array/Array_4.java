package array;

import java.io.FileInputStream;
import java.util.Scanner;

public class Array_4 {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int n;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        //자신의 상하좌우 보다 크면 그 숫자는 봉우리임
        int ans = 0; //봉우리 갯수
        n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < n ; j ++){
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < n ; j ++){
                boolean flag = true;
                for(int k = 0 ; k < 4; k ++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(isRange(nx,ny) && arr[i][j] <= arr[nx][ny]){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    ans ++;
                }
            }
        }
        System.out.println(ans);
    }
    static boolean isRange(int x, int y){
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}
