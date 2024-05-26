//혼자 풀어본 코드

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] board, dis;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;
    static class Point{
        private int x;
        private int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void BFS(){
        Queue<Point> Q = new LinkedList<>();
        //board[][] == 1인 곳을 찾아서 insert
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 1){
                    Q.offer(new Point(i, j));
                }
            }
        }
        int L = 1;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for(int i = 0; i < len; i++){
                Point tmp = Q.poll();
                for(int j = 0; j < 4; j++){
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];
                    if(nx >=1 && ny <n && ny >= 1 && ny < m && board[nx][ny] == 0){
                        board[nx][ny] = L;
                        Q.offer(new Point(nx, ny));
                    }

            }
            }
            L++;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt(); //m값 - column
        n = scanner.nextInt(); //n값 - row 
        
        board = new int[n][m];
        dis = new int[n][m];
        for(int i =0; i <n; i++){
            for(int j = 0; j < m; j++){
                board[i][j] = scanner.nextInt();
            }
        }
        BFS();
        int max = 0;
        for(int i =0; i <n; i++){
            for(int j = 0; j < m; j++){
                if(max < board[i][j]) max = board[i][j];
            }
        }
        System.out.println(max);
    }

}
