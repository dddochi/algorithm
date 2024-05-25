//혼자 풀어본 코드
//DFS
//컴파일 에러
import java.util.*;

public class Main {
    public static int[][] board;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int answer = Integer.MAX_VALUE;
    public static void DFS(int x, int y, int count){
        if(x == 7 && y == 7) answer =  Math.min(answer, count);
        else{
                for(int i = 0; i < n; i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(nx >=1 && nx<=7 && ny >=1 && ny<=7 && board[nx][ny] == 0){
                        board[nx][ny] = 1;
                        DFS(nx, ny, count + 1);
                        board[nx][ny] = 0;
                    }
                }
            
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        arr = new int[8][8];
        for(int i = 1; i <= 7; i++){
            for(int j = 1; j <= 7; j++){
                board[i][j] = scanner.nextInt();
            }
        }
        board[1][1] = 1;
        DFS(1,1, 0);
        if(answer != Integer.MAX_VALUE){
            System.out.println(answer);
        }
        else{
            System.out.println(-1);
        }
    }    
}
