//혼자 풀어본 코드
//문제 : 이미 갔던 곳 어떻게 체크 -> 1로!!
//다시 벡하면 1 풀어주기
import java.util.Scanner;

public class Main {
    static int[][] arr;
    static int n = 7;
    static int answer = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        arr = new int[n+1][n+1];
        for(int i = 1; i <=n; i++){
            for(int j = 1; j <= n; j++){
                arr[i][j] = scanner.nextInt();
            }
        }
        DFS(1,1);
        System.out.println(answer);
    }
    public static void DFS(int row, int col){
        if(row < 1 || col < 1) return;
        if(row > n || col > n)  return;
        if(arr[row][col] == 1) return;
        if(row == n && col == n)  answer++;
        else{
            arr[row][col] = 1;
            DFS(row, col - 1); //위

            DFS(row, col + 1); //아래 

            DFS(row -1, col); //왼쪽

            DFS(row + 1, col); //오른쪽
            arr[row][col] = 0;
        }
    }
}
