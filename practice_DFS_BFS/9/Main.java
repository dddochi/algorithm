import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] ch;
    static int n, m;
    static int[] result;
    public static void BFS(int data){
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(data);
        int L = 0;
        while (!Q.isEmpty()) {
            int item = Q.poll();
            result[L] = item;
            ch[item] = 1;
            L++;
            boolean isChanged = false;
            for(int i = item + 1; i <= n; i++){
                if(ch[i] == 0){
                    Q.offer(i);
                    result[L] = i;
                    isChanged = true;
                }
                if(L == m-1){
                    for (int x : result) {
                        System.out.print(x + " ");
                    }
                    System.out.println();
                }
            }
            if(!isChanged) return;
            if(L == m-1) L--;
            
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        //4c2
        ch = new int[n + 1];
        result = new int[m];
        BFS(1);
    }
}
