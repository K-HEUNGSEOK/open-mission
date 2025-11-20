package towpointerslidewindow;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TwoPointer_1 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0 ; i < n; i ++) a[i] = sc.nextInt();
        int m = sc.nextInt();
        int[] b = new int[m];
        for(int i = 0 ; i < m; i ++) b[i] = sc.nextInt();
        Arrays.sort(a);
        Arrays.sort(b);
        int p1 = 0;
        int p2 = 0;

        List<Integer> list = new ArrayList<>();
        while(p1 < n && p2 < m){
            if(a[p1] == b[p2]){
                list.add(a[p1]);
                p1 ++;
                p2 ++;
            }else if(a[p1] < b[p2]){
                p1++;
            }else{
                p2++;
            }
        }
        for (Integer i : list) {
            System.out.print(i+ " ");
        }
    }
}
