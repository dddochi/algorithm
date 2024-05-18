import java.util.Scanner;

public class Main {
    static int max = Integer.MIN_VALUE;
    static int n, m; // m = 제한시간
    public static void DFS(int L, int score, int restTime, int[][] problems){
        if(restTime < 0) return;
        if(L == n){
            if(max < score) max = score;
            return;
        }
        else{
            DFS(L+1, score += problems[L][0], restTime -= problems[L][1], problems);
            DFS(L+1, score -= problems[L][0], restTime += problems[L][1], problems);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt(); //제한 시간
        int[][] problems = new int[n][2];
        for(int i = 0; i < n; i++){
            problems[i][0] = scanner.nextInt(); //점수
            problems[i][1] = scanner.nextInt(); //시간
        }
        DFS(0, 0, m, problems);
        System.out.println(max);
    }   

}
