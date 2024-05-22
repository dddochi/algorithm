//이항정리를 공부하고 시도해본 코드
//정답;)
import java.util.*;
public class Main {
    static int n, f;
    static int[] ch;
    static boolean flag = false;
    static int[] arr;

    public static void DFS(int data, int L){
        if(flag == true) return;
        if(L == n){
            int sum = 0;
            for(int i = 0; i < n; i++){
                sum += (com(n-1, i) * arr[i]); //문제는 조합 ㅎ 
            }
            if(sum == f){
                for(int i = 0; i < n; i++){
                    System.out.print(arr[i]  + " ");
                }
                flag = true;
                return;
            }
        }
        for(int i = 0; i <n; i++){
            if(ch[i] == 1) continue; 
            ch[i] = 1;
            arr[L] = i + 1;
            DFS(i + 1, L + 1);
            ch[i] = 0;
            arr[L] = 0;
        }
    }
    public static int com(int n, int r){
        int a = 1;
        for(int i = 0; i < r; i++){
            a *= (n - i);
        }
        int b = 1;
        for(int i = 1; i <= r; i++){
            b  *= i;
        }

        return a/b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        f = scanner.nextInt();
        arr = new int[n];
        ch = new int[n+1];
        DFS(0, 0);        
    }
}
