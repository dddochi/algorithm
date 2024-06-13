import java.util.*;
public class Main {
    static int[][] board;
    //상 하 좌 우 사이 대각선도 check
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int n, count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        board = new int[n][n];
        for(int i = 0; i <n; i++){
            for(int j = 0; j <n; j++){
                board[i][j] = scanner.nextInt();
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 1) {
                    DFS(i, j);
                    count++;
                }
            }
        }
   
        System.out.println(count);
    }
    public static void DFS(int x, int y){
        for(int i = 0; i < 8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >=0 && nx < n && ny >=0 && ny < n && board[nx][ny] == 1){
                board[nx][ny] = 0;
                DFS(nx, ny);
            }
        }
    }
}
