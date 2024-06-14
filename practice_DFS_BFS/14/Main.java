import java.util.*;

public class Main {
        static int[][] board;
        static int count = 0;
        public static void main(String[] args) {
        //0-빈칸 1-집 2-피자집
        //피자배달 거리 -> 최소거리 : 집 - 피자 |x1-x2| + |y1-y2|
        //M개 피자집만 살린다 -> 도시의 피자배달거리가 최소가 되는 M개의 피자집 선택

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        board = new int[n+1][n+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                board[i][j] = scanner.nextInt();
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(board[i][j] == 1){
                    DFS(i, j);
                }
            }
        }
        System.out.println(count);

    }
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    public static void DFS(int x, int y){

        //문제 -> 피자집을 어떻게 다 체크할 것인가? 
        //각 피자집 리스트를 만들고, 거리를 각각 구해서 최솟값을 넘긴다.
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < 8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(board[nx][ny] == 2){
                int dist = Math.abs(x - nx) + Math.abs(y - ny);
                answer = Math.min(answer, dist);
            }
        }
        count += answer;
        
    }
}
