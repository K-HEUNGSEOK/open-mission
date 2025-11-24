

import java.io.FileInputStream;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i ++)arr[i] = sc.nextInt();

        //1.0을 만나면 cnt 를 올린다
        //2.cnt가 m 을 넘으면 길이를 계산하고 다시 lt를 0까지 데려온다.
        int lt = 0;
        int cnt = 0;
        int ans = 0;
        for(int i = 0 ; i < n ; i ++){
            if(arr[i] == 0){
                cnt ++;
            }
            if(cnt > m){
                ans = Math.max(ans, i - lt);
                while(cnt > m){
                    if(arr[lt++] == 0){
                        cnt --;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
