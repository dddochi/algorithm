//혼자풀어본 코드 2 - BFS
import java.util.*;

public class Main {
    public static int[][] board;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int count= 0;
   // public static int answer = Integer.MAX_VALUE;
    public static void BFS(){
        int item = 1;
        for(int i = 1; i <= 7; i++){
            for(int j = item; j <= 7; j++){
                if(board[i][j] == 0){
                    count++;
                }
                else {
                    if(i == 1 && j == 1) item = j; //시작일때면!
                    else{item = j -1;}
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        board = new int[8][8];
        for(int i = 1; i <= 7; i++){
            for(int j = 1; j <= 7; j++){
                board[i][j] = scanner.nextInt();
            }
        }
        board[1][1] = 1;
        BFS();
        if(count != 0){
            System.out.println(count);
        }
        else{
            System.out.println(-1);
        }
        
    }
}
