//강사님 코드

import java.util.*;

public class Main {
    static int[][] board;
    static int[][] dis;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        board = new int[8][8];
        dis = new int[8][8];
        for(int i = 1; i <= 7; i++){
            for(int j = 1; j <= 7; j++){
                board[i][j] = scanner.nextInt();
            }
        }
        BFS(1, 1);
        if(dis[7][7] == 0){
            System.out.println(-1);
        }
        else{
            System.out.println(dis[7][7]);
        }

    }
    static class Point{
        private int x;
        private int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void BFS(int x, int y){
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y));
        board[x][y] = 1;
        
        while (!Q.isEmpty()) {
            Point tmp = Q.poll(); //x, y 세팅하기 //dis[x][y] 값 세팅하기
            // board[tmp.x][tmp.y] = 0;
            for(int i = 0; i < 4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if(nx >=1 && nx <=7 && ny >=1 && ny <=7 && board[nx][ny] == 0){
                    board[nx][ny] = 1;
                    Q.offer(new Point(nx, ny));
                   dis[nx][ny] = dis[tmp.x][tmp.y] + 1; //Queue에 값 추가

                }

            }
        }
    }
}
