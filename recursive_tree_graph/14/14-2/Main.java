//강사님 코드

import java.util.*;

public class Main {
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch, dist;
    public static void BFS(int v){
        Queue<Integer> queue = new LinkedList<>();
        ch[v] = 1;
        dis[v] = 0;
        queue.offer(v);
        while (!queue.isEmpty()) {
            int cv = queue.poll();
            for(int nv : graph.get(cv)){
                if(ch[nv] == 0){
                    ch[nv] = 1;
                    queue.offer(nv);
                    dis[nv] = dis[cv] + 1;
                }
            }
        }
    } 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i< m; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph.get(a).get(b);
        }
        BFS(1);
        for(int i = 2; i <=n; i++){
            System.out.println(i + " : " + dist[1]);
        }
    }
}
