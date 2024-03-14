import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i ++){
            arr[i] = scanner.nextInt();
        }
        System.out.println(solution(n, k, arr));
    }
    //스스로 해본 코드 - Time Limit Exceeded    
    // public static int solution(int n , int k, int[] arr){
    //     int start = 0;
    //     int end = k ;
    //     int max = Integer.MIN_VALUE;
    //     while(end <= n){
    //         int sum = 0;
    //         for(int i = start; i <end; i++){
    //             sum += arr[i];
    //         }
    //         if(max < sum) max = sum;
    //         start++;
    //         end++;
    //     }
    //     return max;
    // }
    public static int solution(int n, int k, int[] arr){
        int sum = 0;
        //슬라이딩 윈도우 초기화 k개만큼 더하기
        for(int j = 0; j < k; j++){
            sum += arr[j];
        }
        int max = sum;
        //슬라이딩 윈도우 한칸씩 밀기
        for(int i = k; i < n; i++){
            sum += arr[i];
            sum -= arr[i - k];
            if(sum > max) max = sum;
        }
        return max;
    }
    //강사님 코드
    public static int solution2(int n, int k, int[]arr){
        int answer = 0, sum = 0;
        for(int i = 0; i < k; i++) sum+=arr[i];
        for(int i = k; i < n; i++){
            sum+=(arr[i] - arr[i-k]);
            answer = Math.max(answer, sum);
        }
        return answer;
    }
}
