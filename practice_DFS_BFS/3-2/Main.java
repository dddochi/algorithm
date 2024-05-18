//강사님 코드

public class Main {
    static int answer = Integer.MIN_VALUE, n, m;
    boolean flag = false;
    public static void DFS(int L, int sum, int time, int[] ps, int[] pt){
        if(time > m) return;
        if(L == m){
            answer = Math.max(answer, sum);
        }
        else{
            DFS(L+1, sum+ps[L], time+pt[L], ps, pt);
            DFS(L+1, sum, time, ps, pt);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt(); //제한 시간
        int [] a = new int[n];
        int [] b = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt(); //점수
            b[i] = scanner.nextInt(); //시간
        }
        DFS(0, 0, 0, a, b);
        System.out.println(answer);
    }
}
