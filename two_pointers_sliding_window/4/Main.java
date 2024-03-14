import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println(solution(n, m, arr));
    }
    // public static int solution(int n, int m, int[] arr){
    //     //m인 이유 - m = 6일 때 슬라이드가 6개 이상이면 무조건 6보다 커짐
    //     //윈도우는 최소 2개 ~ m개
    //     int count = 0;
    //     for(int i = 2; i <= m; i++){ // i가 윈도우 크기
    //         int sum = 0;
    //         //첫 윈도우 만들기
    //         for(int j = 0; j < i; j++){
    //             sum+= arr[j];
    //         }
            
    //         for(int k = i; k < n; k++){
    //             sum += (arr[k] - arr[k - i]);
    //             if (sum == m) count++;
    //         }
    //     }
    //     return count;
    // }    

    //설명듣고 스스로 풀어본 코드 
    public static int solution(int n, int m, int arr[]){
        int lt = 0, rt = 0;
        int sum = 0;
        int count = 0;
        sum = arr[lt];
        while(rt < n){
            if(sum == m){
                count++;
                sum -= arr[lt];
                lt++;
            }
            else if(sum > m){
                sum -= arr[lt];
                lt++;
            }
            else if (sum < m){
                if(rt == n-1) break;
                rt++;
                sum += arr[rt];
            }
        }
        return count;
    }
    //강사님 코드
    public static int solution2(int n, int m, int[] arr){
        int answer = 0, sum = 0, lt = 0;
        for(int rt = 0; rt < n; rt++){ //rt 증가
            sum+=arr[rt]; //sum 더하기
            if(sum == m) answer++; //check
            while (sum >= m) { // m값보다 sum이 크면 (sum이 m보다 작을 때까지 계속 뺸다)
                sum -= arr[lt++]; //-> lt값을 빼고 lt++
                if(sum == m) answer++; // sum 변경 후 check
            }

        }
        return answer;
    }
}
