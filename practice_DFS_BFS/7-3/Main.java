//강사님 코드

public class Main {
    //메모이제이션 사용 x
    public static int DFS(int n, int r){
        if(dy[n][r] > 0) return dy[n][r];
        if(n == r || r == 0) return 1;
        return dy[n][r] = DFS(n-1, r-1) + DFS(n-1, r);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        System.out.println(DFS(n, r));
    }  
}
