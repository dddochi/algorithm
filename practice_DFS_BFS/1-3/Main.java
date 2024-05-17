//강사님 코드

import java.util.Scanner;

public class Main {
    static String answer = "NO";
    static int n, total = 0;
    static boolean flag = false;
    public static void DFS(int L, int sum, int[] arr){
        if(flag) return;
        if(sum > total/2) return;
        if(L == n){
            //왜 L == n 일때만 sum을 따질까?
            //착각하지 말자!
            //얘는 상태트리여서 맨 밑단까지 가더라도, 각 레벨에 대해 포함 o, x가 골고루 섞여있다.
            //기존 트리처럼 왜 모든 노드를 포함해야지 check하지..? 이렇게 생각하면 안된다!!!
            if((total - sum ) == sum){ //전체 - sum == sum이면, 즉 절반이 sum이면 당연히 나머지의 합이 절반이 된다
                                        // 굳이 check 배열 쓸 필요X
                answer = "YES";
                flag = true;
            }
        }
        else{
            DFS(L+1, sum + arr[L], arr);
            DFS(L+1, sum, arr);
        }
    }
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       n = scanner.nextInt();
       int[]arr = new int[n];
       for(int i = 0; i < n; i++){
        arr[i] = scanner.nextInt();
        total += arr[i];
       }
       DFS(0, 0, arr);
       System.out.println(answer);
    }
}
