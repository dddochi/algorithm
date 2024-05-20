//시도 2
import java.util.*;
public class Main {
    static int n;
    static int answer = Integer.MAX_VALUE;
    static Integer[] coins;   
    static boolean flag = false;
    static int count = 0;
    public static void DFS(int change, int count){
        // System.out.println("inside loop");
        if(flag == true) return;
        if(change < 0) return;
        if(change == 0){
            answer = Math.min(answer, count);
            flag = true;
            return;
        }
        else{
            for(int i = 1; i < n; i++){
                DFS(change - coins[i], count+1);
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
        Arrays.sort(coins, Collections.reverseOrder()); //내림차순 - 0번 인덱스가 가장 큰 동전
        int change = scanner.nextInt(); //거스름돈
        int maxCoin = coins[0];
        while (change - maxCoin >= 0) {
            change -= maxCoin;
            count++;
            // System.out.println("inner count");
        }
        DFS(change, count);
        
        System.out.println(answer);
    }    
}
