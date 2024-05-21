// //조합의 경우의 수
// //메모이제이션으로 풀기
//메모이제이션이 뭔지 모르겠음 - 제대로 공부하자!!!!!!!!!!
import java.util.*;
public class Main{
    public static int[][] memoization(int n, int r){
        int[][] memo = new int[n + 1][r + 1];
        for(int i = 1; i <=r; i++){
            for(int j = i; j <= n; j++){     
                if(i == 1) memo[j][i] = j;
                else if(i == j) memo[j][i] = 1;
                else{
                    memo[j][i] = memo[j-1][i-1] + memo[j-1][i];
                }
            }
        }
        
        return memo;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        int[][] answer = memoization(n, r);
        System.out.println(answer[n][r]);
    }
}