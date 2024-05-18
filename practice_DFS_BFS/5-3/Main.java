//설명 듣고 시도
import java.util.*;
public class Main {
    static int n, change;
    static int answer = Integer.MAX_VALUE;
    static Integer[] coins;   

    public static void DFS(int L, int sum){
        if(sum > change) return;
        if(sum == change){
            answer = Math.min(answer, L);
            return;
        }
        for(int i = 0; i < n; i++){
            DFS(L+1, sum + coins[i]);
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
        DFS(0, 0);
        System.out.println(answer);
    }
}
