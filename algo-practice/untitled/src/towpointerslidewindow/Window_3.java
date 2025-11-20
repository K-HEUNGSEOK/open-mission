package towpointerslidewindow;

import java.io.FileInputStream;
import java.util.Scanner;

public class Window_3 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int total = 0;
        int lt = 1;
        int ans= 0;
        for(int i = 1; i <= n / 2 + 1; i ++){
            total += i;
            if(total >= i){
                if(total == n){
                    ans ++;
                }
                while(total > n){
                    total -= lt;
                    if(total == n){
                        ans ++;
                    }
                    lt ++;
                }
            }
        }
        System.out.println(ans);
    }
}
