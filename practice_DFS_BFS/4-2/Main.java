 //설명 듣고 풀어본 코드
//배열 활용

import java.util.Scanner;


public class Main {
    static int n, m;
    static int[] pm;
    public static void DFS(int L){
        if(L > m) return;
        if(L == m){
            for(int i = 0; i < m; i++){
                System.out.print(pm[i] + " ");
            }
            System.out.println();
            return;
        }
        else{
            for(int i = 1; i <= n; i++){
                pm[L] = i;
                DFS(L+1);
            
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        pm = new int[m];
        DFS(0);
    }
}
