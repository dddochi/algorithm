import java.util.Scanner;

// class Node{
//     int data;
//     Node lt, rt;
//     public Node(int data){
//         this.data = data;
//         lt = rt = null;
//     }
// }
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // N = 정점의 수
        int n = scanner.nextInt();

        // M = 간선의 수
        int m = scanner.nextInt();

        int[][] graph = new int[n + 1][n + 1];
        // 연결정보 (M줄)
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph[a][b] = 1;
        }

        DFS(1, graph);
        System.out.println(count);
    }

    static int count = 0;
    static int[] check = new int[21];

    public static void DFS(int data, int[][] graph) {

        if (data == 1) {
            for (int i = 1; i < check.length; i++) {
                check[i] = 0;
            }
        }
        check[data] = 1;
        if (data == 5) {
            count++;

        } else {

            int len = graph.length;
            for (int i = 1; i < len; i++) {
                if (graph[data][i] == 1 && check[i] == 0) {
                    DFS(i, graph);
                    check[i] = 0;
                }

            }
        }

    }
}

// 5 9 
// 1 2
// 1 3
// 1 4
// 2 1
// 2 3
// 2 5
// 3 4
// 4 2
// 4 5