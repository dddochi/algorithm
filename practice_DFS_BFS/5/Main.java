//혼자 풀어본 코드
//trial-1
//예시 결과 출력은 잘됨 but 오답 뜬다
import java.util.*;

public class Main {
    static int n;
    static int answer = Integer.MAX_VALUE;
    static Integer[] coins;   
    static boolean flag = false;
    public static void DFS(int L, int change){
        if(change <0) return;
        if(change == 0){  
            answer = Math.min(answer, L);
            // if(answer < L) answer = L;
            return;
        }
        else{
            if(change - coins[0] <0){
                for(int i = 0; i < n; i++){
                    DFS(L+1, change - coins[i]);
                }
            }
            else{
                DFS(L+1, change - coins[0]);
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
        int change = scanner.nextInt(); //거스름돈
        DFS(0, change);
        System.out.println(answer);
    }    
}
