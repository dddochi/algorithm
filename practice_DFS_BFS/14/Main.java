import java.util.*;

public class Main {
    public static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
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
            solution();
            System.out.println(count);
        }
        public static void solution(){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(board[i][j] == 1){
                        BFS(i, j);
                        count++;
                    }
                }
            }
        }
        public static void BFS(int curX, int curY){
            Queue<Point> Q = new LinkedList<>();
            Q.offer(new Point(curX, curY));
            board[curX][curY] = 0;
            while (!Q.isEmpty()) {
                Point tmp = Q.poll();
                for(int i = 0; i < 8; i++){
                    int nx = tmp.x + dx[i];
                    int ny = tmp.y + dy[i];
                   
                    if(nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1){
                        Q.offer(new Point(nx, ny));
                        board[nx][ny] = 0;
                    }
                }
            }
        }
    }
