//강사님 코드

import java.util.Scanner;

public class Main {
    static int n, m, answer = 0;
    static int [][] graph;
    static int[] ch;
    public static void DFS(int v){
        if(v == n) answer++;
        else{
            for(int i = 1; i <= n; i++){
                if(graph[v][i] == 1 && ch[i] == 0){
                    ch[i] = 1;
                    DFS(i);
                    ch[i] = 0; //다시 back했을 때 ch 풀어줘야함
                }
            }
        }
    }
   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        graph = new int[n+1][n+1];
        ch = new int[n+1];
        for(int i=0; i < m; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph[a][b] = 1;
        }
        ch[1] = 1;
        DFS(1);
        System.out.println(answer);
   } 
}
