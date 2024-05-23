//설명듣고 풀어본 코드

import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] combi;
    public static void DFS(int L, int s){
        if(L == m){
            for(int i = 0; i < m; i++){
                System.out.print(combi[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = s; i <= n; i++){
            combi[L] = i;
            DFS(L + 1, i + 1);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        combi = new int[m];
        DFS(0,1);
    }

}
