import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(n);
    }
    public static int solution(int n){
        int[] arr = new int[n];
        int cnt = 0;
        //1~n까지 배열 만들어주기
        for(int i = 0; i < n; i++){
            arr[i] = i+1;
        }
        //n을 i로 나눴을 때 나누어 떨어지면 -> sum 실행 -> sum == n check
        for(int i = 2; i < n/2; i++){
            if(n % i != 0) continue;
            else{
                int sum = 0;
                int quient = n / i ;
                for(int j = 0; j < i; j++){
                    sum += (arr[j] + quient);
                }
                if(sum == n) cnt++;
            }
        }
        return cnt;
    }
    public static int solution2(int n){
        int answer = 0, cnt = 1;
        n--;
        while (n > 0) {
            cnt++;
            n = n - cnt; //15 -> 14 - 2 = 12
            if(n % cnt == 0) answer++;
        }
        return answer;
    }

}
