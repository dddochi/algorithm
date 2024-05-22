import java.util.*;

public class Main {
    static int n, f;
    public static boolean BFS(Queue<Integer> Q) {
        Queue<Integer> answer = new LinkedList<>(Q);
        while (!Q.isEmpty()) {
            if (Q.size() == 1 && f == Q.peek()){ 
                for (Integer x : answer) {
                    System.out.print(x + " ");
                }
                return true;
            }
                
            int item1 = Q.poll();
            int len = Q.size();
            for (int l = 0; l < len; l++) {
                int item2 = Q.poll();
                Q.offer(item1 + item2);
                item1 = item2;
            }
            //L++;
        }
        return false;
    }
    static int[] ch;
    static boolean flag = false;
    public static void DFS(int data, Queue<Integer> Q){
        if(flag == true) return;
        if(Q.size() == n){
            flag = BFS(Q);
            return;
        }
        for(int i = 1; i <= n; i++){
            if(ch[i] == 1) continue;
            ch[i] = 1;
            Q.offer(i);
            DFS(i, Q);
            ch[i] = 0;
            Q.remove(i);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        f = scanner.nextInt();
        ch = new int[n+1];
        DFS(0, new LinkedList<>());
        
        
        
    }
}
