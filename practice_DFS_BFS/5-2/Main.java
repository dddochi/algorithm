//시도 2
//BFS 사용
import java.util.*;
public class Main {
    static int n, change;
    static int answer = Integer.MAX_VALUE;
    static Integer[] coins;   
    static boolean flag = false;
    static int count;
    public static int BFS(){
        Queue<Integer> queue = new LinkedList<>();
        while (change - coins[0] > 0) {
            change = change - coins[0];
            count++;
        }
        queue.offer(coins[0] && !queue.isEmpty());
        while (change > 0 ) { // or change > 0
            int cur = queue.poll();
            for(int i = 0; i < queue.size(); i++){
                count++;
                for(int i = 0; i < n; i++){
                    queue.offer(coins[i]);
                    if(change - coins[i] >=0){
                        change = change - coins[i];
                    }
                }
            }
        }
        
    }
    public static void main(String[] args) {
    
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt(); //동전의 종류
        coins = new Integer[n];
        for(int i = 0; i < n; i++){
            coins[i] = scanner.nextInt();
        }
        Arrays.sort(coins, Collections.reverseOrder());
        change = scanner.nextInt(); //거스름돈
        System.out.println(BFS(););
    }    
}
