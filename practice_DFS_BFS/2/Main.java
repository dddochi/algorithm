//혼자 풀어본 코드 - 정답
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        c = scanner.nextInt();
        n = scanner.nextInt();
        arr = new int[n];
        ch = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        DFS(0, 0);
        System.out.println(max);

    }   
    public static int n, c, max = 0;
    public static int[] ch;
    public static int[] arr;
    public static void DFS(int L, int sum){
        if(sum > c) return;
        if(L == n){
            if(sum > max) max = sum;
            return;
        }
        else{
            ch[L] = 1;
            DFS(L+1, sum += arr[L]);
            ch[L] = 0;
            DFS(L+1, sum -= arr[L]);
        }
    } 
}
