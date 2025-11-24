package towpointerslidewindow;

import java.io.FileInputStream;
import java.util.Scanner;

public class Window_2 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i ++)arr[i] = sc.nextInt();

        //1.더하면서 target보다 높으면 낮아질 떄 까지 start ++ 하면 됨
        int start = 0;
        int end =0;
        int ans = 0;
        int total = 0;
        while(end < n){
            total += arr[end++];
            if(total >= target){
                if(total == target){
                    ans ++;
                }
                while(total > target){
                    total -= arr[start ++];
                    if(total == target){
                        ans ++;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
