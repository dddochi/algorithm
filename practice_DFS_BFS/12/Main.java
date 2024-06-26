//혼자 풀어본 코드
//예시 출력 잘됨
//채점 결과 정답

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
                    if(nx >=0 && nx <n && ny >= 0 && ny < m && board[nx][ny] == 0){
                        board[nx][ny] = L;
                        dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
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
        int max = 0;
        int min = 0;
        for(int i =0; i <n; i++){ 
            for(int j = 0; j < m; j++){
                board[i][j] = scanner.nextInt();
                if(board[i][j] > max) max = board[i][j];
                if(board[i][j] < min) min = board[i][j];
            }
        }
        if(max == 0 && min == 0) {
            System.out.println(0);
            return;
        }
        BFS();
        max = 0;
        for(int i =0; i <n; i++){
            for(int j = 0; j < m; j++){
                if(max < dis[i][j]) max = dis[i][j];
                if(board[i][j] == 0){// 토마토가 다 익지 못하는 상황
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(max);
        // for(int i =0; i <n; i++){
        //     for(int j = 0; j < m; j++){
        //         System.out.print(board[i][j] + " ");
        //     }
        //     System.out.println();
        // }
    }

}
// 6 4
// 0 0 -1 0 0 1
// 0 0 1 0 -1 0
// 1 0 -1 0 0 0
// 0 0 0 0 -1 1
