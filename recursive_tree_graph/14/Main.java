//최소 이동 간선거리

import java.util.*;

public class Main {
    static int n, m;
    static int[][] graph;
    static int[] ch;
    static Queue<Integer> Q = new LinkedList<>();
    static int[] answer;
    
    //혼자 풀어본 코드
    public static void BFS(int node){
        Q.offer(node);
        int L = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for(int i = 0; i < len; i++){
                int curNode = Q.poll();
                answer[curNode] = L;
                //curNode와 L을 기록
                //cur Node와 연결된 노드들 찾기
                for(int j = 1; j <=n; j++){
                    if(graph[curNode][j] == 1 && ch[j] == 0){
                        ch[j] = 1;
                        Q.add(j);
                    }
                }
            }
            L++;
        }
        
    }
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();
        answer = new int[n+1];
        ch = new int[n+1];
        graph = new int[n+1][n+1];
        for(int i = 0; i < m; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph[a][b] = 1;
        }
        ch[1] = 1;
        BFS(1);
        for (int i = 2; i < answer.length; i++) {
            System.out.println(i + " : " + answer[i]);
        }
    }  
   
}
// 6 9
// 1 3
// 1 4
// 2 1 
// 2 5
// 3 4 
// 4 5
// 4 6
// 6 2 
// 6 5
