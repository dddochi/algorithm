import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i< n; i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println(solution(n, k, arr));
    }  
    //스스로 풀어본 코드 - 정답 
    public static int solution(int n, int k, int[] arr){
        int answer = 0, lt = 0;
        int zero_count = 0;
        int rt = 0;
        while (rt < n) {
            if(arr[rt] == 0) zero_count++;
            if(zero_count == k) answer = Math.max(answer, rt - lt + 1);
            while (zero_count > k) { //zero_count ==k일때는 계속 rt를 진전해도 됨! 
                if(arr[lt] == 0) zero_count--;
                lt++;
            }
            rt++;
        }
        return answer;
    }
    //강사님 코드 
    public static int solution2(int n, int k, int[] arr){
        int answer = 0, cnt = 0, lt = 0;
        for(int rt = 0; rt < n; rt++){
            if(arr[rt] == 0) cnt++;
            while (cnt > k) {
                if(arr[lt] == 0) cnt--;
                lt++;
            }
            answer = Math.max(answer, rt - lt + 1);
        }
        return answer;
    }
}
