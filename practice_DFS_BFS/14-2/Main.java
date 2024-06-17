import java.util.*;

public class Main {
    public static class Point{
        private int x;
        private int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static List<Point> hs, pz;
    static int n, m;
    static Point[] ch;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[][] board = new int[n][n];
        hs = new ArrayList<>();
        pz = new ArrayList<>();
        ch = new Point[m];
        for(int i = 0; i <n; i++){
            for(int j = 0; j <n; j++){
                board[i][j] = scanner.nextInt();
                if(board[i][j] == 1){
                    hs.add(new Point(i, j));
                }
                if (board[i][j] == 2) {
                    pz.add(new Point(i, j));
                }
            }
        }
        
        DFS(0, 0);
        System.out.println(minResult);
    }
    static int minResult = Integer.MAX_VALUE;
    public static void DFS(int L, int s){
        if(L == m){ //다 뽑음
            // 각 집과의 거리 구하기 
            int result = 0; 
            for(int j = 0; j < hs.size(); j++){
                int minDist = Integer.MAX_VALUE;
                for(int k = 0; k < m; k++){
                    Point homeP = hs.get(j);
                    Point pizzaP = ch[k];
                    int dist = Math.abs(homeP.x - pizzaP.x) + Math.abs(homeP.y - pizzaP.y);
                    minDist = Math.min(minDist, dist);
                }
                result += minDist;
            }
            minResult = Math.min(minResult, result);
            return;//최솟값을 구해서 더하기
        }
        for(int i = s; i < pz.size(); i++){
            ch[L] = pz.get(i);
            DFS(L+1, i+1);
        }
    }
}
